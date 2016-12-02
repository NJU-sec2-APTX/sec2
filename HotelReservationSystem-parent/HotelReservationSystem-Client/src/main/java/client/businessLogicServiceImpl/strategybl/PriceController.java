package client.businessLogicServiceImpl.strategybl;

import java.rmi.RemoteException;

import client.businessLogicService.strategyblService.StrategyPriceService;
import common.otherEnumClasses.StrategyList;
import common.otherEnumClasses.UserRole;
import common.vo.OrderVO;

public class PriceController implements StrategyPriceService{
	private Strategy strategy;
	
	public StrategyList calPrice(String ID,UserRole ur,OrderVO vo) throws RemoteException{
		return strategy.calPrice(ID, ur, vo);
	}
	
	public PriceController(String ID,UserRole ur){
		if(strategy==null){
			strategy=new Strategy(ID,ur);
		}
	}
}
