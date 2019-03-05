package com.guigu.common.marketing;

import java.io.Serializable;
/**
 * 已安排宿舍条件帮助类
 * @author maomao
 *
 */
public class BoardHelp implements Serializable {
	private String stuName;//学生姓名
	private String dormID;//宿舍ID
	private String classID;//班级编号
	private String empID;//教师编号
	
	public BoardHelp(String stuName, String dormID, String classID, String empID) {
		super();
		this.stuName = stuName;
		this.dormID = dormID;
		this.classID = classID;
		this.empID = empID;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public BoardHelp() {
		super();
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getDormID() {
		return dormID;
	}
	public void setDormID(String dormID) {
		this.dormID = dormID;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	
	
}
