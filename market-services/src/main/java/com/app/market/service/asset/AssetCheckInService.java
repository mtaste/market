package com.app.market.service.asset;

import java.util.Map;

import com.app.market.dto.asset.AssetRegisterDTO;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;

public interface AssetCheckInService {

	PageBean<Map<String, String>> getCheckInList(AssetRegisterDTO p, PageDTO page);

	String saveCheckInData(AssetRegisterDTO p);

	String appCheckInData(AssetRegisterDTO p);

	String removeCheckInData(AssetRegisterDTO p);

}
