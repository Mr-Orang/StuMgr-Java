package com.guigu.domain.authority.vo;

/*
 *  账号信息实体类
 */

public class AccountVO {
	//登录账号
	private String account;
	//登录口令
	private String passWord;
	//账号状态
	private Integer status;
	//员工类型编号
	private Integer role_Type_Id;
	//员工或学生编号
	private String people_Id;
	
	//有参构造方法
	public AccountVO(String account, String passWord, Integer status, Integer role_Type_Id, String people_Id) {
		super();
		this.account = account;
		this.passWord = passWord;
		this.status = status;
		this.role_Type_Id = role_Type_Id;
		this.people_Id = people_Id;
	}

	//无参构造方法
	public AccountVO() {
		super();
	}

	//实体类get和set方法
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRole_Type_Id() {
		return role_Type_Id;
	}

	public void setRole_Type_Id(Integer role_Type_Id) {
		this.role_Type_Id = role_Type_Id;
	}

	public String getPeople_Id() {
		return people_Id;
	}

	public void setPeople_Id(String people_Id) {
		this.people_Id = people_Id;
	}
}
