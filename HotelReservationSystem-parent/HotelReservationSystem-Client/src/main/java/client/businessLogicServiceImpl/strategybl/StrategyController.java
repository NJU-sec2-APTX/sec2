package client.businessLogicServiceImpl.strategybl;

import java.rmi.RemoteException;
import java.util.Map;

import client.businessLogicService.strategyblService.StrategyMaintainService;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.StrategyPO;
import common.vo.StrategyVO;

public class StrategyController implements StrategyMaintainService{
	private Strategy strategy;
	public StrategyController(String ID,UserRole ur){
		if(strategy==null){
			strategy=new Strategy(ID,ur);
		}
	}
	public StrategyVO getStrategy (String StrategyName) throws RemoteException{
		return strategy.getStrategy(StrategyName);
	}
	
	public Map<String,StrategyVO> getStrategyList()throws RemoteException{
		return strategy.getStrategyList();
	}
	
	public ResultMessage modifyStrategy(StrategyPO po)throws RemoteException{
		return strategy.modifyStrategy(po);
	}
	
	public ResultMessage removeStrategy (StrategyPO po) throws RemoteException{
		return strategy.removeStrategy(po);
	}
	
	public ResultMessage addStrategy(StrategyPO po)throws RemoteException{
		return strategy.addStrategy(po);
	}
}
