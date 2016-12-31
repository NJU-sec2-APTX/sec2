package common.po;

import java.io.Serializable;
import java.util.ArrayList;

import common.otherEnumClasses.RoomCondition;
import common.vo.HotelVO;

public class HotelPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2353712117069542017L;
	private String id;
	private String name;
	private String area;
	private String address;
	private String introduction;
	private double price;//最低价格
	private int star;//网站管理人员有权设置
	private double mark;
	private long assessNum;
	private ArrayList<RoomCondition> rooms;
	
	public HotelPO() {
		
	}
	
	public HotelPO(HotelVO hotelVO){
		id = hotelVO.id;
		name = hotelVO.name;
		area = hotelVO.area;
		address = hotelVO.address;
		introduction = hotelVO.introduction;
		setPrice(hotelVO.price);
		setStar(hotelVO.star);
		mark = hotelVO.mark;
		rooms = hotelVO.rooms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ArrayList<RoomCondition> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<RoomCondition> rooms) {
		this.rooms = rooms;
	}

	public long getAssessNum() {
		return assessNum;
	}

	public void setAssessNum(long assessNum) {
		this.assessNum = assessNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}