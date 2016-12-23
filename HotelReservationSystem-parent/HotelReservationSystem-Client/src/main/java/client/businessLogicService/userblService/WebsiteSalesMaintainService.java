package client.businessLogicService.userblService;

import common.otherEnumClasses.ResultMessage;
import common.vo.UserVO;

public interface WebsiteSalesMaintainService {
	/**
	 * 传入id和money
	 * 返回成功或失败
	 * @param id
	 * @param money
	 * @return
	 * @throws Exception
	 */
	public ResultMessage recharge(String id,double money) throws Exception;
	
	/**
	 * 输入id和UserRole，即可获得用户信息
	 * 返回一个uservo，如果不存在就是null
	 * @param id
	 * @param ur
	 * @return
	 * @throws Exception
	 */
	public UserVO getUserInfo() throws Exception;
	
	/**
	 * 由于可以得到uservo，根据vo和修改的值构造一个po传入
	 * 返回成功或失败（id，UserRole不可改变）
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public ResultMessage modifyUserInfo(UserVO vo) throws Exception;
	
}
