package common.dataService;

import java.rmi.Remote;
import java.util.ArrayList;

import common.otherEnumClasses.Person;
import common.po.OrderPO;

public interface OrderDataService extends Remote{

	ArrayList<OrderPO> findOrderList(Person person);

	boolean updateOrder(OrderPO po);
	
}
