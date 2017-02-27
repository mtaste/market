package com.app.market.service.common;

import java.util.List;
import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;

/**
 * 公用服务类
 * 
 * @author ken
 *
 */
public interface CrudService {
	/**
	 * 获取列表分布
	 * 
	 * @param page
	 * @param mapper
	 * @param name
	 * @param ps
	 * @return
	 */
	PageBean<Map<String, String>> getListPage(PageDTO page, Object mapper, String name, Object... ps);

	/**
	 * 获取列表不分页
	 * 
	 * @param page
	 * @param mapper
	 * @param name
	 * @param ps
	 * @return
	 */
	List<Map<String, String>> getList(Object mapper, String name, Object... ps);

	/**
	 * 保存数据
	 * 
	 * @param mapper
	 * @param p
	 * @return
	 */
	String saveData(Object mapper, Object p);

	/**
	 * 删除数据
	 * 
	 * @param mapper
	 * @param name
	 * @param ps
	 * @return
	 */
	Integer removeData(Object mapper, String name, String id, Object... ps);

	/**
	 * 提交
	 * 
	 * @param mgOrgMapper
	 * @param p
	 * @return
	 */
	Integer appData(Object mapper, Object p);

	/**
	 * 审核
	 * 
	 * @param mapper
	 * @param p
	 * @return
	 */
	Integer authData(Object mapper, Object p);

	/**
	 * 否决
	 * 
	 * @param mapper
	 * @param p
	 * @return
	 */
	Integer rejectData(Object mapper, Object p);

}
