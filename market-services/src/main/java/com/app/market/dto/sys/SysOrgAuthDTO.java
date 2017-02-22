package com.app.market.dto.sys;

import java.io.Serializable;

import com.app.market.dao.entity.sys.mybatis.SysOrgAuth;

public class SysOrgAuthDTO extends SysOrgAuth implements Serializable {

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
