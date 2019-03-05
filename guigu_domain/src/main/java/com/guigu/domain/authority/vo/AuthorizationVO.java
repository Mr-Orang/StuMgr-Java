package com.guigu.domain.authority.vo;

public class AuthorizationVO {

	/*
	 * 权限信息实体类
	 */

	// 权限编号
	private String au_Id;
	// 权限名称
	private String au_Name;
	// 权限Url
	private String au_Url;
	// 权限状态
	private Integer status;
	
	//有参的构造方法
	public AuthorizationVO(String au_Id, String au_Name, String au_Url, Integer status) {
		super();
		this.au_Id = au_Id;
		this.au_Name = au_Name;
		this.au_Url = au_Url;
		this.status = status;
	}

	//无参的构造方法
	public AuthorizationVO() {
		super();
	}

	//实体类的get和set方法
	public String getAu_Id() {
		return au_Id;
	}

	public void setAu_Id(String au_Id) {
		this.au_Id = au_Id;
	}

	public String getAu_Name() {
		return au_Name;
	}

	public void setAu_Name(String au_Name) {
		this.au_Name = au_Name;
	}

	public String getAu_Url() {
		return au_Url;
	}

	public void setAu_Url(String au_Url) {
		this.au_Url = au_Url;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
