package com.guigu.domain.authority.view;

public class RoleAuthorizationView {
	private String role_ID;
	private String role_Name;
	private int status;
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

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public RoleAuthorizationView(String role_ID, String role_Name, int status) {
		super();
		this.role_ID = role_ID;
		this.role_Name = role_Name;

		this.status = status;
	}
	public RoleAuthorizationView() {
		super();
	}
	

}
