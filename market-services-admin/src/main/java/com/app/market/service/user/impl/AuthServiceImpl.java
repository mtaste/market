package com.app.market.service.user.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.sys.mybatis.SysAuth;
import com.app.market.dao.entity.sys.mybatis.SysUser;
import com.app.market.dao.entity.sys.mybatis.SysUserExample;
import com.app.market.dao.mapper.sys.auth.AuthMapper;
import com.app.market.dao.mapper.sys.mybatis.SysAuthMapper;
import com.app.market.dao.mapper.sys.mybatis.SysUserMapper;
import com.app.market.dao.mapper.sys.user.UserMapper;
import com.app.market.dto.sys.SysAuthDTO;
import com.app.market.dto.user.UserInfoDTO;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.DTOUtil;
import com.app.market.support.util.GUID;
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

	@Override
	public String authUser(UserInfoDTO p) {
		try {
			SysUserExample ex = new SysUserExample();
			ex.createCriteria().andUserNameEqualTo(p.getUserName());
			List<SysUser> list = sysUserMapper.selectByExample(ex);
			if (list == null || list.size() <= 0) {
				return "-201";
			}
			SysUser temp = list.get(0);
			if (!temp.getPassWord().equals(p.getPassWord())) {
				return "-202";
			}
			String token = TokenUtil.encryptToken("userName");
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
		String ret = "-101";
		if (p == null) {
			return ret;
		}
		if (StringUtils.isBlank(p.getId())) {
			// 增加权限定义数据
			ret = this.addAuthDefine(p);
		} else {
			// 更新权限定义数据
			ret = this.updateAuthDefine(p);
		}
		return ret;
	}

	/**
	 * 更新权限定义的数据
	 * 
	 * @param p
	 * @return
	 */
	private String updateAuthDefine(SysAuthDTO p) {
		SysAuth t = this.sysAuthMapper.selectByPrimaryKey(p.getId());
		DTOUtil.copyPropertiesIgnoreNull(p, t);
		int cn = this.sysAuthMapper.updateByPrimaryKey(p);
		if (cn <= 0)
			return "-101";
		return p.getId();
	}

	/**
	 * 增加数据
	 * 
	 * @param p
	 * @return
	 */
	private String addAuthDefine(SysAuthDTO p) {
		p.setId(GUID.getUUID());
		p.setCreateTime(new Date());
		int cn = this.sysAuthMapper.insertSelective(p);
		if (cn <= 0)
			return "-101";
		return p.getId();
	}

	@Override
	public String removeDefineData(SysAuthDTO p) {
		if (StringUtils.isBlank(p.getId())) {
			return "-101";
		}
		Integer cn = this.authMapper.deleteDefineData(p.getId());
		return cn.toString();
	}

	@Override
	public List<Map<String, String>> getUserMenuFuncs(String userId, SysAuthDTO p) {
		return this.userMapper.getUserMenuFuncs(userId, p.getId());
	}

}
