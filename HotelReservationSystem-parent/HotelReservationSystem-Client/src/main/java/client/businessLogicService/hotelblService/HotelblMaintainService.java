package client.businessLogicService.hotelblService;

import common.vo.HotelVO;

public interface HotelblMaintainService {
	
	/**
	 * 
	 *@description 添加酒店
	 *@param 酒店VO
	 *@return boolean是否成功
	 */
	public boolean addHotel(HotelVO vo);
	
	/**
	 * 
	 *@description 根据酒店ID获得酒店信息
	 *@param 酒店ID
	 *@return 酒店VO
	 */
	public HotelVO getHotelInfo(String hotelId);
	
	/**
	 * 
	 *@description 通过酒店VO维护酒店信息（包含调整客房）
	 *@param 酒店VO
	 *@return boolean是否成功
	 */
	public boolean setHotelInfo(HotelVO hotelInfoVO);
}