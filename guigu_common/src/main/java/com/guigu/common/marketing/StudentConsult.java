package com.guigu.common.marketing;

import java.sql.Date;

/**
 * 生源咨询查询
 * @author lijianghua
 *	TST_ID主键
	TSS_NAME生源编号
	TE_NAME市场人员编号
	TST_DATE咨询日期
	TST_CONTENT沟通情况记录
	TSG_NAME生源等级编号
 */
public class StudentConsult {

	private String tst_id;
	private String tss_name;
	private String te_name;
	private  Date tst_date;
	private String tst_content;
	private String tsg_name;
	private String te_id;
	private String tsg_id;
	private String tss_id;
	private Date end_date;
	public StudentConsult() {
		super();
	}
	public StudentConsult(String tst_id, String tss_name, String te_name, Date tst_date, String tst_content,
			String tsg_name,String te_id,String tsg_id,String tss_id,Date end_date) {
		super();
		this.tst_id = tst_id;
		this.tss_name = tss_name;
		this.te_name = te_name;
		this.tst_date = tst_date;
		this.tst_content = tst_content;
		this.tsg_name = tsg_name;
		this.te_id=te_id;
		this.tsg_id=tsg_id;
		this.tss_id=tss_id;
		this.end_date=end_date;
	}
	public String getTst_id() {
		return tst_id;
	}
	public void setTst_id(String tst_id) {
		this.tst_id = tst_id;
	}
	public String getTss_name() {
		return tss_name;
	}
	public void setTss_name(String tss_name) {
		this.tss_name = tss_name;
	}
	public String getTe_name() {
		return te_name;
	}
	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}
	public Date getTst_date() {
		return tst_date;
	}
	public void setTst_date(Date tst_date) {
		this.tst_date = tst_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getTst_content() {
		return tst_content;
	}
	public void setTst_content(String tst_content) {
		this.tst_content = tst_content;
	}
	public String getTsg_name() {
		return tsg_name;
	}
	public void setTsg_name(String tsg_name) {
		this.tsg_name = tsg_name;
	}
	public String getTe_id() {
		return te_id;
	}
	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}
	public String getTsg_id() {
		return tsg_id;
	}
	public void setTsg_id(String tsg_id) {
		this.tsg_id = tsg_id;
	}
	
	public String getTss_id() {
		return tss_id;
	}
	public void setTss_id(String tss_id) {
		this.tss_id = tss_id;
	}
	@Override
	public String toString() {
		return "StudentConsult [tst_id=" + tst_id + ", tss_name=" + tss_name + ", te_name=" + te_name + ", tst_date="
				+ tst_date + ", tst_content=" + tst_content + ", tsg_name=" + tsg_name + ", te_id=" + te_id
				+ ", tsg_id=" + tsg_id + ", tss_id=" + tss_id + ",end_date"+end_date+"]";
	}
	
	
}
