
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import client.businessLogicService.StrategyFactory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.StrategyPO;
import common.vo.StrategyVO;
import junit.framework.TestCase;

public class StrategyTest extends TestCase{
	
	@Before
	public void setUp(){
		new Client();
	}
	
//	String id,UserRole ur,String strategy_name,String enterpriseList,int roomNumber,
//	Date start_date,Date end_date,String businessarea,int level,double count,StrategyType type
	@Test
	public void testStrategyMaintain(){
		//add
		try {
			assertEquals(ResultMessage.Success,StrategyFactory.getStrategyController("000001",UserRole.HotelWorker).addCorporationEnterPriseStrategy("fuck", 0.85, "南京大学"));
			assertEquals(ResultMessage.Failure,StrategyFactory.getStrategyController("000001",UserRole.HotelWorker).addCorporationEnterPriseStrategy("fuck", 0.85, "南京大学"));
			StrategyVO vo=StrategyFactory.getStrategyController("000001", UserRole.HotelWorker).getStrategy("fuck");
			StrategyPO po=new StrategyPO(vo.getID(),vo.getUserRole(),vo.getName(),vo.getEnterprise(),vo.getRoomNumber()
					,vo.getStartDate(),vo.getEndDate(),vo.getArea(),vo.getLevel(),0.99,vo.getStrategyType());
			assertEquals(ResultMessage.Success,StrategyFactory.getStrategyController("000001", UserRole.HotelWorker).modifyStrategy(new StrategyVO(po)));
			assertEquals(ResultMessage.Success,StrategyFactory.getStrategyController("000001", UserRole.HotelWorker).removeStrategy(new StrategyVO(po)));
			assertEquals(ResultMessage.Failure,StrategyFactory.getStrategyController("000001", UserRole.HotelWorker).removeStrategy(new StrategyVO(po)));
			assertEquals(StrategyFactory.getStrategyController("000002", UserRole.Sales).getStrategy("VipAndArea").getArea(),"南京大学");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
