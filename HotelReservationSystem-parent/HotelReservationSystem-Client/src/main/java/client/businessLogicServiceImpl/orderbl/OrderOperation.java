package client.businessLogicServiceImpl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import client.Client;
import client.businessLogicService.orderblService.orderblService;
import common.otherEnumClasses.CreditChange;
import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.po.HotelPO;
import common.po.OrderPO;
import common.vo.HotelVO;
import common.vo.OrderVO;

public class OrderOperation implements orderblService{

	public ArrayList<HotelVO> searchReservedHotel(Person person){
		ArrayList<HotelVO> vos = new ArrayList<HotelVO>();
		try {
			ArrayList<HotelPO> pos = Client.getOrderDataService().searchReservedHotel(person);
			for(HotelPO hotelPO : pos){
				vos.add(new HotelVO(hotelPO));
			}
		} catch (RemoteException e) {
			
		}
		return vos;
	}
	
	public ArrayList<OrderVO> searchOrderListFromData(Person person, OrderState state, HotelVO hotelVO){
		ArrayList<OrderVO> vos = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> pos = Client.getOrderDataService().findOrderList(person,state,hotelVO);
			for(OrderPO OrderPO : pos){
				vos.add(new OrderVO(OrderPO));
			}
		} catch (RemoteException e) {
			
		}
		return vos;
	}
	
	public boolean createOrder(OrderVO vo, Person person){
		OrderPO po = new OrderPO(vo);
		po.setPerson(person);
		try {
			return Client.getOrderDataService().addOrder(po);
		} catch (RemoteException e) {
			return false;
		}
	}
	
	public boolean executeOrder(OrderVO vo, Person person, Date checkInTime){
		if(vo.state==OrderState.NotDone||vo.state==OrderState.Exceptional){
			OrderPO po = new OrderPO(vo);
			if(vo.state == OrderState.Exceptional){
				po.addCreditChange(new CreditChange(person, 0-po.getCreditChange(), po, vo.state, OrderState.Done));
			}
			po.setState(OrderState.Done);
			po.setCheckInTime(checkInTime);
			po.addCreditChange(new CreditChange(person, po.getPrice(), po, vo.state, OrderState.Done));
			try {
				return Client.getOrderDataService().updateOrder(po);
			} catch (RemoteException e) {
				return false;
			}
		}
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
			if(between/(1000*60*60)<6.0){
				po.addCreditChange(new CreditChange(po.getPerson(), 0-po.getPrice()/2, po, OrderState.NotDone, OrderState.Canceled));
			}
			po.setCancelTime(date);
			po.setState(OrderState.Canceled);
			try {
				return Client.getOrderDataService().updateOrder(po);
			} catch (RemoteException e) {
				return false;
			}
		}
		return false;
	}
	
	public boolean managerCancalOrder(OrderVO vo, boolean isAll){
		if(vo.state==OrderState.Exceptional){
			OrderPO po = new OrderPO(vo);
			po.addCreditChange(new CreditChange(po.getPerson(), (isAll?1:0.5)*po.getPrice(), po, OrderState.Exceptional, OrderState.ExceptionalCanceled));
			po.setCancelTime(new Date());
			po.setState(OrderState.ExceptionalCanceled);
			try {
				return Client.getOrderDataService().updateOrder(po);
			} catch (RemoteException e) {
				return false;
			}
		}
		return false;
	}

	
}
