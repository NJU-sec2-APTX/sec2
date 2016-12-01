package common.vo;

import java.util.Date;

import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.po.OrderPO;

public class OrderVO {

	public String id;
	public int creditChange;
	public OrderState state;
	public double mark;
	public Person person;
	public String hotel;
	public Date createdTime;
	public Date latestDoneTime;
	public Date checkInTime;
	public Date checkOutTime;
	public int numberOfPerson;
	public boolean haschild;
	
	public OrderVO(){
		
	}
	
	public OrderVO(OrderPO po){
		id = po.getId();
		creditChange = po.getCreditChange();
		state = po.getState();
		mark = po.getMark();
		person = po.getPerson();
		hotel = po.getHotel();
		createdTime = po.getCheckInTime();
		latestDoneTime = po.getLatestDoneTime();
		checkInTime = po.getCheckInTime();
		checkOutTime = po.getCheckOutTime();
		numberOfPerson = po.getNumberOfPerson();
		haschild = po.isHaschild();
	}
}
