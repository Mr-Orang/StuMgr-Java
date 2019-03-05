package com.guigu.domain.curriculum.vo;

import java.util.Date;

/**
 * 课程信息视图类
 * @author erlong
 *
 */
public class Course_showInfo {
	//课程编号
	private String tc_cid;
	//课程名称
	private String tc_cname;
	//章节数量
	private String tc_cnumber;
	//添加日期
	private String tc_cdate;
	//阶段名称
	private String tc_sname;
	//课程描述
	private String tc_cdescribe;
	//课程状态
	private int tc_cstatus;
	public Course_showInfo() {
		super();
	}
	public Course_showInfo(String tc_cid, String tc_cname, String tc_cnumber, String tc_cdate, String tc_sname,
			String tc_cdescribe, int tc_cstatus) {
		super();
		this.tc_cid = tc_cid;
		this.tc_cname = tc_cname;
		this.tc_cnumber = tc_cnumber;
		this.tc_cdate = tc_cdate;
		this.tc_sname = tc_sname;
		this.tc_cdescribe = tc_cdescribe;
		this.tc_cstatus = tc_cstatus;
	}
	@Override
	public String toString() {
		return "Course_showInfo [tc_cid=" + tc_cid + ", tc_cname=" + tc_cname + ", tc_cnumber=" + tc_cnumber
				+ ", tc_cdate=" + tc_cdate + ", tc_sname=" + tc_sname + ", tc_cdescribe=" + tc_cdescribe
				+ ", tc_cstatus=" + tc_cstatus + "]";
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
	public String getTc_cnumber() {
		return tc_cnumber;
	}
	public void setTc_cnumber(String tc_cnumber) {
		this.tc_cnumber = tc_cnumber;
	}
	public String getTc_cdate() {
		return tc_cdate;
	}
	public void setTc_cdate(String tc_cdate) {
		this.tc_cdate = tc_cdate;
	}
	public String getTc_sname() {
		return tc_sname;
	}
	public void setTc_sname(String tc_sname) {
		this.tc_sname = tc_sname;
	}
	public String getTc_cdescribe() {
		return tc_cdescribe;
	}
	public void setTc_cdescribe(String tc_cdescribe) {
		this.tc_cdescribe = tc_cdescribe;
	}
	public int getTc_cstatus() {
		return tc_cstatus;
	}
	public void setTc_cstatus(int tc_cstatus) {
		this.tc_cstatus = tc_cstatus;
	}
}
