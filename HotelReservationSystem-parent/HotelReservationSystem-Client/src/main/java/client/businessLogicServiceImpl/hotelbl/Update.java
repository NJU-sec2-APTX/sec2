package client.businessLogicServiceImpl.hotelbl;

import java.rmi.RemoteException;
import java.util.Date;

import client.Client;
import client.businessLogicService.hotelblService.HotelblUpdateService;
import common.otherEnumClasses.Room;
import common.otherEnumClasses.RoomState;

public class Update implements HotelblUpdateService{
	
	@Override
	public boolean checkIn(String hotelId, int roomId, Date beginTime, int day) {
		try {
			Room room = Client.getHotelDataService().getRoom(hotelId, roomId);
			if(room.state != RoomState.Used){
				room.state = RoomState.Used;
				room.beginTime = beginTime;
				room.day = day;
				return Client.getHotelDataService().setRoom(room);
			}
		} catch (RemoteException e) {}
		return false;
	}

	@Override
	public boolean checkOut(String hotelId, int roomId, Date endTime) {
		try {
			Room room = Client.getHotelDataService().getRoom(hotelId, roomId);
			if(room.state == RoomState.Used){
				room.state = RoomState.Empty;
				room.beginTime = null;
				room.day = 0;
				room.endTime = endTime;
				return Client.getHotelDataService().setRoom(room);
			}
		} catch (RemoteException e) {}
		return false;
	}
}