package common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import common.otherEnumClasses.HotelSearchConditions;
import common.otherEnumClasses.Room;
import common.po.HotelPO;

public interface HotelDataService extends Remote{
	
	public HotelPO getHotelInfo(String id) throws RemoteException;
	
	public boolean setHotelInfo(HotelPO hotelInfoPO) throws RemoteException;
	
	public ArrayList<HotelPO> getHotelList(String area, String address, HotelSearchConditions searchItems) throws RemoteException;
	
	public Room getRoom(int id) throws RemoteException;
	
	public boolean setRoom(Room room) throws RemoteException;
}
