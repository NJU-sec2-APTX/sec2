package common.otherEnumClasses;

public enum StrategyType {
	Birthday,CorporationEnterPrise,MemberLevel,RoomNumber,SpecialDate,VipandArea;
	public static StrategyType getType(String s){
		if(s.equals("Birthday")){
			return Birthday;
		}else if(s.equals("CorporationEnterPrise")){
			return CorporationEnterPrise;
		}else if(s.equals("MemberLevel")){
			return MemberLevel;
		}else if(s.equals("RoomNumber")){
			return RoomNumber;
		}else if(s.equals("SpecialDate")){
			return SpecialDate;
		}else if(s.equals("VipandArea")){
			return VipandArea;
		}else{
			return null;
		}
	}
}
