package common.otherEnumClasses;

import java.util.Date;

public class CreditChange {

	public String clientId;
	public double changeNum;
	public double endNum;
	public CreditOperation op;
	public Date time;
	public String orderId;
	
	
	public CreditChange(String clientId, double changeNum, double endNum, CreditOperation op, Date time, String orderId){
		this.clientId = clientId;
		this.changeNum = changeNum;
		this.endNum = endNum;
		this.op = op;
		this.time = time;
		this.orderId = orderId;
	}
}
