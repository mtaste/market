package com.app.market.service.agent;

import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.user.SysUserDTO;

public interface AgentService {

	PageBean<Map<String, String>> getInfoList(SysUserDTO p, PageDTO page);

	String saveInfoData(SysUserDTO p);

}
