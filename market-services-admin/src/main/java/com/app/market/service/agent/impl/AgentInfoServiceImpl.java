package com.app.market.service.agent.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.agent.mybatis.AgentPointsChange;
import com.app.market.dao.entity.agent.mybatis.AgentPointsChangeDetail;
import com.app.market.dao.entity.agent.mybatis.AgentPointsChangeDetailExample;
import com.app.market.dao.entity.sys.mybatis.SysUser;
import com.app.market.dao.entity.sys.mybatis.SysUserExample;
import com.app.market.dao.mapper.agent.info.AgentMapper;
import com.app.market.dao.mapper.agent.mybatis.AgentPointsChangeDetailMapper;
import com.app.market.dao.mapper.agent.mybatis.AgentPointsChangeMapper;
import com.app.market.dao.mapper.sys.mybatis.SysUserMapper;
import com.app.market.dto.agent.AgentPointsChangeDTO;
import com.app.market.dto.agent.AgentPointsChangeDetailDTO;
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
	@Autowired
	private AgentPointsChangeMapper agentPointsChangeMapper;
	@Autowired
	private AgentPointsChangeDetailMapper agentPointsChangeDetailMapper;

	@Override
	public PageBean<Map<String, String>> getInfoList(SysUserDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		SysUser user = this.sysUserMapper.selectByPrimaryKey(p.getUpdateUser());
		p.setOrgId(user.getOrgId());
		if ("1".equals(user.getUserType())) {
			p.setUpdateUser(null);
		}
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

	// ==================================变更控制===============================
	@Override
	public PageBean<Map<String, String>> getPointsChangeList(PageDTO page, AgentPointsChangeDTO p) {
		PageBean<Map<String, String>> ret = null;
		SysUser user = this.sysUserMapper.selectByPrimaryKey(p.getUpdateUser());
		p.setOrgId(user.getOrgId());
		ret = this.crudService.getListPage(page, this.agentMapper, "getPointChangeList", p);
		return ret;
	}

	@Override
	public String savePointsChangeData(AgentPointsChangeDTO p) {
		String ret = "-101";
		// 检查标示是否存在
		if (!StringUtil.isBlank(p.getId())) {
			AgentPointsChange temp = this.agentPointsChangeMapper.selectByPrimaryKey(p.getId());
			if (temp == null) {
				return "-304";
			}
			if (!"0".equals(temp.getStatus()) && !"99".equals(temp.getStatus())) {
				return "-304";
			}
		}
		p.setStatus("0");
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		ret = this.crudService.saveData(this.agentPointsChangeMapper, p);
		return ret;
	}

	@Override
	public String removePointsChangeData(AgentPointsChangeDTO p) {
		AgentPointsChange temp = this.agentPointsChangeMapper.selectByPrimaryKey(p.getId());
		if (temp == null) {
			return "-303";
		}
		if (!"0".equals(temp.getStatus())) {
			return "-303";
		}
		Integer cn = this.agentPointsChangeMapper.deleteByPrimaryKey(p.getId());
		AgentPointsChangeDetailExample ex = new AgentPointsChangeDetailExample();
		ex.createCriteria().andBillIdEqualTo(p.getId());
		cn += this.agentPointsChangeDetailMapper.deleteByExample(ex);
		return cn.toString();
	}

	@Override
	public String appPointsChangeData(AgentPointsChangeDTO p) {
		// 判断提交的代理积分是否足够
		SysUser user = this.sysUserMapper.selectByPrimaryKey(p.getUpdateUser());
		if ("2".equals(user.getUserType())) {
			Integer billCountPoints = this.agentMapper.getPointsByBillId(p.getId());
			if (billCountPoints == null)
				billCountPoints = 0;
			if (user.getPoints() == null)
				user.setPoints(0);
			if (user.getPoints() < billCountPoints) {
				return "-601";
			}
			// 扣除积分
			user.setPoints(user.getPoints() - billCountPoints);
			this.sysUserMapper.updateByPrimaryKey(user);
		}
		Integer cn = this.crudService.appData(this.agentPointsChangeMapper, p);
		this.agentMapper.addAgentPointsByBill(p);
		return cn.toString();
	}

	@Override
	public PageBean<Map<String, String>> pointsChangeDetail(PageDTO page, AgentPointsChangeDTO p) {
		PageBean<Map<String, String>> ret = null;
		ret = this.crudService.getListPage(page, this.agentMapper, "getPointsChangeDetail", p);
		return ret;
	}

	@Override
	public PageBean<Map<String, String>> getPointsChangeMemberList(PageDTO page, AgentPointsChangeDTO p) {
		PageBean<Map<String, String>> ret = null;
		SysUser user = this.sysUserMapper.selectByPrimaryKey(p.getUpdateUser());
		p.setOrgId(user.getOrgId());
		if ("1".equals(user.getUserType())) {
			p.setUpdateUser(null);
		}
		this.agentMapper.getPointsChangeMemberList(p);
		ret = this.crudService.getListPage(page, this.agentMapper, "getPointsChangeMemberList", p);
		return ret;
	}

	@Override
	public String addPointsChangeDetailPoints(AgentPointsChangeDetailDTO p) {
		// ID为产品ID,bill_id为单据ID
		AgentPointsChangeDetailExample ex = new AgentPointsChangeDetailExample();
		ex.createCriteria().andBillIdEqualTo(p.getBillId()).andUserIdEqualTo(p.getId());
		List<AgentPointsChangeDetail> tList = this.agentPointsChangeDetailMapper.selectByExample(ex);
		if (tList == null || tList.size() <= 0) {
			return "-101";
		}
		tList.get(0).setPoints(p.getPoints());
		Integer cn = this.agentPointsChangeDetailMapper.updateByPrimaryKey(tList.get(0));
		return cn.toString();
	}

	@Override
	public String removePointsChangeDetail(AgentPointsChangeDTO p) {
		Integer cn = this.agentMapper.removePointsChangeDetail(p);
		return cn.toString();
	}

	@Override
	public String addPointsChangeDetail(AgentPointsChangeDTO p) {
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		Integer cn = this.agentMapper.savePointsChangeDetail(p);
		return cn.toString();
	}

}
