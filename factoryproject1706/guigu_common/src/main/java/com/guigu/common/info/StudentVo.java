package com.guigu.common.info;
/**
 * 学生视图类
 * @author Administrator
 *
 */
public class StudentVo {

	private String stu_id;//学生编号
	private String stu_name;//学生姓名
	private String stu_sex;//学生性别
	private String stu_phone;//学生电话
	private String par_phone;//家长电话
	private String address;//家庭地址
	private String tc_name;//班级名称
	private String apartment_id;//宿舍编号
	private String stu_Status;//是否在读状态
	private String school;//毕业院校
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
	public String getTc_name() {
		return tc_name;
	}
	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}
	public String getApartment_id() {
		return apartment_id;
	}
	public void setApartment_id(String apartment_id) {
		this.apartment_id = apartment_id;
	}
	public String getStu_Status() {
		return stu_Status;
	}
	public void setStu_Status(String stu_Status) {
		this.stu_Status = stu_Status;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public StudentVo(String stu_id, String stu_name, String stu_sex, String stu_phone, String par_phone, String address,
			String tc_name, String apartment_id, String stu_Status, String school) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_phone = stu_phone;
		this.par_phone = par_phone;
		this.address = address;
		this.tc_name = tc_name;
		this.apartment_id = apartment_id;
		this.stu_Status = stu_Status;
		this.school = school;
	}
	public StudentVo() {
		super();
	}
}
