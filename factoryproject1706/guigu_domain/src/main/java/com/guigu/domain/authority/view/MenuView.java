package com.guigu.domain.authority.view;

public class MenuView {

	private String id;
	private String text;
	private String url;
	private String iconCls;
	private String pid;
	private int status;
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
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public MenuView(String id, String text, String url, String iconCls, String pid, int status) {
		super();
		this.id = id;
		this.text = text;
		this.url = url;
		this.iconCls = iconCls;
		this.pid = pid;
		this.status = status;
	}
	public MenuView() {
		super();
	}
	
	
}
