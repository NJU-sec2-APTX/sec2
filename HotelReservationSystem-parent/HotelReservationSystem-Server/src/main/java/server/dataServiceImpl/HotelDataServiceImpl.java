package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.dataService.HotelDataService;
import common.otherEnumClasses.HotelSearchConditions;
import common.otherEnumClasses.RoomCondition;
import common.otherEnumClasses.RoomType;
import common.po.HotelPO;

public class HotelDataServiceImpl extends UnicastRemoteObject implements HotelDataService {

	private static final long serialVersionUID = 6160639426085817165L;
	private DBHelper data;
	private ResultSet rs;

	public HotelDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public HotelPO getHotelInfo(String id) {
		HotelPO po = new HotelPO();
		try {
			String sql = "select * from hotel where id='" + id + "';";
			data = new DBHelper(sql);
			rs = data.pst.executeQuery(sql);
			while (rs.next()) {
				po.setId(rs.getString(1));
				po.setName(rs.getString(2));
				po.setArea(rs.getString(3));
				po.setAddress(rs.getString(4));
				po.setIntroduction(rs.getString(5));
				po.setPrice(rs.getDouble(6));
				po.setStar(rs.getInt(7));
				po.setMark(rs.getDouble(8));
				po.setAssessNum(rs.getInt(9));
			}
			return getRooms(po);
		} catch (SQLException e) {
		}
		return null;
	}

	private HotelPO getRooms(HotelPO po) {
		ArrayList<RoomCondition> rooms = new ArrayList<RoomCondition>();
		rooms.add(getRoom(po, "SingleStd"));
		rooms.add(getRoom(po, "DoubleStd"));
		rooms.add(getRoom(po, "Family"));
		po.setRooms(rooms);
		return po;
	}

	private RoomCondition getRoom(HotelPO po, String s) {
		RoomCondition r = new RoomCondition();
		try {
			String sql = "select * from room where id='" + po.getId() + s + "'";
			data = new DBHelper(sql);
			rs = data.pst.executeQuery(sql);
			if (rs.next()) {
				r = new RoomCondition(rs.getString(2), RoomType.get(rs.getString(3)), rs.getDouble(4), rs.getInt(5));
				r.restNum = rs.getInt(6);
			}
		} catch (SQLException e) {
		}
		return r;
	}

	@Override
	public boolean setHotelInfo(HotelPO po) {
		String sql = "update hotel set" 
				+ " name = '" + po.getName() + "'"
				+", area = '" + po.getArea() + "'"
				+", address = '" + po.getArea() + "'"
				+", introduction = '" + po.getIntroduction() + "'"
				+", price = '" + po.getPrice() + "'"
				+", star = '" + po.getStar() + "'"
				+", mark = '" + po.getMark() + "'"
				+", assessNum = '" + po.getAssessNum() + "'"
				+" where id='" + po.getId() + "'";
		data = new DBHelper(sql);
		try {
			if (data.pst.execute()) {
				return true;
			}
			setRooms(po);
		} catch (SQLException e) {
		}
		return false;
	}

	private boolean setRooms(HotelPO po) {
		if(setRoom(po.getId()+"SingleStd", po.getRooms().get(0))&&
		setRoom(po.getId()+"DoubleStd", po.getRooms().get(1))&&
		setRoom(po.getId()+"Family", po.getRooms().get(2))) return true;
		return false;
	}

	private boolean setRoom(String id, RoomCondition r) {
		String sql = "update room set"
				+" price = '" + r.price + "'"
				+" totalNum = " + r.totalNum + "'"
				+" restNum = " + r.restNum + "'"
				+"where id='" + id + "'";
		data = new DBHelper(sql);
		try {
			return data.pst.execute();
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public ArrayList<HotelPO> getHotelList(String area, String address, HotelSearchConditions searchItems) {
		ArrayList<HotelPO> pos = new ArrayList<HotelPO>();
		String sql = "select * from hotel where area = '" + area +"'&&address = '" + address 
				+ "'&&price <= '" + searchItems.priceUp + "'&&price >= '" + searchItems.priceDown
				+ "'&&star <= '" + searchItems.starUp + "'&&star >= '" + searchItems.starDown
				+ "'&&mark <= '" + searchItems.markUp + "'&&mark >= '" + searchItems.markDown
				+ "'";
		try {
			data = new DBHelper(sql);
			rs = data.pst.executeQuery(sql);
			while(rs.next()){
				pos.add(getHotel(rs));
			}
		} catch (SQLException e) {}
		return pos;
	}

	@Override
	public boolean addHotel(HotelPO po) throws RemoteException {
		String sql = "insert into hotel (id,name,area,address,star) values ('" + po.getId() + "','" + po.getName()
				+ "','" + po.getArea() + "','" + po.getAddress() + "','" + po.getStar() + "')";
		data = new DBHelper(sql);
		try {
			if (data.pst.execute()&&addRooms(po.getId())) {
				return true;
			}
		} catch (SQLException e) {
		}
		return false;
	}
	
	private boolean addRooms(String hotelId){
		if(addRoom(hotelId, "SingleStd")&&addRoom(hotelId, "DoubleStd")&&addRoom(hotelId, "Family")) return true;
		return false;
	}
	
	private boolean addRoom(String hotelId, String type){
		String sql = "insert into room (id,hotelId,roomtype,price,totalNum,restNum) values ('" 
				+ hotelId + type + "','" + hotelId + "','" + type + "','" 
				+ "0.0" + "','" + "0" + "','" + "0" +"')";
		data = new DBHelper(sql);
		try {
			if (data.pst.execute()) {
				return true;
			}
		} catch (SQLException e) {}
		return false;
	}
	
	private HotelPO getHotel(ResultSet rs){
		HotelPO po = new HotelPO();
		try {
			po.setId(rs.getString(1));
			po.setName(rs.getString(2));
			po.setArea(rs.getString(3));
			po.setAddress(rs.getString(4));
			po.setIntroduction(rs.getString(5));
			po.setPrice(rs.getDouble(6));
			po.setStar(rs.getInt(7));
			po.setMark(rs.getDouble(8));
			po.setAssessNum(rs.getInt(9));
		} catch (SQLException e) {}
		return po;
	}
}
