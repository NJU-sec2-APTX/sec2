package common.otherEnumClasses;

import java.util.ArrayList;

import common.vo.StrategyVO;

public class StrategyList {
	private ArrayList<StrategyLineItem> list;
	
	private int number;
	
	public StrategyList(){
		list=new ArrayList<StrategyLineItem>();
		number=0;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void print(){
		if(list!=null){
			for(int i=0;i<list.size();i++){
				list.get(i).getStrategy().print();
				System.out.println(list.get(i).getPrice()+"\n");
			}
		}
	}
	
	public void addLineItem(double p,StrategyVO vo){
		StrategyLineItem sli=new StrategyLineItem(vo,p);
		if(list.size()!=0){
			int index=list.size();
			for(int i=0;i<list.size();i++){
				if(p<list.get(i).getPrice()){
					index=i;
					break;
				}
			}
			list.add(index, sli);
		}else{
			list.add(sli);
		}
		number++;
	}
	
	public StrategyLineItem getfirstStrategy(){
		if(number==0){
			return null;
		}
		return list.get(0);
	}
	
	public StrategyLineItem getStrategy(String StrategyName,UserRole ur){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getStrategy().getName().equals(StrategyName)){
				return list.get(i);
			}
		}
		return null;
	}
}
