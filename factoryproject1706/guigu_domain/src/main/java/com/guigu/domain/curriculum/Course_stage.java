package com.guigu.domain.curriculum;

/**
 * 课程阶段关联实体类
 * @author cjy
 *
 */
public class Course_stage {
	private String tc_coid;//课程阶段关联编号
	private String tc_cid;//课程编号
	private String tc_sid;//阶段编号
	public Course_stage(String tc_coid, String tc_cid, String tc_sid) {
		super();
		this.tc_coid = tc_coid;
		this.tc_cid = tc_cid;
		this.tc_sid = tc_sid;
	}
	public Course_stage() {
		super();
	}
	public String getTc_coid() {
		return tc_coid;
	}
	public void setTc_coid(String tc_coid) {
		this.tc_coid = tc_coid;
	}
	public String getTc_cid() {
		return tc_cid;
	}
	public void setTc_cid(String tc_cid) {
		this.tc_cid = tc_cid;
	}
	public String getTc_sid() {
		return tc_sid;
	}
	public void setTc_sid(String tc_sid) {
		this.tc_sid = tc_sid;
	}
	@Override
	public String toString() {
		return "Course_stage [tc_coid=" + tc_coid + ", tc_cid=" + tc_cid + ", tc_sid=" + tc_sid + "]";
	}
	
	
}
