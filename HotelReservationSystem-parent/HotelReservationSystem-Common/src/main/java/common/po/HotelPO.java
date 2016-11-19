package common.po;

import java.util.ArrayList;

import common.otherEnumClasses.Room;
import common.vo.HotelVO;

public class HotelPO {
	
	public String id;
	public String name;
	public String area;
	public String address;
	public String introduction;
	public int star;
	public double mark;
	public ArrayList<Room> rooms;
	
	public String accountId;
	public String accountPassword;
	
	
	public HotelPO(){
		
	}
	
	public HotelPO(HotelVO hotelVO){
		super();
		id = hotelVO.id;
		name = hotelVO.name;
		area = hotelVO.area;
		address = hotelVO.address;
		introduction = hotelVO.introduction;
		star = hotelVO.star;
		mark = hotelVO.mark;
	}
}