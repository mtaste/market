package com.app.market.dto.mms;

import java.io.Serializable;

import com.app.market.dao.entity.mms.mybatis.MmsPointsChange;

public class MmsPointsChangeDTO extends MmsPointsChange implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyword;
	private String updateUser;
	private String selectIds;

	public String getSelectIds() {
		return selectIds;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}

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
