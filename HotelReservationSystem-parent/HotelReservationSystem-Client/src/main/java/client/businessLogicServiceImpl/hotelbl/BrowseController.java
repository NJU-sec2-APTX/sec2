package client.businessLogicServiceImpl.hotelbl;

import java.util.ArrayList;

import client.businessLogicService.hotelblService.HotelblBrowseService;
import common.otherEnumClasses.HotelSearchConditions;
import common.otherEnumClasses.Person;
import common.otherEnumClasses.SortFlag;
import common.vo.HotelVO;

public class BrowseController implements HotelblBrowseService{
	
	BrowseHotel bh;
	@Override
	public ArrayList<HotelVO> getHotelList(String area, String address, HotelSearchConditions searchItems, Person person) {
		return bh.browse(area, address, searchItems, person);
	}

	@Override
	public ArrayList<HotelVO> sortHotelList(String area, String address, HotelSearchConditions searchItems, Person person, SortFlag flag, boolean isIncrease) {
		
		return bh.sort(bh.browse(area, address, searchItems,person), flag, isIncrease);
	}
}