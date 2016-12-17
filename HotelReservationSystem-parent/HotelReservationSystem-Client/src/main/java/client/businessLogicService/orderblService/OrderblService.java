package client.businessLogicService.orderblService;

import java.util.ArrayList;
import java.util.Date;

import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.vo.HotelVO;
import common.vo.OrderVO;

public interface OrderblService {
	
	public ArrayList<HotelVO> searchReservedHotel(String clientId);
	
	public ArrayList<OrderVO> searchOrderListFromData(Person person,OrderState state, HotelVO vo);
	
	public boolean createOrder(OrderVO vo, String clientId);
	
	public boolean executeOrder(String orderId, String clientId, Date checkInTime);
	
	public boolean assessOrder(OrderVO vo, double mark);
	
	public boolean clientCancelOrder(OrderVO vo);
	
	public boolean managerCancalOrder(OrderVO vo, boolean isAll);
}
