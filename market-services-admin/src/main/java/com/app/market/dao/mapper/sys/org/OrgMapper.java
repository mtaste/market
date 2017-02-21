package com.app.market.dao.mapper.sys.org;

import java.util.List;
import java.util.Map;

public interface OrgMapper {
	/**
	 * 获取机构列表
	 * 
	 * @return
	 */
	List<Map<String, String>> getOrgList();

}
