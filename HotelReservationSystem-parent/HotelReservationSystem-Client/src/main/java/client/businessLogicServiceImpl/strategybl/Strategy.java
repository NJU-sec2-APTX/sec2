package client.businessLogicServiceImpl.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import client.Client;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.StrategyList;
import common.otherEnumClasses.UserRole;
import common.po.StrategyPO;
import common.vo.MemberVO;
import common.vo.OrderVO;
import common.vo.StrategyVO;

public class Strategy {
	private String id;
	private UserRole ur;
	//这个是用来存strategylineitem容器类的列表，其中存的是持有某个strategy对象以及其根据订单用该strategy所计算出的总价
	
	//这个是用来存某个ID所有的strategy，其中存的是StrategyVO对象
	private Map<String,StrategyVO> strategylist;
	
	private StrategyList strategy_price;
	@SuppressWarnings("deprecation")
	
	public StrategyList calPrice(OrderVO OrderVO) throws RemoteException{
		if(OrderVO!=null){
			strategy_price=new StrategyList();
			ArrayList<StrategyVO> list=Client.getStrategyDataService().CalAll();
			for(int i=0;i<list.size();i++){
				StrategyVO TempStrategy=list.get(i);
				MemberVO membervo=new MemberVO(Client.getMemberDataService().find(TempStrategy.getID()));
				if(TempStrategy.getName().equals("MemberLevel")){
					if(TempStrategy.getLevel()<=membervo.getLevel()){
						double p=OrderVO.price*TempStrategy.getCount();
						strategy_price.addLineItem(p,TempStrategy);
					}
				}else{
					switch(TempStrategy.getStrategyType()){
					case Birthday:
						Date d=new Date();
						if(membervo.getBirthday().getMonth()==d.getMonth()&&membervo.getBirthday().getDate()==d.getDate()){
							double p=OrderVO.price*TempStrategy.getCount();
							strategy_price.addLineItem(p,TempStrategy);
						}
						break;
					case CorporationEnterPrise:
						if(membervo.getUserRole()==UserRole.Enterprise&&TempStrategy.getEnterprise().contains(membervo.getName())){
							double p=OrderVO.price*TempStrategy.getCount();
							strategy_price.addLineItem(p,TempStrategy);
						}
						break;
					case MemberLevel:
						break;
					case RoomNumber:
						String []sum=OrderVO.numOfRoom.split("/");
						int number=0;
						for(int j=0;j<sum.length;j++){
							number+=Integer.parseInt(sum[j]);
						}
						if(TempStrategy.getRoomNumber()<=number){
							double p=OrderVO.price*TempStrategy.getCount();
							strategy_price.addLineItem(p,TempStrategy);
						}
						break;
					case SpecialDate:
						if(TempStrategy.getEndDate()!=null){
							if(TempStrategy.getStartDate().compareTo(OrderVO.checkInTime)<=0&&TempStrategy.getEndDate().compareTo(OrderVO.checkOutTime)>=0){
								double p=OrderVO.price*TempStrategy.getCount();
								strategy_price.addLineItem(p,TempStrategy);
							}
						}else{
							if(TempStrategy.getStartDate().compareTo(OrderVO.checkInTime)<=0){
								double p=OrderVO.price*TempStrategy.getCount();
								strategy_price.addLineItem(p,TempStrategy);
							}
						}
						break;
					case VipandArea:
						if(TempStrategy.getArea().equals(Client.getHotelDataService().getHotelInfo(OrderVO.hotel).getArea())){
							String[] discount=TempStrategy.getEnterprise().split("/");
							for(int j=0;j<discount.length;j++){
								if(membervo.getLevel()>=j+1){
									double p=OrderVO.price*Double.parseDouble(discount[j]);
									strategy_price.addLineItem(p,TempStrategy);
									break;
								}
							}
						}
						break;
					}
				}
			}
			return strategy_price;
		}else{
			return null;
		}
	}
	
	//初始化的时候就将strategylist加载出来
	public Strategy(String ID,UserRole ur){
		id=ID;
		this.ur=ur;
		try {
			this.getStrategyList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public String getID(){
		return id;
	}
	
	public UserRole getUserRole(){
		return ur;
	}
	
	/**
	 * 获得属于该ID和userRole的所有strategy列表,并且在strategy类中持久持有该列表
	 * @return
	 * @throws RemoteException
	 */
	public Map<String,StrategyVO> getStrategyList() throws RemoteException{
		if(Client.getStrategyDataService().findAll(id,ur)==null){
			strategylist=new HashMap<String,StrategyVO>();
			return null;
		}else{
			ArrayList<StrategyVO> templist=Client.getStrategyDataService().findAll(id,ur);
			strategylist=new HashMap<String,StrategyVO>();
			for(int i=0;i<templist.size();i++){
				strategylist.put(templist.get(i).getName(), templist.get(i));
			}
			return strategylist;
		}
	}
	
	/**
	 * 获得某个策略
	 * @param ID
	 * @param StrategyName
	 * @return
	 * @throws RemoteException 
	 */
	public StrategyVO getStrategy (String StrategyName) throws RemoteException{
		if(strategylist.size()!=0){
			return strategylist.get(StrategyName);
		}else{
			this.getStrategyList();
			return strategylist.get(StrategyName);
		}
	}
	
	/**
	 * 输入ID，UserRole和一个PO，倘若在数据库找到，则返回修改信息，否则返回失败
	 * 如果update成功，则修改strategy持有的变量
	 * @param ur
	 * @param ID
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage modifyStrategy(StrategyPO po) throws RemoteException{
		if(po.getID()!=id||po.getUserRole()!=ur){
			return ResultMessage.Failure;
		}
		if(strategylist.get(po.getName())!=null&&strategylist.get(po.getName()).getUserRole()==ur){
			if(Client.getStrategyDataService().update(id,po.getName(),po)==ResultMessage.Success){
				strategylist.replace(po.getName(), new StrategyVO(po));
				return ResultMessage.Success;
			}else{
				return ResultMessage.Failure;
			}
		}
		return ResultMessage.Failure;
	}
	
	/**
	 * 输入ID，UserRole，倘若在数据库中找到，则返回删除信息，否则返回失败
	 * @param ur
	 * @param ID
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage removeStrategy (StrategyPO po) throws RemoteException{
		if(po.getID()!=id||po.getUserRole()!=ur){
			return ResultMessage.Failure;
		}
		if(strategylist.get(po.getName())!=null&&strategylist.get(po.getName()).getUserRole()==ur){
			if(Client.getStrategyDataService().delete(po)==ResultMessage.Success){
				strategylist.remove(po.getName());
				return ResultMessage.Success;
			}else{
				return ResultMessage.Failure;
			}
		}
		return ResultMessage.Failure;
	}
	
	/**
	 * 如果在数据库中找到了该策略，则返回失败，否则返回插入结果
	 * @param ur
	 * @param ID
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addStrategy(StrategyPO po) throws RemoteException{
		if(po.getID()!=id||po.getUserRole()!=ur){
			return ResultMessage.Failure;
		}
		if(strategylist.get(po.getName())==null){
			if(Client.getStrategyDataService().insert(po)==ResultMessage.Success){
				strategylist.put(po.getName(),new StrategyVO(po));
				return ResultMessage.Success;
			}else{
				return ResultMessage.Failure;
			}
		}
		return ResultMessage.Failure;
	}
	
	/**
	 * 输入用户的ID，UserRole以及想要计算的订单，如果传过来的OrderVO不是空，
	 * 并且数据库中查找到该ID和UserRole对应的策略，则获得该列表并查看是否符合要求，若符合策略要求，则进行相应的折扣，
	 * 并返回一个容器，其中包括具体的strategy和相应的价格，并且默认此ArrayList为升幂排序
	 * @param ID
	 * @param ur
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	
	public void print(){
		if(strategylist.size()!=0){
			for(StrategyVO vo:strategylist.values()){
				vo.print();
			}
		}
	}
}