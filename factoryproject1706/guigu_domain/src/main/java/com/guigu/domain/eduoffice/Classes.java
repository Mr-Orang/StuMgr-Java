package com.guigu.domain.eduoffice;
/**
 * 班级实体类
 * @author zy
 *
 */
public class Classes {
	private String tc_id;
	private String tc_name;
	private int tc_personnum;
	private String tc_technology;
	private String te_id;
	private String tl_id;
	private String tc_entering_date;
	private String tc_open_date;
	
	
	
	public Classes() {
		super();
	}
	public Classes(String tc_id, String tc_name, int tc_personnum, String tc_technology, String te_id, String tl_id,
			String tc_entering_date, String tc_open_date) {
		super();
		this.tc_id = tc_id;
		this.tc_name = tc_name;
		this.tc_personnum = tc_personnum;
		this.tc_technology = tc_technology;
		this.te_id = te_id;
		this.tl_id = tl_id;
		this.tc_entering_date = tc_entering_date;
		this.tc_open_date = tc_open_date;
	}
	public String getTc_id() {
		return tc_id;
	}
	public void setTc_id(String tc_id) {
		this.tc_id = tc_id;
	}
	public String getTc_name() {
		return tc_name;
	}
	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}
	public int getTc_personnum() {
		return tc_personnum;
	}
	public void setTc_personnum(int tc_personnum) {
		this.tc_personnum = tc_personnum;
	}
	public String getTc_technology() {
		return tc_technology;
	}
	public void setTc_technology(String tc_technology) {
		this.tc_technology = tc_technology;
	}
	public String getTe_id() {
		return te_id;
	}
	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}
	public String getTl_id() {
		return tl_id;
	}
	public void setTl_id(String tl_id) {
		this.tl_id = tl_id;
	}
	public String getTc_entering_date() {
		return tc_entering_date;
	}
	public void setTc_entering_date(String tc_entering_date) {
		this.tc_entering_date = tc_entering_date;
	}
	public String getTc_open_date() {
		return tc_open_date;
	}
	public void setTc_open_date(String tc_open_date) {
		this.tc_open_date = tc_open_date;
	}
	
}
