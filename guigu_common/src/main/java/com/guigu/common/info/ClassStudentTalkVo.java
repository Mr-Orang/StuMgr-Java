package com.guigu.common.info;

public class ClassStudentTalkVo {

	String stu_id;//学生学号
	String tc_name;//学生班级
	String stu_name;//学生姓名
	String stu_sex;//学生性别
	int shulian;//谈话记录数量
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getTc_name() {
		return tc_name;
	}
	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	public int getShulian() {
		return shulian;
	}
	public void setShulian(int shulian) {
		this.shulian = shulian;
	}
	@Override
	public String toString() {
		return "ClassStudentTalkVo [stu_id=" + stu_id + ", tc_name=" + tc_name + ", stu_name=" + stu_name + ", stu_sex="
				+ stu_sex + ", shulian=" + shulian + "]";
	}
	public ClassStudentTalkVo(String stu_id, String tc_name, String stu_name, String stu_sex, int shulian) {
		super();
		this.stu_id = stu_id;
		this.tc_name = tc_name;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.shulian = shulian;
	}
	public ClassStudentTalkVo() {
		super();
	}
	
}
