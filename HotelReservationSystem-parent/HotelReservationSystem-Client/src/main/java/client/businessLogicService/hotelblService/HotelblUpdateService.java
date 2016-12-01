package client.businessLogicService.hotelblService;

import java.util.Date;

import common.otherEnumClasses.Person;

public interface HotelblUpdateService {
	
	public boolean checkIn(Person person, int roomId, Date beginTime, int dayNum);
	
	public boolean checkOut(Person person, int roomId, Date endTime);

}