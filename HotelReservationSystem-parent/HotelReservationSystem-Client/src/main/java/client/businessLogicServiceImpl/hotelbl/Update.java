package client.businessLogicServiceImpl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import client.Client;
import client.businessLogicService.hotelblService.HotelblUpdateService;
import common.otherEnumClasses.RoomCondition;
import common.po.HotelPO;
import common.po.OrderPO;

public class Update implements HotelblUpdateService {

	public boolean offlineCheckIn(String hotelId, String numOfRoom, Date checkInTime, Date planDepartTime) {
		try {
			HotelPO hotelPO = Client.getHotelDataService().getHotelInfo(hotelId);
			Client.getHotelDataService().setHotelInfo(decrease(hotelPO, numOfRoom));
			return true;
		} catch (RemoteException e) {
			return false;
		}
	}

	public boolean checkOut(String hotelId, String orderId, Date departTime) {
		try {
			HotelPO hotelPO = Client.getHotelDataService().getHotelInfo(hotelId);
			if(orderId.charAt(0)=='/'){
				return Client.getHotelDataService().setHotelInfo(increase(hotelPO, orderId.substring(1)));
			}else{
				OrderPO orderPO = Client.getOrderDataService().findOrderFromData(orderId);
				orderPO.setCheckOutTime(departTime);
				Client.getOrderDataService().updateOrder(orderPO);
				return Client.getHotelDataService().setHotelInfo(increase(hotelPO, orderPO.getNumOfRoom()));
			}
		} catch (RemoteException e) {}
		return false;
	}
	
	private HotelPO increase(HotelPO po, String num){
		ArrayList<RoomCondition> rooms = po.getRooms();
		int temp =  num.indexOf('/');
		rooms.get(0).restNum += Integer.parseInt(num.substring(0,temp));
		num = num.substring(temp+1);
		temp = num.indexOf('/');
		rooms.get(1).restNum += Integer.parseInt(num.substring(0,temp));
		rooms.get(2).restNum += Integer.parseInt(num.substring(temp+1));
		po.setRooms(rooms);
		return po;
	}
	
	private HotelPO decrease(HotelPO po, String num){
		ArrayList<RoomCondition> rooms = po.getRooms();
		int temp =  num.indexOf('/');
		rooms.get(0).restNum -= Integer.parseInt(num.substring(0,temp));
		num = num.substring(temp+1);
		temp = num.indexOf('/');
		rooms.get(1).restNum -= Integer.parseInt(num.substring(0,temp));
		rooms.get(2).restNum -= Integer.parseInt(num.substring(temp+1));
		po.setRooms(rooms);
		return po;
	}
}