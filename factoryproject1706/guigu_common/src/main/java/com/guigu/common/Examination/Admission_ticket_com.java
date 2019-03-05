package com.guigu.common.Examination;

public class Admission_ticket_com {
	private String adm_id;
	private String stu_id;
	private int adm_state;
	private String apply_id;
	private String stu_cid;
	public String getStu_cid() {
		return stu_cid;
	}
	public void setStu_cid(String stu_cid) {
		this.stu_cid = stu_cid;
	}
	public String getAdm_id() {
		return adm_id;
	}
	public void setAdm_id(String adm_id) {
		this.adm_id = adm_id;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public int getAdm_state() {
		return adm_state;
	}
	public void setAdm_state(int adm_state) {
		this.adm_state = adm_state;
	}
	public String getApply_id() {
		return apply_id;
	}
	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}
	@Override
	public String toString() {
		return "Admission_ticket [adm_id=" + adm_id + ", stu_id=" + stu_id + ", adm_state=" + adm_state + ", apply_id="
				+ apply_id + ", getAdm_id()=" + getAdm_id() + ", getStu_id()=" + getStu_id() + ", getAdm_state()="
				+ getAdm_state() + ", getApply_id()=" + getApply_id() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Admission_ticket_com(String adm_id, String stu_id, int adm_state, String apply_id) {
		super();
		this.adm_id = adm_id;
		this.stu_id = stu_id;
		this.adm_state = adm_state;
		this.apply_id = apply_id;
	}
	public Admission_ticket_com() {
		super();
	}
	
}
