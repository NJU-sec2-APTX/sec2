package client.businessLogicService.strategyblService;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

import common.otherEnumClasses.ResultMessage;
import common.vo.StrategyVO;

public interface StrategyMaintainService {
	/** 输入策略名，可以获得策略VO
	 * @param StrategyName
	 */
	public StrategyVO getStrategy (String StrategyName) throws RemoteException;
	
	/**
	 * 获得所属当前用户的所有策略
	 */
	public Map<String,StrategyVO> getStrategyList()throws RemoteException;
	
	/**
	 * 修改策略时，已经拿到一个策略VO了，这时候再根据修改的值和VO重新构造一个VO传入即可
	 * @param Strategypo
	 */
	public ResultMessage modifyStrategy(StrategyVO vo)throws RemoteException;
	
	/**
	 * 根据已经拿到的策略VO，传入一个策略VO删掉他
	 * @param Strategypo
	 */
	public ResultMessage removeStrategy (StrategyVO vo) throws RemoteException;
	
	/**
	 * 新增一个生日策略，只要传入策略名和策略折扣即可
	 * @param Strategyname
	 * @param count
	 */
	public ResultMessage addBirthdayStrategy(String Strategy_name,double count)throws RemoteException;
	
	/**
	 * 新增合作企业策略，输入名字和折扣，并且将这些合作企业的名字按照以下格式以字符串的形式传入
	 * 南京大学/东南大学/……
	 * @param Strategyname
	 * @param count
	 * @param enterprise
	 */
	public ResultMessage addCorporationEnterPriseStrategy(String Strategy_name,double count,String enterprise)throws RemoteException;
	
	/**
	 * 传入一个string，这里表示会员升级所需要的经验，如下
	 * 100/1000/10000/100000/1000000 表示升到1级要100credit，以此类推，超过1000000都是5级
	 * @param creditlist
	 */
	public ResultMessage addMemberLevelStrategy(String credit)throws RemoteException;
	
	/**
	 * 输入策略名，房间数和折扣即可
	 * @param Strategyname
	 * @param count
	 * @param number
	 */
	public ResultMessage addRoomNumberStrategyPO(String Strategy_name,double count,int number)throws RemoteException;
	
	/**
	 * 传入策略名和折扣，以及起始日期和终止日期（终止日期可以为null，起始日期不能为null）
	 * @param Strategy_name
	 * @param count
	 * @param start_date
	 * @param end_date
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addSpecialDateStrategyPO(String Strategy_name,double count,Date s,Date e)throws RemoteException;
	
	/**
	 * 传入策略名，一个商圈，以及对应的不同等级的折扣，例如
	 * 鼓楼VIP专属折扣,0.95/0.9/0.85/0.8/0.75,鼓楼区
	 * @param Strategy_name
	 * @param discountlist
	 * @param area
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addVipandAreaStrategyPO(String Strategy_name,String discountlist,String area)throws RemoteException;
}