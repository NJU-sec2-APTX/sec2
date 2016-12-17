package client.businessLogicServiceImpl.strategybl;

import java.rmi.RemoteException;

import client.Client;
import client.businessLogicService.strategyblService.StrategyPriceService;
import common.otherEnumClasses.StrategyList;
import common.otherEnumClasses.UserRole;
import common.vo.OrderVO;

public class PriceController implements StrategyPriceService{
	private Strategy strategy;
	
	public StrategyList calPrice(OrderVO vo) throws RemoteException{
		strategy=new Strategy(Client.getHotelDataService().getHotelInfo(vo.hotel).getAccountID(),UserRole.HotelWorker);
		return strategy.calPrice(vo);
	}
}