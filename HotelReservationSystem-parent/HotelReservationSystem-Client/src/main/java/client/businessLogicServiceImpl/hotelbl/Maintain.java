package client.businessLogicServiceImpl.hotelbl;

import client.businessLogicService.hotelblService.HotelblMaintainService;
import client.dataService.HotelDataService;
import client.po.HotelPO;
import client.vo.HotelVO;

public class Maintain implements HotelblMaintainService {

	public HotelVO getHotelInfo(String id) {
		return new HotelVO(HotelDataService.getHotelInfo(id));
	}

	public boolean setHotelInfo(HotelVO hotelInfoVO) {
		return HotelDataService.setHotelInfo(new HotelPO(hotelInfoVO));
	}
}
