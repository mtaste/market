package com.app.market.service.sys;

import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.sys.SysOrgDTO;

public interface OrgService {
	/**
	 * 获取机构列表
	 * 
	 * @return
	 */
	PageBean<Map<String, String>> getOrgList(PageDTO page);

	/**
	 * 保存数据
	 * 
	 * @param p
	 * @return
	 */
	String saveOrgData(SysOrgDTO p);

	/**
	 * 删除数据
	 * 
	 * @param p
	 * @return
	 */
	String removeOrgData(SysOrgDTO p);

}
