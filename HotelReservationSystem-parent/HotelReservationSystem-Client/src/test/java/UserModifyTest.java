
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.User_Factory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.po.UserPO;
import common.vo.MemberVO;
import common.vo.UserVO;
import junit.framework.TestCase;

public class UserModifyTest extends TestCase{
	
	@Before
	public void setUp(){
		new Client();
	}
	
	@Test
	public void testSalesModify(){
		try {
			UserPO temp=new UserPO("000001",UserRole.HotelWorker);
			assertEquals(ResultMessage.Failure,User_Factory.getWebsiteSalesController("000002").modifyUserInfo(new UserVO(temp)));
			UserPO po=new UserPO("000002",UserRole.Sales);
			po.setContact("fucka");
			po.setName("叶枫大傻逼");
			po.setPassword("123456");
			assertEquals(ResultMessage.Success,User_Factory.getWebsiteSalesController("000002").modifyUserInfo(new UserVO(po)));
			po.setContact("fuck");
			po.setName("叶枫");
			po.setPassword("123456789");
			assertEquals(ResultMessage.Success,User_Factory.getWebsiteSalesController("000002").modifyUserInfo(new UserVO(po)));
			UserPO po1=new UserPO("000004",UserRole.Sales);
			UserPO po2=new UserPO("000002",UserRole.HotelWorker);
			assertEquals(ResultMessage.Failure,User_Factory.getWebsiteSalesController("000002").modifyUserInfo(new UserVO(po1)));
			assertEquals(ResultMessage.Failure,User_Factory.getWebsiteSalesController("000002").modifyUserInfo(new UserVO(po2)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHotelModify(){
		try {
			UserPO temp=new UserPO("000002",UserRole.Sales);
			assertEquals(ResultMessage.Failure,User_Factory.getHotelWorkerController("000001").modifyUserInfo(new UserVO(temp)));
			UserPO po=new UserPO("000001",UserRole.HotelWorker);
			po.setContact("fuck");
			po.setName("杰克俊逸");
			po.setPassword("123456");
			po.setbelonghotel("隽诚");
			assertEquals(ResultMessage.Success,User_Factory.getHotelWorkerController("000001").modifyUserInfo(new UserVO(po)));
			po.setContact("fuck");
			po.setName("张隽诚");
			po.setPassword("123456789");
			assertEquals(ResultMessage.Success,User_Factory.getHotelWorkerController("000001").modifyUserInfo(new UserVO(po)));
			UserPO po1=new UserPO("000004",UserRole.HotelWorker);
			UserPO po2=new UserPO("000001",UserRole.Sales);
			assertEquals(ResultMessage.Failure,User_Factory.getHotelWorkerController("000001").modifyUserInfo(new UserVO(po1)));
			assertEquals(ResultMessage.Failure,User_Factory.getHotelWorkerController("000001").modifyUserInfo(new UserVO(po2)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testManagerModify(){
		try {
			MemberPO po1=new MemberPO("000003",UserRole.Member);
			po1.setBirthday(new Date(1996-1900,9-1,7));
			po1.setContact("红色鲱鱼");
			po1.setCredit(5000);
			po1.setName("杨子航");
			po1.setPassword("fuckyou");
			UserPO po=new UserPO("000001",UserRole.HotelWorker);
			po.setContact("fuck");
			po.setName("杰克俊逸");
			po.setPassword("123456");
			assertEquals(ResultMessage.Success,User_Factory.getWebsiteManagerController("000000").modifyUserInfo(new UserVO(po)));
			po.setContact("fuck");
			po.setName("张隽诚");
			po.setPassword("123456789");
			assertEquals(ResultMessage.Success,User_Factory.getWebsiteManagerController("000000").modifyUserInfo(new UserVO(po)));
			assertEquals(ResultMessage.Failure,User_Factory.getWebsiteManagerController("000000").modifyMemberInfo("000003", new MemberVO(po1)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}