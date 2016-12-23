package common.otherEnumClasses;

public enum OrderState {
	NotDone, Done, Exceptional, Commented, Canceled, ExceptionalCanceled;
	
	//
	public static OrderState get(String s){
		switch (s) {
		case "NotDone":return OrderState.NotDone;
		case "Done":return OrderState.Done;
		case "Exceptional":return OrderState.Exceptional;
		case "Commented":return OrderState.Commented;
		case "canceled":return OrderState.Canceled;
		case "ExcetionalCanceled":return OrderState.ExceptionalCanceled;
		}
		return null;
	}
}