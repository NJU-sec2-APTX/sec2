package client.businessLogicServiceImpl.hotelbl;

import java.util.ArrayList;
import java.util.Date;

import client.businessLogicService.hotelblService.HotelblUpdateService;
import client.dataService.HotelDataService;
import common.otherEnumClasses.Room;

public class Update implements HotelblUpdateService{

	@Override
	public boolean checkIn(int id, Date beginTime, int dayNum) {
		Room room = HotelDataService.getRoom(id);
		if(!room.isUsed){
			room.isUsed = true;
			room.beginTime = beginTime;
			return HotelDataService.setRoom(room);
		}
		return false;
		
	}

	@Override
	public boolean checkOut(int id, String endTime) {
		Room room = HotelDataService.getRoom(id);
		if(room.isUsed){
			room.isUsed = false;
			room.beginTime = null;
			room.endTime = endTime;
			return HotelDataService.setRoom(room);
		}
		return false;
	}

	@Override
	public boolean adminRoom(ArrayList<Room> rooms) {
		return HotelDataService.adminRoom(rooms);
	}
	
	
}
