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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
			sql = "select * from orderlist where clientId='" + person.id + "'";
                        System.out.println(sql+"/////////////");
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
			sql = "select * from orderlist where hotel='" + name + "'";
			return getList(sql);
		} else if (person.role == UserRole.Sales) {
			sql = "select * from orderlist where state=Exceptional";
			return getList(sql);
		}
		data.close();
		return null;
	}

	@Override
	public boolean updateOrder(OrderPO po) throws RemoteException {
		String sql = "update orderlist set"
				+" hotelId = '"+po.getHotelId()+"'"
				+", price = '"+po.getPrice()+"'"
				+", state = '"+po.getState().toString()+"'"
				+", mark = '"+po.getMark()+"'"
				+", clientId = '"+po.getClientId()+"'"
				+", hotel = '"+po.getHotel()+"'"
				+", day = '"+po.getDay()+"'"
				+", createdTime = '"+getString(po.getCreatedTime())+"'"
				+", planExecuteTime = '"+getString(po.getPlanExecuteTime())+"'"
				+", latestDoneTime = '"+getString(po.getLatestDoneTime())+"'"
				+", checkInTime = '"+getString(po.getCheckInTime())+"'"
				+", planDepartTime = '"+getString(po.getPlanDepartTime())+"'"
				+", checkOutTime = '"+getString(po.getCheckOutTime())+"'"
				+", cancelTime = '"+getString(po.getCancelTime())+"'"
				+", numberOfPerson = '"+po.getNumberOfPerson()+"'"
				+", hasChild = "+(po.isHasChild()?1:0)
				+", numOfRoom = '"+po.getNumOfRoom()+"'"
				+" where id='" + po.getId() + "'";
		data = new DBHelper(sql);
		try {
			if (!data.pst.execute()) {
				return true;
			}
		} catch (SQLException e) {
                    e.printStackTrace();
		}
		data.close();
		return false;
	}

	@Override
	public boolean addOrder(OrderPO po) throws RemoteException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
		String sql = "insert into orderlist(id,hotelId,price,state,clientId,hotel,day,"
				+ "createdTime,planExecuteTime,latestDoneTime,numberOfPerson,hasChild,numOfRoom) value ('" + po.getId()
				+ "','" + po.getHotelId() + "','" + po.getPrice() + "','" + po.getState() + "','" + po.getClientId()
				+ "','" + po.getHotel() + "','" + po.getDay() + "','" + sdf.format(po.getCreatedTime()) + "','"
				+ sdf.format(po.getPlanExecuteTime()) + "','" + sdf.format(po.getLatestDoneTime()) + "','" + po.getNumberOfPerson()
				+ "'," + (po.isHasChild()?1:0) + ",'" + po.getNumOfRoom() + "')";
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
		String sql = "select * from orderlist where id='" + orderId + "'";
		data = new DBHelper(sql);
		OrderPO po = new OrderPO();
		try {
			rs = data.pst.executeQuery(sql);
			if (rs.next()) {
				po = getPO();
			}
		} catch (SQLException e) {
                    e.printStackTrace();
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
                System.out.println(sql+"******");
		if (sql == null)
			return null;
		data = new DBHelper(sql);
                System.out.println("sql:"+sql);
		try {
			rs = data.pst.executeQuery(sql);
			while (rs.next()) {
				pos.add(getPO());
			}
		} catch (SQLException e) {
                    e.printStackTrace();
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
		try {
			po.setId(rs.getString(1));
			po.setHotelId(rs.getString(2));
			po.setPrice(rs.getDouble(3));
			po.setState(OrderState.get(rs.getString(4)));
			po.setMark(rs.getDouble(5));
			po.setClientId(rs.getString(6));
			po.setHotel(rs.getString(7));
			po.setDay(rs.getInt(8));
			po.setCreatedTime(getTime(rs.getString(9)));
			po.setPlanExecuteTime(getTime(rs.getString(10)));
			po.setLatestDoneTime(getTime(rs.getString(11)));
			po.setCheckInTime(getTime(rs.getString(12)));
			po.setPlanDepartTime(getTime(rs.getString(13)));
			po.setCheckOutTime(getTime(rs.getString(14)));
			po.setCancelTime(getTime(rs.getString(15)));
			po.setNumberOfPerson(rs.getInt(16));
			po.setHasChild(rs.getBoolean(17));
			po.setNumOfRoom(rs.getString(18));
		} catch (SQLException e) {
                    e.printStackTrace();
		}
		return po;
	}
        
        private Date getTime(String s){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
            if(s!=null&&!s.equals("null")&&!s.equals("")){
                try {
                	System.out.print(s);
                    return  sdf.parse(s);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
            return  null;
        }
        
        private String getString(Date d){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
            if(d!=null){
                return sdf.format(d);
            }
            return null;
        }
}
