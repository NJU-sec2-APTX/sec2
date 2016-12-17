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
	public Date createdTime;
	public Date latestDoneTime;
	public Date checkInTime;
	public Date checkOutTime;
	public Date cancelTime;
	public int numberOfPerson;
	public boolean hasChild;
	public String numOfRoom;
	
	public OrderVO(){
		
	}
	
	public OrderVO(OrderPO po){
		id = po.getId();
		creditChange = po.getCreditChange();
		state = po.getState();
		mark = po.getMark();
		clientId = po.getClientId();
		hotel = po.getHotel();
		createdTime = po.getCheckInTime();
		latestDoneTime = po.getLatestDoneTime();
		checkInTime = po.getCheckInTime();
		checkOutTime = po.getCheckOutTime();
		cancelTime = po.getCancelTime();
		numberOfPerson = po.getNumberOfPerson();
		hasChild = po.isHasChild();
	}
}
