package com.guigu.domain.marketing;

public class Level {
	/**
	 * tl_id VARCHAR2(10) primary key,--阶段id
	tl_name VARCHAR2(25),--阶段名称
	tl_status VARCHAR2(10)--有效状态
	 * 
	 */
	
	private String tl_id;
	private String tl_name;
	private String tl_status;
	
	public Level() {
		super();
	}

	public Level(String tl_id, String tl_name, String tl_status) {
		super();
		this.tl_id = tl_id;
		this.tl_name = tl_name;
		this.tl_status = tl_status;
	}

	public String getTl_id() {
		return tl_id;
	}

	public void setTl_id(String tl_id) {
		this.tl_id = tl_id;
	}

	public String getTl_name() {
		return tl_name;
	}

	public void setTl_name(String tl_name) {
		this.tl_name = tl_name;
	}

	public String getTl_status() {
		return tl_status;
	}

	public void setTl_status(String tl_status) {
		this.tl_status = tl_status;
	}

	@Override
	public String toString() {
		return "Level [tl_id=" + tl_id + ", tl_name=" + tl_name + ", tl_status=" + tl_status + "]";
	}
	
	
}
