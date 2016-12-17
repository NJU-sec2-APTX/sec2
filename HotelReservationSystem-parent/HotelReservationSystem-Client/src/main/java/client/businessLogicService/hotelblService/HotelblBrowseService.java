package client.businessLogicService.hotelblService;

import java.util.ArrayList;

import common.otherEnumClasses.HotelSearchConditions;
import common.otherEnumClasses.Person;
import common.otherEnumClasses.SortFlag;
import common.vo.HotelVO;

public interface HotelblBrowseService {
	
	public ArrayList<HotelVO> getHotelList(String area, String address, HotelSearchConditions searchItems, String clientId);
	
	public ArrayList<HotelVO> sortHotelList(String area, String address, HotelSearchConditions searchItems, String clientId, SortFlag flag, boolean isIncrease);
}