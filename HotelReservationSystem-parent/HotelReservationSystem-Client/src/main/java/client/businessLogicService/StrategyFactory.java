package client.businessLogicService;

import client.businessLogicService.strategyblService.StrategyMaintainService;
import client.businessLogicService.strategyblService.StrategyPriceService;
import client.businessLogicServiceImpl.strategybl.PriceController;
import client.businessLogicServiceImpl.strategybl.StrategyController;
import common.otherEnumClasses.UserRole;

public class StrategyFactory {
	public static StrategyMaintainService getStrategyController(String id,UserRole ur){
		return new StrategyController(id,ur);
	}
	
	public static StrategyPriceService getPriceController(){
		return new PriceController();
	}
}
