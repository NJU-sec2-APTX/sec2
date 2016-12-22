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
	
	public StrategyList calPrice(OrderVO OrderVO) throws RemoteException{
		if(OrderVO!=null){
			strategy_price=new StrategyList();
			ArrayList<StrategyVO> list=Client.getStrategyDataService().CalAll();
			for(int i=0;i<list.size();i++){
				StrategyVO TempStrategy=list.get(i);
				MemberVO membervo=new MemberVO(Client.getMemberDataService().find(TempStrategy.getID()));
				if(TempStrategy.getName().equals("MemberLevel")){
					if(TempStrategy.getLevel()<=membervo.getLevel()){
						double p=OrderVO.price*TempStrategy.getCount();
						strategy_price.addLineItem(p,TempStrategy);
					}
				}else{
					switch(TempStrategy.getStrategyType()){
					case Birthday:
						Date d=new Date();
						if(membervo.getBirthday().getMonth()==d.getMonth()&&membervo.getBirthday().getDate()==d.getDate()){
							double p=OrderVO.price*TempStrategy.getCount();
							strategy_price.addLineItem(p,TempStrategy);
						}
						break;
					case CorporationEnterPrise:
						if(membervo.getUserRole()==UserRole.Enterprise&&TempStrategy.getEnterprise().contains(membervo.getName())){
							double p=OrderVO.price*TempStrategy.getCount();
							strategy_price.addLineItem(p,TempStrategy);
						}
						break;
					case MemberLevel:
						break;
					case RoomNumber:
						String []sum=OrderVO.numOfRoom.split("/");
						int number=0;
						for(int j=0;j<sum.length;j++){
							number+=Integer.parseInt(sum[j]);
						}
						if(TempStrategy.getRoomNumber()<=number){
							double p=OrderVO.price*TempStrategy.getCount();
							strategy_price.addLineItem(p,TempStrategy);
						}
						break;
					case SpecialDate:
						if(TempStrategy.getEndDate()!=null){
							if(TempStrategy.getStartDate().compareTo(OrderVO.checkInTime)<=0&&TempStrategy.getEndDate().compareTo(OrderVO.checkOutTime)>=0){
								double p=OrderVO.price*TempStrategy.getCount();
								strategy_price.addLineItem(p,TempStrategy);
							}
						}else{
							if(TempStrategy.getStartDate().compareTo(OrderVO.checkInTime)<=0){
								double p=OrderVO.price*TempStrategy.getCount();
								strategy_price.addLineItem(p,TempStrategy);
							}
						}
						break;
					case VipandArea:
						if(TempStrategy.getArea().equals(Client.getHotelDataService().getHotelInfo(OrderVO.hotel).getArea())){
							String[] discount=TempStrategy.getEnterprise().split("/");
							for(int j=0;j<discount.length;j++){
								if(membervo.getLevel()>=j+1){
									double p=OrderVO.price*Double.parseDouble(discount[j]);
									strategy_price.addLineItem(p,TempStrategy);
									break;
								}
							}
						}
						break;
					}
				}
			}
			return strategy_price;
		}else{
			return null;
		}
	}
}
