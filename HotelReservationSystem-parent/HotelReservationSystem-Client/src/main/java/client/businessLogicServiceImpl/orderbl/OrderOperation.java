package client.businessLogicServiceImpl.orderbl;

import java.util.ArrayList;
import java.util.Date;

import client.dataService.OrderDataService;
import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.po.OrderPO;
import common.vo.OrderVO;

public class OrderOperation {

	ArrayList<OrderVO> searchOrderListFromData(Person person){
		ArrayList<OrderPO> pos = OrderDataService.findOrderList();
		
		return null;
	}
	
	boolean executeOrder(OrderVO vo, Person person){
		if(vo.state==OrderState.NotDone){
			vo.state = OrderState.Done;	
		}else if(vo.state==OrderState.Exceptional){
			vo.state = OrderState.Done;
			
		}
		return false;
	}
	
	boolean assessOrder(OrderVO vo, double mark){
		vo.mark = mark;
		OrderPO po = new OrderPO(vo);
		OrderDataService.
		return false;
		
	}
	
	boolean cancelOrder(OrderVO vo){
		return false;
		
	}
}
