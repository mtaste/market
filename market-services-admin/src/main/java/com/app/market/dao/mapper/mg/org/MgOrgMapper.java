package com.app.market.dao.mapper.mg.org;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.mg.MgOrgAuthDTO;
import com.app.market.dto.mg.MgOrgRegisterDTO;

public interface MgOrgMapper {
	/**
	 * 获取机构列表
	 * 
	 * @return
	 */
	List<Map<String, String>> getRegisterOrgList(@Param("param") MgOrgRegisterDTO p);

	/**
	 * 获取列表
	 * 
	 * @return
	 */
	List<Map<String, String>> getOrgAuthBillList(@Param("param") MgOrgAuthDTO p);

	/**
	 * 获取可授权列表
	 * 
	 * @return
	 */
	List<Map<String, String>> getAuthBillAuthList();

	/**
	 * 获取机构列表
	 * 
	 * @return
	 */
	List<Map<String, String>> getOrgAuthOrgList(@Param("param") MgOrgAuthDTO p);

	/**
	 * 保存明细权限
	 * 
	 * @param id
	 * @param authIds
	 * @return
	 */
	Integer saveBillAuths(@Param("billId") String id, @Param("authIds") String authIds);

	/**
	 * 获取单据明细
	 * 
	 * @param p
	 * @return
	 */
	List<Map<String, String>> getAuthBillDetail(@Param("param") MgOrgAuthDTO p);

	/**
	 * 增加权限
	 * 
	 * @param id
	 * @return
	 */
	Integer addOrgAuthByBill(@Param("billId") String id);

	/**
	 * 删除权限
	 * 
	 * @param id
	 * @return
	 */
	Integer delOrgAuthByBill(@Param("billId") String id);

	/**
	 * 获取权限树
	 * 
	 * @param p
	 * @return
	 */
	List<Map<String, String>> getAuths(@Param("param") MgOrgAuthDTO p);

	/**
	 * 初始化机构管理账户
	 * 
	 * @param id
	 * @return
	 */
	Integer initOrgAdminUser(@Param("orgId") String id);

}
