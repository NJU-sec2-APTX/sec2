package client.businessLogicService.hotelblService;

import java.util.Date;

import common.vo.OrderVO;

public interface HotelblUpdateService {

	/**
	 * 
	 *@description 线下入住
	 *@param 酒店ID，房间数量情况（以'/'划分），入住时间，预计离开时间
	 *@return boolean是否成功
	 */
	public boolean offlineCheckIn(String hotelId, String numOfRoom, Date checkInTime, Date planDepartTime);
	
	/**
	 * 
	 *@description 线上退房
	 *@param 酒店ID，订单号，退房时间
	 *@return 退房后的订单VO
	 */
	public OrderVO onlineCheckOut(String hotelId, String orderId, Date DepartTime);
	
	/**
	 * 
	 *@description 线下退房
	 *@param 酒店ID，房间数量情况，退房时间
	 *@return boolean是否退房成功
	 */
	public boolean offlineCheckOut(String hotelId, String numOfRoom, Date DepartTime);
}