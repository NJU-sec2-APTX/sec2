package client.businessLogicServiceImpl.hotelbl;

import java.util.Comparator;

import common.vo.HotelVO;

public class MarkComparator implements Comparator<HotelVO>{
	public int compare(HotelVO hotel1, HotelVO hotel2){
		double mark1 = hotel1.mark;
		double mark2 = hotel2.mark;
		if(mark1>mark2){
			return 1;
		}else if(mark1<mark2){
			return -1;
		}else{
			return 0;
		}
	}
}
