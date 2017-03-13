package com.app.market.dao.mapper.agent.info;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.agent.AgentPointsChangeDTO;
import com.app.market.dto.user.SysUserDTO;

public interface AgentMapper {

	List<Map<String, String>> getInfoList(@Param("param") SysUserDTO p);

	Integer saveInfoRole(@Param("updateUser") String updateUser, @Param("userId") String userId);

	List<Map<String, String>> getPointsChangeDetail(@Param("param") AgentPointsChangeDTO p);

	List<Map<String, String>> getPointsChangeMemberList(@Param("param") AgentPointsChangeDTO p);

	Integer removePointsChangeDetail(@Param("param") AgentPointsChangeDTO p);

	Integer savePointsChangeDetail(@Param("param") AgentPointsChangeDTO p);

	List<Map<String, String>> getPointChangeList(@Param("param") AgentPointsChangeDTO p);
}
