package com.app.market.service.agent.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.sys.mybatis.SysUser;
import com.app.market.dao.entity.sys.mybatis.SysUserExample;
import com.app.market.dao.mapper.agent.info.AgentMapper;
import com.app.market.dao.mapper.sys.mybatis.SysUserMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.user.SysUserDTO;
import com.app.market.service.agent.AgentService;
import com.app.market.service.common.CrudService;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.Version;

import jodd.util.StringUtil;

@Service(version = Version.NOW)
public class AgentInfoServiceImpl implements AgentService {
	@Autowired
	private CrudService crudService;
	@Autowired
	private AuthService authService;
	@Autowired
	private AgentMapper agentMapper;
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public PageBean<Map<String, String>> getInfoList(SysUserDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		ret = this.crudService.getListPage(page, this.agentMapper, "getInfoList", p);
		return ret;
	}

	@Override
	public String saveInfoData(SysUserDTO p) {
		String ret = "-101";
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		// 同一个机构,用户名不能相同
		SysUserExample ex = new SysUserExample();
		ex.createCriteria().andUserNameEqualTo(p.getUserName()).andOrgIdEqualTo(orgId);
		List<SysUser> list = sysUserMapper.selectByExample(ex);
		if (list != null && list.size() > 0) {
			if (!list.get(0).getId().equals(p.getId())) {
				return "-203";
			}
		}
		if (StringUtil.isBlank(p.getId())) {
			p.setUserType("2");// 供应商
			p.setCreateTime(new Date());
			p.setCreateUser(p.getUpdateUser());
			p.setOrgId(orgId);
		}
		ret = this.crudService.saveData(this.sysUserMapper, p);
		// 保存成功后,给角色赋予角色,与创建人一样的角色
		this.agentMapper.saveInfoRole(p.getUpdateUser(), p.getId());
		return ret;
	}

}
