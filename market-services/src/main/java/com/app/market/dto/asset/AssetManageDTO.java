package com.app.market.dto.asset;

import java.io.Serializable;

import com.app.market.dao.entity.asset.mybatis.AssetManage;

public class AssetManageDTO extends AssetManage implements Serializable {
	private static final long serialVersionUID = 1L;
	private String keyword;
	private String updateUser;
	private String userIds;

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
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
