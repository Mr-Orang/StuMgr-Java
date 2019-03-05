package com.guigu.common.marketing;

import java.io.Serializable;
/**
 * 查询生源信息条件类
 * @author maomao
 *
 */
public class StudentSourceHelp implements Serializable {
	private String ID;//编号
	private String Name;//姓名
	private String mobile;//电话
	private String area;//生源地区/院校
	private String startDate;//起始日期
	private String endDate;//截至日期
	private String status;//招生状态
	private String empName;//市场人员名称
	
	public StudentSourceHelp() {
		super();
	}

	public StudentSourceHelp(String iD, String name, String mobile, String area, String startDate, String endDate,
			String status, String empName) {
		super();
		ID = iD;
		Name = name;
		this.mobile = mobile;
		this.area = area;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.empName = empName;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	
}
