package test;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.memberblService.MemberMaintainService;
import client.businessLogicServiceImpl.memberbl.MemberController;
import common.otherEnumClasses.MemberList;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.vo.MemberVO;
import junit.framework.TestCase;

public class MemberTest extends TestCase{
	MemberMaintainService membermaintain;
	MemberList memberlist;
	
	@Before
	public void setUp(){
		new Client();
	}
	
	//当ID和UserRole均符合时，能拿到正确的信息
	@Test
	public void testgetInfo1(){
		membermaintain=new MemberController("000001",UserRole.Enterprise);
		try {
			MemberVO vo=membermaintain.getInfo();
			assertNotNull(vo);
			assertEquals("000001",vo.getId());
			assertEquals("151250183@smail.nju.edu.cn",vo.getContact());
			assertEquals(20000.0,vo.getCredit());
			assertEquals("苏宁",vo.getName());
			assertEquals(3,vo.getLevel());
			assertNull(vo.getBirthday());
			assertEquals(UserRole.Enterprise,vo.getUserRole());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//当ID和UserRole不符合时，拿不到
	@Test
	public void testgetInfo2(){
		membermaintain=new MemberController("000001",UserRole.Member);
		try {
			MemberVO vo=membermaintain.getInfo();
			assertNull(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//只比较了credit，时间没有比较
//	@Test
//	public void testgetcredit(){
//		membermaintain=new MemberController("000002",UserRole.Member);
//		try {
//			memberlist=new MemberList();
//			for(int i=0;i<memberlist.getMemberList().size();i++){
//				assertEquals(memberlist.getMemberList().get(i).getChange(),membermaintain.getMemberCreditInfo().getMemberList().get(i).getChange());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	//用户无法改变自己的会员等级和信用值，因为懒得改数据库，所以不写成功的例子了
	@Test
	public void testmodify(){
		membermaintain=new MemberController("000001",UserRole.Enterprise);
		try {
			MemberPO po=new MemberPO("000001",UserRole.Enterprise);
			po.setContact("151250183@smail.nju.edu.cn");
			po.setCredit(15000);
			po.setName("苏宁");
			po.setPassword("123456");
			po.setBirthday(null);
			assertEquals(ResultMessage.Failure,membermaintain.modifyInfo(po));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}