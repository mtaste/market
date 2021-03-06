package com.app.market.service.user;

import java.util.List;
import java.util.Map;

import com.app.market.dto.sys.SysApprovalListDTO;
import com.app.market.dto.sys.SysAuthDTO;
import com.app.market.dto.user.SysUserDTO;

public interface AuthService {
	/**
	 * 校验用户
	 * 
	 * @param p
	 * @return
	 */
	String authUser(SysUserDTO p);

	/**
	 * 获取用户菜单
	 * 
	 * @param userId
	 * @return
	 */
	List<Map<String, String>> getUserMenus(String userId);

	/**
	 * 权限定义列表信息
	 * 
	 * @return
	 */
	List<Map<String, String>> getAuthDefineList();

	/**
	 * 保存权限定义数据
	 * 
	 * @param p
	 * @return
	 */
	String saveDefineData(SysAuthDTO p);

	/**
	 * 删除权限信息
	 * 
	 * @param p
	 * @return
	 */
	String removeDefineData(SysAuthDTO p);

	/**
	 * 获取用户菜单权限功能
	 * 
	 * @param userId
	 * @param p
	 * @return
	 */
	List<Map<String, String>> getUserMenuFuncs(String userId, SysAuthDTO p);

	/**
	 * 获取用户机构ID
	 */
	String getUserOrgId(String userId);

	/**
	 * 获取审核记录
	 * 
	 * @param p
	 * @return
	 */
	List<Map<String, String>> getBillAuthList(SysApprovalListDTO p);

	/**
	 * 获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	Map<String, String> getUserInfo(String userId);
}
