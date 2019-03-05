package com.guigu.domain.marketing;

public class Menu {
	/*
	 * 菜单信息实体类
	 */
	// 菜单编号
	private String id;
	// 菜单名称
	private String text;
	// 菜单Url
	private String url;
	// 菜单图标
	private String menuIconcls;
	// 父菜单编号
	private String pid;
	// 菜单状态
	private Integer status;
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	public Menu(String id, String text, String url, String menuIconcls, String pid, Integer status) {
		super();
		this.id = id;
		this.text = text;
		this.url = url;
		this.menuIconcls = menuIconcls;
		this.pid = pid;
		this.status = status;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMenuIconcls() {
		return menuIconcls;
	}
	public void setMenuIconcls(String menuIconcls) {
		this.menuIconcls = menuIconcls;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", text=" + text + ", url=" + url + ", menuIconcls=" + menuIconcls + ", pid=" + pid
				+ ", status=" + status + "]";
	}
	
}
