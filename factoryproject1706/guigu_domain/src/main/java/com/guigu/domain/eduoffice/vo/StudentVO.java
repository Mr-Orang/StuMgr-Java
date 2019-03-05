package com.guigu.domain.eduoffice.vo;

import java.util.Date;
	
	public class StudentVO {
	private String stu_id;//学生学号
	private String stu_name;//学生姓名
	private String stu_sex;//学生性别
	private Date stu_birthday;//出生日期
	private String stu_cid;
	private String stu_phone;
	private String par_phone;
	private String address;
	private String class_id;
	private String apartment_id;
	private int stu_status;
	private String school;
	private String rou_id;
	
	public StudentVO() {
		// TODO Auto-generated constructor stub
	}

	public StudentVO(String stu_id, String stu_name, String stu_sex, Date stu_birthday, String stu_cid,
			String stu_phone, String par_phone, String address, String class_id, String apartment_id, int stu_status,
			String school, String rou_id) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_birthday = stu_birthday;
		this.stu_cid = stu_cid;
		this.stu_phone = stu_phone;
		this.par_phone = par_phone;
		this.address = address;
		this.class_id = class_id;
		this.apartment_id = apartment_id;
		this.stu_status = stu_status;
		this.school = school;
		this.rou_id = rou_id;
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

	public Date getStu_birthday() {
		return stu_birthday;
	}

	public void setStu_birthday(Date stu_birthday) {
		this.stu_birthday = stu_birthday;
	}

	public String getStu_cid() {
		return stu_cid;
	}

	public void setStu_cid(String stu_cid) {
		this.stu_cid = stu_cid;
	}

	public String getStu_phone() {
		return stu_phone;
	}

	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}

	public String getPar_phone() {
		return par_phone;
	}

	public void setPar_phone(String par_phone) {
		this.par_phone = par_phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getApartment_id() {
		return apartment_id;
	}

	public void setApartment_id(String apartment_id) {
		this.apartment_id = apartment_id;
	}

	public int getStu_status() {
		return stu_status;
	}

	public void setStu_status(int stu_status) {
		this.stu_status = stu_status;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getRou_id() {
		return rou_id;
	}

	public void setRou_id(String rou_id) {
		this.rou_id = rou_id;
	}

	@Override
	public String toString() {
		return "StudentVO [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_sex=" + stu_sex + ", stu_birthday="
				+ stu_birthday + ", stu_cid=" + stu_cid + ", stu_phone=" + stu_phone + ", par_phone=" + par_phone
				+ ", address=" + address + ", class_id=" + class_id + ", apartment_id=" + apartment_id + ", stu_status="
				+ stu_status + ", school=" + school + ", rou_id=" + rou_id + "]";
	}

}