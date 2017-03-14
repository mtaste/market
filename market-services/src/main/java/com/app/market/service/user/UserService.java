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

	/**
	 * 获取用户信息数据
	 * 
	 * @param userId
	 * @return
	 */
	Map<String, String> getInfo(String userId);

	/**
	 * 修改个人信息
	 * 
	 * @param p
	 * @return
	 */
	String changeInfo(SysUserDTO p);

	/**
	 * 修改个人密码
	 * 
	 * @param p
	 * @return
	 */
	String changePassWord(SysUserDTO p);

}
