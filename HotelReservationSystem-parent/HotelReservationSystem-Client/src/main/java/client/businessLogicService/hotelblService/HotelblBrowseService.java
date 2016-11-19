package client.businessLogicService.hotelblService;

import java.util.ArrayList;

import common.vo.HotelVO;

public interface HotelblBrowseService {
	
	public ArrayList<HotelVO> getHotelList(String area, String address, HotelVO hotelRange);
	
	public ArrayList<HotelVO> sortHotelList(boolean price, boolean star, boolean mark);
	
	public HotelVO getHotelInfo(String hotelId);
}