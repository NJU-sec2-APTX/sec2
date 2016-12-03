package test;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.userblService.HotelWorkerMaintainService;
import client.businessLogicService.userblService.WebsiteManagerMaintainService;
import client.businessLogicService.userblService.WebsiteSalesMaintainService;
import client.businessLogicServiceImpl.userbl.HotelWorkerController;
import client.businessLogicServiceImpl.userbl.WebsiteManagerController;
import client.businessLogicServiceImpl.userbl.WebsiteSalesController;
import common.otherEnumClasses.UserRole;
import common.vo.MemberVO;
import common.vo.UserVO;
import junit.framework.TestCase;

public class UserGetInfoTest extends TestCase{
	WebsiteSalesMaintainService salesmaintain;
	WebsiteManagerMaintainService managermaintain;
	HotelWorkerMaintainService hotelmaintain;
	
	@Before
	public void setUp(){
		new Client();
	}
	
	@Test
	public void testSalesgetInfo(){
		salesmaintain=new WebsiteSalesController("000002");
		try {
			assertNull(salesmaintain.getUserInfo("000000",UserRole.Manager));
			assertNotNull(salesmaintain.getUserInfo("000002", UserRole.Sales));
			assertEquals(salesmaintain.getUserInfo("000002", UserRole.Sales).getContact(),"fuck");
			assertEquals(salesmaintain.getUserInfo("000002", UserRole.Sales).getName(),"叶枫");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHotelWorkergetInfo(){
		hotelmaintain=new HotelWorkerController("000001");
		try {
			assertNull(hotelmaintain.getUserInfo("000002", UserRole.Sales));
			assertNotNull(hotelmaintain.getUserInfo("000001", UserRole.HotelWorker));
			assertEquals(hotelmaintain.getUserInfo("000001", UserRole.HotelWorker).getBelongHotel(),"隽诚");
			assertEquals(hotelmaintain.getUserInfo("000001", UserRole.HotelWorker).getContact(),"fuck");
			assertEquals(hotelmaintain.getUserInfo("000001", UserRole.HotelWorker).getName(),"张隽诚");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testmanagergetInfo(){
		managermaintain=new WebsiteManagerController("000000");
		try {
			MemberVO vo=managermaintain.getMemberInfo("000001",UserRole.Enterprise);
			assertNotNull(vo);
			assertEquals(vo.getCredit(),20000.0);
			assertEquals(vo.getLevel(),5);
			assertEquals(vo.getName(),"苏宁");
			assertEquals(vo.getBirthday(),null);
			UserVO vo1=managermaintain.getUserInfo("000002",UserRole.Sales);
			assertNotNull(vo1);
			assertEquals(vo1.getContact(),"fuck");
			assertEquals(vo1.getName(),"叶枫");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
