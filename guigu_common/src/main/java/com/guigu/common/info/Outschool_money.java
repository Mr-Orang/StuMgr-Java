package com.guigu.common.info;

/**
 * 退学，学生缴费详情
 * @author dyc
 *
 */
public class Outschool_money {

	private String tp_id;
	private String stu_name;
	private String tl_name;
	private String tlf_statement;
	private int tlf_fee;
	private int tp_cash;
	private String tp_date;
	private String te_name;
	private String tp_tip_status;
	public String getTp_id() {
		return tp_id;
	}
	public void setTp_id(String tp_id) {
		this.tp_id = tp_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getTl_name() {
		return tl_name;
	}
	public void setTl_name(String tl_name) {
		this.tl_name = tl_name;
	}
	public String getTlf_statement() {
		return tlf_statement;
	}
	public void setTlf_statement(String tlf_statement) {
		this.tlf_statement = tlf_statement;
	}
	public int getTlf_fee() {
		return tlf_fee;
	}
	public void setTlf_fee(int tlf_fee) {
		this.tlf_fee = tlf_fee;
	}
	public int getTp_cash() {
		return tp_cash;
	}
	public void setTp_cash(int tp_cash) {
		this.tp_cash = tp_cash;
	}
	public String getTp_date() {
		return tp_date;
	}
	public void setTp_date(String tp_date) {
		this.tp_date = tp_date;
	}
	public String getTe_name() {
		return te_name;
	}
	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}
	public String getTp_tip_status() {
		return tp_tip_status;
	}
	public void setTp_tip_status(String tp_tip_status) {
		this.tp_tip_status = tp_tip_status;
	}
	public Outschool_money(String tp_id, String stu_name, String tl_name, String tlf_statement, int tlf_fee,
			int tp_cash, String tp_date, String te_name, String tp_tip_status) {
		super();
		this.tp_id = tp_id;
		this.stu_name = stu_name;
		this.tl_name = tl_name;
		this.tlf_statement = tlf_statement;
		this.tlf_fee = tlf_fee;
		this.tp_cash = tp_cash;
		this.tp_date = tp_date;
		this.te_name = te_name;
		this.tp_tip_status = tp_tip_status;
	}
	public Outschool_money() {
		super();
	}
	@Override
	public String toString() {
		return "Outschool_money [tp_id=" + tp_id + ", stu_name=" + stu_name + ", tl_name=" + tl_name
				+ ", tlf_statement=" + tlf_statement + ", tlf_fee=" + tlf_fee + ", tp_cash=" + tp_cash + ", tp_date="
				+ tp_date + ", te_name=" + te_name + ", tp_tip_status=" + tp_tip_status + "]";
	}
	
}
