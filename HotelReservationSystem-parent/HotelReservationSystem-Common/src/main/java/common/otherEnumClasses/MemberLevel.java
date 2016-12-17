package common.otherEnumClasses;

public class MemberLevel {
	//0.95/0.9/0.85/0.8/0.75
	private double[] Mydiscount;
	
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
	public MemberLevel(String discount,String credit){
		String[] dis=discount.split("/");
		String[] cre=credit.split("/");
		Mydiscount=new double[dis.length];
		MycreditLevel=new int[dis.length];
		for(int i=0;i<dis.length;i++){
			Mydiscount[i]=Double.parseDouble(dis[i]);
			MycreditLevel[i]=Integer.parseInt(cre[i]);
		}
	}
}
