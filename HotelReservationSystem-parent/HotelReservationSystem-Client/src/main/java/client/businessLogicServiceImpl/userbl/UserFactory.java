package client.businessLogicServiceImpl.userbl;

import client.businessLogicService.userblService.UserIFactory;
import client.businessLogicServiceImpl.memberbl.Member;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.vo.MemberVO;

public class UserFactory implements UserIFactory{

	@Override
	public ResultMessage login(String id, UserRole ur, String password) {
		if(ur==UserRole.Manager||ur==UserRole.Sales||ur==UserRole.HotelWorker){
			User u=new User(id,ur);
			return u.login(id, ur, password);
		}else{
			Member m=new Member(id,ur);
			return m.login(id, ur, password);
		}
	}

	@Override
	public ResultMessage register(String id, MemberVO vo) {
		Member m=new Member(id,vo.getUserRole());
		MemberPO po=new MemberPO(vo.getId(),vo.getUserRole());
		po.setBirthday(vo.getBirthday());
		po.setCredit(vo.getCredit());
		po.setContact(vo.getContact());
		po.setName(vo.getName());
		po.setPassword(vo.getPassword());
		return m.register(id,po);
	}

	@Override
	public ResultMessage logout(String id, UserRole ur) {
		if(ur==UserRole.Manager||ur==UserRole.Sales||ur==UserRole.HotelWorker){
			User u=new User(id,ur);
			return u.logout(id,ur);
		}else{
			Member m=new Member(id,ur);
			return m.logout(id,ur);
		}
	}
	
	
}
