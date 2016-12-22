package client.businessLogicServiceImpl.hotelbl;

import java.rmi.RemoteException;

import client.Client;
import client.businessLogicService.hotelblService.HotelblMaintainService;
import common.otherEnumClasses.RoomState;
import common.po.HotelPO;
import common.vo.HotelVO;

public class Maintain implements HotelblMaintainService {

	@Override
	public HotelVO getHotelInfo(String hotelId) {
		try {
			return new HotelVO(Client.getHotelDataService().getHotelInfo(hotelId));
		} catch (RemoteException e) {}
		return null;
	}

	@Override
	public boolean setHotelInfo(HotelVO hotelVO) {
		try {
			hotelVO.price = hotelVO.rooms.get(0).price;
			return Client.getHotelDataService().setHotelInfo(new HotelPO(hotelVO));
		} catch (RemoteException e) {}
		return false;
	}

	@Override
	public boolean addHotel(HotelVO vo) {
		try {
			HotelPO po = new HotelPO();
			po.setId(po.getArea()+po.getName());
			return Client.getHotelDataService().addHotel(po);
		} catch (RemoteException e) {}
		return false;
	}
}
