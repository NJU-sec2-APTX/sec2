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
			return getRoom(po);
		} catch (SQLException e) {
		}
		return null;
	}

	private HotelPO getRoom(HotelPO po) {
		ArrayList<RoomCondition> rooms = new ArrayList<RoomCondition>();
		rooms.add(get(po, "SingleStd"));
		rooms.add(get(po, "DoubleStd"));
		rooms.add(get(po, "Family"));
		po.setRooms(rooms);
		return po;
	}

	private RoomCondition get(HotelPO po, String s) {
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
	public boolean setHotelInfo(HotelPO hotelInfoPO) {
		String sql = "update * from hotel where id='" + hotelInfoPO.getId() + "'";
		data = new DBHelper(sql);
		try {
			if (data.pst.execute()) {
				return true;
			}
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public ArrayList<HotelPO> getHotelList(String area, String address, HotelSearchConditions searchItems) {
		ArrayList<HotelPO> pos = new ArrayList<HotelPO>();
		String sql = "select * from hotel where area='" + "area'&&address";
		return null;
	}

	@Override
	public boolean addHotel(HotelPO po) throws RemoteException {
		String sql = "insert into hotel (id,name,area,address,star) values ('" + po.getId() + "','" + po.getName()
				+ "','" + po.getArea() + "','" + po.getAddress() + "','" + po.getStar() + "')";
		data = new DBHelper(sql);
		try {
			if (data.pst.execute()) {
				return true;
			}
		} catch (SQLException e) {
		}
		return false;
	}
}
