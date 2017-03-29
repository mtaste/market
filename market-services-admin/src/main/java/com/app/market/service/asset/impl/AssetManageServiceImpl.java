package com.app.market.service.asset.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.asset.mybatis.AssetRegister;
import com.app.market.dao.mapper.asset.mybatis.AssetManageMapper;
import com.app.market.dao.mapper.asset.mybatis.AssetRegisterMapper;
import com.app.market.dao.mapper.asset.service.AssetMapper;
import com.app.market.dto.asset.AssetManageDTO;
import com.app.market.dto.asset.AssetRegisterDTO;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.user.SysUserDTO;
import com.app.market.service.asset.AssetManageService;
import com.app.market.service.common.CrudService;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.Version;

import jodd.util.StringUtil;

@Service(version = Version.NOW)
public class AssetManageServiceImpl implements AssetManageService {
	@Autowired
	private CrudService crudService;
	@Autowired
	private AuthService authService;
	@Autowired
	private AssetMapper assetMapper;
	@Autowired
	private AssetManageMapper assetManageMapper;
	@Autowired
	private AssetRegisterMapper assetRegisterMapper;

	@Override
	public PageBean<Map<String, String>> getAssetList(AssetRegisterDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		ret = this.crudService.getListPage(page, this.assetMapper, "getAssetList", p);
		return ret;
	}

	@Override
	public PageBean<Map<String, String>> getAssetUserChooseList(SysUserDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		ret = this.crudService.getListPage(page, this.assetMapper, "getAssetUserChooseList", p);
		return ret;
	}

	@Override
	public String assetLoan(AssetManageDTO p) {
		String[] ss = p.getUserIds().split(";");

		// 几条数据？
		Integer cn = 0, sumQty = 0;
		// 获取总数量，以及列表
		List<AssetManageDTO> list = new ArrayList<AssetManageDTO>();
		for (String s : ss) {
			if (StringUtil.isBlank(s))
				continue;
			AssetManageDTO a = new AssetManageDTO();
			a.setAssetId(p.getId());
			a.setUpdateUser(p.getUpdateUser());
			String[] temp = s.split(",");
			a.setUserId(temp[0]);
			Integer qty = Integer.valueOf(temp[1]);
			sumQty += qty;
			a.setQty(qty);
			a.setStatus("0");
			list.add(a);
		}
		// 检查数量
		AssetRegister re = this.assetRegisterMapper.selectByPrimaryKey(p.getId());
		if (re.getQty() - re.getLoanQty() < sumQty) {
			return "-603";
		}
		// 增加借出记录
		for (AssetManageDTO t : list) {
			this.crudService.saveData(this.assetManageMapper, t);
			cn++;
		}
		// 修改借出总数
		re.setLoanQty(re.getLoanQty() + sumQty);
		this.assetRegisterMapper.updateByPrimaryKey(re);
		cn++;
		// 鎖定借出數據
		return cn.toString();
	}

	@Override
	public PageBean<Map<String, String>> getAssetDetailList(AssetRegisterDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		this.assetMapper.getAssetDetailList(p);
		ret = this.crudService.getListPage(page, this.assetMapper, "getAssetDetailList", p);
		return ret;
	}

}
