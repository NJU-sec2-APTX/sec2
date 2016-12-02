package client.businessLogicService.strategyblService;

import java.rmi.RemoteException;

import common.otherEnumClasses.StrategyList;
import common.otherEnumClasses.UserRole;
import common.vo.OrderVO;

public interface StrategyPriceService {
	public StrategyList calPrice(String ID,UserRole ur,OrderVO vo) throws RemoteException;
}