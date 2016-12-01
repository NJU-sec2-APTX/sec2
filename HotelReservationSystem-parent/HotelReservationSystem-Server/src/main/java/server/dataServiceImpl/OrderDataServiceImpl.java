package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.dataService.OrderDataService;

public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4026471108382528596L;

	public OrderDataServiceImpl() throws RemoteException {
		super();
	}

}
