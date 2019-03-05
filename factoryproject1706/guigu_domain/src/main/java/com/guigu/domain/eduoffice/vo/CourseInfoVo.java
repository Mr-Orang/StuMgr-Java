package com.guigu.domain.eduoffice.vo;
/**
 * 课程信息试图类
 * @author zy
 *
 */
public class CourseInfoVo {
	private String tc_cid;
	private String tc_cname;
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
	public CourseInfoVo(String tc_cid, String tc_cname) {
		super();
		this.tc_cid = tc_cid;
		this.tc_cname = tc_cname;
	}
	public CourseInfoVo() {
		super();
	}
	
}
