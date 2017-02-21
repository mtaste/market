package com.app.market.dto.common;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;

public class PageBean<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long total; // 总记录数
	private List<T> rows; // 结果集

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public PageBean(List<T> list) {
		if (list instanceof Page) {
			Page<T> page = (Page<T>) list;
			this.total = page.getTotal();
			this.rows = page;
		} else if (list != null) {
			this.total = list.size();
			this.rows = list;
		}
	}
}
