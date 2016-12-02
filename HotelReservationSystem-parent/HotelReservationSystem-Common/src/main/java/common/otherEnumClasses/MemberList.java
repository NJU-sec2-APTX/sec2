package common.otherEnumClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class MemberList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<MemberItem> list;
	
	public MemberList(){
		list=new ArrayList<MemberItem>();
	}
	
	public void addMemberItem(MemberItem mi){
		list.add(mi);
	}
	
	public ArrayList<MemberItem> getMemberList(){
		return list;
	}
	
	@SuppressWarnings("deprecation")
	public void print(){
		if(list!=null){
			for(int i=0;i<list.size();i++){
				Date date=list.get(i).getDate();
				System.out.println((date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate()+"\t"+list.get(i).getChange());
			}
		}
	}
}
