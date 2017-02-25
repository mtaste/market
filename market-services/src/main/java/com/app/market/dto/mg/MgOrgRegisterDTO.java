package com.app.market.dto.mg;

import java.io.Serializable;

import com.app.market.dao.entity.sys.mybatis.MgOrgRegister;

public class MgOrgRegisterDTO extends MgOrgRegister implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
