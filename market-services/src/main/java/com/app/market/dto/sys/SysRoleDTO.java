package com.app.market.dto.sys;

import java.io.Serializable;

import com.app.market.dao.entity.sys.mybatis.SysRole;

public class SysRoleDTO extends SysRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String authIds;

	public String getAuthIds() {
		return authIds;
	}

	public void setAuthIds(String authIds) {
		this.authIds = authIds;
	}

}
