package com.app.market.service.agent;

import java.util.Map;

import com.app.market.dto.agent.AgentPointsChangeDTO;
import com.app.market.dto.agent.AgentPointsChangeDetailDTO;
import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.user.SysUserDTO;

public interface AgentService {

	PageBean<Map<String, String>> getInfoList(SysUserDTO p, PageDTO page);

	String saveInfoData(SysUserDTO p);

	PageBean<Map<String, String>> getPointsChangeList(PageDTO page, AgentPointsChangeDTO p);

	String savePointsChangeData(AgentPointsChangeDTO p);

	String removePointsChangeData(AgentPointsChangeDTO p);

	String appPointsChangeData(AgentPointsChangeDTO p);

	PageBean<Map<String, String>> pointsChangeDetail(PageDTO page, AgentPointsChangeDTO p);

	PageBean<Map<String, String>> getPointsChangeMemberList(PageDTO page, AgentPointsChangeDTO p);

	String addPointsChangeDetailPoints(AgentPointsChangeDetailDTO p);

	String removePointsChangeDetail(AgentPointsChangeDTO p);

	String addPointsChangeDetail(AgentPointsChangeDTO p);

}
