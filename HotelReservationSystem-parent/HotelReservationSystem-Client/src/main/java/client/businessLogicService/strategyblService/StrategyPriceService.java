package client.businessLogicService.strategyblService;

import java.rmi.RemoteException;

import common.otherEnumClasses.StrategyList;
import common.vo.OrderVO;

public interface StrategyPriceService {
	public StrategyList calPrice(OrderVO vo) throws RemoteException;
}