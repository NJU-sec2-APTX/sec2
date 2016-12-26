package common.otherEnumClasses;

public enum RoomType {
	SingleStd, DoubleStd, Family;
	
	//将字符串转换为RoomType枚举类
	public static RoomType get(String s){
		switch (s) {
		case "SingleStd":return RoomType.SingleStd;
		case "DoubleStd":return RoomType.DoubleStd;
		case "Family":return RoomType.Family;
		}
		return null;
	}
}
