package com.guigu.domain.info;

public class Kaoqinclassshow {
	// tc_name,tc_personnum,tc_technology
	public Kaoqinclassshow() {
		super();
	}

	private String tc_name;// 班级名称
	private Integer tc_personnum;// 班级人数

	@Override
	public String toString() {
		return "Kaoqinclassshow [tc_name=" + tc_name + ", tc_personnum=" + tc_personnum + ", tc_technology="
				+ tc_technology + "]";
	}

	private String tc_technology;// 班级类别

	public Kaoqinclassshow(String tc_name, Integer tc_personnum, String tc_technology) {
		super();
		this.tc_name = tc_name;
		this.tc_personnum = tc_personnum;
		this.tc_technology = tc_technology;
	}

	public String getTc_name() {
		return tc_name;
	}

	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}

	public Integer getTc_personnum() {
		return tc_personnum;
	}

	public void setTc_personnum(Integer tc_personnum) {
		this.tc_personnum = tc_personnum;
	}

	public String getTc_technology() {
		return tc_technology;
	}

	public void setTc_technology(String tc_technology) {
		this.tc_technology = tc_technology;
	}
}
