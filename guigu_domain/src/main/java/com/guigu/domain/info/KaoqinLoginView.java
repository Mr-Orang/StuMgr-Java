package com.guigu.domain.info;

public class KaoqinLoginView {
	public KaoqinLoginView(){
		super();
	}
	private String te_id;//员工编号
	private String role_name;//角色名称
	@Override
	public String toString() {
		return "KaoqinLoginView [te_id=" + te_id + ", role_name=" + role_name + "]";
	}
	public KaoqinLoginView(String te_id, String role_name) {
		super();
		this.te_id = te_id;
		this.role_name = role_name;
	}
	public String getTe_id() {
		return te_id;
	}
	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
}
