package com.guigu.domain.marketing;

import java.util.Date;

public class Discounts {
	/**
	 * td_id VARCHAR2(10) primary key,--编号
	ts_id VARCHAR2(10),--学号（t_student）
	tlf_id VARCHAR2(10),--年级/阶段编号（t_level_fee）
	td_cash NUMBER(8,2),--优惠额度
	te_id VARCHAR2(10),--申请人(t_employee)
	td_filldate DATE,--申请日期
	td_statement VARCHAR2(255),--优惠理由或说明
	td_librarian VARCHAR2(10),--审批人(t_employee)
	td_examineTime DATE,--审批日期
	td_UseStatus VARCHAR2(10),--审批状态
	td_checkReason VARCHAR2(255),--不同意原因
	 */
	
	private String td_id;
	private String ts_id;
	private String tlf_id;
	private String td_cash;
	private String te_id;
	private Date td_filldate;
	private String td_statement;
	private String td_librarian;
	private String td_examineTime;
	private String td_UseStatus;
	private String td_checkReason;
	
	public Discounts() {
		super();
	}

	public Discounts(String td_id, String ts_id, String tlf_id, String td_cash, String te_id, Date td_filldate,
			String td_statement, String td_librarian, String td_examineTime, String td_UseStatus,
			String td_checkReason) {
		super();
		this.td_id = td_id;
		this.ts_id = ts_id;
		this.tlf_id = tlf_id;
		this.td_cash = td_cash;
		this.te_id = te_id;
		this.td_filldate = td_filldate;
		this.td_statement = td_statement;
		this.td_librarian = td_librarian;
		this.td_examineTime = td_examineTime;
		this.td_UseStatus = td_UseStatus;
		this.td_checkReason = td_checkReason;
	}

	public String getTd_id() {
		return td_id;
	}

	public void setTd_id(String td_id) {
		this.td_id = td_id;
	}

	public String getTs_id() {
		return ts_id;
	}

	public void setTs_id(String ts_id) {
		this.ts_id = ts_id;
	}

	public String getTlf_id() {
		return tlf_id;
	}

	public void setTlf_id(String tlf_id) {
		this.tlf_id = tlf_id;
	}

	public String getTd_cash() {
		return td_cash;
	}

	public void setTd_cash(String td_cash) {
		this.td_cash = td_cash;
	}

	public String getTe_id() {
		return te_id;
	}

	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}

	public Date getTd_filldate() {
		return td_filldate;
	}

	public void setTd_filldate(Date td_filldate) {
		this.td_filldate = td_filldate;
	}

	public String getTd_statement() {
		return td_statement;
	}

	public void setTd_statement(String td_statement) {
		this.td_statement = td_statement;
	}

	public String getTd_librarian() {
		return td_librarian;
	}

	public void setTd_librarian(String td_librarian) {
		this.td_librarian = td_librarian;
	}

	public String getTd_examineTime() {
		return td_examineTime;
	}

	public void setTd_examineTime(String td_examineTime) {
		this.td_examineTime = td_examineTime;
	}

	public String getTd_UseStatus() {
		return td_UseStatus;
	}

	public void setTd_UseStatus(String td_UseStatus) {
		this.td_UseStatus = td_UseStatus;
	}

	public String getTd_checkReason() {
		return td_checkReason;
	}

	public void setTd_checkReason(String td_checkReason) {
		this.td_checkReason = td_checkReason;
	}

	@Override
	public String toString() {
		return "Discounts [td_id=" + td_id + ", ts_id=" + ts_id + ", tlf_id=" + tlf_id + ", td_cash=" + td_cash
				+ ", te_id=" + te_id + ", td_filldate=" + td_filldate + ", td_statement=" + td_statement
				+ ", td_librarian=" + td_librarian + ", td_examineTime=" + td_examineTime + ", td_UseStatus="
				+ td_UseStatus + ", td_checkReason=" + td_checkReason + "]";
	}
	
	
}
