package com.guigu.domain.curriculum;
/**
 * 课程信息实体类
 * @author zy
 *
 */
public class CourseInfo {
	//课程编号
	private String tc_cid;
	//课程名称
	private String tc_cname;
	//章节数量
	private int tc_cnumber;
	//课程别名
	private String tc_calias;
	//课程描述
	private String tc_cdescribe;
	//教学大纲
	private String tc_coutline;
	//课程状态
	private int tc_cstatus;
	//课程添加日期
	private String tc_cdate;
	//员工编号
	private String te_id;
	public CourseInfo(String tc_cid, String tc_cname, int tc_cnumber, String tc_calias, String tc_cdescribe,
			String tc_coutline, int tc_cstatus, String tc_cdate, String te_id) {
		super();
		this.tc_cid = tc_cid;
		this.tc_cname = tc_cname;
		this.tc_cnumber = tc_cnumber;
		this.tc_calias = tc_calias;
		this.tc_cdescribe = tc_cdescribe;
		this.tc_coutline = tc_coutline;
		this.tc_cstatus = tc_cstatus;
		this.tc_cdate = tc_cdate;
		this.te_id = te_id;
	}
	public CourseInfo() {
		super();
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
	public int getTc_cnumber() {
		return tc_cnumber;
	}
	public void setTc_cnumber(int tc_cnumber) {
		this.tc_cnumber = tc_cnumber;
	}
	public String getTc_calias() {
		return tc_calias;
	}
	public void setTc_calias(String tc_calias) {
		this.tc_calias = tc_calias;
	}
	public String getTc_cdescribe() {
		return tc_cdescribe;
	}
	public void setTc_cdescribe(String tc_cdescribe) {
		this.tc_cdescribe = tc_cdescribe;
	}
	public String getTc_coutline() {
		return tc_coutline;
	}
	public void setTc_coutline(String tc_coutline) {
		this.tc_coutline = tc_coutline;
	}
	public int getTc_cstatus() {
		return tc_cstatus;
	}
	public void setTc_cstatus(int tc_cstatus) {
		this.tc_cstatus = tc_cstatus;
	}
	public String getTc_cdate() {
		return tc_cdate;
	}
	public void setTc_cdate(String tc_cdate) {
		this.tc_cdate = tc_cdate;
	}
	public String getTe_id() {
		return te_id;
	}
	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}
	@Override
	public String toString() {
		return "CourseInfo [tc_cid=" + tc_cid + ", tc_cname=" + tc_cname + ", tc_cnumber=" + tc_cnumber + ", tc_calias="
				+ tc_calias + ", tc_cdescribe=" + tc_cdescribe + ", tc_coutline=" + tc_coutline + ", tc_cstatus="
				+ tc_cstatus + ", tc_cdate=" + tc_cdate + ", te_id=" + te_id + "]";
	}
	
	
}
