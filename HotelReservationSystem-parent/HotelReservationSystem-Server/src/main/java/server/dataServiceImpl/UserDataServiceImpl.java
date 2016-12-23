package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import common.dataService.UserDataService;
import common.otherEnumClasses.CreditOperation;
import common.otherEnumClasses.MemberLevel;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.UserPO;

public class UserDataServiceImpl extends UnicastRemoteObject implements UserDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8731398660645877605L;
	public UserDataServiceImpl() throws RemoteException {}

	private DBHelper databasehelper;
	private String sql;
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
	
	@Override
	public ResultMessage checkinuser(String ID, UserRole ur, String password) throws RemoteException {
		sql="select * from onlinelist where id='"+ID+"'&&userrole='"+ur.toString()+"';";
		try {
			databasehelper=new DBHelper(sql);
			resultset=databasehelper.pst.executeQuery();
			if(resultset.next()){
				databasehelper.close();
				return ResultMessage.Logged;
			}else{
				sql="select * from user where id='"+ID+"'&&userrole='"+ur.toString()+"';";
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
					System.out.println("here?");
					return ResultMessage.Failure;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	@Override
	public UserPO find(String id, UserRole ur) throws RemoteException {
		sql="select * from user where id='"+id+"'&&userrole='"+ur.toString()+"';";
		databasehelper=new DBHelper(sql);
		try {
			resultset=databasehelper.pst.executeQuery();
			String name=null;
			String password=null;
			String hotel=null;
			String contact=null;
			while(resultset.next()){
				name=resultset.getString(2);
				password=pullpassword(resultset.getString(3));
				contact=resultset.getString(5);
				hotel=resultset.getString(6);
			}
			if(name==null){
				return null;
			}
			UserPO po=new UserPO(id,ur);
			po.setName(name);
			po.setPassword(password);
			po.setContact(contact);
			po.setbelonghotel(hotel);
			databasehelper.close();
			resultset.close();
			return po;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResultMessage insert(UserPO po) throws RemoteException {
		sql="insert into user(id,name,password,userrole,contact,belonghotel)"+
				" value('"+po.getId()+"','"+po.getName()+"','"+pushpassword(po.getPassword())+"','"+
				(""+po.getUserRole())+"','"+po.getContact()+"','"+po.getHotel()+"');";
		databasehelper=new DBHelper(sql);
		try {
			databasehelper.pst.execute();
			databasehelper.close();
			return ResultMessage.Success;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	@Override
	public ResultMessage update(UserPO po) throws RemoteException {
		sql="update user set name='"+po.getName()+"',password='"+pushpassword(po.getPassword())+"',belonghotel='"+po.getHotel()
		+"',contact='"+po.getContact()+"' where id='"+po.getId()+"'&&userrole='"+po.getUserRole().toString()+"';";
		databasehelper=new DBHelper(sql);
		try{
			databasehelper.pst.execute(sql);
			databasehelper.close();
			return ResultMessage.Success;
		}catch(SQLException e){
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public ResultMessage updatecredit(String id,double newcredit,String OrderID,CreditOperation operation) throws RemoteException {
		//先找到当前用户的信用总值
		sql="select credit from member where id='"+id+"';";
		databasehelper=new DBHelper(sql);
		try {
			resultset=databasehelper.pst.executeQuery();
			double credit=0;
			while(resultset.next()){
				credit=resultset.getDouble(1);
			}
			String sql1="";
			if(newcredit!=0){
				Date d=new Date();
				credit+=newcredit;
				sql1="insert into credit(id,date,changes,credit,orderid,creditoperation)"+"value('"+id+"','"
				+(d.getYear()+1900)+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+d.getHours()+":"+d.getMinutes()+"',"
						+(newcredit)+","+credit+",'"+OrderID+"','"+operation.toString()+"');";
				databasehelper=new DBHelper(sql1);
				databasehelper.pst.execute(sql1);
				databasehelper.close();
				sql="select * from strategy where userrole='Sales'&&strategyType='MemberLevel';";
				databasehelper=new DBHelper(sql);
				resultset=databasehelper.pst.executeQuery();
				MemberLevel memberlevel=null;
				if(resultset.next()){
					memberlevel=new MemberLevel(resultset.getString(11));
				}
				int l=memberlevel.getMemberLevel(credit);
				sql="update member set credit="+credit+",level="+l+" where id='"+id+"';";
				databasehelper=new DBHelper(sql);
				databasehelper.pst.execute();
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

	@Override
	public ResultMessage checkoutuser(String ID, UserRole ur) throws RemoteException {
		sql="select * from onlinelist where id='"+ID+"'&&userrole='"+ur.toString()+"';";
		databasehelper=new DBHelper(sql);
		try {
			resultset=databasehelper.pst.executeQuery();
			if(resultset.next()){
				sql="delete from onlinelist where id='"+ID+"'&&userrole='"+ur.toString()+"';";
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

	@Override
	public ResultMessage remove(String id, UserRole ur) throws RemoteException {
		sql="delete from user where id='"+id+"'&&userrole='"+ur.toString()+"';";
		databasehelper=new DBHelper(sql);
		try {
			databasehelper.pst.execute();
			databasehelper.close();
			return ResultMessage.Success;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}
}