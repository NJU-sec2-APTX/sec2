package client.businessLogicService;

import client.businessLogicService.memberblService.MemberMaintainService;
import client.businessLogicServiceImpl.memberbl.MemberController;
import common.otherEnumClasses.UserRole;

public class MemberFactory {
	public static MemberMaintainService getMemberMaintainService(String id,UserRole ur){
		return new MemberController(id,ur);
	}
}
