package client.businessLogicService.orderblService;

import java.util.ArrayList;
import java.util.Date;

import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.vo.HotelVO;
import common.vo.OrderVO;

public interface OrderblService {

	/**
	 * 
	 *@description 搜索已预定过酒店
	 *@param 客户ID
	 *@return 酒店VO列表
	 */
	public ArrayList<HotelVO> searchReservedHotel(String clientId);
	
	/**
	 * 
	 *@description 根据身份搜索对应可获得的订单列表
	 *@param 搜索者身份，订单状态，酒店
	 *@return 订单VO列表
	 */
	public ArrayList<OrderVO> searchOrderListFromData(Person person, OrderState state, HotelVO hotelVO);
	
	
	/**
	 * 
	 *@description 根据暂定订单信息计算价格（已增加策略）
	 *@param 订单VO
	 *@return 添加价格后的订单VO
	 */
	public OrderVO calPrice(OrderVO vo);
	
	/**
	 * 
	 *@description 生成订单
	 *@param 订单信息VO，客户ID
	 *@return 生成成功的订单VO，或生成失败为null
	 */
	public OrderVO createOrder(OrderVO vo, String clientId);
	
	/**
	 * 
	 *@description 执行订单（容纳了更新入住）
	 *@param 订单号，酒店ID，入住时间，预计离开时间
	 *@return 执行成功的订单VO
	 */
	public OrderVO executeOrder(String orderId, String hotelId, Date checkInTime, Date planCheckOutTime);
	
	
	/**
	 * 
	 *@description 评价订单（已执行订单）
	 *@param 订单VO，评分
	 *@return boolean是否成功
	 */
	public boolean assessOrder(OrderVO vo, double mark);
	
	/**
	 * 
	 *@description 客户撤销未执行订单
	 *@param 订单VO
	 *@return boolean是否成功
	 */
	public boolean clientCancelOrder(OrderVO vo);
	
	/**
	 * 
	 *@description 网站营销人员撤销异常订单
	 *@param 订单VO
	 *@return boolean是否成功s
	 */
	public boolean managerCancalOrder(OrderVO vo, boolean isAll);
}