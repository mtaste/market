package com.app.market.dao.mapper.sys.auth;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.sys.SysApprovalListDTO;

public interface AuthMapper {
	/**
	 * 获取权限列表
	 * 
	 * @param userId
	 * @return
	 */
	List<Map<String, String>> getDefineList();

	/**
	 * 删除权限定义信息
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteDefineData(@Param("id") String id);

	/**
	 * 获取单据审核记录
	 * 
	 * @param p
	 * @return
	 */
	List<Map<String, String>> getBillAuthList(@Param("param") SysApprovalListDTO p);

	/**
	 * 判断用户是否存在
	 * 
	 * @param userName
	 * @return
	 */
	List<Map<String, String>> getUserNamePW(@Param("userName") String userName);

}
