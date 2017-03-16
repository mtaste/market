package com.app.market.dao.mapper.report.mms;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.report.AgentDTO;

public interface ReportAgentMapper {

	List<Map<String, String>> getInfo(@Param("param") AgentDTO p);
}
