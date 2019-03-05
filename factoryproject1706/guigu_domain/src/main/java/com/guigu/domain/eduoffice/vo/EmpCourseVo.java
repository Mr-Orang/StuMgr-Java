package com.guigu.domain.eduoffice.vo;

/**
 * 
 * @author zy
 *
 */
public class EmpCourseVo {
	// 关系编号
	private String ec_id;
	// 课程名称
	private String tc_cname;
	// 老师名称
	private String te_name;
	// 状态(是否可用)
	private String status;

	public EmpCourseVo(String ec_id, String tc_cname, String te_name, String status) {
		super();
		this.ec_id = ec_id;
		this.tc_cname = tc_cname;
		this.te_name = te_name;
		this.status = status;
	}

	public EmpCourseVo() {
		super();
	}

	public String getEc_id() {
		return ec_id;
	}

	public void setEc_id(String ec_id) {
		this.ec_id = ec_id;
	}

	public String getTc_cname() {
		return tc_cname;
	}

	public void setTc_cname(String tc_cname) {
		this.tc_cname = tc_cname;
	}

	public String getTe_name() {
		return te_name;
	}

	public void setTr_name(String te_name) {
		this.te_name = te_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if(status==0) {
			this.status ="可用";
		}else if(status==1){
			this.status="不可用";
		}
		
	}

	@Override
	public String toString() {
		return "EmpCourseVo [ec_id=" + ec_id + ", tc_cname=" + tc_cname + ", tr_name=" + te_name + ", status=" + status
				+ "]";
	}

}
