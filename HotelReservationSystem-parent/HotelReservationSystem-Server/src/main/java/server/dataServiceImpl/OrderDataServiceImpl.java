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

	public OrderDataServiceImpl() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	@Override
	public ArrayList<HotelPO> searchReservedHotel(String clientId) throws RemoteException {
		ArrayList<HotelPO> hotels = new ArrayList<HotelPO>();
		ArrayList<OrderPO> orders = new ArrayList<OrderPO>();
		return null;
	}

	@Override
	public ArrayList<OrderPO> findOrderList(Person person, OrderState state, HotelVO hotelVO)
			throws RemoteException, ParseException {
		try {
			String sql = null;
			if (person.role == UserRole.Member || person.role == UserRole.Enterprise) {
				sql = "select * from order where id='" + person.id + "'";
				ArrayList<OrderPO> pos = getIn(sql);
				if(state!=null){
					ArrayList<OrderPO> orders = new ArrayList<OrderPO>();
				}else if(hotelVO!=null){
					
				}
				return pos;
			} else if (person.role == UserRole.HotelWorker) {
				String name = new HotelDataServiceImpl().getHotelInfo(person.id).getName();
				sql = "select * from order where hotel='" + name + "'";
				return getIn(sql);
			} else if (person.role == UserRole.Sales) {
				sql = "select * from order where state=Exceptional";
				return getIn(sql);
			}
		} catch (SQLException e) {}return null;
	}

	@Override
	public boolean updateOrder(OrderPO po) throws RemoteException {
		return false;
	}

	@Override
	public boolean addOrder(OrderPO po) throws RemoteException {
		return false;
	}

	@Override
	public OrderPO findOrderFromData(String orderId) throws RemoteException {
		return null;
	}

	private ArrayList<OrderPO> getIn(String sql) throws ParseException, SQLException {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		if (sql == null)
			return null;
		data = new DBHelper(sql);
		rs = data.pst.executeQuery(sql);
		while (rs.next()) {
			OrderPO po = new OrderPO();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
			po.setId(rs.getString(1));
			po.setCreditChange(rs.getDouble(2));
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
			pos.add(po);
		}
		return pos;
	}

}
