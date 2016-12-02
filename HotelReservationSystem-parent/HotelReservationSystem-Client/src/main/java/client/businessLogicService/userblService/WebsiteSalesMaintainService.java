package client.businessLogicService.userblService;

import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.UserPO;
import common.vo.UserVO;

public interface WebsiteSalesMaintainService {
	public ResultMessage recharge(String id,double money) throws Exception;
	
	public UserVO getUserInfo(String id,UserRole ur) throws Exception;
	
	public ResultMessage modifyUserInfo(String id,UserPO po) throws Exception;
}
