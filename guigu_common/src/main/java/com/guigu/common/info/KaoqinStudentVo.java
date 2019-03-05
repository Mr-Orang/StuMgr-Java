package com.guigu.common.info;

public class KaoqinStudentVo {
	/**
	 * select ts.stu_id,ts.stu_name,ts.stu_sex,ts.class_id from t_student
	 * ts,t_classes tc where ts.class_id=tc.tc_id and tc.tc_name='1805JA';
	 */
	private String stu_id;
	private String stu_name;
	private String stu_sex;
	private String class_id;

	public KaoqinStudentVo() {
		super();
	}

	@Override
	public String toString() {
		return "KaoqinStudentVo [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_sex=" + stu_sex + ", class_id="
				+ class_id + "]";
	}

	public KaoqinStudentVo(String stu_id, String stu_name, String stu_sex, String class_id) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.class_id = class_id;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
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

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
}
