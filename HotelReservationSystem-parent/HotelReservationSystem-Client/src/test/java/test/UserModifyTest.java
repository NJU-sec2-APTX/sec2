package test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.userblService.HotelWorkerMaintainService;
import client.businessLogicService.userblService.WebsiteManagerMaintainService;
import client.businessLogicService.userblService.WebsiteSalesMaintainService;
import client.businessLogicServiceImpl.userbl.HotelWorkerController;
import client.businessLogicServiceImpl.userbl.WebsiteManagerController;
import client.businessLogicServiceImpl.userbl.WebsiteSalesController;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.po.UserPO;
import junit.framework.TestCase;

public class UserModifyTest extends TestCase{
	WebsiteSalesMaintainService salesmaintain;
	WebsiteManagerMaintainService managermaintain;
	HotelWorkerMaintainService hotelmaintain;
	
	@Before
	public void setUp(){
		new Client();
	}
	
	@Test
	public void testSalesModify(){
		salesmaintain=new WebsiteSalesController("000002");
		try {
			assertEquals(ResultMessage.Failure,salesmaintain.modifyUserInfo(new UserPO("000001",UserRole.HotelWorker)));
			UserPO po=new UserPO("000002",UserRole.Sales);
			po.setContact("fucka");
			po.setName("叶枫大傻逼");
			po.setPassword("123456");
			assertEquals(ResultMessage.Success,salesmaintain.modifyUserInfo(po));
			po.setContact("fuck");
			po.setName("叶枫");
			assertEquals(ResultMessage.Success,salesmaintain.modifyUserInfo(po));
			UserPO po1=new UserPO("000004",UserRole.Sales);
			UserPO po2=new UserPO("000002",UserRole.HotelWorker);
			assertEquals(ResultMessage.Failure,salesmaintain.modifyUserInfo(po1));
			assertEquals(ResultMessage.Failure,salesmaintain.modifyUserInfo(po2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHotelModify(){
		hotelmaintain=new HotelWorkerController("000001");
		try {
			assertEquals(ResultMessage.Failure,hotelmaintain.modifyUserInfo(new UserPO("000002",UserRole.Sales)));
			UserPO po=new UserPO("000001",UserRole.HotelWorker);
			po.setContact("fuck");
			po.setName("杰克俊逸");
			po.setPassword("123456");
			po.setbelonghotel("隽诚");
			assertEquals(ResultMessage.Success,hotelmaintain.modifyUserInfo(po));
			po.setContact("fuck");
			po.setName("张隽诚");
			po.setPassword("123456789");
			assertEquals(ResultMessage.Success,hotelmaintain.modifyUserInfo(po));
			UserPO po1=new UserPO("000004",UserRole.HotelWorker);
			UserPO po2=new UserPO("000001",UserRole.Sales);
			assertEquals(ResultMessage.Failure,hotelmaintain.modifyUserInfo(po1));
			assertEquals(ResultMessage.Failure,hotelmaintain.modifyUserInfo(po2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testManagerModify(){
		managermaintain=new WebsiteManagerController("000000");
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
			assertEquals(ResultMessage.Success,managermaintain.modifyUserInfo(po));
			po.setContact("fuck");
			po.setName("张隽诚");
			po.setPassword("123456789");
			assertEquals(ResultMessage.Success,managermaintain.modifyUserInfo(po));
			assertEquals(ResultMessage.Failure,managermaintain.modifyMemberInfo("000003", po1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}