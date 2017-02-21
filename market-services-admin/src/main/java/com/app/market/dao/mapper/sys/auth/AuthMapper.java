package com.app.market.dao.mapper.sys.auth;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AuthMapper {
	/**
	 * 获取权限列表
	 * 
	 * @param userId
	 * @return
	 */
	List<Map<String, String>> getDefineList();

	/**
	 * 删除权限定义信息
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteDefineData(@Param("id") String id);

}
