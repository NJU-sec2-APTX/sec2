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

public class UserManagerAddTest extends TestCase{
	WebsiteManagerMaintainService managermaintain;
	
	@Before
	public void setUp(){
		new Client();
	}
	
	@Test
	public void testadd(){
		managermaintain=new WebsiteManagerController("000001");
		try {
			assertEquals(ResultMessage.Failure,managermaintain.addUser(new UserPO("000004",UserRole.HotelWorker)));
			managermaintain=new WebsiteManagerController("000000");
			UserPO po=new UserPO("000004",UserRole.Sales);
			po.setContact("hhhh");
			po.setName("杨子脏");
			po.setPassword("干死扬子脏");
			assertEquals(ResultMessage.Success,managermaintain.addUser(po));
			assertEquals(ResultMessage.Registered,managermaintain.addUser(po));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
