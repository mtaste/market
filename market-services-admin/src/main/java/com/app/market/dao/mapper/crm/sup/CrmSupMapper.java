package com.app.market.dao.mapper.crm.sup;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.crm.CrmSupInfoDTO;

public interface CrmSupMapper {
	List<Map<String, String>> getSupList(@Param("param") CrmSupInfoDTO p);
}
