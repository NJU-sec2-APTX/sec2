package test;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.strategyblService.StrategyMaintainService;
import client.businessLogicServiceImpl.strategybl.StrategyController;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.StrategyPO;
import junit.framework.TestCase;

public class StrategyTest extends TestCase{
	StrategyMaintainService strategymaintain;
	
	@Before
	public void setUp(){
		new Client();
	}
	
//	String id,UserRole ur,String strategy_name,String enterpriseList,int roomNumber,
//	Date start_date,Date end_date,String businessarea,int level,double count,boolean IsBirthday
	@Test
	public void testStrategyMaintain(){
		//add
		strategymaintain=new StrategyController("000002",UserRole.Sales);
		try {
			StrategyPO po1=new StrategyPO("000002", UserRole.Sales, "fuck", "null", 0, null, null, "栖霞区", 0, 0, false);
			assertEquals(ResultMessage.Success,strategymaintain.addStrategy(po1));
			assertEquals(ResultMessage.Failure,strategymaintain.addStrategy(po1));
			po1.setBusinessArea("123456");
			assertEquals(ResultMessage.Success,strategymaintain.modifyStrategy(po1));
			assertEquals(ResultMessage.Success,strategymaintain.removeStrategy(po1));
			assertEquals(ResultMessage.Failure,strategymaintain.removeStrategy(po1));
			strategymaintain=new StrategyController("000001",UserRole.HotelWorker);
			assertEquals(strategymaintain.getStrategy("Double11").getCount(),0.85);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
