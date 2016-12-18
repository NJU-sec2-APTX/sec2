package client.businessLogicService.hotelblService;

import java.util.Date;

public interface HotelblUpdateService {
	
	public boolean checkIn(String hotelId, int roomId, Date beginTime, int dayNum);
	
	public boolean checkOut(String hotelId, int roomId, Date endTime);

}