package com.app.market.dto.sys;

import java.io.Serializable;

import com.app.market.dao.entity.sys.mybatis.SysAuth;

public class SysAuthDTO extends SysAuth implements Serializable {

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
