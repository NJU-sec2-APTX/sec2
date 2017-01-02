
import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.User_Factory;
import common.otherEnumClasses.ResultMessage;
import junit.framework.TestCase;

public class UserSalesRecharge extends TestCase{
	
	@Before
	public void setUp(){
		new Client();
	}
	
	@Test
	public void testrecharge(){
		try {
			assertEquals(ResultMessage.Success,User_Factory.getWebsiteSalesController("000002").recharge("000002",500));
			assertEquals(ResultMessage.Success,User_Factory.getWebsiteSalesController("000002").recharge("000002", -500));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
