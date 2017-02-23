package com.app.market.dao.mapper.sys.org;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.sys.SysOrgAuthDTO;

public interface OrgMapper {
	/**
	 * 获取机构列表
	 * 
	 * @return
	 */
	List<Map<String, String>> getOrgList();

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

}
