package client.businessLogicServiceImpl.hotelbl;

import java.util.ArrayList;

import client.businessLogicService.hotelblService.HotelblBrowseService;
import common.vo.HotelVO;

public class BrowseController implements HotelblBrowseService{
	
	BrowseHotel bh;

	public ArrayList<HotelVO> getHotelList(String area, String address, HotelVO hotelRange) {
		return bh.browse(area, address, hotelRange);
	}

	public ArrayList<HotelVO> sortHotelList(ArrayList<HotelVO> hotelList, boolean price, boolean star, boolean mark) {
		return bh.sort(hotelList, price, star, mark);
	}

	public HotelVO getHotelInfo(String id) {
		return bh.getHotelInfo(id);
	}
}
