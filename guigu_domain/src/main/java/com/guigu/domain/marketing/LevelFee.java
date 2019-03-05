package com.guigu.domain.marketing;

public class LevelFee {
	/**
	 * 
	 * tlf_id VARCHAR2(10) primary key,--编号
	tl_id VARCHAR2(10),--阶段id（t_level）
	tlf_fee NUMBER(8,2),--学费标准
	tlf_statement VARCHAR2(38),--说明
	tlf_state VARCHAR2(10)--有效状态
	 */
	
	private String tlf_id;
	private String tl_id;
	private String tlf_fee;
	private String tlf_statement;
	private String tlf_state;
	
	
	public LevelFee() {
		super();
	}


	public LevelFee(String tlf_id, String tl_id, String tlf_fee, String tlf_statement, String tlf_state) {
		super();
		this.tlf_id = tlf_id;
		this.tl_id = tl_id;
		this.tlf_fee = tlf_fee;
		this.tlf_statement = tlf_statement;
		this.tlf_state = tlf_state;
	}


	public String getTlf_id() {
		return tlf_id;
	}


	public void setTlf_id(String tlf_id) {
		this.tlf_id = tlf_id;
	}


	public String getTl_id() {
		return tl_id;
	}


	public void setTl_id(String tl_id) {
		this.tl_id = tl_id;
	}


	public String getTlf_fee() {
		return tlf_fee;
	}


	public void setTlf_fee(String tlf_fee) {
		this.tlf_fee = tlf_fee;
	}


	public String getTlf_statement() {
		return tlf_statement;
	}


	public void setTlf_statement(String tlf_statement) {
		this.tlf_statement = tlf_statement;
	}


	public String getTlf_state() {
		return tlf_state;
	}


	public void setTlf_state(String tlf_state) {
		this.tlf_state = tlf_state;
	}


	@Override
	public String toString() {
		return "LevelFee [tlf_id=" + tlf_id + ", tl_id=" + tl_id + ", tlf_fee=" + tlf_fee + ", tlf_statement="
				+ tlf_statement + ", tlf_state=" + tlf_state + "]";
	}
	
}
