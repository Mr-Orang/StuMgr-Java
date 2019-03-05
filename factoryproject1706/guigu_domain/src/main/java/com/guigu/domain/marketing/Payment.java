package com.guigu.domain.marketing;

import java.util.Date;

public class Payment {
	/**
	 * tp_id VARCHAR2(10) primary key,--编号
	ts_id	VARCHAR2(10),--学生学号（t_student）
	tlf_id VARCHAR2(10),--年阶段/阶段学费编号（t_level_fee）
	tp_cash number(8,2),--实际缴费金额
	tp_date DATE,--缴费日期
	te_id VARCHAR2(10),--收费人（财务人员编号 t_employee）
	tp_tip_status VARCHAR2(10),--是否已收收据/发票，发票收据图片上传
	tp_tip_picture varchar2(50)--收据或发票电子凭证
	 * 
	 */
	
	private String tp_id;
	private String ts_id;
	private String tlf_id;
	private int tp_cash;
	private Date tp_date;
	private String te_id;
	private String tp_tip_status;
	private String tp_tip_picture;
	
	public Payment() {
		super();
	}

	public Payment(String tp_id, String ts_id, String tlf_id, int tp_cash, Date tp_date, String te_id,
			String tp_tip_status, String tp_tip_picture) {
		super();
		this.tp_id = tp_id;
		this.ts_id = ts_id;
		this.tlf_id = tlf_id;
		this.tp_cash = tp_cash;
		this.tp_date = tp_date;
		this.te_id = te_id;
		this.tp_tip_status = tp_tip_status;
		this.tp_tip_picture = tp_tip_picture;
	}

	public String getTp_id() {
		return tp_id;
	}

	public void setTp_id(String tp_id) {
		this.tp_id = tp_id;
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

	public int getTp_cash() {
		return tp_cash;
	}

	public void setTp_cash(int tp_cash) {
		this.tp_cash = tp_cash;
	}

	public Date getTp_date() {
		return tp_date;
	}

	public void setTp_date(Date tp_date) {
		this.tp_date = tp_date;
	}

	public String getTe_id() {
		return te_id;
	}

	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}

	public String getTp_tip_status() {
		return tp_tip_status;
	}

	public void setTp_tip_status(String tp_tip_status) {
		this.tp_tip_status = tp_tip_status;
	}

	public String getTp_tip_picture() {
		return tp_tip_picture;
	}

	public void setTp_tip_picture(String tp_tip_picture) {
		this.tp_tip_picture = tp_tip_picture;
	}

	@Override
	public String toString() {
		return "Payment [tp_id=" + tp_id + ", ts_id=" + ts_id + ", tlf_id=" + tlf_id + ", tp_cash=" + tp_cash
				+ ", tp_date=" + tp_date + ", te_id=" + te_id + ", tp_tip_status=" + tp_tip_status + ", tp_tip_picture="
				+ tp_tip_picture + "]";
	}
	
}
