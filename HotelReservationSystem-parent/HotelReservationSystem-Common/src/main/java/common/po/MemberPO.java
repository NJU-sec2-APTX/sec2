package common.po;

import java.io.Serializable;
import java.util.Date;

import common.otherEnumClasses.MemberItem;
import common.otherEnumClasses.MemberList;
import common.otherEnumClasses.UserRole;
public class MemberPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Id;
	private String name;
	private String password;
	private UserRole role;
	private double credit;
	private Date birthday;
	private MemberList creditlist;
	private int level;
	private String contact;
	
	@SuppressWarnings("deprecation")
	public void print(){
		System.out.println(Id+"\t"+name+"\t"+password+"\t"+role+"\t"+credit+"\t"+
				(birthday.getYear()+1900)+"-"+(birthday.getMonth()+1)+"-"+birthday.getDate()+"\t"
				+contact+"\t"+level);
	}
	
	public void setLevel(int level){
		this.level=level;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setBirthday(Date birthday){
		this.birthday=birthday;
	}
	
	public Date getBirthday(){
		return birthday;
	}
	
	public MemberPO(String id,UserRole ur){
		this.Id=id;
		this.role=ur;
		name=null;
		password=null;
		credit=0.0;
		birthday=null;
		creditlist=null;
		level=0;
		contact=null;
	}
	
	public void addCreditItem(Date date,double changes){
		if(creditlist==null)
			creditlist=new MemberList();
		creditlist.addMemberItem(new MemberItem(date,changes));
	}
	
	public MemberList getCreditList(){
		return creditlist;
	}
	
	public double getCredit(){
		return credit;
	}
	
	public void setCredit(double x){
		credit=x;
	}
	public String getId(){
		return Id;
	}
	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	public UserRole getUserRole(){
		return role;
	}
	public String getContact(){
		return contact;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setContact(String contact){
		this.contact=contact;
	}
}