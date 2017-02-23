package com.app.market.service.sys;

import java.util.List;
import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.sys.SysDeptDTO;
import com.app.market.dto.sys.SysOrgAuthDTO;
import com.app.market.dto.sys.SysOrgDTO;
import com.app.market.dto.sys.SysRoleDTO;

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

	/**
	 * 获取机构权限信息
	 * 
	 * @param p
	 * @return
	 */
	List<Map<String, String>> getOrgAuthList(SysOrgAuthDTO p);

	/**
	 * 保存机构权限
	 * 
	 * @param p
	 * @return
	 */
	String saveOrgAuth(SysOrgAuthDTO p);

	/**
	 * 获取机构部门数据
	 * 
	 * @param userId
	 * @return
	 */
	List<Map<String, String>> getDeptList(String userId);

	/**
	 * 获取部门信息
	 * 
	 * @param p
	 * @param userId
	 * @return
	 */
	String saveDeptData(SysDeptDTO p, String userId);

	/**
	 * 删除部门信息
	 * 
	 * @param p
	 * @return
	 */
	String removeDeptData(SysDeptDTO p);

	/**
	 * 获取部门职务
	 * 
	 * @param page
	 * 
	 * @param p
	 * @return
	 */
	PageBean<Map<String, String>> getDeptRoleList(PageDTO page, SysRoleDTO p);

	/**
	 * 保存部门职务信息
	 * 
	 * @param p
	 * @param userId
	 * @return
	 */
	String saveDeptRoleData(SysRoleDTO p, String userId);

	/**
	 * 删除职务信息
	 * 
	 * @param p
	 * @param userId
	 * @return
	 */
	String removeDeptRoleData(SysRoleDTO p, String userId);

}
