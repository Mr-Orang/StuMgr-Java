package com.guigu.common.marketing;

import java.io.Serializable;
import java.sql.Date;

public class StudentSourceView implements Serializable {
	private String tss_id;//编号
	private String tss_name;//姓名
	private String tss_mobile;//电话
	private String tss_area_school;//生源地区、院校
	private String tss_qq;//qq号码
	private Date tss_regdate;//录入日期
	private String trs_name;//招生状态
	private String tss_losttext;//流失原因
	private String tss_parent_mobile;//父母电话
	private String tss_empName;//市场人员姓名
	private String sts_id;
	public StudentSourceView() {
		// TODO Auto-generated constructor stub
	}
	public StudentSourceView(String tss_id, String tss_name, String tss_mobile, String tss_area_school, String tss_qq,
			Date tss_regdate, String trs_name, String tss_losttext, String tss_parent_mobile, String tss_empName,
			String sts_id) {
		super();
		this.tss_id = tss_id;
		this.tss_name = tss_name;
		this.tss_mobile = tss_mobile;
		this.tss_area_school = tss_area_school;
		this.tss_qq = tss_qq;
		this.tss_regdate = tss_regdate;
		this.trs_name = trs_name;
		this.tss_losttext = tss_losttext;
		this.tss_parent_mobile = tss_parent_mobile;
		this.tss_empName = tss_empName;
		this.sts_id = sts_id;
	}
	public String getTss_id() {
		return tss_id;
	}
	public void setTss_id(String tss_id) {
		this.tss_id = tss_id;
	}
	public String getTss_name() {
		return tss_name;
	}
	public void setTss_name(String tss_name) {
		this.tss_name = tss_name;
	}
	public String getTss_mobile() {
		return tss_mobile;
	}
	public void setTss_mobile(String tss_mobile) {
		this.tss_mobile = tss_mobile;
	}
	public String getTss_area_school() {
		return tss_area_school;
	}
	public void setTss_area_school(String tss_area_school) {
		this.tss_area_school = tss_area_school;
	}
	public String getTss_qq() {
		return tss_qq;
	}
	public void setTss_qq(String tss_qq) {
		this.tss_qq = tss_qq;
	}
	public Date getTss_regdate() {
		return tss_regdate;
	}
	public void setTss_regdate(Date tss_regdate) {
		this.tss_regdate = tss_regdate;
	}
	public String getTrs_name() {
		return trs_name;
	}
	public void setTrs_name(String trs_name) {
		this.trs_name = trs_name;
	}
	public String getTss_losttext() {
		return tss_losttext;
	}
	public void setTss_losttext(String tss_losttext) {
		this.tss_losttext = tss_losttext;
	}
	public String getTss_parent_mobile() {
		return tss_parent_mobile;
	}
	public void setTss_parent_mobile(String tss_parent_mobile) {
		this.tss_parent_mobile = tss_parent_mobile;
	}
	public String getTss_empName() {
		return tss_empName;
	}
	public void setTss_empName(String tss_empName) {
		this.tss_empName = tss_empName;
	}
	public String getSts_id() {
		return sts_id;
	}
	public void setSts_id(String sts_id) {
		this.sts_id = sts_id;
	}
	@Override
	public String toString() {
		return "StudentSourceView [tss_id=" + tss_id + ", tss_name=" + tss_name + ", tss_mobile=" + tss_mobile
				+ ", tss_area_school=" + tss_area_school + ", tss_qq=" + tss_qq + ", tss_regdate=" + tss_regdate
				+ ", trs_name=" + trs_name + ", tss_losttext=" + tss_losttext + ", tss_parent_mobile="
				+ tss_parent_mobile + ", tss_empName=" + tss_empName + ", sts_id=" + sts_id + "]";
	}
	
}
