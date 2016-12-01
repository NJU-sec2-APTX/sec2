package common.po;

import java.util.ArrayList;

import common.otherEnumClasses.Room;
import common.vo.HotelVO;

public class HotelPO {
	
	private String id;
	private String name;
	private String area;
	private String address;
	private String introduction;
	private double price;
	private int star;
	private double mark;
	private ArrayList<Room> rooms;
	
	public HotelPO() {
	
	}
	
	public HotelPO(HotelVO hotelVO){
		id = hotelVO.id;
		name = hotelVO.name;
		area = hotelVO.area;
		address = hotelVO.address;
		introduction = hotelVO.introduction;
		setStar(hotelVO.star);
		mark = hotelVO.mark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
}