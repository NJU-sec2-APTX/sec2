package common.otherEnumClasses;

import java.io.Serializable;
import java.util.ArrayList;

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
}
