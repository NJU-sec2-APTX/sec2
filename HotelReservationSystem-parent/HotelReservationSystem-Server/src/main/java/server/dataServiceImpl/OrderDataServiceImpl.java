package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import common.dataService.OrderDataService;
import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.otherEnumClasses.UserRole;
import common.po.HotelPO;
import common.po.OrderPO;
import common.vo.HotelVO;

public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4026471108382528596L;
	private DBHelper data;
	private ResultSet rs;
	private HotelDataServiceImpl hotel = new HotelDataServiceImpl();

	public OrderDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<HotelPO> searchReservedHotel(String clientId) throws RemoteException {
		ArrayList<HotelPO> hotels = new ArrayList<HotelPO>();
		ArrayList<OrderPO> orders = findOrderList(new Person(UserRole.Member, clientId), null, null);
		for (OrderPO orderPO : orders) {
			HotelPO po = hotel.getHotelInfo(orderPO.getHotelId());
			if (!hotels.contains(po)) {
				hotels.add(po);
			}
		}
		return hotels;
	}

	@Override
	public ArrayList<OrderPO> findOrderList(Person person, OrderState state, HotelVO hotelVO) throws RemoteException {
		String sql = null;
		if (person.role == UserRole.Member || person.role == UserRole.Enterprise) {
			sql = "select * from order where id='" + person.id + "'";
			ArrayList<OrderPO> orders = getList(sql);
			ArrayList<OrderPO> result = new ArrayList<OrderPO>();
			if (state != null) {
				for (OrderPO orderPO : orders) {
					if (orderPO.getState() == state) {
						result.add(orderPO);
					}
				}
				return result;
			} else if (hotelVO != null) {
				for (OrderPO orderPO : orders) {
					if (orderPO.getHotelId() == hotelVO.id) {
						result.add(orderPO);
					}
				}
				return result;
			}
			return orders;
		} else if (person.role == UserRole.HotelWorker) {
			String name = new HotelDataServiceImpl().getHotelInfo(person.id).getName();
			sql = "select * from order where hotel='" + name + "'";
			return getList(sql);
		} else if (person.role == UserRole.Sales) {
			sql = "select * from order where state=Exceptional";
			return getList(sql);
		}
		data.close();
		return null;
	}

	@Override
	public boolean updateOrder(OrderPO po) throws RemoteException {
		String sql = "update order set"
				+" hotelId = '"+po.getHotelId()+"'"
				+", price = '"+po.getPrice()+"'"
				+", state = '"+po.getState().toString()+"'"
				+", mark = '"+po.getMark()+"'"
				+", clientId = '"+po.getClientId()+"'"
				+", hotel = '"+po.getHotel()+"'"
				+", day = '"+po.getDay()+"'"
				+", createdTime = '"+po.getCreatedTime()+"'"
				+", planExecuteTime = '"+po.getPlanExecuteTime()+"'"
				+", latestDoneTime = '"+po.getLatestDoneTime()+"'"
				+", checkInTime = '"+po.getCheckInTime()+"'"
				+", planDepartTime = '"+po.getPlanDepartTime()+"'"
				+", checkOutTime = '"+po.getCheckOutTime()+"'"
				+", cancelTime = '"+po.getCancelTime()+"'"
				+", numberOfPerson = '"+po.getNumberOfPerson()+"'"
				+", hasOfChild = '"+(po.isHasChild()?1:0)+"'"
				+", numOfRoom = '"+po.getNumOfRoom()+"'"
				+" where id='" + po.getId() + "'";
		data = new DBHelper(sql);
		try {
			if (data.pst.execute()) {
				return true;
			}
		} catch (SQLException e) {
		}
		data.close();
		return false;
	}

	@Override
	public boolean addOrder(OrderPO po) throws RemoteException {
		String sql = "insert into order (id,hotelId,price,state,clientId,hotel,day,"
				+ "createdTime,planExcuteTime,latesetDoneTime,numOfPerson,hasChild,numOfRoom) value ('" + po.getId()
				+ "','" + po.getHotelId() + "','" + po.getPrice() + "','" + po.getState() + "','" + po.getClientId()
				+ "','" + po.getHotel() + "','" + po.getDay() + "','" + po.getCreatedTime() + "','"
				+ po.getPlanExecuteTime() + "','" + "','" + po.getLatestDoneTime() + "','" + po.getNumberOfPerson()
				+ "','" + po.isHasChild() + "','" + po.getNumOfRoom() + "')";
		data = new DBHelper(sql);
                System.out.println(sql);
		try {
			if (data.pst.execute()) {
				return true;
			}
		} catch (SQLException e) {
                    e.printStackTrace();
		}
		return false;
	}

	@Override
	public OrderPO findOrderFromData(String orderId) throws RemoteException {
		String sql = "select * from order where id='" + orderId + "'";
		data = new DBHelper(sql);
		OrderPO po = new OrderPO();
		try {
			rs = data.pst.executeQuery(sql);
			if (rs.next()) {
				po = getPO();
			}
		} catch (SQLException e) {
		}
		data.close();
		return po;
	}

	/**
	 * private
	 * 
	 * @description 将sql对应的语句结果集读入OrderPO列表
	 * @param sql语句
	 * @return OrderPO列表
	 */
	private ArrayList<OrderPO> getList(String sql) {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		if (sql == null)
			return null;
		data = new DBHelper(sql);
		try {
			rs = data.pst.executeQuery(sql);
			while (rs.next()) {
				pos.add(getPO());
			}
		} catch (SQLException e) {
		}
		return pos;
	}

	/**
	 * 
	 * @description 按照rs读入OrderPO
	 * @param
	 * @return OrderPO
	 */
	private OrderPO getPO() {
		OrderPO po = new OrderPO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
		try {
			po.setId(rs.getString(1));
			po.setHotelId(rs.getString(2));
			po.setPrice(rs.getDouble(3));
			po.setState(OrderState.get(rs.getString(4)));
			po.setMark(rs.getDouble(5));
			po.setClientId(rs.getString(6));
			po.setHotel(rs.getString(7));
			po.setDay(rs.getInt(8));
			po.setCreatedTime(sdf.parse(rs.getString(9)));
			po.setPlanExecuteTime(sdf.parse(rs.getString(10)));
			po.setLatestDoneTime(sdf.parse(rs.getString(11)));
			po.setCheckInTime(sdf.parse(rs.getString(12)));
			po.setPlanDepartTime(sdf.parse(rs.getString(13)));
			po.setCheckOutTime(sdf.parse(rs.getString(14)));
			po.setCancelTime(sdf.parse(rs.getString(15)));
			po.setNumberOfPerson(rs.getInt(16));
			po.setHasChild(rs.getBoolean(17));
			po.setNumOfRoom(rs.getString(18));
		} catch (SQLException | ParseException e) {
		}
		return po;
	}
}
