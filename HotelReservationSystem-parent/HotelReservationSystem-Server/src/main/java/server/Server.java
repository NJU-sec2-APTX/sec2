package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import server.dataServiceImpl.HotelDataServiceImpl;
import server.dataServiceImpl.MemberDataServiceImpl;
import server.dataServiceImpl.OrderDataServiceImpl;
import server.dataServiceImpl.StrategyDataServiceImpl;
import server.dataServiceImpl.UserDataServiceImpl;

public class Server {

	public Server(){
		try {
            LocateRegistry.createRegistry(1098);
            Naming.bind("rmi://192.168.1.104:1098/HotelDataService", new HotelDataServiceImpl());
            Naming.bind("rmi://192.168.1.104:1098/MemberDataService", new MemberDataServiceImpl());
            Naming.bind("rmi://192.168.1.104:1098/OrderDataService", new OrderDataServiceImpl());
            Naming.bind("rmi://192.168.1.104:1098/StrategyDataService", new StrategyDataServiceImpl());
            Naming.bind("rmi://192.168.1.104:1098/UserDataService", new UserDataServiceImpl());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (java.rmi.AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
