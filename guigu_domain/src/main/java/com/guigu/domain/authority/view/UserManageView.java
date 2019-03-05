package com.guigu.domain.authority.view;


public class UserManageView {
	private String TE_ID;
	private String TE_NAME;
	private String account;
	private String PASSWORD;
	private int status;
	private String role_Name;
	private String deptName;
	private String role_ID;
	private String deptId;
	public String getTE_ID() {
		return TE_ID;
	}
	public void setTE_ID(String tE_ID) {
		TE_ID = tE_ID;
	}
	public String getTE_NAME() {
		return TE_NAME;
	}
	public void setTE_NAME(String tE_NAME) {
		TE_NAME = tE_NAME;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRole_Name() {
		return role_Name;
	}
	public void setRole_Name(String role_Name) {
		this.role_Name = role_Name;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRole_ID() {
		return role_ID;
	}
	public void setRole_ID(String role_ID) {
		this.role_ID = role_ID;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public UserManageView(String tE_ID, String tE_NAME, String account, String pASSWORD, int status, String role_Name,
			String deptName, String role_ID, String deptId) {
		super();
		TE_ID = tE_ID;
		TE_NAME = tE_NAME;
		this.account = account;
		PASSWORD = pASSWORD;
		this.status = status;
		this.role_Name = role_Name;
		this.deptName = deptName;
		this.role_ID = role_ID;
		this.deptId = deptId;
	}
	public UserManageView() {
		super();
	}
	
	
	

}
