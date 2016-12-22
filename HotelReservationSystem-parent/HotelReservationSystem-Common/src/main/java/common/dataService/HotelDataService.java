package common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import common.otherEnumClasses.HotelSearchConditions;
import common.po.HotelPO;

public interface HotelDataService extends Remote{
	
	public boolean addHotel(HotelPO po) throws RemoteException;
	
	public HotelPO getHotelInfo(String id) throws RemoteException;
	
	public boolean setHotelInfo(HotelPO hotelPO) throws RemoteException;
	
	public ArrayList<HotelPO> getHotelList(String area, String address, HotelSearchConditions searchItems) throws RemoteException;
}
