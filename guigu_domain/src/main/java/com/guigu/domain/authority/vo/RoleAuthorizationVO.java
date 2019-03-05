package com.guigu.domain.authority.vo;

public class RoleAuthorizationVO {

	/*
	 * 角色权限关联实体类
	 */
	
	//角色权限关联编号
	private String ra_Id;
	//角色编号
	private String role_Id;
	//权限编号
	private String au_Id;
	
	//有参构造方法
	public RoleAuthorizationVO(String ra_Id, String role_Id, String au_Id) {
		super();
		this.ra_Id = ra_Id;
		this.role_Id = role_Id;
		this.au_Id = au_Id;
	}

	//无参构造方法
	public RoleAuthorizationVO() {
		super();
	}

	//实体类get和set方法
	public String getRa_Id() {
		return ra_Id;
	}

	public void setRa_Id(String ra_Id) {
		this.ra_Id = ra_Id;
	}

	public String getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(String role_Id) {
		this.role_Id = role_Id;
	}

	public String getAu_Id() {
		return au_Id;
	}

	public void setAu_Id(String au_Id) {
		this.au_Id = au_Id;
	}
	
	
}
