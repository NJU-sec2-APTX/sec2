package common.vo;

import java.util.Date;

import common.otherEnumClasses.OrderState;
import common.po.OrderPO;

public class OrderVO {

	public String id;
	public String hotelId;
	public double price;
	public OrderState state;
	public double mark;
	public String clientId;
	public String hotel;
	public int day;
	public Date createdTime;
	public Date planExecuteTime;
	public Date latestDoneTime;
	public Date checkInTime;
	public Date planDepartTime;
	public Date checkOutTime;
	public Date cancelTime;
	public int numberOfPerson;
	public boolean hasChild;
	public String numOfRoom;//按照RoomType类拼接，以'/'间隔
	
	public OrderVO(){
		
	}
	
	public OrderVO(OrderPO po){
		id = po.getId();
		hotelId = po.getHotelId();
		price = po.getPrice();
		state = po.getState();
		mark = po.getMark();
		clientId = po.getClientId();
		hotel = po.getHotel();
		day = po.getDay();
		createdTime = po.getCreatedTime();
		planExecuteTime = po.getPlanExecuteTime();
		latestDoneTime = po.getLatestDoneTime();
		checkInTime = po.getCheckInTime();
		planDepartTime = po.getPlanDepartTime();
		checkOutTime = po.getCheckOutTime();
		cancelTime = po.getCancelTime();
		numberOfPerson = po.getNumberOfPerson();
		hasChild = po.isHasChild();
		numOfRoom = po.getNumOfRoom();
	}
}
