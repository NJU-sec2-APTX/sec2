package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import common.dataService.OrderDataService;
import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.po.HotelPO;
import common.po.OrderPO;
import common.vo.HotelVO;

public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4026471108382528596L;

	public OrderDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<HotelPO> searchReservedHotel(Person person) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderPO> findOrderList(Person person, OrderState state, HotelVO hotelVO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateOrder(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addOrder(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
