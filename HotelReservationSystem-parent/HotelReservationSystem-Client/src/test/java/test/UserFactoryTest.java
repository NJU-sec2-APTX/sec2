package test;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.userblService.UserIFactory;
import client.businessLogicServiceImpl.userbl.UserFactory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.po.UserPO;
import junit.framework.TestCase;

public class UserFactoryTest extends TestCase{
	UserIFactory factory;
	MemberPO member1,member2;
	UserPO user1,user2;
	
	@Before
	public void setUp(){
		member1=new MemberPO("000001",UserRole.Enterprise);
		member1.setPassword("123456");
		member1.setContact("151250183@smail.nju.edu.cn");
		member1.setCredit(20000);
		member1.setLevel(5);
		member1.setName("苏宁");
		member2=new MemberPO("000002",UserRole.Member);
		member2.setPassword("jubaoriben");
		user1=new UserPO("000000",UserRole.Manager);
		user1.setPassword("default");
		user2=new UserPO("000001",UserRole.Sales);
		user2.setPassword("123456789");
		factory=new UserFactory();
		new Client();
	}
	
	//因为不能按顺序执行，所以登出和登录放一起了，结果全过
	@Test
	public void testloginandlogout(){
		//测试登录，包括全部正确，登录成功；密码不对，登录错误；重复登录，登录错误
		assertEquals(ResultMessage.Success,factory.login(member1.getId(), member1.getUserRole(), member1.getPassword()));
		assertEquals(ResultMessage.Failure,factory.login(member2.getId(), member2.getUserRole(), member2.getPassword()));
		assertEquals(ResultMessage.Logged,factory.login(member1.getId(), member1.getUserRole(), member1.getPassword()));
		
		//测试登录，包括全部正确，登录成功；身份不对，登录错误；重复登录，登录错误
		assertEquals(ResultMessage.Success,factory.login(user1.getId(), user1.getUserRole(), user1.getPassword()));
		assertEquals(ResultMessage.Failure,factory.login(user2.getId(), user2.getUserRole(), user2.getPassword()));
		assertEquals(ResultMessage.Logged,factory.login(user1.getId(), user1.getUserRole(), user1.getPassword()));
		
		//测试登出，包括已经登录，则登出成功；账户未登录，登出错误；
		assertEquals(ResultMessage.Success,factory.logout(member1.getId(), member1.getUserRole()));
		assertEquals(ResultMessage.Failure,factory.logout(user2.getId(), user2.getUserRole()));
		assertEquals(ResultMessage.Failure,factory.logout(user2.getId(), user2.getUserRole()));
		assertEquals(ResultMessage.Success,factory.logout(user1.getId(), user1.getUserRole()));
	}
	
	@Test
	public void testregister(){
		//测试注册，已经存在，注册失败
		assertEquals(ResultMessage.Registered,factory.register(member1.getId(), member1));
	}
}
