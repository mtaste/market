package com.app.market.dto.im;

import java.io.Serializable;

import com.app.market.dao.entity.im.mybatis.ImProductChangeDetail;

public class ImProductChangeDetailDTO extends ImProductChangeDetail implements Serializable {

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
