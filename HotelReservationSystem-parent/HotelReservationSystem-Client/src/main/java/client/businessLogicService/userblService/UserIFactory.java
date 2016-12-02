package client.businessLogicService.userblService;

import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;

public interface UserIFactory {
	public ResultMessage login(String id,UserRole ur,String password);
	
	public ResultMessage register(String id,MemberPO po);
	
	public ResultMessage logout(String id,UserRole ur);
}