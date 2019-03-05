package com.guigu.common.Examination;

public class ExamApplyView {
	private String apply_id;
	private String apply_name;
	private String apply_date;
	private String apply_reason;
	private String class_name;
	private String take_name;
	private String take_date;
	private String reson;
	private String apply_state;
	private int status;
	public ExamApplyView(String apply_id, String apply_name, String apply_date, String apply_reason, String class_name,
			String take_name, String take_date, String reson, String apply_state, int status) {
		super();
		this.apply_id = apply_id;
		this.apply_name = apply_name;
		this.apply_date = apply_date;
		this.apply_reason = apply_reason;
		this.class_name = class_name;
		this.take_name = take_name;
		this.take_date = take_date;
		this.reson = reson;
		this.apply_state = apply_state;
		this.status = status;
	}
	public ExamApplyView() {
		super();
	}
	public String getApply_id() {
		return apply_id;
	}
	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}
	public String getApply_name() {
		return apply_name;
	}
	public void setApply_name(String apply_name) {
		this.apply_name = apply_name;
	}
	public String getApply_date() {
		return apply_date;
	}
	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}
	public String getApply_reason() {
		return apply_reason;
	}
	public void setApply_reason(String apply_reason) {
		this.apply_reason = apply_reason;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getTake_name() {
		return take_name;
	}
	public void setTake_name(String take_name) {
		this.take_name = take_name;
	}
	public String getTake_date() {
		return take_date;
	}
	public void setTake_date(String take_date) {
		this.take_date = take_date;
	}
	public String getReson() {
		return reson;
	}
	public void setReson(String reson) {
		this.reson = reson;
	}
	public String getApply_state() {
		return apply_state;
	}
	public void setApply_state(String apply_state) {
		this.apply_state = apply_state;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ExamApplyView [apply_id=" + apply_id + ", apply_name=" + apply_name + ", apply_date=" + apply_date
				+ ", apply_reason=" + apply_reason + ", class_name=" + class_name + ", take_name=" + take_name
				+ ", take_date=" + take_date + ", reson=" + reson + ", apply_state=" + apply_state + ", status="
				+ status + "]";
	}
	
	
}
