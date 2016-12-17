package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import common.dataService.HotelDataService;
import common.dataService.MemberDataService;
import common.dataService.OrderDataService;
import common.dataService.StrategyDataService;
import common.dataService.UserDataService;

public class Client {
	private static MemberDataService memberDataService;
	private static StrategyDataService strategyDataService;
	private static UserDataService userDataService;
	private static HotelDataService hotelDataService;
	private static OrderDataService orderDataService;
	
	public Client(){
		try {
			hotelDataService = (HotelDataService) Naming.lookup("rmi://localhost:8888/HotelDataService");
            memberDataService = (MemberDataService) Naming.lookup("rmi://localhost:8888/MemberDataService");
            orderDataService = (OrderDataService) Naming.lookup("rmi://localhost:8888/OrderDataService");
            strategyDataService = (StrategyDataService) Naming.lookup("rmi://localhost:8888/StrategyDataService");
            userDataService = (UserDataService) Naming.lookup("rmi://localhost:8888/UserDataService");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
	}

	public static HotelDataService getHotelDataService() {
		return hotelDataService;
	}

	public static OrderDataService getOrderDataService() {
		return orderDataService;
	}

	public static MemberDataService getMemberDataService() {
		return memberDataService;
	}

	public static StrategyDataService getStrategyDataService() {
		return strategyDataService;
	}

	public static UserDataService getUserDataService() {
		return userDataService;
	}
}
