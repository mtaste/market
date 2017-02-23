package com.app.market.service.user.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.mapper.sys.mybatis.SysUserMapper;
import com.app.market.dao.mapper.sys.user.UserMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.user.SysUserDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.user.AuthService;
import com.app.market.service.user.UserService;
import com.app.market.support.util.Version;

@Service(version = Version.NOW)
public class UserServiceImpl implements UserService {
	@Autowired
	private CrudService crudService;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AuthService authService;
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public PageBean<Map<String, String>> getUserList(SysUserDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUserId());
		p.setOrgId(orgId);
		ret = this.crudService.getListPage(page, this.userMapper, "getUserList", p);
		return ret;
	}

	@Override
	public String saveUserData(SysUserDTO p) {
		String ret = "-101";
		String orgId = this.authService.getUserOrgId(p.getUserId());
		p.setOrgId(orgId);
		ret = this.crudService.saveData(this.sysUserMapper, p);
		return ret;
	}

	@Override
	public String removeUserData(SysUserDTO p) {
		Integer cn = this.crudService.removeData(this.userMapper, "deleteUserData", p.getId());
		return cn.toString();
	}

}
