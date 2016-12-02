package client.businessLogicService.strategyblService;

import java.rmi.RemoteException;
import java.util.Map;

import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.StrategyPO;
import common.vo.StrategyVO;

public interface StrategyMaintainService {
	public StrategyVO getStrategy (String ID,String StrategyName) throws RemoteException;
	
	public Map<String,StrategyVO> getStrategyList(String ID,UserRole ur)throws RemoteException;
	
	public ResultMessage modifyStrategy(UserRole ur,String ID,StrategyPO po)throws RemoteException;
	
	public ResultMessage removeStrategy (UserRole ur,String ID,StrategyPO po) throws RemoteException;
	
	public ResultMessage addStrategy(UserRole ur,String ID,StrategyPO po)throws RemoteException;
}
