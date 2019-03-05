package com.guigu.common.info;

import java.util.List;

public class PageVo<T> {
	private List<T> rows;
	private Long total;
	
	public PageVo() {
		// TODO Auto-generated constructor stub
	}

	public PageVo(List<T> rows, Long total) {
		super();
		this.rows = rows;
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PageVo [rows=" + rows + ", total=" + total + "]";
	}
	
}
