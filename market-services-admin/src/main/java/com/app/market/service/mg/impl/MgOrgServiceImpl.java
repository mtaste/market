package com.app.market.service.mg.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.sys.mybatis.MgOrgAuth;
import com.app.market.dao.entity.sys.mybatis.MgOrgRegister;
import com.app.market.dao.entity.sys.mybatis.MgOrgRegisterExample;
import com.app.market.dao.entity.sys.mybatis.SysOrg;
import com.app.market.dao.mapper.mg.org.MgOrgMapper;
import com.app.market.dao.mapper.sys.mybatis.MgOrgAuthMapper;
import com.app.market.dao.mapper.sys.mybatis.MgOrgRegisterMapper;
import com.app.market.dao.mapper.sys.mybatis.SysOrgMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.mg.MgOrgAuthDTO;
import com.app.market.dto.mg.MgOrgRegisterDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.mg.MgOrgService;
import com.app.market.support.util.DTOUtil;
import com.app.market.support.util.GUID;
import com.app.market.support.util.Version;

import jodd.util.StringUtil;

@Service(version = Version.NOW)
public class MgOrgServiceImpl implements MgOrgService {
	@Autowired
	private CrudService crudService;
	@Autowired
	private MgOrgMapper mgOrgMapper;
	@Autowired
	private MgOrgRegisterMapper mgOrgRegisterMapper;
	@Autowired
	private SysOrgMapper sysOrgMapper;
	@Autowired
	private MgOrgAuthMapper mgOrgAuthMapper;

	@Override
	public PageBean<Map<String, String>> getOrgList(PageDTO page, MgOrgRegisterDTO p) {
		PageBean<Map<String, String>> ret = null;
		ret = this.crudService.getListPage(page, this.mgOrgMapper, "getRegisterOrgList", p);
		return ret;
	}

	@Override
	public String saveOrgData(MgOrgRegisterDTO p) {
		String ret = "-101";
		// 检查标示是否存在
		MgOrgRegisterExample ex = new MgOrgRegisterExample();
		ex.createCriteria().andFlagEqualTo(p.getFlag()).andIdNotEqualTo(p.getId());
		List<MgOrgRegister> list = this.mgOrgRegisterMapper.selectByExample(ex);
		if (list.size() >= 1) {
			return "-306";
		}
		if (StringUtil.isBlank(p.getId())) {
			p.setCreateUser(p.getUpdateUser());
		} else {
			MgOrgRegister temp = this.mgOrgRegisterMapper.selectByPrimaryKey(p.getId());
			if (temp == null) {
				return "-304";
			}
			if (!"0".equals(temp.getStatus()) && !"99".equals(temp.getStatus())) {
				return "-304";
			}
		}
		p.setStatus("0");
		ret = this.crudService.saveData(this.mgOrgRegisterMapper, p);
		return ret;
	}

	@Override
	public String removeOrgData(MgOrgRegisterDTO p) {
		MgOrgRegister temp = this.mgOrgRegisterMapper.selectByPrimaryKey(p.getId());
		if (temp == null) {
			return "-303";
		}
		if (!"0".equals(temp.getStatus())) {
			return "-303";
		}
		Integer cn = this.mgOrgRegisterMapper.deleteByPrimaryKey(p.getId());
		return cn.toString();
	}

	@Override
	public String appRegisterData(MgOrgRegisterDTO p) {
		Integer cn = this.crudService.appData(this.mgOrgRegisterMapper, p);
		return cn.toString();
	}

	@Override
	public String authRegisterData(MgOrgRegisterDTO p) {
		Integer cn = this.crudService.authData(this.mgOrgRegisterMapper, p);
		if (cn >= 1 && "2".equals(p.getStatus())) {
			SysOrg org = new SysOrg();
			DTOUtil.copyPropertiesIgnoreNull(p, org);
			org.setId(GUID.getUUID());
			org.setFlag(p.getFlag());
			org.setName(p.getName());
			sysOrgMapper.insertSelective(org);
			// 增加管理账户
			this.mgOrgMapper.initOrgAdminUser(org.getId());
		}
		return cn.toString();
	}

	@Override
	public String rejectRegisterData(MgOrgRegisterDTO p) {
		Integer cn = this.crudService.rejectData(this.mgOrgRegisterMapper, p);
		return cn.toString();
	}

	@Override
	public PageBean<Map<String, String>> getOrgAuthBillList(PageDTO page, MgOrgAuthDTO p) {
		PageBean<Map<String, String>> ret = null;
		ret = this.crudService.getListPage(page, this.mgOrgMapper, "getOrgAuthBillList", p);
		return ret;
	}

	@Override
	public String saveOrgAuthBillData(MgOrgAuthDTO p) {
		String ret = "-101";
		// 检查标示是否存在
		if (!StringUtil.isBlank(p.getId())) {
			MgOrgAuth temp = this.mgOrgAuthMapper.selectByPrimaryKey(p.getId());
			if (temp == null) {
				return "-304";
			}
			if (!"0".equals(temp.getStatus()) && !"99".equals(temp.getStatus())) {
				return "-304";
			}
		}
		p.setStatus("0");
		ret = this.crudService.saveData(this.mgOrgAuthMapper, p);
		// 保存授权明细
		this.mgOrgMapper.saveBillAuths(p.getId(), p.getAuthIds());
		return ret;
	}

	@Override
	public String appAuthBillData(MgOrgAuthDTO p) {
		Integer cn = this.crudService.appData(this.mgOrgAuthMapper, p);
		return cn.toString();
	}

	@Override
	public String authAuthBillData(MgOrgAuthDTO p) {
		Integer cn = this.crudService.authData(this.mgOrgAuthMapper, p);
		if (cn >= 1 && "2".equals(p.getStatus())) {
			if ("1".equals(p.getAuthType())) {
				this.mgOrgMapper.addOrgAuthByBill(p.getId());
			} else if ("-1".equals(p.getAuthType())) {
				this.mgOrgMapper.delOrgAuthByBill(p.getId());
			}
		}
		return cn.toString();
	}

	@Override
	public String rejectAuthBillData(MgOrgAuthDTO p) {
		Integer cn = this.crudService.rejectData(this.mgOrgAuthMapper, p);
		return cn.toString();
	}

	@Override
	public String removeOrgAuthBillData(MgOrgAuthDTO p) {
		MgOrgAuth temp = this.mgOrgAuthMapper.selectByPrimaryKey(p.getId());
		if (temp == null) {
			return "-303";
		}
		if (!"0".equals(temp.getStatus())) {
			return "-303";
		}
		Integer cn = this.mgOrgAuthMapper.deleteByPrimaryKey(p.getId());
		return cn.toString();
	}

	@Override
	public List<Map<String, String>> getAuthBillAuthList(MgOrgAuthDTO p) {
		return this.mgOrgMapper.getAuthBillAuthList();
	}

	@Override
	public PageBean<Map<String, String>> getOrgAuthOrgList(PageDTO page, MgOrgAuthDTO p) {
		PageBean<Map<String, String>> ret = null;
		ret = this.crudService.getListPage(page, this.mgOrgMapper, "getOrgAuthOrgList", p);
		return ret;
	}

	@Override
	public List<Map<String, String>> getAuthBillDetail(MgOrgAuthDTO p) {
		return this.mgOrgMapper.getAuthBillDetail(p);
	}

	@Override
	public List<Map<String, String>> getAuths(MgOrgAuthDTO p) {
		return this.mgOrgMapper.getAuths(p);
	}
}
