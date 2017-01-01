package client.businessLogicServiceImpl.hotelbl;

import java.util.ArrayList;

import client.businessLogicService.hotelblService.HotelblBrowseService;
import common.otherEnumClasses.HotelSearchConditions;
import common.otherEnumClasses.SortFlag;
import common.vo.HotelVO;

public class BrowseController implements HotelblBrowseService{
	
	BrowseHotel bh;
        
        public BrowseController(){
            bh = new BrowseHotel();
        }
        
	@Override
	public ArrayList<HotelVO> getHotelList(String area, String address, HotelSearchConditions searchItems, String clientId) {
                
                System.out.println(area);
                System.out.println(address+clientId);
                System.out.println(searchItems==null);
                System.out.println(bh.browse(area, address, searchItems, clientId).size());
		return bh.browse(area, address, searchItems, clientId);
	}

	@Override
	public ArrayList<HotelVO> sortHotelList(String area, String address, HotelSearchConditions searchItems, String clientId, SortFlag flag, boolean isIncrease) {
		
		return bh.sort(bh.browse(area, address, searchItems, clientId), flag, isIncrease);
	}
}