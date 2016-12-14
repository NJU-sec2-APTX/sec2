package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import common.dataService.UserDataService;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.UserPO;

public class UserDataServiceImpl extends UnicastRemoteObject implements UserDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8731398660645877605L;

	public UserDataServiceImpl() throws RemoteException {
	}

	private DBHelper databasehelper;
	private String sql;
	private ResultSet resultset;
	
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
				sql="select * from user where id='"+ID+"'&&password='"+password+"'&&userrole='"+ur.toString()+"';";
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
				password=resultset.getString(3);
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
				" value('"+po.getId()+"','"+po.getName()+"','"+po.getPassword()+"','"+
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
		sql="update user set name='"+po.getName()+"',password='"+po.getPassword()+"',belonghotel='"+po.getHotel()
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
	public ResultMessage updatecredit(String id, double money) throws RemoteException {
		sql="select credit from member where id='"+id+"';";
		databasehelper=new DBHelper(sql);
		try {
			resultset=databasehelper.pst.executeQuery();
			double credit=0;
			while(resultset.next()){
				credit=resultset.getDouble(1);
			}
			String sql1="";
			if(money!=0){
				Date d=new Date();
				sql1="insert into credit(id,date,changes)"+"value('"+id+"','"
				+(d.getYear()+1900)+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+d.getHours()+":"+d.getMinutes()+"',"
						+(money*100)+");";
				databasehelper=new DBHelper(sql1);
				databasehelper.pst.execute(sql1);
				databasehelper.close();
				credit+=money*100;
				sql="update member set credit="+credit+" where id='"+id+"';";
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
}