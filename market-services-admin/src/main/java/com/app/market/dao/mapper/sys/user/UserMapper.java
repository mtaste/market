package com.app.market.dao.mapper.sys.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.user.SysUserDTO;

public interface UserMapper {
	/**
	 * 获取菜单
	 * 
	 * @param userId
	 * @return
	 */
	List<Map<String, String>> getUserMenu(@Param("userId") String userId);

	/**
	 * 获取此用户的菜单功能
	 * 
	 * @param userId
	 * @param id
	 * @return
	 */
	List<Map<String, String>> getUserMenuFuncs(@Param("userId") String userId, @Param("id") String id);

	/**
	 * 获取用户列表
	 * 
	 * @param p
	 * @return
	 */
	List<Map<String, String>> getUserList(@Param("param") SysUserDTO p);

	/**
	 * 删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteUserData(@Param("id") String id);
}
