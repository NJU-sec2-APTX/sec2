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
	
	public Client(){
		try {
            HotelDataService hotelds = (HotelDataService) Naming.lookup("rmi://172.17.232.191:1098/HotelDataService");
            memberDataService = (MemberDataService) Naming.lookup("rmi://172.17.232.191:1098/MemberDataService");
            OrderDataService orderds = (OrderDataService) Naming.lookup("rmi://172.17.232.191:1098/OrderDataService");
            strategyDataService = (StrategyDataService) Naming.lookup("rmi://172.17.232.191:1098/StrategyDataService");
            userDataService = (UserDataService) Naming.lookup("rmi://172.17.232.191:1098/UserDataOService");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
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
