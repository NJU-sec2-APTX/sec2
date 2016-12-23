package client.businessLogicService.userblService;

import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.UserPO;
import common.vo.UserVO;

public interface HotelWorkerMaintainService {
	/**
	 * 输入id和UserRole，即可获得一个uservo，如果不存在，则返回null
	 * @param id
	 * @param ur
	 * @return
	 * @throws Exception
	 */
	public UserVO getUserInfo(String id,UserRole ur) throws Exception;
	
	/**
	 * 由于可以拿到一个uservo，于是可以根据这个vo和新的属性构造一个userpo
	 * 返回成功，失败（如果没有改变，返回失败）
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public ResultMessage modifyUserInfo(UserPO po) throws Exception;
}