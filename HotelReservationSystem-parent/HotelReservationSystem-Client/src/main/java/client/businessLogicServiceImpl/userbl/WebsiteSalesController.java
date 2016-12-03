package client.businessLogicServiceImpl.userbl;

import client.businessLogicService.userblService.WebsiteSalesMaintainService;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.UserPO;
import common.vo.UserVO;

public class WebsiteSalesController implements WebsiteSalesMaintainService{
	
	private User u;
	
	public WebsiteSalesController(String id){
		u=new User(id,UserRole.Sales);
	}
	
	@Override
	public ResultMessage recharge(String id, double money) throws Exception {
		return u.recharge(id, money);
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