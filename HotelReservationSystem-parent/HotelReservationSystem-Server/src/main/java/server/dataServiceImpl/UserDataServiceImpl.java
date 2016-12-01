package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.dataService.UserDataService;

public class UserDataServiceImpl extends UnicastRemoteObject implements UserDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2214885817688101053L;

	public UserDataServiceImpl() throws RemoteException {
		super();
	}

}
