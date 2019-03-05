package com.guigu.domain.info;

public class Attendance {

	private String class_id;// 班级编号
	private String teacher_id;// 考勤老师编号
	private String type_id;// 考勤类型
	private String attendance_time;// 考勤日期
	private String ty_yeso;//考勤状态

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getAttendance_time() {
		return attendance_time;
	}

	public void setAttendance_time(String attendance_time) {
		this.attendance_time = attendance_time;
	}

	public String getTy_yeso() {
		return ty_yeso;
	}

	public void setTy_yeso(String ty_yeso) {
		this.ty_yeso = ty_yeso;
	}


	public Attendance(String class_id, String teacher_id, String type_id, String attendance_time, String ty_yeso) {
		super();
		this.class_id = class_id;
		this.teacher_id = teacher_id;
		this.type_id = type_id;
		this.attendance_time = attendance_time;
		this.ty_yeso = ty_yeso;
	}

	@Override
	public String toString() {
		return "Attendance [class_id=" + class_id + ", teacher_id=" + teacher_id + ", type_id=" + type_id
				+ ", attendance_time=" + attendance_time + ", ty_yeso=" + ty_yeso + "]";
	}

	public Attendance() {
		super();
	}

}
