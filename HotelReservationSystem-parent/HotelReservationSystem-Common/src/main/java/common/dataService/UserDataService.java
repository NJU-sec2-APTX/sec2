package common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.UserPO;

public interface UserDataService extends Remote{
	public ResultMessage checkinuser(String ID,UserRole ur,String password) throws RemoteException;
	
	public UserPO find(String id,UserRole ur) throws RemoteException;
	
	public ResultMessage insert(UserPO po) throws RemoteException;
	
	public ResultMessage update(UserPO po) throws RemoteException;
	
	public ResultMessage updatecredit(String id,double money) throws RemoteException;
	
	public ResultMessage checkoutuser(String ID,UserRole ur) throws RemoteException;
}