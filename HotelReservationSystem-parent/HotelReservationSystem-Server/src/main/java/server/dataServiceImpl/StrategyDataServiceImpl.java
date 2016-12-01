package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.dataService.StrategyDataService;

public class StrategyDataServiceImpl extends UnicastRemoteObject implements StrategyDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3198715297352420467L;

	public StrategyDataServiceImpl() throws RemoteException {
		super();
	}

}
