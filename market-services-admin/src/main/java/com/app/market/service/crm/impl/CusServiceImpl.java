package com.app.market.service.crm.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.mapper.crm.cus.CrmCusMapper;
import com.app.market.dao.mapper.crm.mybatis.CrmCusInfoMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.crm.CrmCusInfoDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.crm.CusService;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.Version;

import jodd.util.StringUtil;

@Service(version = Version.NOW)
public class CusServiceImpl implements CusService {
	@Autowired
	private CrudService crudService;
	@Autowired
	private CrmCusMapper crmCusMapper;
	@Autowired
	private AuthService authService;
	@Autowired
	private CrmCusInfoMapper crmCusInfoMapper;

	@Override
	public PageBean<Map<String, String>> getCusList(CrmCusInfoDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		ret = this.crudService.getListPage(page, this.crmCusMapper, "getCusList", p);
		return ret;
	}

	@Override
	public String saveCusData(CrmCusInfoDTO p) {
		String ret = "-101";
		if (StringUtil.isBlank(p.getId())) {
			String orgId = this.authService.getUserOrgId(p.getUpdateUser());
			p.setOrgId(orgId);
		}
		ret = this.crudService.saveData(this.crmCusInfoMapper, p);
		return ret;
	}

}
