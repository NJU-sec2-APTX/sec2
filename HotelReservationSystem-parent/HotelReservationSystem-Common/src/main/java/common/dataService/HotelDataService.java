package common.dataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import common.otherEnumClasses.Room;
import common.po.HotelPO;

public interface HotelDataService {
	
	public HotelPO getHotelInfo(String id) throws RemoteException;
	
	public boolean setHotelInfo(HotelPO hotelInfoPO) throws RemoteException;
	
	public ArrayList<HotelPO> getHotelList(String area, String address) throws RemoteException;
	
	public Room getRoom(String id) throws RemoteException;
	
	public boolean setRoom(Room room) throws RemoteException;	
}
