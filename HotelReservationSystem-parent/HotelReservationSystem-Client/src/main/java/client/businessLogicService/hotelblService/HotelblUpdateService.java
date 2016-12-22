package client.businessLogicService.hotelblService;

import java.util.Date;

public interface HotelblUpdateService {

	public boolean offlineCheckIn(String hotelId, String orderId, Date checkInTime, Date planDepartTime);
	
	public boolean checkOut(String hotelId, String orderId, Date DepartTime);
}