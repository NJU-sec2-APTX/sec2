package common.dataService;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import common.otherEnumClasses.MemberList;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;

public interface MemberDataService extends Remote{

	public ResultMessage insert(MemberPO mpo) throws IOException,RemoteException;
	
	public MemberPO find(String ID)throws RemoteException;
	
	public ResultMessage update (MemberPO po)throws RemoteException;
	
	public MemberList findCredit(String ID) throws RemoteException;
	
	public ResultMessage checkinmember(String ID,UserRole ur,String password) throws RemoteException;
	
	public ResultMessage checkoutmember(String id,UserRole ur) throws RemoteException;
}
