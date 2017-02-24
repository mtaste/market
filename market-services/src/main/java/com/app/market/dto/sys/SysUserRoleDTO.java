package com.app.market.dto.sys;

import java.io.Serializable;

import com.app.market.dao.entity.sys.mybatis.SysUserRole;

public class SysUserRoleDTO extends SysUserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyword;
	private String userIds;

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
