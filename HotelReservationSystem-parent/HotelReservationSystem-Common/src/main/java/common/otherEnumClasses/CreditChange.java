package common.otherEnumClasses;

import common.po.OrderPO;

public class CreditChange {

	public Person person;
	public double changeNum;
	public OrderPO po;
	public OrderState fromState;
	public OrderState toState;
	
	public CreditChange(Person person, double changeNum, OrderPO po, OrderState fromState, OrderState toState){
		this.person = person;
		this.changeNum = changeNum;
		this.po = po;
		this.fromState = fromState;
		this.toState = toState;
	}
}
