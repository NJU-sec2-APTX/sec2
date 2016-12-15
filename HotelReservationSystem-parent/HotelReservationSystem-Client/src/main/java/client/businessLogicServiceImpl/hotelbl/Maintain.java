package client.businessLogicServiceImpl.hotelbl;

import java.rmi.RemoteException;

import client.Client;
import client.businessLogicService.hotelblService.HotelblMaintainService;
import common.otherEnumClasses.Person;
import common.po.HotelPO;
import common.vo.HotelVO;

public class Maintain implements HotelblMaintainService {

	@Override
	public HotelVO getHotelInfo(Person person) {
		try {
			return new HotelVO(Client.getHotelDataService().getHotelInfo(person.id));
		} catch (RemoteException e) {}
		return null;
	}

	@Override
	public boolean setHotelInfo(HotelVO hotelVO) {
		try {
			return Client.getHotelDataService().setHotelInfo(new HotelPO(hotelVO));
		} catch (RemoteException e) {}
		return false;
	}
}
