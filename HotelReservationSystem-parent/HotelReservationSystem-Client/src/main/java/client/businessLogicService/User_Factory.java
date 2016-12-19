package client.businessLogicService;

import client.businessLogicService.userblService.HotelWorkerMaintainService;
import client.businessLogicService.userblService.UserIFactory;
import client.businessLogicService.userblService.WebsiteManagerMaintainService;
import client.businessLogicService.userblService.WebsiteSalesMaintainService;
import client.businessLogicServiceImpl.userbl.HotelWorkerController;
import client.businessLogicServiceImpl.userbl.UserFactory;
import client.businessLogicServiceImpl.userbl.WebsiteManagerController;
import client.businessLogicServiceImpl.userbl.WebsiteSalesController;

public class User_Factory {
	public static UserIFactory getUserService(){
		return new UserFactory();
	}
	
	public static HotelWorkerMaintainService getHotelWorkerController(String id){
		return new HotelWorkerController(id);
	}
	
	public static WebsiteManagerMaintainService getWebsiteManagerController(String id){
		return new WebsiteManagerController(id);
	}
	
	public static WebsiteSalesMaintainService getWebsiteSalesController(String id){
		return new WebsiteSalesController(id);
	}
}
