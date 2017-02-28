package com.app.market.service.common.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.sys.mybatis.SysApprovalConfig;
import com.app.market.dao.entity.sys.mybatis.SysApprovalList;
import com.app.market.dao.entity.sys.mybatis.SysTimeList;
import com.app.market.dao.mapper.sys.mybatis.SysApprovalConfigMapper;
import com.app.market.dao.mapper.sys.mybatis.SysApprovalListMapper;
import com.app.market.dao.mapper.sys.mybatis.SysTimeListMapper;
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
	@Autowired
	private SysApprovalListMapper sysApprovalListMapper;
	@Autowired
	private SysApprovalConfigMapper sysApprovalConfigMapper;
	@Autowired
	private SysTimeListMapper sysTimeListMapper;

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
		// 增加时间记录
		SysTimeList record = new SysTimeList();
		record.setBillId(id);
		record.setCreateTime(new Date());
		Object updateUser = ReflectUtil.getValue(p, "getUpdateUser");
		if (null != updateUser) {
			record.setCreateUser(updateUser.toString());
		}
		this.sysTimeListMapper.insertSelective(record);
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
		Integer cn = (Integer) ReflectUtil.runMethod(mapper, "updateByPrimaryKey", t);
		if (cn <= 0)
			return "-101";
		// 更新时间记录
		this.updateTime(id, p);
		return id;
	}

	private void updateTime(String id, Object p) {
		SysTimeList record = this.sysTimeListMapper.selectByPrimaryKey(id);
		if (record == null)
			return;
		record.setUpdateTime(new Date());
		Object updateUser = ReflectUtil.getValue(p, "getUpdateUser");
		if (null != updateUser) {
			record.setUpdateUser(updateUser.toString());
		}
		this.sysTimeListMapper.updateByPrimaryKey(record);
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

	@Override
	public Integer appData(Object mapper, Object p) {
		String id = ReflectUtil.getValue(p, "getId").toString();
		Object t = ReflectUtil.runMethod(mapper, "selectByPrimaryKey", id);
		if (t == null) {
			return -302;
		}
		String status = ReflectUtil.getValue(t, "getStatus").toString();
		if (!"0".equals(status)) {
			return -301;
		}
		// 更新状态
		ReflectUtil.runMethod(t, "setStatus", "1");
		Integer cn = (Integer) ReflectUtil.runMethod(mapper, "updateByPrimaryKey", t);
		this.addAuthList(p, id, 1);
		this.updateTime(id, p);
		return cn;
	}

	@Override
	public Integer authData(Object mapper, Object p) {
		String id = ReflectUtil.getValue(p, "getId").toString();
		Object t = ReflectUtil.runMethod(mapper, "selectByPrimaryKey", id);
		if (t == null) {
			return -302;
		}
		String status = ReflectUtil.getValue(t, "getStatus").toString();
		if ("0".equals(status)) {
			return -305;
		}
		// 获取单据最大的status
		SysApprovalConfig config = this.sysApprovalConfigMapper.selectByPrimaryKey(p.getClass().getSimpleName());
		if (config == null) {
			return -501;
		}
		// 判断审核后的是否超过最大,超过则不能处理.
		Integer maxStatus = Integer.parseInt(config.getMaxStatus());
		Integer nextStatus = Integer.parseInt(status) + 1;
		if (nextStatus > maxStatus) {
			return -502;
		}
		ReflectUtil.runMethod(t, "setStatus", nextStatus.toString());
		Integer cn = (Integer) ReflectUtil.runMethod(mapper, "updateByPrimaryKey", t);
		// 增加审核记录
		DTOUtil.copyPropertiesIgnoreNull(t, p);
		this.addAuthList(p, id, nextStatus);
		this.updateTime(id, p);
		return cn;
	}

	private void addAuthList(Object p, String id, Integer status) {
		SysApprovalList record = new SysApprovalList();
		record.setId(GUID.getUUID());
		record.setBillId(id);
		record.setBillName(p.getClass().getSimpleName());
		record.setCreateTime(new Date());
		String updateUser = ReflectUtil.getValue(p, "getUpdateUser").toString();
		record.setCreateUser(updateUser);
		String remark = ReflectUtil.getValue(p, "getRemark").toString();
		record.setRemark(remark);
		record.setStatus(status.toString());
		sysApprovalListMapper.insertSelective(record);
	}

	@Override
	public Integer rejectData(Object mapper, Object p) {
		String id = ReflectUtil.getValue(p, "getId").toString();
		Object t = ReflectUtil.runMethod(mapper, "selectByPrimaryKey", id);
		if (t == null) {
			return -302;
		}
		String status = ReflectUtil.getValue(t, "getStatus").toString();
		if ("0".equals(status) || "99".equals(status)) {
			return -305;
		}
		// 获取单据最大的status
		SysApprovalConfig config = this.sysApprovalConfigMapper.selectByPrimaryKey(p.getClass().getSimpleName());
		if (config == null) {
			return -501;
		}
		// 判断审核后的是否超过最大,超过则不能处理.
		Integer maxStatus = Integer.parseInt(config.getMaxStatus());
		Integer curentStatus = Integer.parseInt(status);
		if (curentStatus >= maxStatus) {
			return -503;
		}
		ReflectUtil.runMethod(t, "setStatus", "99");
		Integer cn = (Integer) ReflectUtil.runMethod(mapper, "updateByPrimaryKey", t);
		// 增加审核记录
		this.addAuthList(p, id, 99);
		this.updateTime(id, p);
		return cn;
	}

}
