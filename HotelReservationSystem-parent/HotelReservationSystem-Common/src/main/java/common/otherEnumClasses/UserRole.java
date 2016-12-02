package common.otherEnumClasses;

public enum UserRole {
	Member, HotelWorker, Sales, Manager, Enterprise;
	public static UserRole getUserRole(String s){
		if(s.equals("Member")){
			return UserRole.Member;
		}else if(s.equals("Sales")){
			return UserRole.Sales;
		}else if(s.equals("HotelWorker")){
			return UserRole.HotelWorker;
		}else if(s.equals("Manager")){
			return UserRole.Manager;
		}else{
			return UserRole.Enterprise;
		}
	}
}
