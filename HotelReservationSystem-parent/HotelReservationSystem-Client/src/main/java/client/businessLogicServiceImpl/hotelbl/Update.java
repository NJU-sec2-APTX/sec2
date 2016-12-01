package client.businessLogicServiceImpl.hotelbl;

import java.util.Date;

import client.businessLogicService.hotelblService.HotelblUpdateService;
import common.dataService.HotelDataService;
import common.otherEnumClasses.Person;
import common.otherEnumClasses.Room;

public class Update implements HotelblUpdateService{
	
	@Override
	public boolean checkIn(Person person, int roomId, Date beginTime, int dayNum) {
		Room room = HotelDataService.getRoom(roomId);
		if(!room.isUsed){
			room.isUsed = true;
			room.beginTime = beginTime;
			return HotelDataService.setRoom(room);
		}
		return false;
	}

	@Override
	public boolean checkOut(Person person, int roomID, Date endTime) {
		Room room = HotelDataService.getRoom(person.id);
		if(room.isUsed){
			room.isUsed = false;
			room.beginTime = null;
			room.endTime = endTime;
			return HotelDataService.setRoom(room);
		}
		return false;
	}
}
