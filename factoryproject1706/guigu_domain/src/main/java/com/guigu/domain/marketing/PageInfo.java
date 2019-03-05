package com.guigu.domain.marketing;

import java.util.List;

/**
 * @author Administrator
 *
 */
public class PageInfo {
	private long total;
	private List rows;

	public PageInfo() {
		super();
	}

	public PageInfo(long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageInfo [total=" + total + ", rows=" + rows + "]";
	}


}
