package client.businessLogicServiceImpl.userbl;

import client.businessLogicService.userblService.WebsiteManagerMaintainService;
import client.businessLogicServiceImpl.memberbl.Member;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.po.UserPO;
import common.vo.MemberVO;
import common.vo.UserVO;

public class WebsiteManagerController implements WebsiteManagerMaintainService{
	
	private Member m;
	private User u;
	
	public WebsiteManagerController(String id){
		u=new User(id,UserRole.Manager);
	}

	@Override
	public UserVO getUserInfo(String id, UserRole ur) throws Exception {
		return u.getUserInf(id, ur);
	}

	@Override
	public MemberVO getMemberInfo(String id, UserRole ur) throws Exception {
		m=new Member(id,ur);
		return m.getMemberInfo();
	}

	@Override
	public ResultMessage modifyUserInfo(UserVO vo) throws Exception {
		UserPO po=new UserPO(vo.getId(),vo.getUserRole());
		po.setbelonghotel(vo.getBelongHotel());
		po.setContact(vo.getContact());
		po.setName(vo.getName());
		po.setPassword(vo.getPassword());
		return u.modifyUser(po);
	}

	@Override
	public ResultMessage modifyMemberInfo(String id, MemberVO vo) throws Exception {
		m=new Member(id,vo.getUserRole());
		MemberPO po=new MemberPO(vo.getId(),vo.getUserRole());
		po.setBirthday(vo.getBirthday());
		po.setContact(vo.getContact());
		po.setCredit(vo.getCredit());
		po.setName(vo.getName());
		po.setPassword(vo.getPassword());
		return m.modifyMemberInfo(po);
	}

	@Override
	public ResultMessage addUser(UserVO vo) throws Exception {
		UserPO po=new UserPO(vo.getId(),vo.getUserRole());
		po.setbelonghotel(vo.getBelongHotel());
		po.setContact(vo.getContact());
		po.setName(vo.getName());
		po.setPassword(vo.getPassword());
		return u.addUser(po);
	}

	@Override
	public ResultMessage recoverCredit(String id,double credit) throws Exception {
		if(credit<=0){
			return ResultMessage.Failure;
		}else{
			return u.recharge(id, credit/100);
		}
	}
	
	@Override
	public ResultMessage removeUser(String id, UserRole ur) throws Exception {
		return u.removeUser(id, ur);
	}
}
