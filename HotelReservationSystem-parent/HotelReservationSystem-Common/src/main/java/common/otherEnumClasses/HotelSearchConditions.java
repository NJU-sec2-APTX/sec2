package common.otherEnumClasses;

import java.io.Serializable;
import java.util.Date;

public class HotelSearchConditions implements Serializable{
	
	public String hotelName;
	public int priceUp;
	public int priceDown;
	public int starUp;
	public int starDown;
	public double markUp ;
	public double markDown;
	public Date dateUp;
	public Date dateDown;
	public int restHotelNumber = 0;//空房总数，忽略房间类型
	public boolean onlyEverReserved;//逻辑层已筛选
        
        public HotelSearchConditions(){
            priceUp = 10000;
            priceDown = 0;
            starUp = 5 ;
            starDown = 0;
            markUp = 5.0;
            markDown = 0.0;
            dateUp = null;
            dateDown = null;
            restHotelNumber = 10000;
            onlyEverReserved = false;
        }
}