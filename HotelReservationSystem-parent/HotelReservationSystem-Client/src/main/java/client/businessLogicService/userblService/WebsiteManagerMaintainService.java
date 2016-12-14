package client.businessLogicService.userblService;

import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.po.UserPO;
import common.vo.MemberVO;
import common.vo.UserVO;

public interface WebsiteManagerMaintainService {
	
	public UserVO getUserInfo(String id,UserRole ur) throws Exception;
	
	public MemberVO getMemberInfo(String id,UserRole ur) throws Exception;
	
	public ResultMessage modifyUserInfo(UserPO po) throws Exception;
	
	public ResultMessage modifyMemberInfo(String id,MemberPO po) throws Exception;
	
	public ResultMessage addUser(UserPO po) throws Exception;
	
	public ResultMessage recoverCredit(String id,double credit) throws Exception;
}
