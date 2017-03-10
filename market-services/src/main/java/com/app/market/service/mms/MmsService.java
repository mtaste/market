package com.app.market.service.mms;

import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.mms.MmsInfoDTO;
import com.app.market.dto.mms.MmsPointsChangeDTO;
import com.app.market.dto.mms.MmsPointsChangeDetailDTO;

public interface MmsService {

	PageBean<Map<String, String>> getInfoList(MmsInfoDTO p, PageDTO page);

	String saveInfoData(MmsInfoDTO p);

	/**
	 * 获取积分变更列表
	 * 
	 * @param page
	 * @param p
	 * @return
	 */
	PageBean<Map<String, String>> getPointsChangeList(PageDTO page, MmsPointsChangeDTO p);

	/**
	 * 保存表单信息
	 * 
	 * @param p
	 * @return
	 */

	String savePointsChangeData(MmsPointsChangeDTO p);

	/**
	 * 删除
	 * 
	 * @param p
	 * @return
	 */
	String removePointsChangeData(MmsPointsChangeDTO p);

	/**
	 * 提交
	 * 
	 * @param p
	 * @return
	 */
	String appPointsChangeData(MmsPointsChangeDTO p);

	/**
	 * 审核
	 * 
	 * @param p
	 * @return
	 */
	String authPointsChangeData(MmsPointsChangeDTO p);

	/**
	 * 否决
	 * 
	 * @param p
	 * @return
	 */
	String rejectPointsChangeData(MmsPointsChangeDTO p);

	/**
	 * 明细列表
	 * 
	 * @param page
	 * @param p
	 * @return
	 */
	PageBean<Map<String, String>> pointsChangeDetail(PageDTO page, MmsPointsChangeDTO p);

	/**
	 * 获取可选择列表
	 * 
	 * @param page
	 * @param p
	 * @return
	 */
	PageBean<Map<String, String>> getPointsChangeMemberList(PageDTO page, MmsPointsChangeDTO p);

	/**
	 * 修改明细数量
	 * 
	 * @param p
	 * @return
	 */
	String addPointsChangeDetailPoints(MmsPointsChangeDetailDTO p);

	/**
	 * 删除明细
	 * 
	 * @param p
	 * @return
	 */
	String removePointsChangeDetail(MmsPointsChangeDTO p);

	/**
	 * 增加明细
	 * 
	 * @param p
	 * @return
	 */
	String addPointsChangeDetail(MmsPointsChangeDTO p);

}
