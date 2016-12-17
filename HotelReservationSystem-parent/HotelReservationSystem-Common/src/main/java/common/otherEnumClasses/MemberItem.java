package common.otherEnumClasses;

import java.io.Serializable;
import java.util.Date;

public class MemberItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private double change;
	private String OrderID;
	private double credit;
	private CreditOperation operation;
	public MemberItem(Date d,double c,String o,double cre,CreditOperation ope){
		date=d;
		change=c;
		OrderID=o;
		credit=cre;
		operation=ope;
	}
	public String getOrderID(){
		return OrderID;
	}
	public double getCredit(){
		return credit;
	}
	public CreditOperation getOperation(){
		return operation;
	}
	public Date getDate(){
		return date;
	}
	public double getChange(){
		return change;
	}
}
