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
	public int star;
	public double mark;
	public ArrayList<Room> roomCondition;
	
	public HotelVO(HotelPO hotelPO){
		id = hotelPO.id;
		name = hotelPO.name;
		area = hotelPO.area;
		address = hotelPO.address;
		introduction = hotelPO.introduction;
		star = hotelPO.star;
		mark = hotelPO.mark;
		
		//convert rooms to rommCondition
	}
}
