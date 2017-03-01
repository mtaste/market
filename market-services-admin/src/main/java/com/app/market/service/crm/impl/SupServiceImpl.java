package com.app.market.service.crm.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.mapper.crm.mybatis.CrmSupInfoMapper;
import com.app.market.dao.mapper.crm.sup.CrmSupMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.crm.CrmSupInfoDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.crm.SupService;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.Version;

import jodd.util.StringUtil;

@Service(version = Version.NOW)
public class SupServiceImpl implements SupService {
	@Autowired
	private CrudService crudService;
	@Autowired
	private CrmSupMapper crmSupMapper;
	@Autowired
	private AuthService authService;
	@Autowired
	private CrmSupInfoMapper crmSupInfoMapper;

	@Override
	public PageBean<Map<String, String>> getSupList(CrmSupInfoDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		ret = this.crudService.getListPage(page, this.crmSupMapper, "getSupList", p);
		return ret;
	}

	@Override
	public String saveSupData(CrmSupInfoDTO p) {
		String ret = "-101";
		if (StringUtil.isBlank(p.getId())) {
			String orgId = this.authService.getUserOrgId(p.getUpdateUser());
			p.setOrgId(orgId);
		}
		ret = this.crudService.saveData(this.crmSupInfoMapper, p);
		return ret;
	}

}
