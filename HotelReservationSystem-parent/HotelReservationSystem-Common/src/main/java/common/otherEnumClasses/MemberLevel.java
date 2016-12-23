package common.otherEnumClasses;

public class MemberLevel {
	
	//100/1000/10000/100000/1000000
	private int[] MycreditLevel;
	
	/**
	 * 通过传入的信用返回用户的等级
	 * @param credit
	 * @return
	 */
	public int getMemberLevel(double credit){
		for(int i=0;i<MycreditLevel.length;i++){
			if(credit<MycreditLevel[i]){
				return i;
			}
		}
		return MycreditLevel.length;
	}
	
	/**
	 * 构造函数通过传入的string确定会员等级制度
	 * @param discount
	 * @param credit
	 */
	public MemberLevel(String credit){
		String[] cre=credit.split("/");
		MycreditLevel=new int[cre.length];
		for(int i=0;i<cre.length;i++){
			MycreditLevel[i]=Integer.parseInt(cre[i]);
		}
	}
}
