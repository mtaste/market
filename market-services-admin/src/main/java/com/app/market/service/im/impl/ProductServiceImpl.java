package com.app.market.service.im.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.mapper.im.mybatis.ImProductInfoMapper;
import com.app.market.dao.mapper.im.product.ImProductMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.im.ImProductInfoDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.im.ProductService;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.Version;

import jodd.util.StringUtil;

@Service(version = Version.NOW)
public class ProductServiceImpl implements ProductService {
	@Autowired
	private CrudService crudService;
	@Autowired
	private ImProductMapper imProductMapper;
	@Autowired
	private AuthService authService;
	@Autowired
	private ImProductInfoMapper imProductInfoMapper;

	@Override
	public PageBean<Map<String, String>> getList(ImProductInfoDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		ret = this.crudService.getListPage(page, this.imProductMapper, "getList", p);
		return ret;
	}

	@Override
	public String saveData(ImProductInfoDTO p) {
		String ret = "-101";
		if (StringUtil.isBlank(p.getId())) {
			String orgId = this.authService.getUserOrgId(p.getUpdateUser());
			p.setOrgId(orgId);
		}
		ret = this.crudService.saveData(this.imProductInfoMapper, p);
		return ret;
	}

}
