package com.guigu.domain.authority.view;

public class RoleImplentView {
	private String id;
	private String text;
	private String checked;
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
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public RoleImplentView(String id, String text, String checked) {
		super();
		this.id = id;
		this.text = text;
		this.checked = checked;
	}
	public RoleImplentView() {
		super();
	}
	
}
