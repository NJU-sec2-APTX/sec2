package client.businessLogicServiceImpl.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import client.Client;
import common.otherEnumClasses.StrategyList;
import common.otherEnumClasses.UserRole;
import common.vo.MemberVO;
import common.vo.OrderVO;
import common.vo.StrategyVO;

public class PriceHelper {
	private StrategyList strategy_price;
	@SuppressWarnings("deprecation")
	public StrategyList calPrice(OrderVO vo) throws RemoteException{
		if(vo!=null){
			strategy_price=new StrategyList();
			ArrayList<StrategyVO> list=Client.getStrategyDataService().CalAll();
			for(int i=0;i<list.size();i++){
				StrategyVO tempvo=list.get(i);
				MemberVO membervo=new MemberVO(Client.getMemberDataService().find(tempvo.getID()));
				if(tempvo.getName().equals("MemberLevel")){
					if(tempvo.getLevel()<=membervo.getLevel()){
						double p=vo.price*tempvo.getCount();
						strategy_price.addLineItem(p,tempvo);
					}
				}else{
					//判断生日
					if(tempvo.IsMemberBirth()&&membervo.getUserRole()==UserRole.Member){
						Date d=new Date();
						if(membervo.getBirthday().getMonth()!=d.getMonth()||membervo.getBirthday().getDate()!=d.getDate()){
							continue;
						}
					}
//					//判断商圈
//					if(tempvo.getArea()!=null){
//						if(!tempvo.getArea().contains(Client.getHotelDataService().getHotelInfo(vo.hotel).getArea())){
//							break;
//						}
//					}
					//判断时间
					if(tempvo.getStartDate()!=null){
						if(tempvo.getEndDate()!=null){
							if(tempvo.getStartDate().compareTo(vo.checkInTime)>0||tempvo.getEndDate().compareTo(vo.checkOutTime)<0){
								continue;
							}
						}else{
							if(!tempvo.getStartDate().before(vo.checkInTime)){
								continue;
							}
						}
					}
					//判断房间数
					if(tempvo.getRoomNumber()!=0){
						String []sum=vo.numOfRoom.split("/");
						int number=0;
						for(int j=0;j<sum.length;j++){
							number+=Integer.parseInt(sum[j]);
						}
						if(tempvo.getRoomNumber()>number){
							continue;
						}
					}
					//判断等级
					if(tempvo.getLevel()!=0){
						if(tempvo.getLevel()>membervo.getLevel()){
							continue;
						}
					}
					//判断合作企业
					if(!tempvo.getEnterprise().equals("null")&&membervo.getUserRole()==UserRole.Enterprise){
						if(!tempvo.getEnterprise().contains(membervo.getName())){
							continue;
						}
					}
					double p=vo.price*tempvo.getCount();
					strategy_price.addLineItem(p,tempvo);
				}
			}
			return strategy_price;
		}else{
			return null;
		}
	}
}
