package com.app.market.dao.mapper.oa.attendance;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.oa.OaAttendanceDTO;

public interface AttendanceMapper {
	/**
	 * 获取用户签到信息
	 * 
	 * @param p
	 * @return
	 */
	Map<String, String> getUserTodayInfo(@Param("param") OaAttendanceDTO p);

	List<Map<String, String>> getAttendanceList(@Param("param") OaAttendanceDTO p);

}
