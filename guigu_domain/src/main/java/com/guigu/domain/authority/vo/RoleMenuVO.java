package com.guigu.domain.authority.vo;

/*
 * 角色菜单关联实体类
 */
public class RoleMenuVO {

	// 角色菜单关联编号
	private String rm_Id;
	// 角色编号
	private String role_Id;
	// 菜单编号
	private String menu_Id;
	
	// 有参构造方法
	public RoleMenuVO(String rm_Id, String role_Id, String menu_Id) {
		super();
		this.rm_Id = rm_Id;
		this.role_Id = role_Id;
		this.menu_Id = menu_Id;
	}

	// 无参的构造方法
	public RoleMenuVO() {
		super();
	}

	// 实体类的get和set方法
	public String getRm_Id() {
		return rm_Id;
	}

	public void setRm_Id(String rm_Id) {
		this.rm_Id = rm_Id;
	}

	public String getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(String role_Id) {
		this.role_Id = role_Id;
	}

	public String getMenu_Id() {
		return menu_Id;
	}

	public void setMenu_Id(String menu_Id) {
		this.menu_Id = menu_Id;
	}
    
	
}
