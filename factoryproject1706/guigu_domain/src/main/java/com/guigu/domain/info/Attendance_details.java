package com.guigu.domain.info;

public class Attendance_details {

	String tad_id;//考勤详情编号
	String ta_id;//考勤编号
	String stu_id;//学生编号
	String status;//状态
	public String getTad_id() {
		return tad_id;
	}
	public void setTad_id(String tad_id) {
		this.tad_id = tad_id;
	}
	public String getTa_id() {
		return ta_id;
	}
	public void setTa_id(String ta_id) {
		this.ta_id = ta_id;
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
	@Override
	public String toString() {
		return "Attendance_details [tad_id=" + tad_id + ", ta_id=" + ta_id + ", stu_id=" + stu_id + ", status=" + status
				+ "]";
	}
	public Attendance_details(String tad_id, String ta_id, String stu_id, String status) {
		super();
		this.tad_id = tad_id;
		this.ta_id = ta_id;
		this.stu_id = stu_id;
		this.status = status;
	}
	public Attendance_details() {
		super();
	}
	
	
}
