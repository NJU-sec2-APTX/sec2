
import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.User_Factory;
import common.otherEnumClasses.UserRole;
import common.vo.MemberVO;
import common.vo.UserVO;
import junit.framework.TestCase;

public class UserGetInfoTest extends TestCase{
	
	@Before
	public void setUp(){
		new Client();
	}
	
	@Test
	public void testSalesgetInfo(){
		try {
			assertNotNull(User_Factory.getWebsiteSalesController("000002"));
			assertNull(User_Factory.getWebsiteSalesController("000001").getUserInfo());
			assertEquals(User_Factory.getWebsiteSalesController("000002").getUserInfo().getPassword(),"123456789");
			assertEquals(User_Factory.getWebsiteSalesController("000002").getUserInfo().getContact(),"fuck");
			assertEquals(User_Factory.getWebsiteSalesController("000002").getUserInfo().getName(),"叶枫");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHotelWorkergetInfo(){
		try {
			assertNotNull(User_Factory.getHotelWorkerController("000001"));
			assertNull(User_Factory.getHotelWorkerController("000002").getUserInfo());
			assertEquals(User_Factory.getHotelWorkerController("000001").getUserInfo().getBelongHotel(),"隽诚");
			assertEquals(User_Factory.getHotelWorkerController("000001").getUserInfo().getContact(),"fuck");
			assertEquals(User_Factory.getHotelWorkerController("000001").getUserInfo().getName(),"张隽诚");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testmanagergetInfo(){
		try {
			MemberVO vo=User_Factory.getWebsiteManagerController("000000").getMemberInfo("000001",UserRole.Enterprise);
			assertNotNull(vo);
			assertEquals(vo.getCredit(),20000.0);
			assertEquals(vo.getLevel(),3);
			assertEquals(vo.getName(),"苏宁");
			assertEquals(vo.getBirthday(),null);
			UserVO vo1=User_Factory.getWebsiteManagerController("000000").getUserInfo("000002",UserRole.Sales);
			assertNotNull(vo1);
			assertEquals(vo1.getContact(),"fuck");
			assertEquals(vo1.getName(),"叶枫");
			UserVO vo2=User_Factory.getWebsiteManagerController("000000").getUserInfo("000001",UserRole.Sales);
			assertNull(vo2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
