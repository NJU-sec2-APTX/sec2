package client.businessLogicService.userblService;

import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.vo.MemberVO;

public interface UserIFactory {
	/**
	 * 传入id，UserRole和password
	 * 返回值有成功，失败，已经登录
	 * @param id
	 * @param ur
	 * @param password
	 * @return
	 */
	public ResultMessage login(String id,UserRole ur,String password);
	
	/**
	 * 传入一个ID和MemberPO来注册member
	 * 返回值有成功，失败
	 * @param id
	 * @param po
	 * @return
	 */
	public ResultMessage register(String id,MemberVO vo);
	
	/**
	 * 传入id和UserRole用来登出，记得关闭窗口要登出
	 * 返回值有成功，失败（表示用户未登录）
	 * @param id
	 * @param ur
	 * @return
	 */
	public ResultMessage logout(String id,UserRole ur);
}