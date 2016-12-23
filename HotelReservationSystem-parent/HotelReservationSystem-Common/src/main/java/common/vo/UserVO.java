package common.vo;

import common.otherEnumClasses.UserRole;
import common.po.UserPO;

public class UserVO{
	private String Id;
	private String name;
	private UserRole role;
	private String contact;
	private String belonghotel;
	private String password;
	public UserVO(UserPO po){
		Id=po.getId();
		name=po.getName();
		role=po.getUserRole();
		contact=po.getContact();
		belonghotel=po.getHotel();
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
	public String getContact(){
		return contact;
	}
	public String getBelongHotel(){
		return belonghotel;
	}
}