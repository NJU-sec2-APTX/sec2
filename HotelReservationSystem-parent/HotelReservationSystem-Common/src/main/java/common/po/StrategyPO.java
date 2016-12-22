package common.po;

import java.io.Serializable;
import java.util.Date;

import common.otherEnumClasses.StrategyType;
import common.otherEnumClasses.UserRole;

public class StrategyPO  implements Serializable{
	//期间，商圈，会员等级，还要考虑是否是合作企业，是否是会员生日，三间及以上折扣
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//策略制定者的身份
	private UserRole ur;
	private String id;
	
	private String strategy_name;
	
	private StrategyType type;
	
	//用于记录合作企业名称，不为空表示只适用于这些企业，只要用创建者的ID和UserRole即可确定列表，因为合作企业属于该ID
	private String enterpriseList;
	
	//用于记录房间数多少间可以打折，不为空表示超过多少间才能行
	private int roomNumber;
	
	//用于记录策略开始时间，不为空表示开始实行时间
	private Date start_date;
	
	//用于记录策略结束时间，不为空表示结束实行时间
	private Date end_date;
	
	//用于记录策略适用商圈，不为空表示特定商圈才符合，而businessarea只属于某个策略,故要持有策略名称
	private String businessarea;
	
	//用于记录会员等级达到多少即可享受折扣，不为空表示特定等级的会员才能享受
	private int level;
	
	//用于记录折扣比例
	private double count;
	
	public StrategyPO(String id,UserRole ur,String strategy_name,String enterpriseList,int roomNumber,
			Date start_date,Date end_date,String businessarea,int level,double count,StrategyType type){
		this.ur=ur;
		this.id=id;
		this.strategy_name=strategy_name;
		this.start_date=start_date;
		this.end_date=end_date;
		this.businessarea=businessarea;
		this.level=level;
		this.count=count;
		this.enterpriseList=enterpriseList;
		this.roomNumber=roomNumber;
		this.type=type;
	}
	
	public String getID(){
		return id;
	}
	
	public void setCount(double c){
		this.count=c;
	}
	
	public void setEnterprise(String s){
		this.enterpriseList=s;
	}
	
	public void setStartDate(Date d){
		this.start_date=d;
	}
	
	public void setEndDate(Date d){
		this.end_date=d;
	}
	
	public void setBusinessArea(String s){
		this.businessarea=s;
	}
	
	public void setRoom(int r){
		this.roomNumber=r;
	}
	
	public UserRole getUserRole(){
		return ur;
	}
	
	public String getName(){
		return strategy_name;
	}
	
	public Date getStartDate(){
		return start_date;
	}
	
	public StrategyType getStrategyType(){
		return type;
	}
	
	public Date getEndDate(){
		return end_date;
	}
	
	public double getCount(){
		return count;
	}
	
	public String getArea(){
		return businessarea;
	}
	
	public int getLevel(){
		return level;
	}
	
	public String getEnterprise(){
		return enterpriseList;
	}
	
	public int getRoomNumber(){
		return roomNumber;
	}
}