package com.guigu.domain.info;
/**
 * 菜单类
 * @author Administrator
 *
 */
public class Menus {
	//菜单编号
	private String menu_id;
	//菜单名
	private String menu_name;
	//跳转路径
	private String menu_url;
	//菜单图片
	private String menuiconcls;
	//菜单状态
	private int status;
	//菜单模块
	private String model_id;
	
	public Menus() {
		// TODO Auto-generated constructor stub
	}

	public Menus(String menu_id, String menu_name, String menu_url, String menuiconcls, int status, String model_id) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_url = menu_url;
		this.menuiconcls = menuiconcls;
		this.status = status;
		this.model_id = model_id;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_url() {
		return menu_url;
	}

	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}

	public String getMenuiconcls() {
		return menuiconcls;
	}

	public void setMenuiconcls(String menuiconcls) {
		this.menuiconcls = menuiconcls;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getModel_id() {
		return model_id;
	}

	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}

	@Override
	public String toString() {
		return "Menus [menu_id=" + menu_id + ", menu_name=" + menu_name + ", menu_url=" + menu_url + ", menuiconcls="
				+ menuiconcls + ", status=" + status + ", model_id=" + model_id + "]";
	}
	
	
	
}
