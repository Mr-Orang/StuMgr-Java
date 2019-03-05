package com.guigu.domain.marketing;

public class Board {
	/**
	 * 
	 * tbo_id VARCHAR2(10) primary key,--编号，
	ts_id VARCHAR2(10),--学生编号，（t_student）
	tdm_id VARCHAR2(10)--宿舍编号（t_dorm）
	 */
	
	private String tbo_id;
	private String ts_id;
	private String tdm_id;
	
	public Board() {
		super();
	}

	public Board(String tbo_id, String ts_id, String tdm_id) {
		super();
		this.tbo_id = tbo_id;
		this.ts_id = ts_id;
		this.tdm_id = tdm_id;
	}

	public String getTbo_id() {
		return tbo_id;
	}

	public void setTbo_id(String tbo_id) {
		this.tbo_id = tbo_id;
	}

	public String getTs_id() {
		return ts_id;
	}

	public void setTs_id(String ts_id) {
		this.ts_id = ts_id;
	}

	public String getTdm_id() {
		return tdm_id;
	}

	public void setTdm_id(String tdm_id) {
		this.tdm_id = tdm_id;
	}

	@Override
	public String toString() {
		return "Board [tbo_id=" + tbo_id + ", ts_id=" + ts_id + ", tdm_id=" + tdm_id + "]";
	}
	
}
