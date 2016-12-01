package client.businessLogicServiceImpl.hotelbl;

import java.util.ArrayList;

import client.businessLogicService.hotelblService.HotelblMaintainService;
import common.dataService.HotelDataService;
import common.otherEnumClasses.Person;
import common.otherEnumClasses.Room;
import common.po.HotelPO;
import common.vo.HotelVO;

public class Maintain implements HotelblMaintainService {

	@Override
	public HotelVO getHotelInfo(Person person) {
		return HotelDataService.getHotelInfo(person.id);
	}

	@Override
	public boolean setHotelInfo(HotelVO hotelInfoVO) {
		return HotelDataService.setHotelInfo(new HotelPO(hotelVO));
	}
}
