package common.otherEnumClasses;

import java.util.Date;

public class Room {
	
	public String hotelId;
	public int id;
	public RoomType type;
	public double price;
	
	public RoomState state;
	public Date beginTime;//开始入住的时间（预计或者实际）
	public Date endTime;//退房时间（预计或者实际）
	public int day;
}