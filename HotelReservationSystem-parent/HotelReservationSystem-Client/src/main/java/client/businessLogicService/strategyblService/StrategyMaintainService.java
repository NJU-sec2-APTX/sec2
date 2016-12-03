package client.businessLogicService.strategyblService;

import java.rmi.RemoteException;
import java.util.Map;

import common.otherEnumClasses.ResultMessage;
import common.po.StrategyPO;
import common.vo.StrategyVO;

public interface StrategyMaintainService {
	public StrategyVO getStrategy (String StrategyName) throws RemoteException;
	
	public Map<String,StrategyVO> getStrategyList()throws RemoteException;
	
	public ResultMessage modifyStrategy(StrategyPO po)throws RemoteException;
	
	public ResultMessage removeStrategy (StrategyPO po) throws RemoteException;
	
	public ResultMessage addStrategy(StrategyPO po)throws RemoteException;
}