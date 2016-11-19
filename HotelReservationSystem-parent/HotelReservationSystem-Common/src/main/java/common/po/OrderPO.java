package common.po;

import java.util.Date;

import common.otherEnumClasses.OrderState;

public class OrderPO {
	
	String id;
	OrderState state;
	String userId;
	String hotel;
	Date createdTime;
	Date latestDoneTime;
	Date checkInTime;
	Date checkOutTime;
	
	int numberOfPerson;
	boolean haschild;
}
