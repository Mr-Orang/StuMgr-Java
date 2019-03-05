package com.guigu.domain.authority.vo;

/*
 * 员工部门实体类
 */
public class DepartmentVO {

	//部门编号
	private String deptId;
	//部门名称
	private String deptName;
	//部门描述
	private String remark;
	//部门状态
	private String status;
	
	//有参构造方法
	public DepartmentVO(String deptId, String deptName, String remark, String status) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.remark = remark;
		this.status = status;
	}

	//无参构造方法
	public DepartmentVO() {
		super();
	}

	//实体类get和set方法
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
