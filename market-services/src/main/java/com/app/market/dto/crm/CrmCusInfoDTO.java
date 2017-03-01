package com.app.market.dto.crm;

import java.io.Serializable;

import com.app.market.dao.entity.crm.mybatis.CrmCusInfo;

public class CrmCusInfoDTO extends CrmCusInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyword;
	private String updateUser;

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
