package com.app.market.dto.im;

import java.io.Serializable;

import com.app.market.dao.entity.im.mybatis.ImProductChange;

public class ImProductChangeDTO extends ImProductChange implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyword;
	private String updateUser;
	private String productIds;

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
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
