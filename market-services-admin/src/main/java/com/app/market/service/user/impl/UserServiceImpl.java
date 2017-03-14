package com.app.market.service.user.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.sys.mybatis.SysUser;
import com.app.market.dao.entity.sys.mybatis.SysUserExample;
import com.app.market.dao.mapper.sys.mybatis.SysUserMapper;
import com.app.market.dao.mapper.sys.user.UserMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.user.SysUserDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.user.AuthService;
import com.app.market.service.user.UserService;
import com.app.market.support.util.Version;

import jodd.util.StringUtil;

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
			p.setCreateTime(new Date());
			p.setCreateUser(p.getUserId());
		}
		ret = this.crudService.saveData(this.sysUserMapper, p);
		return ret;
	}

	@Override
	public String removeUserData(SysUserDTO p) {
		Integer cn = this.crudService.removeData(this.userMapper, "deleteUserData", p.getId());
		return cn.toString();
	}

	@Override
	public Map<String, String> getInfo(String userId) {
		return this.userMapper.getInfo(userId);
	}

	@Override
	public String changeInfo(SysUserDTO p) {
		SysUser user = this.sysUserMapper.selectByPrimaryKey(p.getId());
		if (user == null) {
			return "-101";
		}
		user.setAddress(p.getAddress());
		user.setMobile(p.getMobile());
		user.setName(p.getName());
		Integer cn = this.sysUserMapper.updateByPrimaryKey(user);
		return cn.toString();
	}

	@Override
	public String changePassWord(SysUserDTO p) {
		SysUser user = this.sysUserMapper.selectByPrimaryKey(p.getId());
		if (user == null) {
			return "-101";
		}
		if (!p.getPassWord().equals(user.getPassWord())) {
			return "-202";
		}
		user.setPassWord(p.getNewPassWord());
		Integer cn = this.sysUserMapper.updateByPrimaryKey(user);
		return cn.toString();
	}

}
