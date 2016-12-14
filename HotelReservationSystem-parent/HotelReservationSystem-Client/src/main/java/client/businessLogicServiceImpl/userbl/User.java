package client.businessLogicServiceImpl.userbl;

import java.rmi.RemoteException;

import client.Client;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.po.UserPO;
import common.vo.UserVO;

public class User {
	//如果是member，则委托给member模块
	//如果是hotel，则委托给hotel模块
	//如果是websales，则其依赖某些模块来完成自己的职责
	//如果是webmanager，则其依赖某些模块来完成自己的职责
	private UserPO userpo;
	
	public User(String id,UserRole ur){
		userpo=new UserPO(id,ur);
	}
	
	public UserPO getUserPO(){
		return userpo;
	}
	
	public ResultMessage logout(String id,UserRole ur){
		try {
			return Client.getUserDataService().checkoutuser(id, ur);
		} catch (RemoteException e) {
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage login(String id,UserRole ur,String password){
		try {
			return Client.getUserDataService().checkinuser(id, ur, password);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage recharge(String id,double money){
		if(userpo.getUserRole()==UserRole.Sales||userpo.getUserRole()==UserRole.Manager){
			MemberPO po;
			try {
				if(Client.getUserDataService().find(userpo.getId(),userpo.getUserRole())!=null){
					po = Client.getMemberDataService().find(id);
					if(po==null){
						return ResultMessage.Failure;
					}else{
						po.setCredit(po.getCredit()+money*100);
						return Client.getUserDataService().updatecredit(id, money);
					}
				}else{
					return ResultMessage.Failure;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return ResultMessage.Failure;
			}
		}else{
			return ResultMessage.Failure;
		}
	}
	
	/**
	 * 只有manager有权利查看所有的user，否则对应的人只能查看自己的资料
	 * @param id
	 * @param ur
	 * @return
	 */
	public UserVO getUserInf(String id,UserRole ur){
		try {
			if(Client.getUserDataService().find(userpo.getId(), userpo.getUserRole())!=null){
				if(userpo.getUserRole()==UserRole.Manager||
						(userpo.getUserRole()==UserRole.HotelWorker&&ur==UserRole.HotelWorker)||
						(userpo.getUserRole()==UserRole.Sales&&ur==UserRole.Sales)){
					UserPO po=Client.getUserDataService().find(id, ur);
					return new UserVO(po);
				}else{
					return null;
				}
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * manager可以更改营销人员，酒店工作人员信息和用户信息
	 * @param ID
	 * @param po
	 * @return
	 */
	
	public ResultMessage modifyUser(UserPO po){
		if((userpo.getUserRole()==UserRole.Manager&&po.getUserRole()!=UserRole.Manager||
				(userpo.getUserRole()==UserRole.HotelWorker&&po.getUserRole()==UserRole.HotelWorker))||
				(userpo.getUserRole()==UserRole.Sales&&po.getUserRole()==UserRole.Sales)){
			try {
				if(Client.getUserDataService().find(userpo.getId(), userpo.getUserRole())!=null){
					if(Client.getUserDataService().find(po.getId(), po.getUserRole())==null){
						return ResultMessage.Failure;
					}else{
						UserPO temp=Client.getUserDataService().find(po.getId(), po.getUserRole());
						if(temp.getName().equals(po.getName())&&temp.getPassword().equals(po.getPassword())
								&&temp.getContact().equals(po.getContact())&&temp.getHotel().equals(po.getHotel())){
							return ResultMessage.Failure;
						}else{
							if(Client.getUserDataService().update(po)==ResultMessage.Success){
								userpo=po;
								return ResultMessage.Success;
							}else{
								return ResultMessage.Failure;
							}
						}
					}
				}else{
					return ResultMessage.Failure;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return ResultMessage.Failure;
			}
		}else{
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage addUser(UserPO po){
		if(userpo.getUserRole()==UserRole.Manager){
			try {
				if(Client.getUserDataService().find(userpo.getId(), UserRole.Manager)!=null){
					if(Client.getUserDataService().find(po.getId(), po.getUserRole())!=null){
						return ResultMessage.Registered;
					}else{
						return Client.getUserDataService().insert(po);
					}
				}else{
					return ResultMessage.Failure;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return ResultMessage.Failure;
			}
		}else{
			return ResultMessage.Failure;
		}
	}
}