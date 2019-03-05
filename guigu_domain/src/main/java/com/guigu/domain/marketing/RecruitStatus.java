package com.guigu.domain.marketing;

public class RecruitStatus {
	/**
	 * trs_id varchar2(10) primary key,--编号
		trs_name varchar2(38)--状态名称
	 */
	private  String trs_id;
	private String trs_name;
	public RecruitStatus() {
		super();
	}
	public RecruitStatus(String trs_id, String trs_name) {
		super();
		this.trs_id = trs_id;
		this.trs_name = trs_name;
	}
	public String getTrs_id() {
		return trs_id;
	}
	public void setTrs_id(String trs_id) {
		this.trs_id = trs_id;
	}
	public String getTrs_name() {
		return trs_name;
	}
	public void setTrs_name(String trs_name) {
		this.trs_name = trs_name;
	}
	@Override
	public String toString() {
		return "RecruitStatus [trs_id=" + trs_id + ", trs_name=" + trs_name + "]";
	}
	
	
}
