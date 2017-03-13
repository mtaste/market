package com.app.market.service.user.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.sys.mybatis.SysUser;
import com.app.market.dao.mapper.sys.auth.AuthMapper;
import com.app.market.dao.mapper.sys.mybatis.SysAuthMapper;
import com.app.market.dao.mapper.sys.mybatis.SysUserMapper;
import com.app.market.dao.mapper.sys.user.UserMapper;
import com.app.market.dto.sys.SysApprovalListDTO;
import com.app.market.dto.sys.SysAuthDTO;
import com.app.market.dto.user.SysUserDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.TokenUtil;
import com.app.market.support.util.Version;

@Service(version = Version.NOW)
public class AuthServiceImpl implements AuthService {
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AuthMapper authMapper;
	@Autowired
	private SysAuthMapper sysAuthMapper;
	@Autowired
	private CrudService crudService;

	@Override
	public String authUser(SysUserDTO p) {
		try {
			List<Map<String, String>> list = this.authMapper.getUserNamePW(p.getUserName());
			if (list == null || list.size() <= 0) {
				return "-201";
			}
			Map<String, String> temp = list.get(0);
			if (!temp.get("passWord").equals(p.getPassWord())) {
				return "-202";
			}
			if (!"10".equals(temp.get("status").toString())) {
				return "-204";
			}
			String token = TokenUtil.encryptToken(temp.get("id"));
			return token;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "-101";
	}

	@Override
	public List<Map<String, String>> getUserMenus(String userId) {
		// 获取菜单
		return this.userMapper.getUserMenu(userId);
	}

	@Override
	public List<Map<String, String>> getAuthDefineList() {
		return this.authMapper.getDefineList();
	}

	@Override
	public String saveDefineData(SysAuthDTO p) {
		String ret = this.crudService.saveData(sysAuthMapper, p);
		return ret;
	}

	@Override
	public String removeDefineData(SysAuthDTO p) {
		Integer cn = this.crudService.removeData(authMapper, "deleteDefineData", p.getId());
		return cn.toString();
	}

	@Override
	public List<Map<String, String>> getUserMenuFuncs(String userId, SysAuthDTO p) {
		return this.userMapper.getUserMenuFuncs(userId, p.getId());
	}

	@Override
	public String getUserOrgId(String userId) {
		SysUser user = this.sysUserMapper.selectByPrimaryKey(userId);
		if (user != null) {
			return user.getOrgId();
		}
		return "";
	}

	@Override
	public List<Map<String, String>> getBillAuthList(SysApprovalListDTO p) {
		return this.authMapper.getBillAuthList(p);
	}

	@Override
	public Map<String, String> getUserInfo(String userId) {
		return this.userMapper.getUserInfo(userId);
	}

}
