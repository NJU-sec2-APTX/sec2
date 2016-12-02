package common.vo;

import java.io.Serializable;
import java.util.Date;

import common.otherEnumClasses.UserRole;
import common.po.StrategyPO;

public class StrategyVO implements Serializable{
	//期间，商圈，会员等级，还要考虑是否是合作企业，是否是会员生日，三间及以上折扣
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//策略制定者的身份
	private UserRole ur;
	private String id;
	
	private String strategy_name;
	//可以是专门为了房间数，也可以是专门为了生日，例如strategyForRoomnumber
	//如何理解呢，就是只要这里的变量不为空，那么就必须满足条件
	
	private boolean IsMemberBirthday;
	
	//用于记录合作企业名称，不为空表示只适用于这些企业
	private String enterpriseList;
	
	//用于记录房间数多少间可以打折，不为空表示超过多少间才能行
	private int roomNumber;
	
		//用于记录策略开始时间，不为空表示开始实行时间
	private Date start_date;
		
		//用于记录策略结束时间，不为空表示结束实行时间
	private Date end_date;
		
		//用于记录策略适用商圈，不为空表示特定商圈才符合
	private String businessarea;
		
		//用于记录会员等级达到多少即可享受折扣，不为空表示特定等级的会员才能享受
	private int level;
		
		//用于记录折扣比例
	private double count;
		
	public StrategyVO(StrategyPO po){
		this.ur=po.getUserRole();
		this.id=po.getID();
		this.strategy_name=po.getName();
		this.start_date=po.getStartDate();
		this.end_date=po.getEndDate();
		this.businessarea=po.getArea();
		this.level=po.getLevel();
		this.count=po.getCount();
		this.enterpriseList=po.getEnterprise();
		this.roomNumber=po.getRoomNumber();
		this.IsMemberBirthday=po.IsMemberBirth();
	}
	
	public void print(){
		System.out.println(id+"\t"+strategy_name+"\t"+start_date+"\t"+end_date+"\t"+businessarea+"\t"+level+"\t"
				+count+"\t"+enterpriseList+"\t"+roomNumber+"\t"+IsMemberBirthday);
	}
	
	public String getID(){
		return id;
	}
		
	public void setName(String s){
		if(!s.equals(strategy_name)){
			strategy_name=s;
		}
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
		
	public boolean IsMemberBirth(){
		return IsMemberBirthday;
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

