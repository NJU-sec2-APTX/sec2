package common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import common.otherEnumClasses.ResultMessage;
import common.po.StrategyPO;
import common.vo.StrategyVO;

public interface StrategyDataService extends Remote{

	public ResultMessage insert(StrategyPO spo)throws RemoteException;
	
	public ResultMessage update(String ID,String name, StrategyPO po)throws RemoteException;

	public ResultMessage delete(StrategyPO spo)throws RemoteException;
	
	public ArrayList<StrategyVO> findAll(String ID) throws RemoteException;
}

