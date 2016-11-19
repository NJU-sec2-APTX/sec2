package client.businessLogicService.hotelblService;

import java.util.ArrayList;

import client.po.Room;

public interface HotelblUpdateService {
	
	public boolean checkIn(int id, String beginTime, int dayNum);
	
	public boolean checkOut(int id, String endTime);
	
	public boolean adminRoom(ArrayList<Room> rooms);
}
