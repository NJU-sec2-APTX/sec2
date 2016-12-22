package client.businessLogicService.hotelblService;

import common.vo.HotelVO;

public interface HotelblMaintainService {
	
	public boolean addHotel(HotelVO vo);
	
	public HotelVO getHotelInfo(String hotelId);
	
	public boolean setHotelInfo(HotelVO hotelInfoVO);
}