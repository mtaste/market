package com.app.market.service.oa;

import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.oa.OaNoticeDTO;

public interface OaNoticeService {
	/**
	 * 列表
	 * 
	 * @param p
	 * @param page
	 * @return
	 */
	PageBean<Map<String, String>> getNoticeList(OaNoticeDTO p, PageDTO page);

	/**
	 * 保存
	 * 
	 * @param p
	 * @return
	 */
	String saveNoticeData(OaNoticeDTO p);

	/**
	 * 提交
	 * 
	 * @param p
	 * @return
	 */
	String appNoticeData(OaNoticeDTO p);

	/**
	 * 删除
	 * 
	 * @param p
	 * @return
	 */
	String removeNoticeData(OaNoticeDTO p);

}
