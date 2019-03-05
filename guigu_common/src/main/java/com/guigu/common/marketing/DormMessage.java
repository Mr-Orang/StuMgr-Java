package com.guigu.common.marketing;
/**
 * 宿舍信息视图类
 * @author lijianghua
 *
 */
public class DormMessage {
	private String tdm_id;
	private String tdm_number;
	private Integer tdm_bed;
	private Integer tdm_nowbed;
	private String tdm_state;
	private String tdm_typename;
	private Integer tdm_typeid;
	public DormMessage() {
		super();
	}
	public DormMessage(String tdm_id, String tdm_number, Integer tdm_bed, Integer tdm_nowbed, String tdm_state,
			String tdm_typename, Integer tdm_typeid) {
		super();
		this.tdm_id = tdm_id;
		this.tdm_number = tdm_number;
		this.tdm_bed = tdm_bed;
		this.tdm_nowbed = tdm_nowbed;
		this.tdm_state = tdm_state;
		this.tdm_typename = tdm_typename;
		this.tdm_typeid = tdm_typeid;
	}
	public String getTdm_id() {
		return tdm_id;
	}
	public void setTdm_id(String tdm_id) {
		this.tdm_id = tdm_id;
	}
	public String getTdm_number() {
		return tdm_number;
	}
	public void setTdm_number(String tdm_number) {
		this.tdm_number = tdm_number;
	}
	public Integer getTdm_bed() {
		return tdm_bed;
	}
	public void setTdm_bed(Integer tdm_bed) {
		this.tdm_bed = tdm_bed;
	}
	public Integer getTdm_nowbed() {
		return tdm_nowbed;
	}
	public void setTdm_nowbed(Integer tdm_nowbed) {
		this.tdm_nowbed = tdm_nowbed;
	}
	public String getTdm_state() {
		return tdm_state;
	}
	public void setTdm_state(String tdm_state) {
		this.tdm_state = tdm_state;
	}
	public String getTdm_typename() {
		return tdm_typename;
	}
	public void setTdm_typename(String tdm_typename) {
		this.tdm_typename = tdm_typename;
	}
	public Integer getTdm_typeid() {
		return tdm_typeid;
	}
	public void setTdm_typeid(Integer tdm_typeid) {
		this.tdm_typeid = tdm_typeid;
	}
	@Override
	public String toString() {
		return "DormMessage [tdm_id=" + tdm_id + ", tdm_number=" + tdm_number + ", tdm_bed=" + tdm_bed + ", tdm_nowbed="
				+ tdm_nowbed + ", tdm_state=" + tdm_state + ", tdm_typename=" + tdm_typename + ", tdm_typeid="
				+ tdm_typeid + "]";
	}
	
	
}
