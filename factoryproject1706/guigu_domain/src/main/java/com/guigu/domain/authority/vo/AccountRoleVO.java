package com.guigu.domain.authority.vo;

public class AccountRoleVO {

	/*
	 * 账号角色关联实体类
	 */
	
	//账号角色关联编号
	private String ar_Id;
	//登录账号
	private String acc_Id;
	//角色编号
	private String role_Id;
	
	//有参构造方法
	public AccountRoleVO(String ar_Id, String acc_Id, String role_Id) {
		super();
		this.ar_Id = ar_Id;
		this.acc_Id = acc_Id;
		this.role_Id = role_Id;
	}

	//无参构造方法
	public AccountRoleVO() {
		super();
	}

	//实体类的get和set方法
	public String getAr_Id() {
		return ar_Id;
	}

	public void setAr_Id(String ar_Id) {
		this.ar_Id = ar_Id;
	}

	public String getAcc_Id() {
		return acc_Id;
	}

	public void setAcc_Id(String acc_Id) {
		this.acc_Id = acc_Id;
	}

	public String getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(String role_Id) {
		this.role_Id = role_Id;
	}
	
}
