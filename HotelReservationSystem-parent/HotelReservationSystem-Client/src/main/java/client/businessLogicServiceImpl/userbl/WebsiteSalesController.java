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
	public UserVO getUserInfo() throws Exception {
		return u.getUserInf(u.getUserPO().getId(), UserRole.Sales);
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