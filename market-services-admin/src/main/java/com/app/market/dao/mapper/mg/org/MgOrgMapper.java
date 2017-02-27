package com.app.market.dao.mapper.mg.org;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.mg.MgOrgRegisterDTO;

public interface MgOrgMapper {
	/**
	 * 获取机构列表
	 * 
	 * @return
	 */
	List<Map<String, String>> getRegisterOrgList(@Param("param") MgOrgRegisterDTO p);
}
