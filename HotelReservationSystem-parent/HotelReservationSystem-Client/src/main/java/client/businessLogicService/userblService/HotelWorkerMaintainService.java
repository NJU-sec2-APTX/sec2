package client.businessLogicService.userblService;

import common.otherEnumClasses.ResultMessage;
import common.vo.UserVO;

public interface HotelWorkerMaintainService {
	/**
	 * 获得一个uservo，如果不存在，则返回null
	 * @param id
	 * @param ur
	 * @return
	 * @throws Exception
	 */
	public UserVO getUserInfo() throws Exception;
	
	/**
	 * 由于可以拿到一个uservo，于是可以根据这个vo和新的属性构造一个userpo
	 * 返回成功，失败（如果没有改变，返回失败）
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public ResultMessage modifyUserInfo(UserVO vo) throws Exception;
}