package com.app.market.dao.mapper.sys.org;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.sys.SysOrgAuthDTO;
import com.app.market.dto.sys.SysOrgDTO;
import com.app.market.dto.sys.SysRoleDTO;
import com.app.market.dto.sys.SysUserRoleDTO;

public interface OrgMapper {
	/**
	 * 获取机构列表
	 * 
	 * @return
	 */
	List<Map<String, String>> getOrgList(@Param("param") SysOrgDTO p);

	/**
	 * 获取机构权限信息
	 * 
	 * @param orgId
	 * @return
	 */
	List<Map<String, String>> getOrgAuthList(String orgId);

	/**
	 * 删除机构
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteOrgData(@Param("orgId") String id);

	/**
	 * 保存机构权限
	 * 
	 * @param p
	 * @return
	 */
	Integer saveOrgAuth(@Param("param") SysOrgAuthDTO p);

	/**
	 * 获取部门列表数据
	 * 
	 * @return
	 */
	List<Map<String, String>> getDeptList(@Param("userId") String userId);

	/**
	 * 删除部门数据
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteDeptData(@Param("id") String id);

	/**
	 * 获取部门职务列表
	 * 
	 * @return
	 */
	List<Map<String, String>> getDeptRoleList(@Param("deptId") String deptId);

	/**
	 * 删除职务
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteDeptRoleData(@Param("id") String id);

	/**
	 * 获取机构的权限列表
	 * 
	 * @param orgId
	 * @return
	 */
	List<Map<String, String>> getOrgAllAuth(@Param("orgId") String orgId);

	/**
	 * 获取职务权限信息
	 * 
	 * @param userId
	 * @param id
	 * @return
	 */
	List<Map<String, String>> getRoleAuthList(@Param("userId") String userId, @Param("roleId") String id);

	/**
	 * 保存部门职务权限
	 * 
	 * @param id
	 * @param authIds
	 * @return
	 */
	Integer saveRoleAuth(@Param("roleId") String roleId, @Param("authIds") String authIds);

	/**
	 * 获取职务可选择用户列表
	 * 
	 * @param roleId
	 * @return
	 */
	List<Map<String, String>> getRoleUserSelect(@Param("param") SysUserRoleDTO roleId);

	/**
	 * 保存职务人呐
	 * 
	 * @param p
	 * @return
	 */
	Integer saveRoleUserData(@Param("param") SysUserRoleDTO p);

	/**
	 * 删除用户职务
	 * 
	 * @param p
	 * @return
	 */
	Integer removeRoleUserData(@Param("param") SysUserRoleDTO p);

	/**
	 * 获取部门用户信息
	 * 
	 * @param roleId
	 * @return
	 */
	List<Map<String, String>> getDeptUserList(@Param("param") SysRoleDTO p);

	/**
	 * 获取机构基础信息
	 * 
	 * @param userId
	 * @return
	 */
	Map<String, String> getOrgInfoByUser(@Param("userId") String userId);

}
