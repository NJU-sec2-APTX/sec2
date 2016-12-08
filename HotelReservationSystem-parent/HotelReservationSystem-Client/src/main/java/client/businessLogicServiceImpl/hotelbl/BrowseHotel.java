package client.businessLogicServiceImpl.hotelbl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.security.auth.PrivateCredentialPermission;

import client.Client;
import common.otherEnumClasses.HotelSearchConditions;
import common.otherEnumClasses.Person;
import common.otherEnumClasses.SortFlag;
import common.po.HotelPO;
import common.po.OrderPO;
import common.vo.HotelVO;

public class BrowseHotel {

	ArrayList<HotelVO> browse(String area, String address, HotelSearchConditions searchItems, Person person){
		ArrayList<HotelPO> hotelsPO = Client.getHotelDataService().getHotelList(area, address);
		ArrayList<HotelVO> hotelsVO = new ArrayList<HotelVO>();
		for (HotelPO hotelPO : hotelsPO) {
			hotelsVO.add(new HotelVO(hotelPO));
		}
		return BrowseHotel.checkConditions(hotelsVO, searchItems, person);
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
	
	private static ArrayList<HotelVO> checkConditions(ArrayList<HotelVO> vos, HotelSearchConditions items, Person person){
		if(items.hotelName!=null){
			
		}
		if(items.priceUp!=items.priceDown&&items.priceDown>0){
			
		}
		if(items.starUp!=items.starDown&&items.starDown>0){
			
		}
		if(items.markUp!=items.markDown&&items.markDown>0){
			
		}
		if(items.dateUp!=null&&items.dateDown!=null){
			
		}
		
		ArrayList<OrderPO> orders = Client.getOrderDataService().findOrderList(person);
		for(OrderPO po : orders){
			
		}
		return vos;
	}
}