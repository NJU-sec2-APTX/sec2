package client.businessLogicServiceImpl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import client.Client;
import common.otherEnumClasses.HotelSearchConditions;
import common.otherEnumClasses.SortFlag;
import common.po.HotelPO;
import common.vo.HotelVO;

public class BrowseHotel {

	ArrayList<HotelVO> browse(String area, String address, HotelSearchConditions searchItems, String clientId){
		ArrayList<HotelVO> hotelVOs = new ArrayList<HotelVO>();
		try {
			ArrayList<HotelPO> reservedHotels = Client.getOrderDataService().searchReservedHotel(clientId);
			ArrayList<HotelPO> hotelsPO = Client.getHotelDataService().getHotelList(area, address, searchItems);
			for (HotelPO hotelPO : hotelsPO) {
				if(reservedHotels.contains(hotelPO)){
					hotelVOs.add(new HotelVO(hotelPO,true));
				}else{
					hotelVOs.add(new HotelVO(hotelPO,false));
				}
			}
			if(searchItems.onlyEverReserved){
				ArrayList<HotelVO> vos = new ArrayList<HotelVO>();
				for(HotelVO hotelVO : hotelVOs){
					if(hotelVO.isEverReserved){
						vos.add(hotelVO);
					}
				}
				hotelVOs = vos;
			}
		} catch (RemoteException e) {}
		return hotelVOs;
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