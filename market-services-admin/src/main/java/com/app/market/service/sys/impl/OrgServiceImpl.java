package com.app.market.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.mapper.sys.mybatis.SysDeptMapper;
import com.app.market.dao.mapper.sys.mybatis.SysOrgMapper;
import com.app.market.dao.mapper.sys.mybatis.SysRoleMapper;
import com.app.market.dao.mapper.sys.org.OrgMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.sys.SysDeptDTO;
import com.app.market.dto.sys.SysOrgAuthDTO;
import com.app.market.dto.sys.SysOrgDTO;
import com.app.market.dto.sys.SysRoleDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.sys.OrgService;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.Version;

@Service(version = Version.NOW)
public class OrgServiceImpl implements OrgService {
	@Autowired
	private OrgMapper orgMapper;
	@Autowired
	private SysOrgMapper sysOrgMapper;
	@Autowired
	private SysDeptMapper sysDeptMapper;
	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private CrudService crudService;
	@Autowired
	private AuthService authService;

	@Override
	public PageBean<Map<String, String>> getOrgList(PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		ret = this.crudService.getListPage(page, this.orgMapper, "getOrgList");
		return ret;
	}

	@Override
	public String saveOrgData(SysOrgDTO p) {
		String ret = "-101";
		ret = this.crudService.saveData(this.sysOrgMapper, p);
		return ret;
	}

	@Override
	public String removeOrgData(SysOrgDTO p) {
		Integer cn = this.crudService.removeData(this.orgMapper, "deleteOrgData", p.getId());
		return cn.toString();
	}

	@Override
	public List<Map<String, String>> getOrgAuthList(SysOrgAuthDTO p) {
		return orgMapper.getOrgAuthList(p.getOrgId());
	}

	@Override
	public String saveOrgAuth(SysOrgAuthDTO p) {
		Integer ret = this.orgMapper.saveOrgAuth(p);
		return ret.toString();
	}

	@Override
	public List<Map<String, String>> getDeptList(String userId) {
		List<Map<String, String>> ret = this.crudService.getList(this.orgMapper, "getDeptList", userId);
		return ret;
	}

	@Override
	public String saveDeptData(SysDeptDTO p, String userId) {
		String orgId = this.authService.getUserOrgId(userId);
		p.setOrgId(orgId);
		String ret = "-101";
		ret = this.crudService.saveData(this.sysDeptMapper, p);
		return ret;
	}

	@Override
	public String removeDeptData(SysDeptDTO p) {
		Integer cn = this.crudService.removeData(this.orgMapper, "deleteDeptData", p.getId());
		return cn.toString();
	}

	@Override
	public PageBean<Map<String, String>> getDeptRoleList(PageDTO page, SysRoleDTO p) {
		PageBean<Map<String, String>> ret = null;
		ret = this.crudService.getListPage(page, this.orgMapper, "getDeptRoleList", p.getDeptId());
		return ret;
	}

	@Override
	public String saveDeptRoleData(SysRoleDTO p, String userId) {
		String ret = "-101";
		ret = this.crudService.saveData(this.sysRoleMapper, p);
		return ret;
	}

	@Override
	public String removeDeptRoleData(SysRoleDTO p, String userId) {
		Integer cn = this.crudService.removeData(this.orgMapper, "deleteDeptRoleData", p.getId());
		return cn.toString();
	}

}
