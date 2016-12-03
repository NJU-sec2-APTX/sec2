package client.businessLogicService.userblService;

import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.UserPO;
import common.vo.UserVO;

public interface HotelWorkerMaintainService {
	public UserVO getUserInfo(String id,UserRole ur) throws Exception;
	
	public ResultMessage modifyUserInfo(UserPO po) throws Exception;
}