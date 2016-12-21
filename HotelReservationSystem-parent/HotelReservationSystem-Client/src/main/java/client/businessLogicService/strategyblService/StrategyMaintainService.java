package client.businessLogicService.strategyblService;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.StrategyPO;
import common.vo.StrategyVO;

public interface StrategyMaintainService {
	public StrategyVO getStrategy (String StrategyName) throws RemoteException;
	
	public Map<String,StrategyVO> getStrategyList()throws RemoteException;
	
	public ResultMessage modifyStrategy(StrategyPO po)throws RemoteException;
	
	public ResultMessage removeStrategy (StrategyPO po) throws RemoteException;
	
	public ResultMessage addBirthdayStrategy(String ID,UserRole ur,String Strategy_name,double count)throws RemoteException;
	
	public ResultMessage addCorporationEnterPriseStrategy(String ID,UserRole ur,String Strategy_name,double count,String enterprise)throws RemoteException;
	
	public ResultMessage addMemberLevelStrategy(String ID,UserRole ur,double count,String countList,String credit)throws RemoteException;
	
	public ResultMessage addRoomNumberStrategyPO(String ID,UserRole ur,String Strategy_name,double count,int number)throws RemoteException;
	
	public ResultMessage addSpecialDateStrategyPO(String ID,UserRole ur,String Strategy_name,double count,Date s,Date e)throws RemoteException;
	
	public ResultMessage addVipandAreaStrategyPO(String ID,UserRole ur,String Strategy_name,double count,int level,String area)throws RemoteException;
}