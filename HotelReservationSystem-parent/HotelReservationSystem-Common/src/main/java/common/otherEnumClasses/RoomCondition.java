package common.otherEnumClasses;

import java.io.Serializable;

public class RoomCondition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1705412326867711177L;
	public String id;// 唯一标识，便于数据库查找
	public String hotelId;
	public RoomType type = null;
	public double price = 0;
	public int totalNum = 0;
	public int restNum = 0;
	
	public RoomCondition(){
		
	}
	
	public RoomCondition(String hotelId, RoomType type, double price, int totalNum){
		this.id = hotelId+type.toString();
		this.hotelId = hotelId;
		this.type = type;
		this.price = price;
		this.totalNum = totalNum;
	}
}