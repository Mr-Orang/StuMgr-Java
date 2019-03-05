package com.guigu.domain.info;
/**
 * 菜单视图类
 * @author Administrator
 *
 */
public class MenuView {
	//菜单编号
	private String id;
	//菜单名
	private String text;
	//跳转路径
	private String menu_url;
	//菜单图片
	private String menuiconcls;
		
	public MenuView() {
		// TODO Auto-generated constructor stub
	}

	public MenuView(String id, String text, String menu_url, String menuiconcls) {
		super();
		this.id = id;
		this.text = text;
		this.menu_url = menu_url;
		this.menuiconcls = menuiconcls;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	@Override
	public String toString() {
		return "MenuView [id=" + id + ", text=" + text + ", menu_url=" + menu_url + ", menuiconcls=" + menuiconcls
				+ "]";
	}

	
}
