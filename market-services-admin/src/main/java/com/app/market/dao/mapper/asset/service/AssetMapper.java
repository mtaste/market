package com.app.market.dao.mapper.asset.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.asset.AssetRegisterDTO;
import com.app.market.dto.user.SysUserDTO;

public interface AssetMapper {

	List<Map<String, String>> getCheckInList(@Param("param") AssetRegisterDTO p);

	Integer deleteCheckInData(@Param("id") String id);

	List<Map<String, String>> getAssetList(@Param("param") AssetRegisterDTO p);

	List<Map<String, String>> getAssetUserChooseList(@Param("param") SysUserDTO p);

	List<Map<String, String>> getAssetDetailList(@Param("param") AssetRegisterDTO p);

}
