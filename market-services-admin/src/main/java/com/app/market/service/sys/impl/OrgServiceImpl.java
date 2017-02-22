package com.app.market.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.mapper.sys.mybatis.SysOrgMapper;
import com.app.market.dao.mapper.sys.org.OrgMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.sys.SysOrgAuthDTO;
import com.app.market.dto.sys.SysOrgDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.sys.OrgService;
import com.app.market.support.util.Version;

@Service(version = Version.NOW)
public class OrgServiceImpl implements OrgService {
	@Autowired
	private OrgMapper orgMapper;
	@Autowired
	private SysOrgMapper sysOrgMapper;
	@Autowired
	private CrudService crudService;

	@Override
	public PageBean<Map<String, String>> getOrgList(PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		ret = this.crudService.getListPage(page, this.orgMapper, "getOrgList");
		return ret;
	}

	@Override
	public String saveOrgData(SysOrgDTO p) {
		String ret = "-101";
		ret = this.crudService.saveData(this.sysOrgMapper, p);
		return ret;
	}

	@Override
	public String removeOrgData(SysOrgDTO p) {
		Integer cn = this.crudService.removeData(this.orgMapper, "deleteOrgData", p.getId());
		return cn.toString();
	}

	@Override
	public List<Map<String, String>> getOrgAuthList(SysOrgAuthDTO p) {
		return orgMapper.getOrgAuthList(p.getOrgId());
	}

	@Override
	public String saveOrgAuth(SysOrgAuthDTO p) {
		Integer ret = this.orgMapper.saveOrgAuth(p);
		return ret.toString();
	}

}
