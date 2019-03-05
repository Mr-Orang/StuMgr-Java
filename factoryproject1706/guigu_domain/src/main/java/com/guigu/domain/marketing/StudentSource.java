package com.guigu.domain.marketing;

import java.util.Date;

public class StudentSource {
	/**
	 * tss_id VARCHAR2(10) primary key,--编号

	tss_name VARCHAR2(20),--姓名
	
	tss_mobile VARCHAR2(11),--联系电话
	
	tss_area_school VARCHAR2(38),--生源地区/院校名称

	tss_qq VARCHAR2(38),--qq号码

	tss_regdate DATE,--录入日期时间

	trs_id VARCHAR2(10),--招生状态

	tss_losttext VARCHAR2(255),0--流失原因
	
	tss_parent_mobile VARCHAR2(20),--父母电话
	
	--tsm_id VARCHAR2(10),--市场人员编号
	sts_id varchar2(10),--市场人员编号

	--tsg_grade VARCHAR2(2)--等级编号
	 */
	private String tss_id;
	private String tss_name;
	private String tss_mobile;
	private String tss_area_school;
	private String tss_qq;
	private Date tss_regdate;
	private String trs_id;
	private String tss_losttext;
	private String tss_parent_mobile;
	private String sts_id;
	
	public StudentSource() {
		super();
	}

	public StudentSource(String tss_id, String tss_name, String tss_mobile, String tss_area_school, String tss_qq,
			Date tss_regdate, String trs_id, String tss_losttext, String tss_parent_mobile, String sts_id) {
		super();
		this.tss_id = tss_id;
		this.tss_name = tss_name;
		this.tss_mobile = tss_mobile;
		this.tss_area_school = tss_area_school;
		this.tss_qq = tss_qq;
		this.tss_regdate = tss_regdate;
		this.trs_id = trs_id;
		this.tss_losttext = tss_losttext;
		this.tss_parent_mobile = tss_parent_mobile;
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

	public String getTrs_id() {
		return trs_id;
	}

	public void setTrs_id(String trs_id) {
		this.trs_id = trs_id;
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

	public String getSts_id() {
		return sts_id;
	}

	public void setSts_id(String sts_id) {
		this.sts_id = sts_id;
	}

	@Override
	public String toString() {
		return "StudentSource [tss_id=" + tss_id + ", tss_name=" + tss_name + ", tss_mobile=" + tss_mobile
				+ ", tss_area_school=" + tss_area_school + ", tss_qq=" + tss_qq + ", tss_regdate=" + tss_regdate
				+ ", trs_id=" + trs_id + ", tss_losttext=" + tss_losttext + ", tss_parent_mobile=" + tss_parent_mobile
				+ ", sts_id=" + sts_id + "]";
	}

}
