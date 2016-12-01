package client.businessLogicServiceImpl.hotelbl;

import java.util.Comparator;

import common.vo.HotelVO;

public class PriceComparator implements Comparator<HotelVO>{
	
	boolean isIncrease;
	
	public int compare(HotelVO hotel1, HotelVO hotel2){
		double price1 = hotel1.price;
		double price2 = hotel2.price;
		if(price1>price2){
			return 1;
		}else if(price1<price2){
			return -1;
		}else{
			return 0;
		}
	}
}
