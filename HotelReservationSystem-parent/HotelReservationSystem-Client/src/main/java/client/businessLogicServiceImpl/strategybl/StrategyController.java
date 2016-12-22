package client.businessLogicServiceImpl.strategybl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

import client.businessLogicService.strategyblService.StrategyMaintainService;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.StrategyType;
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
	
	public ResultMessage addBirthdayStrategy(String ID,UserRole ur,String Strategy_name,double count)throws RemoteException{
		StrategyPO po=new StrategyPO(ID,ur,Strategy_name,null,0,null,null,null,0,count,StrategyType.Birthday);
		return strategy.addStrategy(po);
	}
	
	public ResultMessage addCorporationEnterPriseStrategy(String ID,UserRole ur,String Strategy_name,double count,String enterprise)throws RemoteException{
		StrategyPO po=new StrategyPO(ID,ur,Strategy_name,enterprise,0,null,null,null,0,count,StrategyType.CorporationEnterPrise);
		return strategy.addStrategy(po);
	}
	
	public ResultMessage addMemberLevelStrategy(String ID,UserRole ur,double count,String credit)throws RemoteException{
		StrategyPO po=new StrategyPO(ID,ur,"MemberLevel",null,0,null,null,credit,0,count,StrategyType.MemberLevel);
		return strategy.addStrategy(po);
	}
	
	public ResultMessage addRoomNumberStrategyPO(String ID,UserRole ur,String Strategy_name,double count,int number)throws RemoteException{
		StrategyPO po=new StrategyPO(ID,ur,Strategy_name,null,number,null,null,null,0,count,StrategyType.RoomNumber);
		return strategy.addStrategy(po);
	}
	
	public ResultMessage addSpecialDateStrategyPO(String ID,UserRole ur,String Strategy_name,double count,Date s,Date e)throws RemoteException{
		StrategyPO po=new StrategyPO(ID,ur,Strategy_name,null,0,s,e,null,0,count,StrategyType.SpecialDate);
		return strategy.addStrategy(po);
	}
	
	public ResultMessage addVipandAreaStrategyPO(String ID,UserRole ur,String Strategy_name,String discountlist,String area)throws RemoteException{
		StrategyPO po=new StrategyPO(ID,ur,Strategy_name,discountlist,0,null,null,area,0,0,StrategyType.VipandArea);
		return strategy.addStrategy(po);
	}
}
