package client.businessLogicService.hotelblService;

import java.util.ArrayList;

import common.otherEnumClasses.HotelSearchConditions;
import common.otherEnumClasses.Person;
import common.otherEnumClasses.SortFlag;
import common.vo.HotelVO;

public interface HotelblBrowseService {
	
	/**
	 * 
	 *@description 根据组合条件搜索酒店VO列表
	 *@param 商圈，地址，搜索条件，客户ID
	 *@return 酒店VO列表
	 */
	public ArrayList<HotelVO> getHotelList(String area, String address, HotelSearchConditions searchItems, String clientId);
	
	/**
	 * 
	 *@description 根据排序
	 *@param 商圈，地址，搜索条件，客户ID，排序指标，是否升序
	 *@return 排序后的酒店VO列表
	 */
	public ArrayList<HotelVO> sortHotelList(String area, String address, HotelSearchConditions searchItems, String clientId, SortFlag flag, boolean isIncrease);
}