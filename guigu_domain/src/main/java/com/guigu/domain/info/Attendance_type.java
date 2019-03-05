package com.guigu.domain.info;

public class Attendance_type {

	String type_id;//类型编号
	String type_name;//(32)	Not null	类型名称
	String in_Attendance_time;//考勤开始时间
	String out_Attendance_time;//考勤结束时间
	
	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getIn_Attendance_time() {
		return in_Attendance_time;
	}

	public void setIn_Attendance_time(String in_Attendance_time) {
		this.in_Attendance_time = in_Attendance_time;
	}

	public String getOut_Attendance_time() {
		return out_Attendance_time;
	}

	public void setOut_Attendance_time(String out_Attendance_time) {
		this.out_Attendance_time = out_Attendance_time;
	}

	@Override
	public String toString() {
		return "Attendance_type [type_id=" + type_id + ", type_name=" + type_name + ", in_Attendance_time="
				+ in_Attendance_time + ", out_Attendance_time=" + out_Attendance_time + "]";
	}
	
	public Attendance_type(String type_id, String type_name, String in_Attendance_time, String out_Attendance_time) {
		super();
		this.type_id = type_id;
		this.type_name = type_name;
		this.in_Attendance_time = in_Attendance_time;
		this.out_Attendance_time = out_Attendance_time;
	}

	public Attendance_type() {
		super();
	}
	
	
}
