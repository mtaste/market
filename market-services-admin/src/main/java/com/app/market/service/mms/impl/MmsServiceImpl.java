package com.app.market.service.mms.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.mms.mybatis.MmsPointsChange;
import com.app.market.dao.entity.mms.mybatis.MmsPointsChangeDetail;
import com.app.market.dao.entity.mms.mybatis.MmsPointsChangeDetailExample;
import com.app.market.dao.mapper.mms.info.MmsMapper;
import com.app.market.dao.mapper.mms.mybatis.MmsInfoMapper;
import com.app.market.dao.mapper.mms.mybatis.MmsPointsChangeDetailMapper;
import com.app.market.dao.mapper.mms.mybatis.MmsPointsChangeMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.mms.MmsInfoDTO;
import com.app.market.dto.mms.MmsPointsChangeDTO;
import com.app.market.dto.mms.MmsPointsChangeDetailDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.mms.MmsService;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.Version;

import jodd.util.StringUtil;

@Service(version = Version.NOW)
public class MmsServiceImpl implements MmsService {
	@Autowired
	private CrudService crudService;
	@Autowired
	private AuthService authService;
	@Autowired
	private MmsInfoMapper mmsInfoMapper;
	@Autowired
	private MmsPointsChangeDetailMapper mmsPointsChangeDetailMapper;
	@Autowired
	private MmsPointsChangeMapper mmsPointsChangeMapper;
	@Autowired
	private MmsMapper mmsMapper;

	@Override
	public PageBean<Map<String, String>> getInfoList(MmsInfoDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		ret = this.crudService.getListPage(page, this.mmsMapper, "getInfoList", p);
		return ret;
	}

	@Override
	public String saveInfoData(MmsInfoDTO p) {
		String ret = "-101";
		if (StringUtil.isBlank(p.getId())) {
			String orgId = this.authService.getUserOrgId(p.getUpdateUser());
			p.setOrgId(orgId);
		}
		ret = this.crudService.saveData(this.mmsInfoMapper, p);
		return ret;
	}

	// ==================================变更控制===============================
	@Override
	public PageBean<Map<String, String>> getPointsChangeList(PageDTO page, MmsPointsChangeDTO p) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		ret = this.crudService.getListPage(page, this.mmsMapper, "getPointChangeList", p);
		return ret;
	}

	@Override
	public String savePointsChangeData(MmsPointsChangeDTO p) {
		String ret = "-101";
		// 检查标示是否存在
		if (!StringUtil.isBlank(p.getId())) {
			MmsPointsChange temp = this.mmsPointsChangeMapper.selectByPrimaryKey(p.getId());
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
		ret = this.crudService.saveData(this.mmsPointsChangeMapper, p);
		return ret;
	}

	@Override
	public String appPointsChangeData(MmsPointsChangeDTO p) {
		Integer cn = this.crudService.appData(this.mmsPointsChangeMapper, p);
		return cn.toString();
	}

	@Override
	public String authPointsChangeData(MmsPointsChangeDTO p) {
		Integer cn = this.crudService.authData(this.mmsPointsChangeMapper, p);
		if (cn >= 1 && "2".equals(p.getStatus())) {
			this.mmsMapper.saveMemberPointsChange(p);
		}
		return cn.toString();
	}

	@Override
	public String rejectPointsChangeData(MmsPointsChangeDTO p) {
		Integer cn = this.crudService.rejectData(this.mmsPointsChangeMapper, p);
		return cn.toString();
	}

	@Override
	public PageBean<Map<String, String>> pointsChangeDetail(PageDTO page, MmsPointsChangeDTO p) {
		PageBean<Map<String, String>> ret = null;
		this.mmsMapper.getPointsChangeDetail(p);
		ret = this.crudService.getListPage(page, this.mmsMapper, "getPointsChangeDetail", p);
		return ret;
	}

	@Override
	public PageBean<Map<String, String>> getPointsChangeMemberList(PageDTO page, MmsPointsChangeDTO p) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		ret = this.crudService.getListPage(page, this.mmsMapper, "getPointsChangeMemberList", p);
		return ret;
	}

	@Override
	public String addPointsChangeDetailPoints(MmsPointsChangeDetailDTO p) {
		// ID为产品ID,bill_id为单据ID
		MmsPointsChangeDetailExample ex = new MmsPointsChangeDetailExample();
		ex.createCriteria().andBillIdEqualTo(p.getBillId()).andInfoIdEqualTo(p.getId());
		List<MmsPointsChangeDetail> tList = this.mmsPointsChangeDetailMapper.selectByExample(ex);
		if (tList == null || tList.size() <= 0) {
			return "-101";
		}
		tList.get(0).setPoints(p.getPoints());
		Integer cn = this.mmsPointsChangeDetailMapper.updateByPrimaryKey(tList.get(0));
		return cn.toString();
	}

	@Override
	public String removePointsChangeDetail(MmsPointsChangeDTO p) {
		Integer cn = this.mmsMapper.removePointsChangeDetail(p);
		return cn.toString();
	}

	@Override
	public String addPointsChangeDetail(MmsPointsChangeDTO p) {
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		Integer cn = this.mmsMapper.savePointsChangeDetail(p);
		return cn.toString();
	}

	@Override
	public String removePointsChangeData(MmsPointsChangeDTO p) {
		MmsPointsChange temp = this.mmsPointsChangeMapper.selectByPrimaryKey(p.getId());
		if (temp == null) {
			return "-303";
		}
		if (!"0".equals(temp.getStatus())) {
			return "-303";
		}
		Integer cn = this.mmsPointsChangeMapper.deleteByPrimaryKey(p.getId());
		MmsPointsChangeDetailExample ex = new MmsPointsChangeDetailExample();
		ex.createCriteria().andBillIdEqualTo(p.getId());
		cn += this.mmsPointsChangeDetailMapper.deleteByExample(ex);
		return cn.toString();
	}

}
