package test;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.userblService.WebsiteSalesMaintainService;
import client.businessLogicServiceImpl.userbl.WebsiteSalesController;
import common.otherEnumClasses.ResultMessage;
import junit.framework.TestCase;

public class UserSalesRecharge extends TestCase{
	WebsiteSalesMaintainService salesmaintain;
	
	@Before
	public void setUp(){
		new Client();
	}
	
	@Test
	public void testrecharge(){
		salesmaintain=new WebsiteSalesController("000002");
		try {
			assertEquals(ResultMessage.Success,salesmaintain.recharge("000002",500));
			assertEquals(ResultMessage.Success,salesmaintain.recharge("000002", -500));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
