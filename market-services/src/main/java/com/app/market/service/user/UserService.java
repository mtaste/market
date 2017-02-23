package com.app.market.service.user;

import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.user.SysUserDTO;

public interface UserService {
	/**
	 * 获取用户列表
	 * 
	 * @param p
	 * @param page
	 * @return
	 */
	PageBean<Map<String, String>> getUserList(SysUserDTO p, PageDTO page);

	/**
	 * 保存用户信息
	 * 
	 * @param p
	 * @return
	 */
	String saveUserData(SysUserDTO p);

	/**
	 * 删除用户信息
	 * 
	 * @param p
	 * @return
	 */
	String removeUserData(SysUserDTO p);

}
