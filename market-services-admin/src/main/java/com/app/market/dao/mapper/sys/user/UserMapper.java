package com.app.market.dao.mapper.sys.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	/**
	 * 获取菜单
	 * 
	 * @param userId
	 * @return
	 */
	List<Map<String, String>> getUserMenu(@Param("userId") String userId);

}
