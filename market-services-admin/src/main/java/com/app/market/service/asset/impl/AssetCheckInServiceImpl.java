package com.app.market.service.asset.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.mapper.asset.mybatis.AssetRegisterMapper;
import com.app.market.dao.mapper.asset.service.AssetMapper;
import com.app.market.dto.asset.AssetRegisterDTO;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.service.asset.AssetCheckInService;
import com.app.market.service.common.CrudService;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.Version;

import jodd.util.StringUtil;

@Service(version = Version.NOW)
public class AssetCheckInServiceImpl implements AssetCheckInService {
	@Autowired
	private CrudService crudService;
	@Autowired
	private AuthService authService;
	@Autowired
	private AssetMapper assetMapper;
	@Autowired
	private AssetRegisterMapper assetRegisterMapper;

	@Override
	public PageBean<Map<String, String>> getCheckInList(AssetRegisterDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		ret = this.crudService.getListPage(page, this.assetMapper, "getCheckInList", p);
		return ret;
	}

	@Override
	public String saveCheckInData(AssetRegisterDTO p) {
		String ret = "-101";
		if (StringUtil.isBlank(p.getId())) {
			String orgId = this.authService.getUserOrgId(p.getUpdateUser());
			p.setOrgId(orgId);
			p.setStatus("0");
			p.setLoanQty(0);
		}
		ret = this.crudService.saveData(this.assetRegisterMapper, p);
		return ret;
	}

	@Override
	public String appCheckInData(AssetRegisterDTO p) {
		Integer cn = this.crudService.appData(this.assetRegisterMapper, p);
		return cn.toString();
	}

	@Override
	public String removeCheckInData(AssetRegisterDTO p) {
		Integer cn = this.crudService.removeData(this.assetMapper, "deleteCheckInData", p.getId());
		return cn.toString();
	}

}
