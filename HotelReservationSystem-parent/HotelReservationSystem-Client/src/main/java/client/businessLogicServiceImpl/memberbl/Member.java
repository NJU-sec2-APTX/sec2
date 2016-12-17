package client.businessLogicServiceImpl.memberbl;

import java.rmi.RemoteException;

import client.Client;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.vo.MemberVO;
import common.otherEnumClasses.MemberList;

public class Member{
	private MemberList memberlist;
	private MemberPO memberpo;

	public Member(String id,UserRole ur){
		memberpo=new MemberPO(id,ur);
	}
	
	public ResultMessage register(String id,MemberPO po){
		try {
			if(Client.getMemberDataService().find(id)==null){
				return Client.getMemberDataService().insert(po);
			}else{
				return ResultMessage.Registered;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage logout(String id,UserRole ur){
		try {
			return Client.getMemberDataService().checkoutmember(id, ur);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage login(String id,UserRole ur,String password){
		try {
			return Client.getMemberDataService().checkinmember(id, ur, password);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	/**
	 * 输入member的ID，比对是否和初始化的ID相同，并且查找是否有该ID
	 * 如果找到，则将member对象的memberpo替换成数据库中找到的，并且返回一个membervo
	 * 否则返回空
	 * @param ID
	 * @return
	 * @throws Exception
	 */
	public MemberVO getMemberInfo() throws Exception{
		if(Client.getMemberDataService().find(memberpo.getId())==null){
			return null;
		}else{
			if(memberpo.getUserRole()!=Client.getMemberDataService().find(memberpo.getId()).getUserRole()){
				return null;
			}
			memberpo=Client.getMemberDataService().find(memberpo.getId());
			return new MemberVO(memberpo);
		}
	}
	
	/**
	 * 输入member的ID，如果此ID对应的用户不存在，或者此PO和初始化的PO的ID不同，则返回错误
	 * 如果数据库中的po和此po一样，则无需修改
	 * 否则，则将新的po赋值给member持有的po，并更新数据库中的po
	 * @param ID
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public ResultMessage modifyMemberInfo(MemberPO po) throws Exception{
		if(Client.getMemberDataService().find(memberpo.getId())==null||(!memberpo.getId().equals(memberpo.getId()))){
			return ResultMessage.Failure;
		}else{
			MemberPO temp=Client.getMemberDataService().find(memberpo.getId());
			if(temp.getCredit()!=po.getCredit()||temp.getLevel()!=po.getLevel()){
				return ResultMessage.Failure;
			}else if(temp.getName().equals(po.getName())
					&&temp.getPassword().equals(po.getPassword())
					&&temp.getBirthday().equals(po.getBirthday())
					&&temp.getContact().equals(po.getContact())){
				return ResultMessage.Failure;
			}else if(po.getUserRole()!=memberpo.getUserRole()){
				return ResultMessage.Failure;
			}else {
				if(Client.getMemberDataService().update(po)==ResultMessage.Success){
					memberpo=Client.getMemberDataService().find(memberpo.getId());
					return ResultMessage.Success;
				}else{
					return ResultMessage.Failure;
				}
			}  
		}
	}
	
	/**
	 * 输入member的ID，返回其信用变换记录
	 * @param ID
	 * @return
	 * @throws Exception
	 */
	public MemberList getMemberCreditInfo () throws Exception{
		if(Client.getMemberDataService().find(memberpo.getId())==null){
			return null;
		}else{
			memberpo=Client.getMemberDataService().find(memberpo.getId());
			memberlist=memberpo.getCreditList();
			return memberlist;
		}
	}
}