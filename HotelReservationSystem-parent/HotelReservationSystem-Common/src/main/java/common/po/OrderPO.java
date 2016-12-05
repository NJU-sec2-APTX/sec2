package common.po;

import java.util.ArrayList;
import java.util.Date;

import common.otherEnumClasses.CreditChange;
import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.vo.OrderVO;

public class OrderPO {
	
	private String id;
	private double creditChange;
	private double price;
	private OrderState state;
	private double mark;
	private Person person;
	private	String hotel;
	private Date createdTime;
	private Date latestDoneTime;
	private Date checkInTime;
	private Date checkOutTime;
	private int numberOfPerson;
	private boolean haschild;
	ArrayList<CreditChange> creditChangeList;
	
	public OrderPO(){
		
	}
	
	public OrderPO(OrderVO vo){
		id = vo.id;
		creditChange = vo.creditChange;
		state = vo.state;
		mark = vo.mark;
		person = vo.person;
		hotel = vo.hotel;
		createdTime = vo.checkInTime;
		latestDoneTime = vo.latestDoneTime;
		checkInTime = vo.checkInTime;
		checkOutTime = vo.checkOutTime;
		numberOfPerson = vo.numberOfPerson;
		haschild = vo.haschild;
	}
	
	public void addCreditChange(CreditChange oneRecord){
		this.creditChangeList.add(oneRecord);
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

	public ArrayList<CreditChange> getCreditChangeList() {
		return creditChangeList;
	}

	public void setCreditChangeList(ArrayList<CreditChange> creditChangeList) {
		this.creditChangeList = creditChangeList;
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
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
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
	public boolean isHaschild() {
		return haschild;
	}
	public void setHaschild(boolean haschild) {
		this.haschild = haschild;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
}