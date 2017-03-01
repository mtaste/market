package com.app.market.dao.mapper.crm.cus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.crm.CrmCusInfoDTO;

public interface CrmCusMapper {
	List<Map<String, String>> getCusList(@Param("param") CrmCusInfoDTO p);
}
