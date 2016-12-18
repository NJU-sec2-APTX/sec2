package common.otherEnumClasses;

public enum CreditOperation {
	Execute, Exception, Cancel, ExceptionCancel, Recharge;
	public static CreditOperation getCreditOperation(String s){
		if(s.equals("Execute")){
			return Execute;
		}else if(s.equals("Exception")){
			return Exception;
		}else if(s.equals("Cancel")){
			return Cancel;
		}else if(s.equals("Recharge")){
			return Recharge;
		}else if(s.equals("ExceptionCancel")){
			return ExceptionCancel;
		}else{
			return null;
		}
	}
}
