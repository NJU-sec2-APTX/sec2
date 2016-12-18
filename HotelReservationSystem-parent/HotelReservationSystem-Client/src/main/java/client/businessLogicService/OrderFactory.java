package client.businessLogicService;

import client.businessLogicService.orderblService.OrderblService;
import client.businessLogicServiceImpl.orderbl.OrderOperation;

public class OrderFactory {

	public static OrderblService getOrderService(){
		return new OrderOperation();
	}
}
