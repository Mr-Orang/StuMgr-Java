package com.guigu.common.marketing;

import java.io.Serializable;
/**
 * 已安排住宿视图类
 * @author maomao
 *
 */
public class BoardView implements Serializable {
	private String tbo_id;//住宿编号
	private String stu_id;//学生编号
	private String stu_name;//学生姓名
	private String tdm_number;//宿舍编号
	private String tc_name;//班级名称
	public BoardView() {
		super();
	}
	
	public BoardView(String tbo_id, String stu_id, String stu_name, String tdm_number, String tc_name) {
		super();
		this.tbo_id = tbo_id;
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.tdm_number = tdm_number;
		this.tc_name = tc_name;
	}

	public String getTc_name() {
		return tc_name;
	}

	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}

	public String getTbo_id() {
		return tbo_id;
	}
	public void setTbo_id(String tbo_id) {
		this.tbo_id = tbo_id;
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
	public String getTdm_number() {
		return tdm_number;
	}
	public void setTdm_number(String tdm_number) {
		this.tdm_number = tdm_number;
	}
	
}
