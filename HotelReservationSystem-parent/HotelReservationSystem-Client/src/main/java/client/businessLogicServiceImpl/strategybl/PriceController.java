package client.businessLogicServiceImpl.strategybl;

import java.rmi.RemoteException;

import client.businessLogicService.strategyblService.StrategyPriceService;
import common.otherEnumClasses.StrategyList;
import common.vo.OrderVO;

public class PriceController implements StrategyPriceService{
	private Strategy price;
	
	public StrategyList calPrice(OrderVO vo) throws RemoteException{
		price=new Strategy(null,null);
		return price.calPrice(vo);
	}
}