 
 package com.guigu.domain.authority.vo;

/*
 * 菜单信息实体类
 */
public class MenuVO {
	// 菜单编号
	private String menu_Id;
	// 菜单名称
	private String menu_Name;
	// 菜单Url
	private String menu_Url;
	// 菜单图标
	private String menuIconcls;
	// 父菜单编号
	private String menuparent_Id;
	//模块编号
	private String model_Id;
	// 菜单状态
	private Integer status;
	
	// 有参构造方法
	public MenuVO(String menu_Id, String menu_Name, String menu_Url, String menuIconcls, String menuparent_Id,
			String model_Id, Integer status) {
		super();
		this.menu_Id = menu_Id;
		this.menu_Name = menu_Name;
		this.menu_Url = menu_Url;
		this.menuIconcls = menuIconcls;
		this.menuparent_Id = menuparent_Id;
		this.model_Id = model_Id;
		this.status = status;
	}

	// 无参构造方法
	public MenuVO() {
		super();
	}

	// 实体类的get和set方法
	public String getMenu_Id() {
		return menu_Id;
	}

	public void setMenu_Id(String menu_Id) {
		this.menu_Id = menu_Id;
	}

	public String getMenu_Name() {
		return menu_Name;
	}

	public void setMenu_Name(String menu_Name) {
		this.menu_Name = menu_Name;
	}

	public String getMenu_Url() {
		return menu_Url;
	}

	public void setMenu_Url(String menu_Url) {
		this.menu_Url = menu_Url;
	}

	public String getMenuIconcls() {
		return menuIconcls;
	}

	public void setMenuIconcls(String menuIconcls) {
		this.menuIconcls = menuIconcls;
	}

	public String getMenuparent_Id() {
		return menuparent_Id;
	}

	public void setMenuparent_Id(String menuparent_Id) {
		this.menuparent_Id = menuparent_Id;
	}

	public String getModel_Id() {
		return model_Id;
	}

	public void setModel_Id(String model_Id) {
		this.model_Id = model_Id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
