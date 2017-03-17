package com.app.market.service.oa.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.mapper.oa.mybatis.OaNoticeMapper;
import com.app.market.dao.mapper.oa.notice.NoticeMapper;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.oa.OaNoticeDTO;
import com.app.market.service.common.CrudService;
import com.app.market.service.oa.OaNoticeService;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.Version;

import jodd.util.StringUtil;

@Service(version = Version.NOW)
public class OaNoticeServiceImpl implements OaNoticeService {
	@Autowired
	private CrudService crudService;
	@Autowired
	private AuthService authService;
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private OaNoticeMapper oaNoticeMapper;

	@Override
	public PageBean<Map<String, String>> getNoticeList(OaNoticeDTO p, PageDTO page) {
		PageBean<Map<String, String>> ret = null;
		String orgId = this.authService.getUserOrgId(p.getUpdateUser());
		p.setOrgId(orgId);
		ret = this.crudService.getListPage(page, this.noticeMapper, "getNoticeList", p);
		return ret;
	}

	@Override
	public String saveNoticeData(OaNoticeDTO p) {
		String ret = "-101";
		if (StringUtil.isBlank(p.getId())) {
			String orgId = this.authService.getUserOrgId(p.getUpdateUser());
			p.setOrgId(orgId);
			p.setStatus("0");
		}
		ret = this.crudService.saveData(this.oaNoticeMapper, p);
		return ret;
	}

	@Override
	public String appNoticeData(OaNoticeDTO p) {
		Integer cn = this.crudService.appData(this.oaNoticeMapper, p);
		return cn.toString();
	}

	@Override
	public String removeNoticeData(OaNoticeDTO p) {
		Integer cn = this.crudService.removeData(this.noticeMapper, "deleteNoticeData", p.getId());
		return cn.toString();
	}

}
