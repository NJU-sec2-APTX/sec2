
import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.User_Factory;
import common.otherEnumClasses.ResultMessage;
import common.po.MemberPO;
import junit.framework.TestCase;

public class ManagerRecoverCredit extends TestCase{
	@Before
	public void setUp(){
		new Client();
	}
	
	@Test
	public void testrecharge(){
		try {
			assertEquals(ResultMessage.Failure,User_Factory.getWebsiteManagerController("000000").recoverCredit("000002", -500));
			assertEquals(ResultMessage.Failure,User_Factory.getWebsiteManagerController("000000").recoverCredit("000002", 0));
			assertEquals(ResultMessage.Success,User_Factory.getWebsiteManagerController("000000").recoverCredit("000002", 10000));
			MemberPO po=Client.getMemberDataService().find("000002");
			po.setCredit(po.getCredit()-10000);
			Client.getMemberDataService().update(po);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
