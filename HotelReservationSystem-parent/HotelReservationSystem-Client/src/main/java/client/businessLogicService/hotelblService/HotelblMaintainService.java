package client.businessLogicService.hotelblService;

import common.vo.HotelVO;

public interface HotelblMaintainService {
	
	public HotelVO getHotelInfo(String id);
	
	public boolean setHotelInfo(HotelVO hotelInfoVO);
}
