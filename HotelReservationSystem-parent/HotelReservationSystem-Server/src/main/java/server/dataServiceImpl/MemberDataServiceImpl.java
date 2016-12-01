package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.dataService.MemberDataService;

public class MemberDataServiceImpl extends UnicastRemoteObject implements MemberDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4634564291584930824L;

	public MemberDataServiceImpl() throws RemoteException {
		super();
	}

}
