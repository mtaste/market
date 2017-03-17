package com.app.market.dto.oa;

import java.io.Serializable;

import com.app.market.dao.entity.oa.mybatis.OaNotice;

public class OaNoticeDTO extends OaNotice implements Serializable {
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
