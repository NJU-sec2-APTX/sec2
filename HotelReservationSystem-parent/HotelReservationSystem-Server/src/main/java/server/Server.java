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
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/HotelDataService", new HotelDataServiceImpl());
            Naming.bind("rmi://localhost:8888/MemberDataService", new MemberDataServiceImpl());
            Naming.bind("rmi://localhost:8888/OrderDataService", new OrderDataServiceImpl());
            Naming.bind("rmi://localhost:8888/StrategyDataService", new StrategyDataServiceImpl());
            Naming.bind("rmi://localhost:8888/UserDataService", new UserDataServiceImpl());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (java.rmi.AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

}
