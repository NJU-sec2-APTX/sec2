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
	public ResultMessage modifyUserInfo(UserVO vo) throws Exception {
		UserPO po=new UserPO(vo.getId(),vo.getUserRole());
		po.setbelonghotel(vo.getBelongHotel());
		po.setContact(vo.getContact());
		po.setName(vo.getName());
		po.setPassword(vo.getPassword());
		return u.modifyUser(po);
	}
}