package com.guigu.domain.curriculum.vo;

public class Course_search {
	//阶段编号
	private String sid;
	//课程状态
	private int cstatus;
	//课程名称
	private String cname;
	//搜索起始日期
	private String sdate;
	//搜索结束日期
	private String edate;
	public Course_search() {
		super();
	}
	public Course_search(String sid, String cstatus, String cname, String date) {
		super();
		this.sid = sid;
		//当状态为空时，默认赋值为-1
		
		this.cname = cname;

	}
	@Override
	public String toString() {
		return "Course_search [sid=" + sid + ", cstatus=" + cstatus + ", cname=" + cname + ", sdate=" + sdate
				+ ", edate=" + edate + "]";
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getCstatus() {
		return cstatus;
	}
	public void setCstatus(String cstatus) {
		this.cstatus = (cstatus==null||"".equals(cstatus))?-1:Integer.parseInt(cstatus);
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
}
