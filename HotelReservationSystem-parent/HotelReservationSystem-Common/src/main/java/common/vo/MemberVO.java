package common.vo;

import java.util.Date;

import common.otherEnumClasses.MemberList;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;

public class MemberVO {
	private String Id;
	private String name;
	private UserRole role;
	private double credit;
	private MemberList creditList;
	private Date birthday;
	private int level;
	private String contact;
	private String password;
	
	public int getLevel(){
		return level;
	}
	
	public Date getBirthday(){
		return birthday;
	}
	public MemberVO(String i,UserRole r){
		Id=i;
		role=r;
		name=null;
		credit=0.0;
		birthday=null;
		creditList=null;
		level=0;
		contact=null;
		password=null;
	}
	
	public MemberVO(MemberPO po){
		super();
		Id=po.getId();
		name=po.getName();
		role=po.getUserRole();
		credit=po.getCredit();
		creditList=po.getCreditList();
		birthday=po.getBirthday();
		contact=po.getContact();
		level=po.getLevel();
		password=po.getPassword();
	}
	
	public String getPassword(){
		return password;
	}
	public String getId(){
		return Id;
	}
	public String getName(){
		return name;
	}
	public UserRole getUserRole(){
		return role;
	}
	public double getCredit(){
		return credit;
	}
	public MemberList getCreditList(){
		return creditList;
	}
	public String getContact() {
		return contact;
	}
}
