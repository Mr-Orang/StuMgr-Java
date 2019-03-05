package com.guigu.domain.authority.vo;

/*
 * 角色信息实体类
 */

public class RoleVO {
	// 角色编号
	private String role_ID;
	// 角色名称
	private String role_Name;
	// 父角色编号
	private String RoleParent_Id;
	// 角色的状态
	private Integer status;

	// 有参构造方法
	public RoleVO(String role_ID, String role_Name, String roleParent_Id, Integer status) {
		super();
		this.role_ID = role_ID;
		this.role_Name = role_Name;
		RoleParent_Id = roleParent_Id;
		this.status = status;
	}

	// 无参构造方法
	public RoleVO() {
		super();
	}

	// 实体类的get和set方法
	public String getRole_ID() {
		return role_ID;
	}

	public void setRole_ID(String role_ID) {
		this.role_ID = role_ID;
	}

	public String getRole_Name() {
		return role_Name;
	}

	public void setRole_Name(String role_Name) {
		this.role_Name = role_Name;
	}

	public String getRoleParent_Id() {
		return RoleParent_Id;
	}

	public void setRoleParent_Id(String roleParent_Id) {
		RoleParent_Id = roleParent_Id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	

	

	

}
