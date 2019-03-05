package com.guigu.common.info;

public class Outschool_studentinfo {

//学生信息表+班级视图
	private String stu_id;
	private String stu_name;
	private String stu_sex;
	private String stu_cid;
	private String address;
	private int stu_status;
	private String school;
	private String tc_name;
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
	public String getStu_cid() {
		return stu_cid;
	}
	public void setStu_cid(String stu_cid) {
		this.stu_cid = stu_cid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getTc_name() {
		return tc_name;
	}
	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}
	public Outschool_studentinfo(String stu_id, String stu_name, String stu_sex, String stu_cid, String address,
			int stu_status, String school, String tc_name) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_cid = stu_cid;
		this.address = address;
		this.stu_status = stu_status;
		this.school = school;
		this.tc_name = tc_name;
	}
	public Outschool_studentinfo() {
		super();
	}
	@Override
	public String toString() {
		return "Outschool_studentinfo [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_sex=" + stu_sex
				+ ", stu_cid=" + stu_cid + ", address=" + address + ", stu_status=" + stu_status + ", school=" + school
				+ ", tc_name=" + tc_name + "]";
	}
	
}
