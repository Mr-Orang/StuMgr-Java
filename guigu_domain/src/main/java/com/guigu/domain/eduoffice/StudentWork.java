package com.guigu.domain.eduoffice;

/**
 * 学生作业实体类
 * 
 * @author zy
 *
 */
public class StudentWork {
	// 学生作业编号
	private String sw_id;
	// 学生编号
	private String stu_id;
	// 是否提交
	private String status;
	// 批改总结
	private String remark;
	// 课程作业编号
	private String cw_id;

	public StudentWork(String sw_id, String stu_id, String status, String remark, String cw_id) {
		super();
		this.sw_id = sw_id;
		this.stu_id = stu_id;
		this.status = status;
		this.remark = remark;
		this.cw_id = cw_id;
	}

	public StudentWork() {
		super();
	}

	public String getSw_id() {
		return sw_id;
	}

	public void setSw_id(String sw_id) {
		this.sw_id = sw_id;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCw_id() {
		return cw_id;
	}

	public void setCw_id(String cw_id) {
		this.cw_id = cw_id;
	}

	@Override
	public String toString() {
		return "StudentWork [sw_id=" + sw_id + ", stu_id=" + stu_id + ", status=" + status + ", remark=" + remark
				+ ", cw_id=" + cw_id + "]";
	}

}
