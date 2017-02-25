package com.app.market.service.mg;

import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.mg.MgOrgRegisterDTO;

public interface MgOrgService {
	/**
	 * 查
	 * 
	 * @param page
	 * @param p
	 * @return
	 */
	PageBean<Map<String, String>> getOrgList(PageDTO page, MgOrgRegisterDTO p);

	/**
	 * 保存
	 * 
	 * @param p
	 * @return
	 */
	String saveOrgData(MgOrgRegisterDTO p);

	/**
	 * 删除
	 * 
	 * @param p
	 * @return
	 */
	String removeOrgData(MgOrgRegisterDTO p);

}
