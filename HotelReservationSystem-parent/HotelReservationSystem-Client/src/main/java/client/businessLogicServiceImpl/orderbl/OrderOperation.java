package client.businessLogicServiceImpl.orderbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import client.Client;
import client.businessLogicService.orderblService.OrderblService;
import client.businessLogicService.strategyblService.StrategyPriceService;
import client.businessLogicServiceImpl.strategybl.PriceController;
import common.otherEnumClasses.CreditOperation;
import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.RoomCondition;
import common.po.HotelPO;
import common.po.OrderPO;
import common.vo.HotelVO;
import common.vo.OrderVO;

public class OrderOperation implements OrderblService {

	@Override
	public ArrayList<HotelVO> searchReservedHotel(String clientId) {
		ArrayList<HotelVO> vos = new ArrayList<HotelVO>();
		try {
			ArrayList<HotelPO> pos = Client.getOrderDataService().searchReservedHotel(clientId);
			for (HotelPO hotelPO : pos) {
				vos.add(new HotelVO(hotelPO, true));
			}
		} catch (RemoteException e) {
		}
		return vos;
	}

	@Override
	public ArrayList<OrderVO> searchOrderListFromData(Person person, OrderState state, HotelVO hotelVO) {
		ArrayList<OrderVO> vos = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> pos = Client.getOrderDataService().findOrderList(person, state, hotelVO);
			for (OrderPO OrderPO : pos) {
				vos.add(new OrderVO(OrderPO));
			}
		} catch (RemoteException | ParseException e) {
                    e.printStackTrace();
		}
		return vos;
	}

	@Override
	public OrderVO calPrice(OrderVO vo) {
		StrategyPriceService calprice = new PriceController();
		try {
                    HotelPO hotel = Client.getHotelDataService().getHotelInfo(vo.hotelId);
                    System.out.println("*******");
                    System.out.println(vo.hotelId);
                    String num = vo.numOfRoom;
                    System.out.println(num);
                    int temp = num.indexOf('/');
                    vo.price += hotel.getRooms().get(0).price*Integer.parseInt(num.substring(0, temp));
                    num = num.substring(temp + 1);
			temp = num.indexOf('/');
                    vo.price += hotel.getRooms().get(1).price*Integer.parseInt(num.substring(0, temp));
                    vo.price += hotel.getRooms().get(2).price*Integer.parseInt(num.substring(temp + 1));
                    
                    System.out.println(vo.price);
                    vo.price = calprice.calPrice(vo).getfirstStrategy().getPrice();
		} catch (RemoteException e) {
                    e.printStackTrace();
		}
                System.out.println(vo.price);
		return vo;
	}

	@Override
	public OrderVO createOrder(OrderVO vo, String clientId) {
		try {
			vo.clientId = clientId;
			vo.state = OrderState.NotDone;
			Date date = new Date();
			vo.createdTime = date;
			Calendar cal = Calendar.getInstance();
			vo.id = clientId + cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH) + cal.get(Calendar.DATE)
					+ cal.get(Calendar.HOUR) + cal.get(Calendar.MINUTE);
                        vo.latestDoneTime = vo.planExecuteTime;

			HotelPO hotel = Client.getHotelDataService().getHotelInfo(vo.hotelId);
			ArrayList<RoomCondition> rooms = hotel.getRooms();
			String num = vo.numOfRoom;
			int temp = num.indexOf('/');
			rooms.get(0).restNum -= Integer.parseInt(num.substring(0, temp));
			num = num.substring(temp + 1);
			temp = num.indexOf('/');
			rooms.get(1).restNum -= Integer.parseInt(num.substring(0, temp));
			rooms.get(2).restNum -= Integer.parseInt(num.substring(temp + 1));
			hotel.setRooms(rooms);

			if (Client.getHotelDataService().setHotelInfo(hotel)
					&& Client.getOrderDataService().addOrder(new OrderPO(vo))) {
				return vo;
			}
		} catch (RemoteException e) {
                    e.printStackTrace();
		}
		return null;
	}

	@Override
	public OrderVO executeOrder(String orderId, String hotelId, Date checkInTime, Date planCheckOutTime) {
		try {
			OrderPO po = Client.getOrderDataService().findOrderFromData(orderId);
                        System.out.println(po==null);
			if (po.getHotelId().equals(Client.getHotelDataService().getHotelInfo(hotelId).getId())) {
				if (po.getState() == OrderState.NotDone || po.getState() == OrderState.Exceptional) {
					if (po.getState() == OrderState.Exceptional) {
						Client.getUserDataService().updatecredit(po.getClientId(), po.getPrice(), po.getId(),
								CreditOperation.ExceptionCancel);
					}
                                        System.out.println(po.getId());
					po.setState(OrderState.Done);
					po.setCheckInTime(checkInTime);
					po.setCheckOutTime(planCheckOutTime);
                                        boolean b1 = Client.getUserDataService().updatecredit(po.getClientId(), po.getPrice(), po.getId(),
							CreditOperation.Execute) == ResultMessage.Success;
                                        boolean b2 = Client.getOrderDataService().updateOrder(po);
                                        System.out.println(b1);
                                        System.out.println(b2);
					if (b1&& b2) {
                                            System.out.println("this/!");
                                             System.out.println(po.getId());
						return new OrderVO(po);
					}
				}
			}
		} catch (RemoteException e) {
                    e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean assessOrder(OrderVO vo, double mark) {
		if (vo.state != OrderState.Done) {
			OrderPO po = new OrderPO(vo);
			po.setMark(mark);
			try {
				HotelPO hotelPO = Client.getHotelDataService().getHotelInfo(vo.hotel);
				hotelPO.setMark((hotelPO.getMark() * hotelPO.getAssessNum() + mark) / (hotelPO.getAssessNum() + 1));
				hotelPO.setAssessNum(hotelPO.getAssessNum() + 1);
				return Client.getOrderDataService().updateOrder(po)
						&& Client.getHotelDataService().setHotelInfo(hotelPO);
			} catch (RemoteException e) {
			}
		}
		return false;
	}

	@Override
	public boolean clientCancelOrder(OrderVO vo) {
		if (vo.state == OrderState.NotDone) {
			OrderPO po = new OrderPO(vo);
			Date latestTime = po.getLatestDoneTime();
			Date date = new Date();
			long between = latestTime.getTime() - date.getTime();
			try {
				if (between / (1000 * 60 * 60) < 6.0) {
					Client.getUserDataService().updatecredit(po.getClientId(), 0 - po.getPrice() / 2, po.getId(),
							CreditOperation.Cancel);
				}
				po.setCancelTime(date);
				po.setState(OrderState.Canceled);

				HotelPO hotel = Client.getHotelDataService().getHotelInfo(vo.hotel);
				ArrayList<RoomCondition> rooms = hotel.getRooms();
				hotel.setRooms(increaseRoom(rooms, vo.numOfRoom));
				Client.getHotelDataService().setHotelInfo(hotel);

				return Client.getOrderDataService().updateOrder(po);
			} catch (RemoteException e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean managerCancalOrder(OrderVO vo, boolean isAll) {
		if (vo.state == OrderState.Exceptional) {
			try {
				OrderPO po = new OrderPO(vo);
				Client.getUserDataService().updatecredit(po.getClientId(), (isAll ? 1 : 0.5) * po.getPrice(),
						po.getId(), CreditOperation.ExceptionCancel);
				po.setCancelTime(new Date());
				po.setState(OrderState.ExceptionalCanceled);

				HotelPO hotel = Client.getHotelDataService().getHotelInfo(vo.hotel);
				ArrayList<RoomCondition> rooms = hotel.getRooms();
				hotel.setRooms(increaseRoom(rooms, vo.numOfRoom));
				Client.getHotelDataService().setHotelInfo(hotel);

				return Client.getOrderDataService().updateOrder(po);
			} catch (RemoteException e) {
				return false;
			}
		}
		return false;
	}

	public ArrayList<RoomCondition> increaseRoom(ArrayList<RoomCondition> rooms, String num) {
		int temp = num.indexOf('/');
		rooms.get(0).restNum += Integer.parseInt(num.substring(0, temp));
		num = num.substring(temp + 1);
		temp = num.indexOf('/');
		rooms.get(1).restNum += Integer.parseInt(num.substring(0, temp));
		rooms.get(2).restNum += Integer.parseInt(num.substring(temp + 1));
		return rooms;
	}

	@Override
	public OrderVO searchOrderById(String id) {
		OrderVO vo = new OrderVO();
		try {
			vo = new OrderVO(Client.getOrderDataService().findOrderFromData(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vo;
	}
}