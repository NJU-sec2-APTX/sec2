package common.vo;

import java.util.ArrayList;

import common.otherEnumClasses.Room;
import common.po.HotelPO;

public class HotelVO {
	
	public String id;
	public String name;
	public String area;
	public String address;
	public String introduction;
	public double price;
	public int star;
	public double mark;
	public ArrayList<Room> rooms;
	public boolean isEverReserved;
	
	public HotelVO(HotelPO hotelPO){
		id = hotelPO.getId();
		name = hotelPO.getName();
		area = hotelPO.getArea();
		address = hotelPO.getAddress();
		introduction = hotelPO.getIntroduction();
		star = hotelPO.getStar();
		mark = hotelPO.getMark();
		rooms = hotelPO.getRooms();
	}
}
