package common.otherEnumClasses;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private double change;
	private String hotel;
	
	public MemberItem(Date d,double c){
		date=d;
		change=c;
	}
	
	public Date getDate(){
		return date;
	}
	public double getChange(){
		return change;
	}
	public String getHotel(){
		return hotel;
	}
	@SuppressWarnings("deprecation")
	public void print(){
		System.out.print((date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate()+"/"
	+date.getHours()+"/"+date.getMinutes()+new SimpleDateFormat("EEEE").format(date)+";");
		if(change<0){
			System.out.println(change);
		}else{
			System.out.println("+"+change);
		}
	}
}
