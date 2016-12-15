package test;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.userblService.WebsiteManagerMaintainService;
import client.businessLogicServiceImpl.userbl.WebsiteManagerController;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.UserPO;
import junit.framework.TestCase;

public class UserManagerDeleteTest extends TestCase{
	WebsiteManagerMaintainService managermaintain;
	@Before
	public void setUp(){
		new Client();
	}
	
	@Test
	public void testDelete(){
		managermaintain=new WebsiteManagerController("000001");
		try {
			assertEquals(ResultMessage.Failure,managermaintain.removeUser("000001", UserRole.Sales));
			managermaintain=new WebsiteManagerController("000000");
			assertEquals(ResultMessage.Failure,managermaintain.removeUser("000001", UserRole.Sales));
			assertEquals(ResultMessage.Failure,managermaintain.removeUser("000000",UserRole.Manager));
			assertEquals(ResultMessage.Success,managermaintain.removeUser("000001", UserRole.HotelWorker));
			UserPO po=new UserPO("000001",UserRole.HotelWorker);
			po.setbelonghotel("隽诚");
			po.setContact("fuck");
			po.setName("张隽诚");
			po.setPassword("123456789");
			Client.getUserDataService().insert(po);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}