package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import common.dataService.HotelDataService;
import common.otherEnumClasses.Room;
import common.po.HotelPO;

public class HotelDataServiceImpl extends UnicastRemoteObject implements HotelDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6160639426085817165L;

	public HotelDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public HotelPO getHotelInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setHotelInfo(HotelPO hotelInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<HotelPO> getHotelList(String area, String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room getRoom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setRoom(Room room) {
		// TODO Auto-generated method stub
		return false;
	}

}
