package com.guigu.domain.eduoffice;

/**
 * 课程作业实体类
 * 
 * @author zy
 *
 */
public class CourseWork {
	// 课程作业编号
	private String cw_id;
	// 班级编号
	private String class_id;
	// 对应的课程的章节
	private String sc_id;
	// 日期
	private String date;
	// 是否开启
	private int state;

	public CourseWork(String cw_id, String class_id, String sc_id, String date, int state) {
		super();
		this.cw_id = cw_id;
		this.class_id = class_id;
		this.sc_id = sc_id;
		this.date = date;
		this.state = state;
	}

	public CourseWork() {
		super();
	}

	public String getCw_id() {
		return cw_id;
	}

	public void setCw_id(String cw_id) {
		this.cw_id = cw_id;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "CourseWork [cw_id=" + cw_id + ", class_id=" + class_id + ", sc_id=" + sc_id + ", date=" + date
				+ ", state=" + state + "]";
	}

}
