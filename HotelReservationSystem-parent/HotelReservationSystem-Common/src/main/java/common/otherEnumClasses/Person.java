package common.otherEnumClasses;

import java.io.Serializable;

public class Person implements Serializable{
	
	public UserRole role;//用户身份
	public String id;//身份对应ID
	
	public Person(){
		
	}
	
	public Person(UserRole role,String id){
		this.role = role;
		this.id = id;
	}
}
