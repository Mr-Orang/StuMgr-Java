package com.guigu.domain.marketing;

import java.sql.*;

public class Classes {
	/**
	 * 
	 * tc_id	VARCHAR2(10) primary key,--编号
	tc_name	VARCHAR2(20),--班级名称
	tc_personnum number(3),--班级人数
	tc_technology VARCHAR2(20),--专业方式
	te_id VARCHAR2(10),--员工编号（班主任 t_employee）
	tl_id VARCHAR2(10),--阶段id（阶段信息t_level）
	tc_entering_date DATE --录入日期
	tc_entering_date	DATE,--				录入日期
	tc_open_date DATE --开班日期

	 */
	
	private String tc_id;
	private String tc_name;
	private int tc_personnum;
	private String tc_technology;
	private String te_name;
	private String tl_name;
	private Date tc_entering_date;
	private Date tc_open_date;
	
	public Classes() {
		super();
	}

	public Classes(String tc_id, String tc_name, int tc_personnum, String tc_technology, String te_name, String tl_name,
			Date tc_entering_date, Date tc_open_date) {
		super();
		this.tc_id = tc_id;
		this.tc_name = tc_name;
		this.tc_personnum = tc_personnum;
		this.tc_technology = tc_technology;
		this.te_name = te_name;
		this.tl_name = tl_name;
		this.tc_entering_date = tc_entering_date;
		this.tc_open_date = tc_open_date;
	}

	public String getTc_id() {
		return tc_id;
	}

	public void setTc_id(String tc_id) {
		this.tc_id = tc_id;
	}

	public String getTc_name() {
		return tc_name;
	}

	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}

	public int getTc_personnum() {
		return tc_personnum;
	}

	public void setTc_personnum(int tc_personnum) {
		this.tc_personnum = tc_personnum;
	}

	public String getTc_technology() {
		return tc_technology;
	}

	public void setTc_technology(String tc_technology) {
		this.tc_technology = tc_technology;
	}

	public String getTe_name() {
		return te_name;
	}

	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}

	public String getTl_name() {
		return tl_name;
	}

	public void setTl_name(String tl_name) {
		this.tl_name = tl_name;
	}

	public Date getTc_entering_date() {
		return tc_entering_date;
	}

	public void setTc_entering_date(Date tc_entering_date) {
		this.tc_entering_date = tc_entering_date;
	}

	public Date getTc_open_date() {
		return tc_open_date;
	}

	public void setTc_open_date(Date tc_open_date) {
		this.tc_open_date = tc_open_date;
	}

	@Override
	public String toString() {
		return "Classes [tc_id=" + tc_id + ", tc_name=" + tc_name + ", tc_personnum=" + tc_personnum
				+ ", tc_technology=" + tc_technology + ", te_name=" + te_name + ", tl_name=" + tl_name
				+ ", tc_entering_date=" + tc_entering_date + ", tc_open_date=" + tc_open_date + "]";
	}

	
	
}
