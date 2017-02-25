package com.app.market.dao.mapper.mg.org;

import java.util.List;
import java.util.Map;

import com.app.market.dto.mg.MgOrgRegisterDTO;

public interface MgOrgMapper {
	/**
	 * 获取机构列表
	 * 
	 * @return
	 */
	List<Map<String, String>> getRegisterOrgList(MgOrgRegisterDTO p);
}
