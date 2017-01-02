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
                        System.out.println(area+" "+address+" ");
			ArrayList<HotelPO> hotelsPO = Client.getHotelDataService().getHotelList(area, address, searchItems);
			for (HotelPO hotelPO : hotelsPO) {
				if(reservedHotels.contains(hotelPO)){
					hotelVOs.add(new HotelVO(hotelPO,true));
				}else{
					hotelVOs.add(new HotelVO(hotelPO,false));
				}
			}//标记每个酒店是否曾预定过
			if(searchItems.onlyEverReserved){
				ArrayList<HotelVO> vos = new ArrayList<HotelVO>();
				for(HotelVO hotelVO : hotelVOs){
					if(hotelVO.isEverReserved){
						vos.add(hotelVO);
					}
				}
				hotelVOs = vos;
			}
		} catch (RemoteException e) {
                e.printStackTrace();}
		return hotelVOs;
	}
	
	/**
	 * 
	 *@description 将酒店列表按要求排序
	 *@param 初始酒店VO列表，排序指标，是否升序
	 *@return 排序后的酒店VO列表
	 */
	@SuppressWarnings("unchecked")
	ArrayList<HotelVO> sort(ArrayList<HotelVO> hotelList, SortFlag flag, boolean isIncrease) {
		Comparator<HotelVO> comp;
		try {
			//通过反射获取排序指标对应的comparator
			comp = (Comparator<HotelVO>) Class.forName("client.businessLogicServiceImpl.hotelbl."+flag+"Comparator").newInstance();
			if(!isIncrease){
				comp = comp.reversed();
			}
			Collections.sort(hotelList, comp);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {}
                System.out.println("*sort*"+hotelList.size());
		return hotelList;
	}
}