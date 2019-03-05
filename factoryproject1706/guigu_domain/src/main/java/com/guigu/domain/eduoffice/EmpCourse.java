package com.guigu.domain.eduoffice;

/**
 * 员工课程关系实体类
 * 
 * @author zy
 *
 */
public class EmpCourse {
	// 关系id
	private String ec_id;
	// 课程编号
	private String tc_cid;
	// 员工编号
	private String emp_id;
	// 状态(是否可用)
	private int status;

	public EmpCourse() {
		super();
	}

	public EmpCourse(String ec_id, String tc_cid, String emp_id, int status) {
		super();
		this.ec_id = ec_id;
		this.tc_cid = tc_cid;
		this.emp_id = emp_id;
		this.status = status;
	}

	public String getEc_id() {
		return ec_id;
	}

	public void setEc_id(String ec_id) {
		this.ec_id = ec_id;
	}

	public String getTc_cid() {
		return tc_cid;
	}

	public void setTc_cid(String tc_cid) {
		this.tc_cid = tc_cid;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EmpCourse [ec_id=" + ec_id + ", tc_cid=" + tc_cid + ", emp_id=" + emp_id + ", status=" + status + "]";
	}

}
