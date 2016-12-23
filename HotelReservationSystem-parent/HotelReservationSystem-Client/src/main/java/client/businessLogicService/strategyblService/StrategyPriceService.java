package client.businessLogicService.strategyblService;

import java.rmi.RemoteException;

import common.otherEnumClasses.StrategyList;
import common.vo.OrderVO;

public interface StrategyPriceService {
	/**
	 * 传入一个订单VO，即可根据所有的策略享受最低折扣，获得的是一个list，使用getfirst即可获得最低价格的策略vo和其相应的价格
	 * @param ordervo
	 * @return
	 * @throws RemoteException
	 */
	public StrategyList calPrice(OrderVO vo) throws RemoteException;
}