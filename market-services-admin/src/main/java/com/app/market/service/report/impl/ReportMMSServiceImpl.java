package com.app.market.service.report.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.sys.mybatis.SysUser;
import com.app.market.dao.mapper.report.mms.ReportMmsMapper;
import com.app.market.dao.mapper.sys.mybatis.SysUserMapper;
import com.app.market.dto.report.MmsDTO;
import com.app.market.service.report.ReportMMSService;
import com.app.market.support.util.Version;

@Service(version = Version.NOW)
public class ReportMMSServiceImpl implements ReportMMSService {
	@Autowired
	private ReportMmsMapper reportMmsMapper;
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public List<Map<String, String>> getInfo(MmsDTO p) {
		SysUser user = this.sysUserMapper.selectByPrimaryKey(p.getUpdateUser());
		p.setOrgId(user.getOrgId());
		if ("1".equals(user.getUserType())) {
			p.setUpdateUser(null);
		}
		return this.reportMmsMapper.getInfo(p);
	}

}
