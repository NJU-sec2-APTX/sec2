package client.businessLogicServiceImpl.userbl;

import client.businessLogicService.userblService.HotelWorkerMaintainService;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.UserPO;
import common.vo.UserVO;

public class HotelWorkerController implements HotelWorkerMaintainService{

	private User u;
	
	public HotelWorkerController(String id){
		u=new User(id,UserRole.HotelWorker);
	}
	
	@Override
	public UserVO getUserInfo(String id, UserRole ur) throws Exception {
		return u.getUserInf(id, ur);
	}

	@Override
	public ResultMessage modifyUserInfo(UserPO po) throws Exception {
		return u.modifyUser(po);
	}
}