package common.po;

import java.util.Date;

import common.otherEnumClasses.OrderState;
import common.vo.OrderVO;

public class OrderPO {
	
	private String id;
	private double creditChange;
	private double price;
	private OrderState state;
	private double mark;
	private String clientId;
	private	String hotel;
	private int day;
	private Date createdTime;
	private Date planTime;
	private Date latestDoneTime;
	private Date checkInTime;
	private Date checkOutTime;
	private Date cancelTime;
	private int numberOfPerson;
	private boolean hasChild;
	private String numOfRoom;//按照RoomType类拼接，以'/'间隔
	private int[] roomIds;
	
	public OrderPO(){
		
	}
	
	public OrderPO(OrderVO vo){
		id = vo.id;
		creditChange = vo.creditChange;
		price = vo.price;
		state = vo.state;
		mark = vo.mark;
		clientId = vo.clientId;
		hotel = vo.hotel;
		day = vo.day;
		createdTime = vo.createdTime;
		planTime = vo.planTime;
		latestDoneTime = vo.latestDoneTime;
		checkInTime = vo.checkInTime;
		checkOutTime = vo.checkOutTime;
		cancelTime = vo.cancelTime;
		numberOfPerson = vo.numberOfPerson;
		hasChild = vo.hasChild;
		numOfRoom = vo.numOfRoom;
		roomIds = vo.roomIds;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getCreditChange() {
		return creditChange;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setCreditChange(double creditChange) {
		this.creditChange = creditChange;
	}

	public void setCreditChange(int creditChange) {
		this.creditChange = creditChange;
	}
	public OrderState getState() {
		return state;
	}
	public void setState(OrderState state) {
		this.state = state;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getLatestDoneTime() {
		return latestDoneTime;
	}
	public void setLatestDoneTime(Date latestDoneTime) {
		this.latestDoneTime = latestDoneTime;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Date getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public int getNumberOfPerson() {
		return numberOfPerson;
	}
	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}
	public boolean isHasChild() {
		return hasChild;
	}
	public void setHasChild(boolean haschild) {
		this.hasChild = haschild;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getNumOfRoom() {
		return numOfRoom;
	}

	public void setNumOfRoom(String numOfRoom) {
		this.numOfRoom = numOfRoom;
	}

	public int[] getRoomIds() {
		return roomIds;
	}

	public void setRoomIds(int[] roomIds) {
		this.roomIds = roomIds;
	}

	public Date getPlanTime() {
		return planTime;
	}

	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}