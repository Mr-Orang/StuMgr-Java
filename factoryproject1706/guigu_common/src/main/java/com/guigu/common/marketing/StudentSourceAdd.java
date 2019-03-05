package com.guigu.common.marketing;

import java.io.Serializable;
/**
 * 生源添加vo类
 * @author maomao
 *
 */
public class StudentSourceAdd implements Serializable {
	private String stuSourceID;//生源编号
	private String stuSourceName;//生源姓名
	private String stuSourceMobile;//生源电话
	private String stuSourceArea;//生源地区或院校
	private String stuSourceQQ;//生源qq
	private String stuSourcePmobile;//生源父母电话
	private String empID;//员工编号
	
	public StudentSourceAdd() {
		super();
	}
	
	
	public StudentSourceAdd(String stuSourceID, String stuSourceName, String stuSourceMobile, String stuSourceArea,
			String stuSourceQQ, String stuSourcePmobile, String empID) {
		super();
		this.stuSourceID = stuSourceID;
		this.stuSourceName = stuSourceName;
		this.stuSourceMobile = stuSourceMobile;
		this.stuSourceArea = stuSourceArea;
		this.stuSourceQQ = stuSourceQQ;
		this.stuSourcePmobile = stuSourcePmobile;
		this.empID = empID;
	}


	public String getEmpID() {
		return empID;
	}


	public void setEmpID(String empID) {
		this.empID = empID;
	}


	public String getStuSourceID() {
		return stuSourceID;
	}

	public void setStuSourceID(String stuSourceID) {
		this.stuSourceID = stuSourceID;
	}

	public String getStuSourceName() {
		return stuSourceName;
	}
	public void setStuSourceName(String stuSourceName) {
		this.stuSourceName = stuSourceName;
	}
	public String getStuSourceMobile() {
		return stuSourceMobile;
	}
	public void setStuSourceMobile(String stuSourceMobile) {
		this.stuSourceMobile = stuSourceMobile;
	}
	public String getStuSourceArea() {
		return stuSourceArea;
	}
	public void setStuSourceArea(String stuSourceArea) {
		this.stuSourceArea = stuSourceArea;
	}
	public String getStuSourceQQ() {
		return stuSourceQQ;
	}
	public void setStuSourceQQ(String stuSourceQQ) {
		this.stuSourceQQ = stuSourceQQ;
	}
	public String getStuSourcePmobile() {
		return stuSourcePmobile;
	}
	public void setStuSourcePmobile(String stuSourcePmobile) {
		this.stuSourcePmobile = stuSourcePmobile;
	}
	
	
}
