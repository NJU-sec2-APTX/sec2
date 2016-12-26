package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import common.dataService.MemberDataService;
import common.otherEnumClasses.CreditOperation;
import common.otherEnumClasses.MemberLevel;
import common.otherEnumClasses.MemberList;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;

public class MemberDataServiceImpl extends UnicastRemoteObject implements MemberDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3822375549030670538L;
	private DBHelper databasehelper;
	private String sql;
	private String sql1;
	private ResultSet resultset;
	
	public String pushpassword(String s){
		char[]list=s.toCharArray();
		String Result="";
		int random=(int)(Math.random()*9)+1;
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
	
	public MemberDataServiceImpl() throws RemoteException{}
	
	@SuppressWarnings("deprecation")
	@Override
	public ResultMessage insert(MemberPO mpo) throws RemoteException{
		sql="select * from strategy where userrole='Sales'&&strategyType='MemberLevel';";
		databasehelper=new DBHelper(sql);
		try {
			databasehelper=new DBHelper(sql);
			resultset=databasehelper.pst.executeQuery();
			MemberLevel memberlevel=null;
			if(resultset.next()){
				memberlevel=new MemberLevel(resultset.getString(11));
			}
			int l=memberlevel.getMemberLevel(mpo.getCredit());
                        if(mpo.getUserRole().equals(UserRole.Member)){
                            sql="insert into member(id,name,password,userrole,credit,birthday,contact,level)"+
					" value('"+mpo.getId()+"','"+mpo.getName()+"','"+pushpassword(mpo.getPassword())+"','"+
					(""+mpo.getUserRole())+"',"+mpo.getCredit()+",'"+(mpo.getBirthday().getYear()+1900)
					+"-"+(mpo.getBirthday().getMonth()+1)+"-"+mpo.getBirthday().getDate()+
					"','"+mpo.getContact()+"',"+l+");";
                        }else{
                            sql="insert into member(id,name,password,userrole,credit,birthday,contact,level)"+
					" value('"+mpo.getId()+"','"+mpo.getName()+"','"+pushpassword(mpo.getPassword())+"','"+
					(""+mpo.getUserRole())+"',"+mpo.getCredit()+",'null','"+mpo.getContact()+"',"+l+");";
                        }
			databasehelper=new DBHelper(sql);
			databasehelper.pst.execute();
			databasehelper.close();
			return ResultMessage.Success;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	@Override
	public MemberPO find(String ID) throws RemoteException{
		sql="select * from member where id='"+ID+"';";
		sql1="select * from credit where id='"+ID+"';";
		try {
			databasehelper=new DBHelper(sql);
			resultset=databasehelper.pst.executeQuery();
			String id = null;
			UserRole userrole = null;
			String name=null;
			String password=null;
			Date birthday=null;
			String contact=null;
			double credit=0;
			while (resultset.next()) {
				id=resultset.getString(1);
				name=resultset.getString(2);
				password=pullpassword(resultset.getString(3));
				userrole=UserRole.getUserRole(resultset.getString(4));
				credit=resultset.getDouble(5);
				birthday=resultset.getDate(6);
				contact=resultset.getString(7);
            }
			if(id==null){
				return null;
			}
			MemberPO memberpo=new MemberPO(id,userrole);
			memberpo.setBirthday(birthday);
			memberpo.setCredit(credit);
			memberpo.setName(name);
			memberpo.setPassword(password);
			memberpo.setContact(contact);
			
			sql="select * from strategy where userrole='Sales'&&strategyType='MemberLevel';";
			databasehelper=new DBHelper(sql);
			resultset=databasehelper.pst.executeQuery();
			MemberLevel memberlevel=null;
			if(resultset.next()){
				memberlevel=new MemberLevel(resultset.getString(11));
			}
			int l=memberlevel.getMemberLevel(memberpo.getCredit());
			memberpo.setLevel(l);
			databasehelper.close();
			
			databasehelper=new DBHelper(sql1);
			resultset=databasehelper.pst.executeQuery();
			while(resultset.next()){
				memberpo.addCreditItem(resultset.getDate(2), resultset.getDouble(3),resultset.getString(5),
						resultset.getDouble(4),CreditOperation.getCreditOperation(resultset.getString(6)));
			}
			databasehelper.close();
			resultset.close();
			return memberpo;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public ResultMessage update(MemberPO po) throws RemoteException{
		sql1="";
		try {
			if(find(po.getId()).getCredit()!=po.getCredit()){
				return ResultMessage.Failure;
			}
			sql="update member set name='"+po.getName()+"',password='"+pushpassword(po.getPassword())+"',birthday"
					+ "='"+(po.getBirthday().getYear()+1900)+"-"+(po.getBirthday().getMonth()+1)+"-"
				+po.getBirthday().getDate()+"',contact='"+po.getContact()+"' where id='"+po.getId()+"';";
			databasehelper=new DBHelper(sql);
			databasehelper.pst.execute(sql);
			databasehelper.close();
			return ResultMessage.Success;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	@Override
	public MemberList findCredit(String ID) throws RemoteException{
		MemberPO po=find(ID);
		if(po==null){
			return null;
		}
		return po.getCreditList();
	}
	
	@Override
	public ResultMessage checkinmember(String ID, UserRole ur, String password) throws RemoteException {
		sql="select * from onlinelist where id='"+ID+"'&&userrole='"+ur.toString()+"';";
		try {
			databasehelper=new DBHelper(sql);
			resultset=databasehelper.pst.executeQuery();
			if(resultset.next()){
				databasehelper.close();
				return ResultMessage.Logged;
			}else{
				sql="select * from member where id='"+ID+"'&&userrole='"+ur.toString()+"';";
				databasehelper=new DBHelper(sql);
				resultset=databasehelper.pst.executeQuery();
				if(resultset.next()){
					if(password.equals(pullpassword(resultset.getString(3)))){
						sql="insert into onlinelist(id,userrole)value('"+ID+"','"+ur.toString()+"');";
						databasehelper=new DBHelper(sql);
						databasehelper.pst.execute();
						resultset.close();
						databasehelper.close();
						return ResultMessage.Success;
					}else{
						return ResultMessage.Failure;
					}
				}else{
					databasehelper.close();
					return ResultMessage.Failure;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	@Override
	public ResultMessage checkoutmember(String id, UserRole ur) throws RemoteException {
		sql="select * from onlinelist where id='"+id+"'&&userrole='"+ur.toString()+"';";
		databasehelper=new DBHelper(sql);
		try {
			resultset=databasehelper.pst.executeQuery();
			if(resultset.next()){
				sql="delete from onlinelist where id='"+id+"'&&userrole='"+ur.toString()+"';";
				databasehelper=new DBHelper(sql);
				databasehelper.pst.execute();
				resultset.close();
				databasehelper.close();
				return ResultMessage.Success;
			}else{
				return ResultMessage.Failure;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}
}
