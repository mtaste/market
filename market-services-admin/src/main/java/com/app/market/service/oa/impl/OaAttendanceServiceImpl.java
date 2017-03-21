package com.app.market.service.oa.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.oa.mybatis.OaAttendance;
import com.app.market.dao.mapper.oa.attendance.AttendanceMapper;
import com.app.market.dao.mapper.oa.mybatis.OaAttendanceMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.oa.OaAttendanceDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.oa.OaAttendanceService;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.GUID;
import com.app.market.support.util.Lunar;
import com.app.market.support.util.Version;

@Service(version = Version.NOW)
public class OaAttendanceServiceImpl implements OaAttendanceService {
	@Autowired
	private AttendanceMapper attendanceMapper;
	@Autowired
	private AuthService authService;
	@Autowired
	private CrudService crudService;
	@Autowired
	private OaAttendanceMapper oaAttendanceMapper;

	@Override
	public Map<String, String> getTodayInfo(OaAttendanceDTO p) {
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		p.setUserId(p.getUpdateUser());
		Map<String, String> ret = this.attendanceMapper.getUserTodayInfo(p);
		if (ret == null) {
			ret = new Hashtable<String, String>();
		}
		ret.put("nowTime", String.valueOf(new Date().getTime()));
		Calendar today = Calendar.getInstance();
		Lunar lunar = new Lunar(today);
		StringBuffer sb = new StringBuffer(lunar.cyclical());
		sb.append("年").append(lunar.toString());
		ret.put("oldTime", sb.toString());
		return ret;
	}

	@Override
	public PageBean<Map<String, String>> getAttendanceList(OaAttendanceDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		p.setUserId(p.getUpdateUser());
		this.attendanceMapper.getAttendanceList(p);
		ret = this.crudService.getListPage(page, this.attendanceMapper, "getAttendanceList", p);
		return ret;
	}

	@Override
	public String signIn(String userId) {
		// 签到，
		OaAttendanceDTO p = new OaAttendanceDTO();
		String orgId = this.authService.getUserOrgId(userId);
		p.setOrgId(orgId);
		p.setUserId(userId);
		Map<String, String> ret = this.attendanceMapper.getUserTodayInfo(p);
		if (ret != null) {
			return "-101";
		}
		Date now = new Date();
		p.setBeginTime(now);
		p.setId(GUID.getUUID());
		this.oaAttendanceMapper.insertSelective(p);
		return String.valueOf(now.getTime());
	}

	@Override
	public String signOut(String userId) {
		// 答出
		OaAttendanceDTO p = new OaAttendanceDTO();
		String orgId = this.authService.getUserOrgId(userId);
		p.setOrgId(orgId);
		p.setUserId(userId);
		Map<String, String> ret = this.attendanceMapper.getUserTodayInfo(p);
		if (ret == null) {
			return "-101";
		}
		String id = ret.get("id");
		OaAttendance t = this.oaAttendanceMapper.selectByPrimaryKey(id);
		Date now = new Date();
		t.setEndTime(now);
		this.oaAttendanceMapper.updateByPrimaryKey(t);
		return String.valueOf(now.getTime());
	}

}
