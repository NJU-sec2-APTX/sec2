package client.businessLogicServiceImpl.hotelbl;

import java.rmi.RemoteException;
import java.util.Date;

import client.Client;
import client.businessLogicService.hotelblService.HotelblUpdateService;
import common.otherEnumClasses.Person;
import common.otherEnumClasses.Room;

public class Update implements HotelblUpdateService{
	
	@Override
	public boolean checkIn(Person person, int roomId, Date beginTime, int dayNum) {
		try {
			Room room = Client.getHotelDataService().getRoom(roomId);
			if(!room.isUsed){
				room.isUsed = true;
				room.beginTime = beginTime;
				return Client.getHotelDataService().setRoom(room);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkOut(Person person, int roomID, Date endTime) {
		try {
			Room room = Client.getHotelDataService().getRoom(roomID);	
			if(room.isUsed){
				room.isUsed = false;
				room.beginTime = null;
				room.endTime = endTime;
				return Client.getHotelDataService().setRoom(room);
			}
		} catch (RemoteException e) {}
		return false;
	}
}
