package com.guigu.domain.materials;

public class ReturnView {
	private String id;
	private String text;
	private String parentId;

	public ReturnView() {

	}

	public ReturnView(String id, String text, String parentId) {
		this.id = id;
		this.text = text;
		this.parentId = parentId;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
