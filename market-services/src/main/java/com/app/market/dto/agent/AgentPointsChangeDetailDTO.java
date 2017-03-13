package com.app.market.dto.agent;

import java.io.Serializable;

import com.app.market.dao.entity.agent.mybatis.AgentPointsChangeDetail;

public class AgentPointsChangeDetailDTO extends AgentPointsChangeDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String updateUser;

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
