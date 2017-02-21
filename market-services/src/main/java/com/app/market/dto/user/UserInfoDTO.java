package com.app.market.dto.user;

import java.io.Serializable;

import com.app.market.dao.entity.sys.mybatis.SysUser;

public class UserInfoDTO extends SysUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ids;
	private String keyword;
	private String roles;

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
