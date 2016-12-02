package client.businessLogicServiceImpl.memberbl;

import client.businessLogicService.memberblService.MemberMaintainService;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.vo.MemberVO;
import common.otherEnumClasses.MemberList;

public class MemberController implements MemberMaintainService{
	private Member m;
	
	public MemberController(String ID,UserRole ur){
		m=new Member(ID,ur);
	}
	
	public MemberVO getInfo() throws Exception{
		return m.getMemberInfo();
	}
	
	public ResultMessage modifyInfo(MemberPO po) throws Exception{
		return m.modifyMemberInfo(po);
	}
	
	public MemberList getMemberCreditInfo () throws Exception{
		return m.getMemberCreditInfo();
	}
	
	public ResultMessage login(String id,UserRole userrole,String password){
		return m.login(id, userrole, password);
	}
}