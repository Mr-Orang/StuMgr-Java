package com.guigu.domain.eduoffice;

/**
 * 授课实体类
 * 
 * @author zy
 *
 */
public class GiveLessons {
	// 授课记录编号
	private String gl_id;
	// 班级编号
	private String class_id;
	// 课程编号
	private String sc_id;
	// 时间
	private String time;
	// 老师编号
	private String ter_id;
	// 课程状态(该门课程是否已完结)
	private String status;

	public GiveLessons(String gl_id, String class_id, String sc_id, String time, String ter_id, String status) {
		super();
		this.gl_id = gl_id;
		this.class_id = class_id;
		this.sc_id = sc_id;
		this.time = time;
		this.ter_id = ter_id;
		this.status = status;
	}

	public GiveLessons() {
		super();
	}

	public String getGl_id() {
		return gl_id;
	}

	public void setGl_id(String gl_id) {
		this.gl_id = gl_id;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getSc_id() {
		return sc_id;
	}

	public void setSc_id(String sc_id) {
		this.sc_id = sc_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTer_id() {
		return ter_id;
	}

	public void setTer_id(String ter_id) {
		this.ter_id = ter_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GiveLessons [gl_id=" + gl_id + ", class_id=" + class_id + ", sc_id=" + sc_id + ", time=" + time
				+ ", ter_id=" + ter_id + ", status=" + status + "]";
	}

}
