package com.guigu.domain.curriculum.vo;
/***
 * 添加课程的信息类
 * @author erlong
 *
 */
public class Course_addInfo {
	//课程编号
	private String tc_cid;
	//课程名称
	private String tc_cname;
	//课程别名
	private String tc_calias;
	//课程阶段编号(data_sourse:t_course_stage表)
	private String tc_sid;
	//课程大纲路径
	private String tc_coutline;
	//课程描述
	private String tc_cdescribe;
	//添加课程的员工编号
	private String te_id;
	public Course_addInfo() {
		super();
	}
	public Course_addInfo(String tc_cid, String tc_cname, String tc_calias, String tc_sid, String tc_coutline,
			String tc_cdescribe, String te_id) {
		super();
		this.tc_cid = tc_cid;
		this.tc_cname = tc_cname;
		this.tc_calias = tc_calias;
		this.tc_sid = tc_sid;
		this.tc_coutline = tc_coutline;
		this.tc_cdescribe = tc_cdescribe;
		this.te_id = te_id;
	}
	@Override
	public String toString() {
		return "Course_addInfo [tc_cid=" + tc_cid + ", tc_cname=" + tc_cname + ", tc_calias=" + tc_calias + ", tc_sid="
				+ tc_sid + ", tc_coutline=" + tc_coutline + ", tc_cdescribe=" + tc_cdescribe + ", te_id=" + te_id + "]";
	}
	public String getTc_cid() {
		return tc_cid;
	}
	public void setTc_cid(String tc_cid) {
		this.tc_cid = tc_cid;
	}
	public String getTc_cname() {
		return tc_cname;
	}
	public void setTc_cname(String tc_cname) {
		this.tc_cname = tc_cname;
	}
	public String getTc_calias() {
		return tc_calias;
	}
	public void setTc_calias(String tc_calias) {
		this.tc_calias = tc_calias;
	}
	public String getTc_sid() {
		return tc_sid;
	}
	public void setTc_sid(String tc_sid) {
		this.tc_sid = tc_sid;
	}
	public String getTc_coutline() {
		return tc_coutline;
	}
	public void setTc_coutline(String tc_coutline) {
		this.tc_coutline = tc_coutline;
	}
	public String getTc_cdescribe() {
		return tc_cdescribe;
	}
	public void setTc_cdescribe(String tc_cdescribe) {
		this.tc_cdescribe = tc_cdescribe;
	}
	public String getTe_id() {
		return te_id;
	}
	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}
}
