package client.businessLogicServiceImpl.memberbl;

import client.businessLogicService.memberblService.MemberMaintainService;
import common.otherEnumClasses.MemberList;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.vo.MemberVO;

public class MemberController implements MemberMaintainService{
	private Member m;
	
	public MemberController(String ID,UserRole ur){
		m=new Member(ID,ur);
	}

	public MemberVO getInfo() throws Exception{
		return m.getMemberInfo();
	}
	
	public ResultMessage modifyInfo(MemberVO vo) throws Exception{
		MemberPO po=new MemberPO(vo.getId(),vo.getUserRole());
		po.setBirthday(vo.getBirthday());
		po.setContact(vo.getContact());
		po.setCredit(vo.getCredit());
		po.setName(vo.getName());
		po.setPassword(vo.getPassword());
		return m.modifyMemberInfo(po);
	}
	
	public MemberList getMemberCreditInfo () throws Exception{
		return m.getMemberCreditInfo();
	}
	
	public ResultMessage login(String id,UserRole userrole,String password){
		return m.login(id, userrole, password);
	}
}