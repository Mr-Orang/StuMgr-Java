package com.guigu.domain.eduoffice.vo;

/**
 * 授课信息视图类
 * 
 * @author zy
 *
 */
public class GiveLessonsVo {
	private String gl_id;
	private String tc_name;
	private String tc_cid;
	private String tc_cname;
	private String te_name;
	private String status;

	public String getGl_id() {
		return gl_id;
	}

	public GiveLessonsVo() {
		super();
	}

	public GiveLessonsVo(String gl_id, String tc_name, String tc_cid, String tc_cname, String te_name, String status) {
		super();
		this.gl_id = gl_id;
		this.tc_name = tc_name;
		this.tc_cid = tc_cid;
		this.tc_cname = tc_cname;
		this.te_name = te_name;
		this.status = status;
	}

	public void setGl_id(String gl_id) {
		this.gl_id = gl_id;
	}

	public String getTc_name() {
		return tc_name;
	}

	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}

	public String getTc_cid() {
		return tc_cid;
	}

	public void setTc_cid(String tc_cid) {
		this.tc_cid = tc_cid;
	}

	public String getTc_cname() {
		return tc_cname;
	}

	public void setTc_cname(String tc_cname) {
		this.tc_cname = tc_cname;
	}

	public String getTe_name() {
		return te_name;
	}

	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if (status == 0) {
			this.status = "未结课";
		} else if (status == 1) {
			this.status = "已结课";
		}
	}

}
