package common.otherEnumClasses;

import common.vo.StrategyVO;

public class StrategyLineItem {
	private StrategyVO strategy;
	private double price;
	
	public StrategyLineItem(StrategyVO st,double p){
		strategy=st;
		price=p;
	}
	
	public StrategyVO getStrategy(){
		return strategy;
	}
	
	public double getPrice(){
		return price;
	}
}