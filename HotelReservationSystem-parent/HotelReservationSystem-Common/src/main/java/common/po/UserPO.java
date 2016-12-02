package common.po;

import java.io.Serializable;

import common.otherEnumClasses.UserRole;

public class UserPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Id=null;
	private String name=null;
	private String password=null;
	private UserRole role=null;
	private String contact=null;
	private String belonghotel=null;
	public UserPO(String id,UserRole ur){
		Id=id;
		role=ur;
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
	public void setbelonghotel(String hotel){
		this.belonghotel=hotel;
	}
	public String getHotel(){
		return belonghotel;
	}
}
