package client.businessLogicServiceImpl.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
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
	
	/**
	 * 获得Controller时就要输入当前用户的ID和UserRole，这样就限制了他不能拿到别人的策略
	 * @param ID
	 * @param ur
	 */
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
	
	public ResultMessage modifyStrategy(StrategyVO vo)throws RemoteException{
		StrategyPO po=new StrategyPO(vo.getID(),vo.getUserRole(),vo.getName(),vo.getEnterprise(),
				vo.getRoomNumber(),vo.getStartDate(),vo.getEndDate(),vo.getArea(),vo.getLevel(),vo.getCount(),vo.getStrategyType());
		return strategy.modifyStrategy(po);
	}
	
	public ResultMessage removeStrategy (StrategyVO vo) throws RemoteException{
		StrategyPO po=new StrategyPO(vo.getID(),vo.getUserRole(),vo.getName(),vo.getEnterprise(),
				vo.getRoomNumber(),vo.getStartDate(),vo.getEndDate(),vo.getArea(),vo.getLevel(),vo.getCount(),vo.getStrategyType());
		return strategy.removeStrategy(po);
	}
	
	public ResultMessage addBirthdayStrategy(String Strategy_name,double count)throws RemoteException{
		StrategyPO po=new StrategyPO(strategy.getID(),strategy.getUserRole(),Strategy_name,null,0,null,null,null,0,count,StrategyType.Birthday);
		return strategy.addStrategy(po);
	}
	
	public ResultMessage addCorporationEnterPriseStrategy(String Strategy_name,double count,String enterprise)throws RemoteException{
		StrategyPO po=new StrategyPO(strategy.getID(),strategy.getUserRole(),Strategy_name,enterprise,0,null,null,null,0,count,StrategyType.CorporationEnterPrise);
		return strategy.addStrategy(po);
	}
	
	public ResultMessage addMemberLevelStrategy(String credit)throws RemoteException{
		StrategyPO po=new StrategyPO(strategy.getID(),strategy.getUserRole(),"MemberLevel",null,0,null,null,credit,0,0.0,StrategyType.MemberLevel);
		return strategy.addStrategy(po);
	}
	
	public ResultMessage addRoomNumberStrategyPO(String Strategy_name,double count,int number)throws RemoteException{
		StrategyPO po=new StrategyPO(strategy.getID(),strategy.getUserRole(),Strategy_name,null,number,null,null,null,0,count,StrategyType.RoomNumber);
		return strategy.addStrategy(po);
	}
	
	public ResultMessage addSpecialDateStrategyPO(String Strategy_name,double count,Date s,Date e)throws RemoteException{
		StrategyPO po=new StrategyPO(strategy.getID(),strategy.getUserRole(),Strategy_name,null,0,s,e,null,0,count,StrategyType.SpecialDate);
		return strategy.addStrategy(po);
	}
	
	public ResultMessage addVipandAreaStrategyPO(String Strategy_name,String discountlist,String area)throws RemoteException{
		StrategyPO po=new StrategyPO(strategy.getID(),strategy.getUserRole(),Strategy_name,discountlist,0,null,null,area,0,0,StrategyType.VipandArea);
		return strategy.addStrategy(po);
	}

	@Override
	public ArrayList<StrategyVO> getAllStrategy() throws RemoteException {
		return strategy.getAllStrategy();
	}
}