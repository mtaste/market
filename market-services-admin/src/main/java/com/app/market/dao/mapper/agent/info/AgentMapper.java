package com.app.market.dao.mapper.agent.info;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.user.SysUserDTO;

public interface AgentMapper {

	List<Map<String, String>> getInfoList(@Param("param") SysUserDTO p);

	Integer saveInfoRole(@Param("updateUser") String updateUser, @Param("userId") String userId);
}
