package test;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.userblService.WebsiteManagerMaintainService;
import client.businessLogicServiceImpl.userbl.WebsiteManagerController;
import common.otherEnumClasses.ResultMessage;
import junit.framework.TestCase;

public class ManagerRecoverCredit extends TestCase{
	WebsiteManagerMaintainService managermaintain;
	@Before
	public void setUp(){
		new Client();
	}
	
	@Test
	public void testrecharge(){
		managermaintain=new WebsiteManagerController("000000");
		try {
			assertEquals(ResultMessage.Failure,managermaintain.recoverCredit("000002", -500));
			assertEquals(ResultMessage.Failure,managermaintain.recoverCredit("000002", 0));
			assertEquals(ResultMessage.Success,managermaintain.recoverCredit("000002", 10000));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
