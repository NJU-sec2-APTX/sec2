package client.businessLogicServiceImpl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import client.Client;
import client.businessLogicService.orderblService.OrderblService;
import client.businessLogicService.strategyblService.StrategyPriceService;
import client.businessLogicServiceImpl.strategybl.PriceController;
import common.otherEnumClasses.CreditChange;
import common.otherEnumClasses.CreditOperation;
import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.po.HotelPO;
import common.po.OrderPO;
import common.vo.HotelVO;
import common.vo.OrderVO;

public class OrderOperation implements OrderblService{

	public ArrayList<HotelVO> searchReservedHotel(String clientId){
		ArrayList<HotelVO> vos = new ArrayList<HotelVO>();
		try {
			ArrayList<HotelPO> pos = Client.getOrderDataService().searchReservedHotel(clientId);
			for(HotelPO hotelPO : pos){
				vos.add(new HotelVO(hotelPO, true));
			}
		} catch (RemoteException e) {}
		return vos;
	}
	
	public ArrayList<OrderVO> searchOrderListFromData(Person person, OrderState state, HotelVO hotelVO){
		ArrayList<OrderVO> vos = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> pos = Client.getOrderDataService().findOrderList(person,state,hotelVO);
			for(OrderPO OrderPO : pos){
				vos.add(new OrderVO(OrderPO));
			}
		} catch (RemoteException e) {}
		return vos;
	}
	
	public boolean createOrder(OrderVO vo, String clientId){
		OrderPO po = new OrderPO(vo);
		po.setClientId(clientId);
		try {
			StrategyPriceService calprice = new PriceController();
			po.setPrice(calprice.calPrice(new OrderVO(po)).getfirstStrategy().getPrice());
			return Client.getOrderDataService().addOrder(po);
		} catch (RemoteException e) {
			return false;
		}
	}
	
	public boolean executeOrder(String orderId, String clientId, Date checkInTime){
		try {
			OrderPO po = Client.getOrderDataService().findOrderFromData(orderId);
			if(po.getState()==OrderState.NotDone||po.getState()==OrderState.Exceptional){
				if(po.getState() == OrderState.Exceptional){
					Client.getUserDataService().updatecredit(clientId, po.getPrice(), po.getId(), CreditOperation.ExceptionCancel);
				}
				po.setState(OrderState.Done);
				po.setCheckInTime(checkInTime);
				Client.getUserDataService().updatecredit(clientId, po.getPrice(), po.getId(), CreditOperation.Execute);
				return Client.getOrderDataService().updateOrder(po);
			}
		} catch (RemoteException e) {}
		return false;
	}
	
	public boolean assessOrder(OrderVO vo, double mark){
		if(vo.state!=OrderState.Done){
			OrderPO po = new OrderPO(vo);
			po.setMark(mark);
			try {
				return Client.getOrderDataService().updateOrder(po);
			} catch (RemoteException e) {
				return false;
			}
		}
		return false;
	}
	
	public boolean clientCancelOrder(OrderVO vo){
		if(vo.state==OrderState.NotDone){
			OrderPO po = new OrderPO(vo);
			Date latestTime = po.getLatestDoneTime();
			Date date = new Date();
			long between = latestTime.getTime()-date.getTime();
			try {
				if(between/(1000*60*60)<6.0){
					Client.getUserDataService().updatecredit(po.getClientId(),0-po.getPrice()/2, po.getId(), CreditOperation.Cancel);
				}
				po.setCancelTime(date);
				po.setState(OrderState.Canceled);
				return Client.getOrderDataService().updateOrder(po);
			} catch (RemoteException e) {
				return false;
			}
		}
		return false;
	}
	
	public boolean managerCancalOrder(OrderVO vo, boolean isAll){
		if(vo.state==OrderState.Exceptional){
			try {
				OrderPO po = new OrderPO(vo);
				Client.getUserDataService().updatecredit(po.getClientId(), (isAll?1:0.5)*po.getPrice(), po.getId(), CreditOperation.ExceptionCancel);
				po.setCancelTime(new Date());
				po.setState(OrderState.ExceptionalCanceled);
				return Client.getOrderDataService().updateOrder(po);
			} catch (RemoteException e) {
				return false;
			}
		}
		return false;
	}

	
}
