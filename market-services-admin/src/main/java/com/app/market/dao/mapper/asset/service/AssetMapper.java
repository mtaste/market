package com.app.market.dao.mapper.asset.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.asset.AssetRegisterDTO;

public interface AssetMapper {

	List<Map<String, String>> getCheckInList(@Param("param") AssetRegisterDTO p);

	Integer deleteCheckInData(@Param("id") String id);

}
