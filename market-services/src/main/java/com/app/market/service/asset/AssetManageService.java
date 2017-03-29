package com.app.market.service.asset;

import java.util.Map;

import com.app.market.dto.asset.AssetManageDTO;
import com.app.market.dto.asset.AssetRegisterDTO;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.user.SysUserDTO;

public interface AssetManageService {

	PageBean<Map<String, String>> getAssetList(AssetRegisterDTO p, PageDTO page);

	/*
	 * 获取用户
	 */
	PageBean<Map<String, String>> getAssetUserChooseList(SysUserDTO p, PageDTO page);

	/**
	 * 借出
	 * 
	 * @param p
	 * @return
	 */
	String assetLoan(AssetManageDTO p);

	PageBean<Map<String, String>> getAssetDetailList(AssetRegisterDTO p, PageDTO page);

}
