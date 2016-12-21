package common.vo;

import common.otherEnumClasses.UserRole;
import common.po.UserPO;

public class UserVO{
	String Id;
	String name;
	UserRole role;
	String contact;
	String belonghotel;
	public UserVO(UserPO po){
		Id=po.getId();
		name=po.getName();
		role=po.getUserRole();
		contact=po.getContact();
		belonghotel=po.getHotel();
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
	public String getContact(){
		return contact;
	}
	public String getBelongHotel(){
		return belonghotel;
	}
}