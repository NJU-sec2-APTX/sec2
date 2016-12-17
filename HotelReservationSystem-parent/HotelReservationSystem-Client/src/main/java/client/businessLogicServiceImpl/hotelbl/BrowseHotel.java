package client.businessLogicServiceImpl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import client.Client;
import common.otherEnumClasses.HotelSearchConditions;
import common.otherEnumClasses.Person;
import common.otherEnumClasses.SortFlag;
import common.po.HotelPO;
import common.po.OrderPO;
import common.vo.HotelVO;

public class BrowseHotel {

	ArrayList<HotelVO> browse(String area, String address, HotelSearchConditions searchItems, String clientId){
		ArrayList<HotelVO> hotelsVO = new ArrayList<HotelVO>();
		try {
			ArrayList<HotelPO> hotelsPO = Client.getHotelDataService().getHotelList(area, address, searchItems);
			for (HotelPO hotelPO : hotelsPO) {
				
				hotelsVO.add(new HotelVO(hotelPO));
			}
		} catch (RemoteException e) {}
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
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {}
		return hotelList;
	}
}