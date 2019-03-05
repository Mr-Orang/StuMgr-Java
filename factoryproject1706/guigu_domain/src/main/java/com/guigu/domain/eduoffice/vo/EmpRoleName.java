package com.guigu.domain.eduoffice.vo;

/**
 * 加载下拉框角色名字实体类
 * @author 雷神
 *
 */

public class EmpRoleName {

	private String role_id;
	private String role_name;
	
	
	public EmpRoleName() {
		super();
	}

	public EmpRoleName(String role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "EmpRoleName [role_id=" + role_id + ", role_name=" + role_name + "]";
	}
	
	
	
	
	
}
