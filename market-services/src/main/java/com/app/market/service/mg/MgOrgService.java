package com.app.market.service.mg;

import java.util.List;
import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.mg.MgOrgAuthDTO;
import com.app.market.dto.mg.MgOrgRegisterDTO;

public interface MgOrgService {
	/**
	 * 查
	 * 
	 * @param page
	 * @param p
	 * @return
	 */
	PageBean<Map<String, String>> getOrgList(PageDTO page, MgOrgRegisterDTO p);

	/**
	 * 保存
	 * 
	 * @param p
	 * @return
	 */
	String saveOrgData(MgOrgRegisterDTO p);

	/**
	 * 删除
	 * 
	 * @param p
	 * @return
	 */
	String removeOrgData(MgOrgRegisterDTO p);

	/**
	 * 提交
	 * 
	 * @param p
	 * @return
	 */
	String appRegisterData(MgOrgRegisterDTO p);

	/**
	 * 审核
	 * 
	 * @param p
	 * @return
	 */
	String authRegisterData(MgOrgRegisterDTO p);

	/**
	 * 否决
	 * 
	 * @param p
	 * @return
	 */
	String rejectRegisterData(MgOrgRegisterDTO p);

	// ===========================授权机构
	PageBean<Map<String, String>> getOrgAuthBillList(PageDTO page, MgOrgAuthDTO p);

	String saveOrgAuthBillData(MgOrgAuthDTO p);

	String appAuthBillData(MgOrgAuthDTO p);

	String authAuthBillData(MgOrgAuthDTO p);

	String rejectAuthBillData(MgOrgAuthDTO p);

	String removeOrgAuthBillData(MgOrgAuthDTO p);

	/**
	 * 获取可授权列表
	 * 
	 * @param p
	 * @return
	 */
	List<Map<String, String>> getAuthBillAuthList(MgOrgAuthDTO p);

	/**
	 * 获取机构列表
	 * 
	 * @param page
	 * @param p
	 * @return
	 */
	PageBean<Map<String, String>> getOrgAuthOrgList(PageDTO page, MgOrgAuthDTO p);

	/**
	 * 获取单据明细
	 * 
	 * @param p
	 * @return
	 */
	List<Map<String, String>> getAuthBillDetail(MgOrgAuthDTO p);

	/**
	 * 获取机构权限
	 * 
	 * @param p
	 * @return
	 */
	List<Map<String, String>> getAuths(MgOrgAuthDTO p);

}
