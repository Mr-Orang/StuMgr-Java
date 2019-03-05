package com.guigu.domain.curriculum;

/**
 * 课程章节表
 * 	tc_chid	连接课程授课模块章节资源表
 * @author cjy
 *
 */
public class Course_section {
	private String tc_chid;//章节编号
	private String tc_chname;//章节名称
	private String tc_cid;//课程编号
	private int tc_chstatus;//章节状态
	
	public Course_section() {
		// TODO Auto-generated constructor stub
	}
	public Course_section(String tc_chid, String tc_chname, String tc_cid, int tc_chstatus) {
		super();
		this.tc_chid = tc_chid;
		this.tc_chname = tc_chname;
		this.tc_cid = tc_cid;
		this.tc_chstatus = tc_chstatus;
	}

	public String getTc_chid() {
		return tc_chid;
	}

	public void setTc_chid(String tc_chid) {
		this.tc_chid = tc_chid;
	}

	public String getTc_chname() {
		return tc_chname;
	}

	public void setTc_chname(String tc_chname) {
		this.tc_chname = tc_chname;
	}

	public String getTc_cid() {
		return tc_cid;
	}

	public void setTc_cid(String tc_cid) {
		this.tc_cid = tc_cid;
	}

	public int getTc_chstatus() {
		return tc_chstatus;
	}

	public void setTc_chstatus(int tc_chstatus) {
		this.tc_chstatus = tc_chstatus;
	}

	@Override
	public String toString() {
		return "Course_section [tc_chid=" + tc_chid + ", tc_chname=" + tc_chname + ", tc_cid=" + tc_cid
				+ ", tc_chstatus=" + tc_chstatus + "]";
	}
	
	
}
