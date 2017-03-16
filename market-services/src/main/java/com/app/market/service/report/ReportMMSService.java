package com.app.market.service.report;

import java.util.List;
import java.util.Map;

import com.app.market.dto.report.MmsDTO;

public interface ReportMMSService {
	/**
	 * 
	 * @param p
	 * @return
	 */
	List<Map<String, String>> getInfo(MmsDTO p);

}
