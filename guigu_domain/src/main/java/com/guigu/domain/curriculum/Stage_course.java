package com.guigu.domain.curriculum;

/**
 * 课程阶段表实体类
 * @author cjy
 *
 */
public class Stage_course {
	private String tc_sid;//阶段编号
	private String tc_sname;//阶段名称
	private String tc_sstatus;//阶段状态 0可用 1 不可用
	public Stage_course(String tc_sid, String tc_sname, String tc_sstatus) {
		super();
		this.tc_sid = tc_sid;
		this.tc_sname = tc_sname;
		this.tc_sstatus = tc_sstatus;
	}
	public Stage_course() {
		super();
	}
	public String getTc_sid() {
		return tc_sid;
	}
	public void setTc_sid(String tc_sid) {
		this.tc_sid = tc_sid;
	}
	public String getTc_sname() {
		return tc_sname;
	}
	public void setTc_sname(String tc_sname) {
		this.tc_sname = tc_sname;
	}
	public String getTc_sstatus() {
		return tc_sstatus;
	}
	public void setTc_sstatus(String tc_sstatus) {
		this.tc_sstatus = tc_sstatus;
	}
	@Override
	public String toString() {
		return "Stage_course [tc_sid=" + tc_sid + ", tc_sname=" + tc_sname + ", tc_sstatus=" + tc_sstatus + "]";
	}
	
}
