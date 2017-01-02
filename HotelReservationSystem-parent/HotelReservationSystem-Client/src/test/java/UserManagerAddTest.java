
import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.User_Factory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.UserPO;
import common.vo.UserVO;
import junit.framework.TestCase;

public class UserManagerAddTest extends TestCase{
	
	@Before
	public void setUp(){
		new Client();
	}
	
	@Test
	public void testadd(){
		try {
			UserPO po=new UserPO("000004",UserRole.HotelWorker);
			assertEquals(ResultMessage.Failure,User_Factory.getWebsiteManagerController("000001").addUser(new UserVO(po)));
			UserPO po1=new UserPO("000004",UserRole.Sales);
			po1.setContact("hhhh");
			po1.setName("杨子脏");
			po1.setPassword("干死扬子脏");
			assertEquals(ResultMessage.Success,User_Factory.getWebsiteManagerController("000000").addUser(new UserVO(po1)));
			assertEquals(ResultMessage.Registered,User_Factory.getWebsiteManagerController("000000").addUser(new UserVO(po1)));
			assertEquals(ResultMessage.Success,User_Factory.getWebsiteManagerController("000000").removeUser("000004",UserRole.Sales));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
