package client.businessLogicService.memberblService;

import common.otherEnumClasses.ResultMessage;
import common.po.MemberPO;
import common.vo.MemberVO;
import common.otherEnumClasses.MemberList;

public interface MemberMaintainService {

	public MemberVO getInfo () throws Exception;

	public ResultMessage modifyInfo(MemberPO po) throws Exception;
	
	public MemberList getMemberCreditInfo() throws Exception;
}
