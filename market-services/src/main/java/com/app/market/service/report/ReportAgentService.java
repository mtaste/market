package com.app.market.service.report;

import java.util.List;
import java.util.Map;

import com.app.market.dto.report.AgentDTO;

public interface ReportAgentService {

	List<Map<String, String>> getInfo(AgentDTO p);

}
