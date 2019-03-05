package com.guigu.domain.marketing;

import java.util.Date;

public class SourceTalk {
	/**
	 * tst_id VARCHAR2(10) primary key,--编号
	
	tss_id VARCHAR2(10),--生源编号(生源信息t_student_source)
	
	te_id	VARCHAR2(10),--市场人员编号

	tst_date DATE,--沟通日期时间

	tst_content VARCHAR2(255),--沟通情况记录
,
	tsg_id VARCHAR2(2)--生源等级编号（生源等级t_student_grade）
	 */
	
	private String tst_id;
	private String tss_id;
	private String te_id;
	private Date tst_date;
	private String tst_content;
	private String tsg_id;
	
	public SourceTalk() {
		super();
	}

	public SourceTalk(String tst_id, String tss_id, String te_id, Date tst_date, String tst_content, String tsg_id) {
		super();
		this.tst_id = tst_id;
		this.tss_id = tss_id;
		this.te_id = te_id;
		this.tst_date = tst_date;
		this.tst_content = tst_content;
		this.tsg_id = tsg_id;
	}

	public String getTst_id() {
		return tst_id;
	}

	public void setTst_id(String tst_id) {
		this.tst_id = tst_id;
	}

	public String getTss_id() {
		return tss_id;
	}

	public void setTss_id(String tss_id) {
		this.tss_id = tss_id;
	}

	public String getTe_id() {
		return te_id;
	}

	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}

	public Date getTst_date() {
		return tst_date;
	}

	public void setTst_date(Date tst_date) {
		this.tst_date = tst_date;
	}

	public String getTst_content() {
		return tst_content;
	}

	public void setTst_content(String tst_content) {
		this.tst_content = tst_content;
	}

	public String getTsg_id() {
		return tsg_id;
	}

	public void setTsg_id(String tsg_id) {
		this.tsg_id = tsg_id;
	}

	@Override
	public String toString() {
		return "SourceTalk [tst_id=" + tst_id + ", tss_id=" + tss_id + ", te_id=" + te_id + ", tst_date=" + tst_date
				+ ", tst_content=" + tst_content + ", tsg_id=" + tsg_id + "]";
	}
	
	
	
}
