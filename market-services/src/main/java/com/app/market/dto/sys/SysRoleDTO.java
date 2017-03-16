package com.app.market.dto.sys;

import java.io.Serializable;

import com.app.market.dao.entity.sys.mybatis.SysRole;

public class SysRoleDTO extends SysRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String authIds;
	private String userId;
	private String roleId;
	private String updateUser;

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAuthIds() {
		return authIds;
	}

	public void setAuthIds(String authIds) {
		this.authIds = authIds;
	}

}
