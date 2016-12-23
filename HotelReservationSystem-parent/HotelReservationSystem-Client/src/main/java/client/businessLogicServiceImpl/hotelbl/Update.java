package client.businessLogicServiceImpl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import client.Client;
import client.businessLogicService.hotelblService.HotelblUpdateService;
import common.otherEnumClasses.RoomCondition;
import common.po.HotelPO;
import common.po.OrderPO;
import common.vo.OrderVO;

public class Update implements HotelblUpdateService {

	@Override
	public boolean offlineCheckIn(String hotelId, String numOfRoom, Date checkInTime, Date planDepartTime) {
		try {
			HotelPO hotelPO = Client.getHotelDataService().getHotelInfo(hotelId);
			return Client.getHotelDataService().setHotelInfo(decrease(hotelPO, numOfRoom));
		} catch (RemoteException e) {
			return false;
		}
	}

	@Override
	public OrderVO onlineCheckOut(String hotelId, String orderId, Date departTime) {
		try {
			HotelPO hotelPO = Client.getHotelDataService().getHotelInfo(hotelId);
			OrderPO orderPO = Client.getOrderDataService().findOrderFromData(orderId);
			orderPO.setCheckOutTime(departTime);
			if (Client.getOrderDataService().updateOrder(orderPO)
					&& Client.getHotelDataService().setHotelInfo(increase(hotelPO, orderPO.getNumOfRoom())))
				return new OrderVO(orderPO);
		} catch (RemoteException e) {
		}
		return null;
	}

	@Override
	public boolean offlineCheckOut(String hotelId, String numOfRoom, Date DepartTime) {
		try {
			HotelPO hotelPO = Client.getHotelDataService().getHotelInfo(hotelId);
			return Client.getHotelDataService().setHotelInfo(increase(hotelPO, numOfRoom));
		} catch (RemoteException e) {
		}
		return false;
	}

	/**
	 * 
	 * @description 增加酒店空房数
	 * @param 酒店PO，房间情况
	 * @return 调整后酒店PO
	 */
	private HotelPO increase(HotelPO po, String num) {
		ArrayList<RoomCondition> rooms = po.getRooms();
		int temp = num.indexOf('/');
		rooms.get(0).restNum += Integer.parseInt(num.substring(0, temp));
		num = num.substring(temp + 1);
		temp = num.indexOf('/');
		rooms.get(1).restNum += Integer.parseInt(num.substring(0, temp));
		rooms.get(2).restNum += Integer.parseInt(num.substring(temp + 1));
		po.setRooms(rooms);
		return po;
	}

	/**
	 * 
	 * @description 减少酒店空房数
	 * @param 酒店PO，房间情况
	 * @return 调整后酒店PO
	 */
	private HotelPO decrease(HotelPO po, String num) {
		ArrayList<RoomCondition> rooms = po.getRooms();
		int temp = num.indexOf('/');
		rooms.get(0).restNum -= Integer.parseInt(num.substring(0, temp));
		num = num.substring(temp + 1);
		temp = num.indexOf('/');
		rooms.get(1).restNum -= Integer.parseInt(num.substring(0, temp));
		rooms.get(2).restNum -= Integer.parseInt(num.substring(temp + 1));
		po.setRooms(rooms);
		return po;
	}
}