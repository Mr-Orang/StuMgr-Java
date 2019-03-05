package com.guigu.domain.marketing;

import java.util.Date;

public class ChangeBoardApply {
	/**
	 * 
	 * tcha_id VARCHAR2(10) primary key,--更换编号，
	ts_id VARCHAR2(10),--学生编号（t_student），
	tcha_proposer VARCHAR2(10),--申请人，(t_employee)
	tcha_filldate DATE,--申请日期，
	tcha_checkEmpNo VARCHAR2(10),--审批人、(t_employee)
	tcha_examineTime DATE,--审批日期、
	tcha_UseStatus VARCHAR2(10),--审批状态、
	tcha_checkReason VARCHAR2(50)--不同意原因
	 */
	
	private String tcha_id;
	private String ts_id;
	private String tcha_proposer;
	private Date tcha_filldate;
	private String tcha_checkEmpNo;
	private Date tcha_examineTime;
	private String tcha_UseStatus;
	private String tcha_checkReason;
	
	public ChangeBoardApply() {
		super();
	}

	public ChangeBoardApply(String tcha_id, String ts_id, String tcha_proposer, Date tcha_filldate,
			String tcha_checkEmpNo, Date tcha_examineTime, String tcha_UseStatus, String tcha_checkReason) {
		super();
		this.tcha_id = tcha_id;
		this.ts_id = ts_id;
		this.tcha_proposer = tcha_proposer;
		this.tcha_filldate = tcha_filldate;
		this.tcha_checkEmpNo = tcha_checkEmpNo;
		this.tcha_examineTime = tcha_examineTime;
		this.tcha_UseStatus = tcha_UseStatus;
		this.tcha_checkReason = tcha_checkReason;
	}

	public String getTcha_id() {
		return tcha_id;
	}

	public void setTcha_id(String tcha_id) {
		this.tcha_id = tcha_id;
	}

	public String getTs_id() {
		return ts_id;
	}

	public void setTs_id(String ts_id) {
		this.ts_id = ts_id;
	}

	public String getTcha_proposer() {
		return tcha_proposer;
	}

	public void setTcha_proposer(String tcha_proposer) {
		this.tcha_proposer = tcha_proposer;
	}

	public Date getTcha_filldate() {
		return tcha_filldate;
	}

	public void setTcha_filldate(Date tcha_filldate) {
		this.tcha_filldate = tcha_filldate;
	}

	public String getTcha_checkEmpNo() {
		return tcha_checkEmpNo;
	}

	public void setTcha_checkEmpNo(String tcha_checkEmpNo) {
		this.tcha_checkEmpNo = tcha_checkEmpNo;
	}

	public Date getTcha_examineTime() {
		return tcha_examineTime;
	}

	public void setTcha_examineTime(Date tcha_examineTime) {
		this.tcha_examineTime = tcha_examineTime;
	}

	public String getTcha_UseStatus() {
		return tcha_UseStatus;
	}

	public void setTcha_UseStatus(String tcha_UseStatus) {
		this.tcha_UseStatus = tcha_UseStatus;
	}

	public String getTcha_checkReason() {
		return tcha_checkReason;
	}

	public void setTcha_checkReason(String tcha_checkReason) {
		this.tcha_checkReason = tcha_checkReason;
	}

	@Override
	public String toString() {
		return "ChangeBoardApply [tcha_id=" + tcha_id + ", ts_id=" + ts_id + ", tcha_proposer=" + tcha_proposer
				+ ", tcha_filldate=" + tcha_filldate + ", tcha_checkEmpNo=" + tcha_checkEmpNo + ", tcha_examineTime="
				+ tcha_examineTime + ", tcha_UseStatus=" + tcha_UseStatus + ", tcha_checkReason=" + tcha_checkReason
				+ "]";
	}
}
