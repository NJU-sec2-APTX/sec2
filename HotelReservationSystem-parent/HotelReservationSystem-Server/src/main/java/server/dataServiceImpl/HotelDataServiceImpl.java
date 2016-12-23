package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import common.dataService.HotelDataService;
import common.otherEnumClasses.HotelSearchConditions;
import common.po.HotelPO;

public class HotelDataServiceImpl extends UnicastRemoteObject implements HotelDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6160639426085817165L;
	private DBHelper data;
	private ResultSet rs;

	public HotelDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public HotelPO getHotelInfo(String id) {
		HotelPO po = new HotelPO();
		String sql = "select * from hotel where id='" + id + "';";
		data = new DBHelper(sql);
		try {
			rs = data.pst.executeQuery(sql);
			while (rs.next()) {
				po.setName(rs.getString(1));
				po.setArea(rs.getString(2));
				po.setAddress(rs.getString(3));
				po.setIntroduction(rs.getString(4));
				po.setStar(rs.getInt(5));
				po.setMark(rs.getDouble(6));
				po.setPrice(rs.getDouble(7));
				po.setAssessNum(rs.getInt(8));
			}
		} catch (SQLException e) {

		}
		return null;
	}

	@Override
	public boolean setHotelInfo(HotelPO hotelInfoPO) {
		String sql = "update * from hotel where id='" + hotelInfoPO.getId() + "';";
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
		String sql = "select * from hotel where area='"+"area'&&address";
		return null;
	}

	@Override
	public boolean addHotel(HotelPO po) throws RemoteException {
		String sql = "insert into hotel (id,name,area,address,star) values ('" + po.getId() + "','" + po.getName()
				+ "','" + po.getArea() + "','" + po.getAddress() + "','" + po.getStar() + "')";
		data = new DBHelper(sql);
		try {
			if(data.pst.execute()){
				return true;
			}
		} catch (SQLException e) {}
		return false;
	}
}
