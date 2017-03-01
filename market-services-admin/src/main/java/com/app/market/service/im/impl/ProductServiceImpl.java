package com.app.market.service.im.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.im.mybatis.ImProductChange;
import com.app.market.dao.entity.im.mybatis.ImProductChangeDetailExample;
import com.app.market.dao.mapper.im.mybatis.ImProductChangeDetailMapper;
import com.app.market.dao.mapper.im.mybatis.ImProductChangeMapper;
import com.app.market.dao.mapper.im.mybatis.ImProductInfoMapper;
import com.app.market.dao.mapper.im.product.ImProductMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.im.ImProductChangeDTO;
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
	@Autowired
	private ImProductChangeMapper imProductChangeMapper;
	@Autowired
	private ImProductChangeDetailMapper imProductChangeDetailMapper;

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
	// ==================================变更控制===============================

	@Override
	public String removeChangeData(ImProductChangeDTO p) {
		ImProductChange temp = this.imProductChangeMapper.selectByPrimaryKey(p.getId());
		if (temp == null) {
			return "-303";
		}
		if (!"0".equals(temp.getStatus())) {
			return "-303";
		}
		Integer cn = this.imProductChangeMapper.deleteByPrimaryKey(p.getId());
		ImProductChangeDetailExample ex = new ImProductChangeDetailExample();
		ex.createCriteria().andBillIdEqualTo(p.getId());
		cn += this.imProductChangeDetailMapper.deleteByExample(ex);
		return cn.toString();
	}

	@Override
	public String rejectChangeData(ImProductChangeDTO p) {
		Integer cn = this.crudService.rejectData(this.imProductChangeMapper, p);
		return cn.toString();
	}

	@Override
	public PageBean<Map<String, String>> getChangeList(PageDTO page, ImProductChangeDTO p) {
		PageBean<Map<String, String>> ret = null;
		ret = this.crudService.getListPage(page, this.imProductMapper, "getChangeList", p);
		return ret;
	}

	@Override
	public String saveChangeData(ImProductChangeDTO p) {
		String ret = "-101";
		// 检查标示是否存在
		if (!StringUtil.isBlank(p.getId())) {
			ImProductChange temp = this.imProductChangeMapper.selectByPrimaryKey(p.getId());
			if (temp == null) {
				return "-304";
			}
			if (!"0".equals(temp.getStatus()) && !"99".equals(temp.getStatus())) {
				return "-304";
			}
		}
		p.setStatus("0");
		ret = this.crudService.saveData(this.imProductChangeMapper, p);
		// 保存授权明细
		this.imProductMapper.saveChangeDetail(p.getId(), p.getProductIds());
		return ret;
	}

	@Override
	public String appChangeData(ImProductChangeDTO p) {
		Integer cn = this.crudService.appData(this.imProductChangeMapper, p);
		return cn.toString();
	}

	@Override
	public String authChangeData(ImProductChangeDTO p) {
		Integer cn = this.crudService.authData(this.imProductChangeMapper, p);
		if (cn >= 1 && "2".equals(p.getStatus())) {
			// TODO 变更库存
		}
		return cn.toString();
	}

}
