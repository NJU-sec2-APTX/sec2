package common.vo;

import java.util.Date;

import common.otherEnumClasses.OrderState;
import common.po.OrderPO;

public class OrderVO {

	public String id;
	public double creditChange;
	public double price;
	public OrderState state;
	public double mark;
	public String clientId;
	public String hotel;
	public int day;
	public Date createdTime;
	public Date planTime;
	public Date latestDoneTime;
	public Date checkInTime;
	public Date checkOutTime;
	public Date cancelTime;
	public int numberOfPerson;
	public boolean hasChild;
	public String numOfRoom;//按照RoomType类拼接，以'/'间隔
	public int[] roomIds;
	
	public OrderVO(){
		
	}
	
	public OrderVO(OrderPO po){
		id = po.getId();
		creditChange = po.getCreditChange();
		price = po.getPrice();
		state = po.getState();
		mark = po.getMark();
		clientId = po.getClientId();
		hotel = po.getHotel();
		day = po.getDay();
		createdTime = po.getCheckInTime();
		planTime = po.getPlanTime();
		latestDoneTime = po.getLatestDoneTime();
		checkInTime = po.getCheckInTime();
		checkOutTime = po.getCheckOutTime();
		cancelTime = po.getCancelTime();
		numberOfPerson = po.getNumberOfPerson();
		hasChild = po.isHasChild();
		numOfRoom = po.getNumOfRoom();
		roomIds = po.getRoomIds();
	}
}
