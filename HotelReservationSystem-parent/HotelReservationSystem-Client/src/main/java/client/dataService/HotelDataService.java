package client.dataService;

import java.util.ArrayList;

import common.otherEnumClasses.Room;
import common.po.HotelPO;

public interface HotelDataService {
	
	public HotelPO getHotelInfo(String id);
	
	public boolean setHotelInfo(HotelPO hotelInfoPO);
	
	public ArrayList<HotelPO> getHotelList(String area, String address);
	
	public Room getRoom(String id);
	
	public boolean setRoom(Room room);
	
	public boolean adminRoom(ArrayList<Room> rooms);
	
}
