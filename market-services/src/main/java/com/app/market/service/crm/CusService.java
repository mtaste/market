package com.app.market.service.crm;

import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.crm.CrmCusInfoDTO;

public interface CusService {
	/**
	 * 获取客户列表
	 * 
	 * @param p
	 * @param page
	 * @return
	 */
	PageBean<Map<String, String>> getCusList(CrmCusInfoDTO p, PageDTO page);

	/**
	 * 
	 * @param p
	 * @return
	 */
	String saveCusData(CrmCusInfoDTO p);

}
