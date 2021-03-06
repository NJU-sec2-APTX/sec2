package common.po;

import java.io.Serializable;
import java.util.Date;

import common.otherEnumClasses.OrderState;
import common.vo.OrderVO;

public class OrderPO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4418625116144117845L;
	private String id;
	private String hotelId;
	private double price;
	private OrderState state;
	private double mark;
	private String clientId;
	private	String hotel;
	private int day;
	private Date createdTime;
	private Date planExecuteTime;
	private Date latestDoneTime;
	private Date checkInTime;
	private Date planDepartTime;
	private Date checkOutTime;
	private Date cancelTime;
	private int numberOfPerson;
	private boolean hasChild;
	private String numOfRoom;//按照RoomType类顺序拼接，以'/'间隔
	
	public OrderPO(){
		
	}
	
	public OrderPO(OrderVO vo){
		id = vo.id;
		hotelId = vo.hotelId;
		price = vo.price;
		state = vo.state;
		mark = vo.mark;
		clientId = vo.clientId;
		hotel = vo.hotel;
		day = vo.day;
		createdTime = vo.createdTime;
		planExecuteTime = vo.planExecuteTime;
		latestDoneTime = vo.latestDoneTime;
		checkInTime = vo.checkInTime;
		planDepartTime = vo.planDepartTime;
		checkOutTime = vo.checkOutTime;
		cancelTime = vo.cancelTime;
		numberOfPerson = vo.numberOfPerson;
		hasChild = vo.hasChild;
		numOfRoom = vo.numOfRoom;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Date getPlanDepartTime() {
		return planDepartTime;
	}

	public void setPlanDepartTime(Date planDepartTime) {
		this.planDepartTime = planDepartTime;
	}

	public Date getPlanExecuteTime() {
		return planExecuteTime;
	}

	public void setPlanExecuteTime(Date planExecuteTime) {
		this.planExecuteTime = planExecuteTime;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
}