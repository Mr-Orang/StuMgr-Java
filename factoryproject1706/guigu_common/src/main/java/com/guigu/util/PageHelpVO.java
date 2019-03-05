package com.guigu.util;

import java.util.List;

public class PageHelpVO {
	private List rows;
	private Long total;
	public PageHelpVO() {
		super();
	}
	public PageHelpVO(List rows, Long total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	
}
