package com.guigu.common.marketing;

import java.io.Serializable;
/**
 * 已安排住宿视图类
 * @author maomao
 *
 */
public class DormView implements Serializable {
	private String tbo_id;//住宿编号
	private String stu_id;//学生编号
	private String stu_name;//学生姓名
	private String tdm_number;//宿舍编号
	public DormView() {
		super();
	}
	public DormView(String tbo_id, String stu_id, String stu_name, String tdm_number) {
		super();
		this.tbo_id = tbo_id;
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.tdm_number = tdm_number;
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
