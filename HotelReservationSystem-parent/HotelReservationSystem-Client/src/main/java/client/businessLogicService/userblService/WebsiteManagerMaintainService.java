package client.businessLogicService.userblService;

import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.vo.MemberVO;
import common.vo.UserVO;

public interface WebsiteManagerMaintainService {
	/**
	 * 传入id和UserRole，即可查看user的信息
	 * 返回有失败或成功
	 * @param id
	 * @param ur
	 * @return
	 * @throws Exception
	 */
	public UserVO getUserInfo(String id,UserRole ur) throws Exception;
	
	/**
	 * 传入id和UserRole，即可查看member信息
	 * 返回有成功或失败
	 * @param id
	 * @param ur
	 * @return
	 * @throws Exception
	 */
	public MemberVO getMemberInfo(String id,UserRole ur) throws Exception;
	
	/**
	 * 由于可以得到uservo，根据vo和修改的信息可以构造一个po传入
	 * 返回有成功和失败（如果没有改变，则返回失败）
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public ResultMessage modifyUserInfo(UserVO vo) throws Exception;
	
	/**
	 * 由于可以得到membervo，根据vo和修改的信息可以构造一个po传入，同样，这里不能改变信用值
	 * 返回有成功和失败（如果没有改变，则返回失败）
	 * @param id
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public ResultMessage modifyMemberInfo(String id,MemberVO vo) throws Exception;
	
	/**
	 * 传入一个userpo，可以新增一个user
	 * 返回成功或失败（表示已经存在）
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public ResultMessage addUser(UserVO vo) throws Exception;
	
	/**
	 * 传入id和恢复的信用值
	 * 由界面层选择一半或者全部（传入credit/2或者credit）
	 * 返回失败（传入的credit<=0,）或成功
	 * @param id
	 * @param credit
	 * @return
	 * @throws Exception
	 */
	public ResultMessage recoverCredit(String id,double credit) throws Exception;
	
	/**
	 * 传入id和UserRole，删除user
	 * 返回成功或失败（不存在）
	 * @param id
	 * @param ur
	 * @return
	 * @throws Exception
	 */
	public ResultMessage removeUser(String id,UserRole ur) throws Exception;
}
