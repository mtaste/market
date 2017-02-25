package com.app.market.service.mg.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.mg.MgOrgRegisterDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.mg.MgOrgService;
import com.app.market.support.util.Version;
import com.app.market.dao.mapper.mg.org.MgOrgMapper;
import com.app.market.dao.mapper.sys.mybatis.MgOrgRegisterMapper;

@Service(version = Version.NOW)
public class MgOrgServiceImpl implements MgOrgService {
	@Autowired
	private CrudService crudService;
	@Autowired
	private MgOrgMapper mgOrgMapper;
	@Autowired
	private MgOrgRegisterMapper mgOrgRegisterMapper;

	@Override
	public PageBean<Map<String, String>> getOrgList(PageDTO page, MgOrgRegisterDTO p) {
		PageBean<Map<String, String>> ret = null;
		ret = this.crudService.getListPage(page, this.mgOrgMapper, "getRegisterOrgList", p);
		return ret;
	}

	@Override
	public String saveOrgData(MgOrgRegisterDTO p) {
		String ret = "-101";
		ret = this.crudService.saveData(this.mgOrgRegisterMapper, p);
		return ret;
	}

	@Override
	public String removeOrgData(MgOrgRegisterDTO p) {
		Integer cn = this.mgOrgRegisterMapper.deleteByPrimaryKey(p.getId());
		return cn.toString();
	}
}
