package com.guigu.domain.authority.vo;

public class MenuModelVO {

	/*
	 * 菜单模块实体类
	 */
	
	//模块编号
	private String model_Id;
	//模块名称
	private String model_Name;
	
	//有参构造方法
	public MenuModelVO(String model_Id, String model_Name) {
		super();
		this.model_Id = model_Id;
		this.model_Name = model_Name;
	}

	//无参构造方
	public MenuModelVO() {
		super();
	}

	//实体类的get和set方法
	public String getModel_Id() {
		return model_Id;
	}

	public void setModel_Id(String model_Id) {
		this.model_Id = model_Id;
	}

	public String getModel_Name() {
		return model_Name;
	}

	public void setModel_Name(String model_Name) {
		this.model_Name = model_Name;
	}
	
	
	
	
	
	
}
