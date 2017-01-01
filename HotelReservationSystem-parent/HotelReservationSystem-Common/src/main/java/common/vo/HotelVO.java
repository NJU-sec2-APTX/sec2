package common.vo;

import java.util.ArrayList;

import common.otherEnumClasses.RoomCondition;
import common.po.HotelPO;

public class HotelVO {
	
	public String id;
	public String name;
	public String area;
	public String address;
	public String introduction;
	public double price = 0.0;
	public int star;
	public double mark;
	public ArrayList<RoomCondition> rooms;
	public boolean isEverReserved;
	
	public HotelVO(){
		
	}
	
	public HotelVO(HotelPO hotelPO){
		id = hotelPO.getId();
		name = hotelPO.getName();
		area = hotelPO.getArea();
		address = hotelPO.getAddress();
		introduction = hotelPO.getIntroduction();
		star = hotelPO.getStar();
		mark = hotelPO.getMark();
		rooms = hotelPO.getRooms();
		isEverReserved = false;
	}
	
	public HotelVO(HotelPO hotelPO, boolean isEverReserved){
                id = hotelPO.getId();
		name = hotelPO.getName();
		area = hotelPO.getArea();
		address = hotelPO.getAddress();
		introduction = hotelPO.getIntroduction();
		star = hotelPO.getStar();
		mark = hotelPO.getMark();
		rooms = hotelPO.getRooms();
		this.isEverReserved = isEverReserved;
	}
}