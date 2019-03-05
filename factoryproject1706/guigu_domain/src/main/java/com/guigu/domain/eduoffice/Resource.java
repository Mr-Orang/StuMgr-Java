package com.guigu.domain.eduoffice;

/**
 * 资源实体类
 * 
 * @author zy
 *
 */
public class Resource {
	// 资源编号
	private String re_id;
	// 资源类型
	private String re_type;
	// 资源名称
	private String re_name;
	// 对应章节编号
	private String tc_chid;
	// 资源所有者
	private String userid;
	// 资源所在地
	private String re_adress;
	// 资源浏览量
	private String re_view;
	// 日期
	private String date;

	public Resource(String re_id, String re_type, String re_name, String tc_chid, String userid, String re_adress,
			String re_view, String date) {
		super();
		this.re_id = re_id;
		this.re_type = re_type;
		this.re_name = re_name;
		this.tc_chid = tc_chid;
		this.userid = userid;
		this.re_adress = re_adress;
		this.re_view = re_view;
		this.date = date;
	}

	public Resource() {
		super();
	}

	public String getRe_id() {
		return re_id;
	}

	public void setRe_id(String re_id) {
		this.re_id = re_id;
	}

	public String getRe_type() {
		return re_type;
	}

	public void setRe_type(String re_type) {
		this.re_type = re_type;
	}

	public String getRe_name() {
		return re_name;
	}

	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}

	public String getTc_chid() {
		return tc_chid;
	}

	public void setTc_chid(String tc_chid) {
		this.tc_chid = tc_chid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRe_adress() {
		return re_adress;
	}

	public void setRe_adress(String re_adress) {
		this.re_adress = re_adress;
	}

	public String getRe_view() {
		return re_view;
	}

	public void setRe_view(String re_view) {
		this.re_view = re_view;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Resource [re_id=" + re_id + ", re_type=" + re_type + ", re_name=" + re_name + ", tc_chid=" + tc_chid
				+ ", userid=" + userid + ", re_adress=" + re_adress + ", re_view=" + re_view + ", date=" + date + "]";
	}

}
