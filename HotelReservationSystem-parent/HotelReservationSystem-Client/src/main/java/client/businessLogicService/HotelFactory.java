package client.businessLogicService;

import client.businessLogicService.hotelblService.HotelblBrowseService;
import client.businessLogicService.hotelblService.HotelblMaintainService;
import client.businessLogicService.hotelblService.HotelblUpdateService;
import client.businessLogicServiceImpl.hotelbl.BrowseController;
import client.businessLogicServiceImpl.hotelbl.Maintain;
import client.businessLogicServiceImpl.hotelbl.Update;

public class HotelFactory {

	public static HotelblBrowseService getHotelBrowseService(){
		return new BrowseController();
	}
	
	public static HotelblMaintainService getHotelMaintainService(){
		return new Maintain();
	}
	
	public static HotelblUpdateService getHotelUpdateService(){
		return new Update();
	}
}
