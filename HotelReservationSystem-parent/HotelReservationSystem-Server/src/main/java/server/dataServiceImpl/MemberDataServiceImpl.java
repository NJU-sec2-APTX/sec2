package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import common.dataService.MemberDataService;
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
	
	public MemberDataServiceImpl() throws RemoteException{
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public ResultMessage insert(MemberPO mpo) throws RemoteException{
		sql="insert into member(id,name,password,userrole,credit,birthday,contact,level)"+
				" value('"+mpo.getId()+"','"+mpo.getName()+"','"+mpo.getPassword()+"','"+
				(""+mpo.getUserRole())+"',"+mpo.getCredit()+",'"+(mpo.getBirthday().getYear()+1900)
				+"-"+(mpo.getBirthday().getMonth()+1)+"-"+mpo.getBirthday().getDate()+
				"','"+mpo.getContact()+"',"+mpo.getLevel()+");";
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
	
	private UserRole change(String s){
		if(s.equals("Member")){
			return UserRole.Member;
		}else if(s.equals("Enterprise")){
			return UserRole.Enterprise;
		}
		return null;
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
				password=resultset.getString(3);
				userrole=change(resultset.getString(4));
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
			databasehelper.close();
			
			databasehelper=new DBHelper(sql1);
			resultset=databasehelper.pst.executeQuery();
			while(resultset.next()){
				memberpo.addCreditItem(resultset.getDate(2), resultset.getDouble(3));
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
				Date d=new Date();
				sql1="insert into credit(id,date,changes)"+"value('"+po.getId()+"','"
				+(d.getYear()+1900)+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+d.getHours()+":"+d.getMinutes()+"',"
						+(po.getCredit()-find(po.getId()).getCredit())+");";
				databasehelper=new DBHelper(sql1);
				databasehelper.pst.execute(sql1);
				databasehelper.close();
			}
			sql="update member set name='"+po.getName()+"',password='"+po.getPassword()+"',credit="+po.getCredit()
			+",birthday='"+(po.getBirthday().getYear()+1900)+"-"+(po.getBirthday().getMonth()+1)+"-"
				+po.getBirthday().getDate()+"',contact='"+po.getContact()+"',level="+po.getLevel()+" where id='"+po.getId()+"';";
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
				sql="select * from member where id='"+ID+"'&&password='"+password+"'&&userrole='"+ur.toString()+"';";
				databasehelper=new DBHelper(sql);
				resultset=databasehelper.pst.executeQuery();
				if(resultset.next()){
					sql="insert into onlinelist(id,userrole)value('"+ID+"','"+ur.toString()+"');";
					databasehelper=new DBHelper(sql);
					databasehelper.pst.execute();
					resultset.close();
					databasehelper.close();
					return ResultMessage.Success;
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
