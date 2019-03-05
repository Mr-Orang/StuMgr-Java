package com.guigu.domain.eduoffice.vo;

import java.util.Date;

public class CuedClassesVO {
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
		tc_cname --课程名称
		status --课程状态
		sc_id --课程编号
	 */
	
	private String tc_id;
	private String tc_name;
	private int tc_personnum;
	private String tc_technology;
	private String te_id;
	private String tl_id;
	private Date tc_entering_date;
	private Date tc_open_date;
	private String tc_cname;
	private int status;
	private String sc_id;
	private String tc_sname;
	
	public CuedClassesVO() {}

	public CuedClassesVO(String tc_id, String tc_name, int tc_personnum, String tc_technology, String te_id,
			String tl_id, Date tc_entering_date, Date tc_open_date, String tc_cname, int status, String sc_id,
			String tc_sname) {
		super();
		this.tc_id = tc_id;
		this.tc_name = tc_name;
		this.tc_personnum = tc_personnum;
		this.tc_technology = tc_technology;
		this.te_id = te_id;
		this.tl_id = tl_id;
		this.tc_entering_date = tc_entering_date;
		this.tc_open_date = tc_open_date;
		this.tc_cname = tc_cname;
		this.status = status;
		this.sc_id = sc_id;
		this.tc_sname = tc_sname;
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

	public String getTe_id() {
		return te_id;
	}

	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}

	public String getTl_id() {
		return tl_id;
	}

	public void setTl_id(String tl_id) {
		this.tl_id = tl_id;
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

	public String getTc_cname() {
		return tc_cname;
	}

	public void setTc_cname(String tc_cname) {
		this.tc_cname = tc_cname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSc_id() {
		return sc_id;
	}

	public void setSc_id(String sc_id) {
		this.sc_id = sc_id;
	}

	public String getTc_sname() {
		return tc_sname;
	}

	public void setTc_sname(String tc_sname) {
		this.tc_sname = tc_sname;
	}

	@Override
	public String toString() {
		return "CuedClassesVO [tc_id=" + tc_id + ", tc_name=" + tc_name + ", tc_personnum=" + tc_personnum
				+ ", tc_technology=" + tc_technology + ", te_id=" + te_id + ", tl_id=" + tl_id + ", tc_entering_date="
				+ tc_entering_date + ", tc_open_date=" + tc_open_date + ", tc_cname=" + tc_cname + ", status=" + status
				+ ", sc_id=" + sc_id + ", tc_sname=" + tc_sname + "]";
	}


	
	

	
	
}
