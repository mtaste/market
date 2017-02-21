package com.app.market.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.sys.mybatis.SysOrg;
import com.app.market.dao.mapper.sys.mybatis.SysOrgMapper;
import com.app.market.dao.mapper.sys.org.OrgMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.sys.SysOrgDTO;
import com.app.market.service.sys.OrgService;
import com.app.market.support.util.DTOUtil;
import com.app.market.support.util.GUID;
import com.app.market.support.util.Version;
import com.github.pagehelper.PageHelper;

@Service(version = Version.NOW)
public class OrgServiceImpl implements OrgService {
	@Autowired
	private OrgMapper orgMapper;
	@Autowired
	private SysOrgMapper sysOrgMapper;

	@Override
	public PageBean<Map<String, String>> getOrgList(PageDTO page) {
		if (page != null) {
			PageHelper.startPage(page.getPage(), page.getRows());
		}
		List<Map<String, String>> ret = this.orgMapper.getOrgList();
		return new PageBean<Map<String, String>>(ret);
	}

	@Override
	public String saveOrgData(SysOrgDTO p) {
		String ret = "-101";
		if (p == null) {
			return ret;
		}
		if (StringUtils.isBlank(p.getId())) {
			// 增加权数据
			ret = this.addOrgInfo(p);
		} else {
			// 更新数据
			ret = this.updateOrgInfo(p);
		}
		return ret;
	}

	private String updateOrgInfo(SysOrgDTO p) {
		SysOrg t = this.sysOrgMapper.selectByPrimaryKey(p.getId());
		DTOUtil.copyPropertiesIgnoreNull(p, t);
		int cn = this.sysOrgMapper.updateByPrimaryKey(p);
		if (cn <= 0)
			return "-101";
		return p.getId();
	}

	private String addOrgInfo(SysOrgDTO p) {
		p.setId(GUID.getUUID());
		int cn = this.sysOrgMapper.insertSelective(p);
		if (cn <= 0)
			return "-101";
		return p.getId();
	}

	@Override
	public String removeOrgData(SysOrgDTO p) {
		if (StringUtils.isBlank(p.getId())) {
			return "-101";
		}
		Integer cn = this.sysOrgMapper.deleteByPrimaryKey(p.getId());
		return cn.toString();
	}

}
