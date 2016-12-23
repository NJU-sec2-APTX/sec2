package common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.po.HotelPO;
import common.po.OrderPO;
import common.vo.HotelVO;

public interface OrderDataService extends Remote{

	public ArrayList<HotelPO> searchReservedHotel(String clientId) throws RemoteException;
	
	public OrderPO findOrderFromData(String orderId) throws RemoteException;
	
	public ArrayList<OrderPO> findOrderList(Person person,OrderState state, HotelVO hotelVO) throws RemoteException, ParseException;

	boolean updateOrder(OrderPO po) throws RemoteException;
	
	boolean addOrder(OrderPO po) throws RemoteException;
}