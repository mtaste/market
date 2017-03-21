package com.app.market.service.oa;

import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.oa.OaAttendanceDTO;

public interface OaAttendanceService {

	Map<String, String> getTodayInfo(OaAttendanceDTO p);

	PageBean<Map<String, String>> getAttendanceList(OaAttendanceDTO p, PageDTO page);

	String signIn(String userId);

	String signOut(String userId);

}
