package common.otherEnumClasses;

import java.util.Date;

public class HotelSearchConditions {
	
	public String hotelName;
	public int priceUp = 10000;
	public int priceDown = 0;
	public int starUp = 5 ;
	public int starDown = 0;
	public double markUp = 5.0;
	public double markDown = 0.0;
	public Date dateUp = null;
	public Date dateDown = null;
	public int restHotelNumber = 0;//空房总数，忽略房间类型
	public boolean onlyEverReserved;//逻辑层已筛选
}