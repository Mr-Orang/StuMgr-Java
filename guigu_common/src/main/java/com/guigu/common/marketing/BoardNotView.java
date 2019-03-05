package com.guigu.common.marketing;

import java.io.Serializable;

/**
 * 未安排住宿的学生视图类
 * @author maomao
 *
 */
public class BoardNotView implements Serializable {
	private String stu_id;//学生编号
	private String stu_name;//学生姓名
	private String stu_sex;//学生性别
	private String address;//学生地址
	private String tc_name;//班级名称
	public BoardNotView() {
		super();
	}
	public BoardNotView(String stu_id, String stu_name, String stu_sex, String address, String tc_name) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.address = address;
		this.tc_name = tc_name;
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
	
	
}
