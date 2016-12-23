package client.businessLogicService.memberblService;

import common.otherEnumClasses.ResultMessage;
import common.po.MemberPO;
import common.vo.MemberVO;
import common.otherEnumClasses.MemberList;

public interface MemberMaintainService {
	/**
	 * 获得自己的membervo
	 * 如果为null，则不存在（理论上不可能）
	 * @return
	 * @throws Exception
	 */
	public MemberVO getInfo () throws Exception;

	/**
	 * 由于可以获得membervo，根据vo和修改的值构造一个po
	 * 返回成功或失败（credit，id，UserRole不可改变，如果改变返回失败）
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public ResultMessage modifyInfo(MemberPO po) throws Exception;
	
	/**
	 * 返回一个memberlist，其中memberlist里面有个ArrayList，里面装的是memberitem
	 * memberitem属性为改变日期，改变的信用值，改变后客户的信用值，引起变化的订单id（如果操作是充值，为null），引起变化的操作
	 * @return
	 * @throws Exception
	 */
	public MemberList getMemberCreditInfo() throws Exception;
}
