package client.businessLogicServiceImpl.strategybl;

import java.rmi.RemoteException;

import client.businessLogicService.strategyblService.StrategyPriceService;
import common.otherEnumClasses.StrategyList;
import common.vo.OrderVO;

public class PriceController implements StrategyPriceService{
	private PriceHelper price;
	
	public StrategyList calPrice(OrderVO vo) throws RemoteException{
		price=new PriceHelper();
		return price.calPrice(vo);
	}
}