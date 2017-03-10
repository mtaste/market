package com.app.market.dto.mms;

import java.io.Serializable;

import com.app.market.dao.entity.mms.mybatis.MmsPointsChangeDetail;

public class MmsPointsChangeDetailDTO extends MmsPointsChangeDetail implements Serializable {
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
