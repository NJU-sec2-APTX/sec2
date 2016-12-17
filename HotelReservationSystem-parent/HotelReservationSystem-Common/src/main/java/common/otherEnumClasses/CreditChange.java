package common.otherEnumClasses;

public class CreditChange {

	public String clientId;
	public double changeNum;
	public double endNum;
	public CreditOperation op;
	public String orderId;
	
	public CreditChange(String clientId, double changeNum, double endNum, CreditOperation op, String orderId){
		this.clientId = clientId;
		this.changeNum = changeNum;
		this.endNum = endNum;
		this.op = op;
		this.orderId = orderId;
	}
}
