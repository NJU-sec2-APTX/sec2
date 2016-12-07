package client.businessLogicServiceImpl.hotelbl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import client.Client;
import common.dataService.HotelDataService;
import common.otherEnumClasses.HotelSearchConditions;
import common.otherEnumClasses.SortFlag;
import common.po.HotelPO;
import common.vo.HotelVO;

public class BrowseHotel {

	ArrayList<HotelVO> browse(String area, String address, HotelSearchConditions searchItems){
		ArrayList<HotelPO> hotelsPO = Client.getHotelDataService().getHotelList(area, address);
		ArrayList<HotelVO> hotelsVO = new ArrayList<HotelVO>();
		for (HotelPO hotelPO : hotelsPO) {
			hotelsVO.add(new HotelVO(hotelPO));
		}
		return hotelsVO;
	}
	
	@SuppressWarnings("unchecked")
	ArrayList<HotelVO> sort(ArrayList<HotelVO> hotelList, SortFlag flag, boolean isIncrease) {
		Comparator<HotelVO> comp;
		try {
			comp = (Comparator<HotelVO>) Class.forName("client.businessLogicServiceImpl.hotelbl."+flag+"Comparator").newInstance();
			if(!isIncrease){
				comp = comp.reversed();
			}
			Collections.sort(hotelList, comp);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return hotelList;
	}
}