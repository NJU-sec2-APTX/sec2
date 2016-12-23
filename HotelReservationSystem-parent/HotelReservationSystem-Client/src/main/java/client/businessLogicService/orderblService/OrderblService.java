package client.businessLogicService.orderblService;

import java.util.ArrayList;
import java.util.Date;

import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.vo.HotelVO;
import common.vo.OrderVO;

public interface OrderblService {

	public ArrayList<HotelVO> searchReservedHotel(String clientId);
	
	public ArrayList<OrderVO> searchOrderListFromData(Person person, OrderState state, HotelVO hotelVO);
	
	public OrderVO createOrder(OrderVO vo, String clientId);
	
	public OrderVO executeOrder(String orderId, String hotelId, Date checkInTime, Date planCheckOutTime);
	
	public boolean assessOrder(OrderVO vo, double mark);
	
	public boolean clientCancelOrder(OrderVO vo);
	
	public boolean managerCancalOrder(OrderVO vo, boolean isAll);
}
