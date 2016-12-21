package server.dataServiceImpl;

public class aa {	
	public static void main(String[]args){
		aa a=new aa();
		String s="default";
		String result=a.pushpassword(s);
		System.out.println(result);
		System.out.println(a.pullpassword(result));
	}
	
	public String pushpassword(String s){
		char[]list=s.toCharArray();
		String Result="";
		int random=(int)(Math.random()*10);
		for(int i=0;i<list.length;i++){
			Result+=(char)((list[i]+random*random)%127);
		}
		return Result+random;
	}
	
	public String pullpassword(String s){
		char[]list=s.substring(0,s.length()-1).toCharArray();
		String Result="";
		int random=Integer.parseInt(s.charAt(s.length()-1)+"");
		for(int i=0;i<list.length;i++){
			Result+=(char)((list[i]-random*random+127)%127);
		}
		return Result;
	}
}