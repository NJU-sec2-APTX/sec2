package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.dataService.HotelDataService;
import common.otherEnumClasses.HotelSearchConditions;
import common.otherEnumClasses.Room;
import common.po.HotelPO;

public class HotelDataServiceImpl extends UnicastRemoteObject implements HotelDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6160639426085817165L;
	private DBHelper database;
	private ResultSet rs;

	public HotelDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public HotelPO getHotelInfo(String id) {
		HotelPO po = new HotelPO();
		String sql = "select * from hotel where id="+id;
		database = new DBHelper(sql);
		try {
			rs = database.conn.createStatement().executeQuery(sql);
			while(rs.next()){
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean setHotelInfo(HotelPO hotelInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<HotelPO> getHotelList(String area, String address, HotelSearchConditions searchItems) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addHotel(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
