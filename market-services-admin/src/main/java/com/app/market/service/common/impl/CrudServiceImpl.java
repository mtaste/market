package com.app.market.service.common.impl;

import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.service.common.CrudService;
import com.app.market.support.util.DTOUtil;
import com.app.market.support.util.GUID;
import com.app.market.support.util.ReflectUtil;
import com.app.market.support.util.Version;
import com.github.pagehelper.PageHelper;

@Service(version = Version.NOW)
public class CrudServiceImpl implements CrudService {
	@Override
	public String saveData(Object mapper, Object p) {
		String ret = "-101";
		if (p == null) {
			return ret;
		}
		String id = ReflectUtil.getValue(p, "getId").toString();
		if (StringUtils.isBlank(id)) {
			// 增加权数据
			ret = this.add(mapper, p);
		} else {
			// 更新数据
			ret = this.update(mapper, p);
		}
		return ret;
	}

	/**
	 * 新增加
	 * 
	 * @param mapper
	 * @param p
	 * @return
	 */
	private String add(Object mapper, Object p) {
		String id = GUID.getUUID();
		ReflectUtil.setValue(p, "setId", id);
		Integer cn = (Integer) ReflectUtil.runMethod(mapper, "insertSelective", p);
		if (cn <= 0)
			return "-101";
		return id;
	}

	/**
	 * 修改
	 * 
	 * @param mapper
	 * @param p
	 * @return
	 */
	private String update(Object mapper, Object p) {
		String id = ReflectUtil.getValue(p, "getId").toString();
		Object t = ReflectUtil.runMethod(mapper, "selectByPrimaryKey", id);
		DTOUtil.copyPropertiesIgnoreNull(p, t);
		Integer cn = (Integer) ReflectUtil.runMethod(mapper, "updateByPrimaryKey", p);
		if (cn <= 0)
			return "-101";
		return id;
	}

	@Override
	public PageBean<Map<String, String>> getListPage(PageDTO page, Object mapper, String name, Object... ps) {
		if (page != null) {
			PageHelper.startPage(page.getPage(), page.getRows());
		}
		List<Map<String, String>> ret = this.getList(mapper, name, ps);
		return new PageBean<Map<String, String>>(ret);
	}

	@Override
	public List<Map<String, String>> getList(Object mapper, String name, Object... ps) {
		@SuppressWarnings("unchecked")
		List<Map<String, String>> ret = (List<Map<String, String>>) ReflectUtil.runMethod(mapper, name, ps);
		return ret;
	}

	@Override
	public Integer removeData(Object mapper, String name, String id, Object... ps) {
		if (StringUtils.isBlank(id)) {
			return -101;
		}
		Integer cn = (Integer) ReflectUtil.runMethod(mapper, name, id, ps);
		return cn;
	}

}
