package client.businessLogicServiceImpl.hotelbl;

import java.util.Comparator;

import common.vo.HotelVO;

public class StarComparator implements Comparator<HotelVO>{
	public int compare(HotelVO hotel1, HotelVO hotel2){
		int star1 = hotel1.star;
		int star2 = hotel2.star;
		if(star1>star2){
			return 1;
		}else if(star1<star2){
			return -1;
		}else{
			return 0;
		}
	}
}
