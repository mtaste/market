package com.app.market.service.report.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.sys.mybatis.SysUser;
import com.app.market.dao.mapper.report.mms.ReportAgentMapper;
import com.app.market.dao.mapper.sys.mybatis.SysUserMapper;
import com.app.market.dto.report.AgentDTO;
import com.app.market.service.report.ReportAgentService;
import com.app.market.support.util.Version;

@Service(version = Version.NOW)
public class ReportAgentServiceImpl implements ReportAgentService {
	@Autowired
	private ReportAgentMapper reportAgentMapper;
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public List<Map<String, String>> getInfo(AgentDTO p) {
		SysUser user = this.sysUserMapper.selectByPrimaryKey(p.getUpdateUser());
		p.setOrgId(user.getOrgId());
		if ("1".equals(user.getUserType())) {
			p.setUpdateUser(null);
		}
		return this.reportAgentMapper.getInfo(p);
	}

}
