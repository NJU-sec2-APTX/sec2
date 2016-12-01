package client.businessLogicService.hotelblService;

import common.otherEnumClasses.Person;
import common.vo.HotelVO;

public interface HotelblMaintainService {
	
	public HotelVO getHotelInfo(Person person);
	
	public boolean setHotelInfo(HotelVO hotelInfoVO);
}