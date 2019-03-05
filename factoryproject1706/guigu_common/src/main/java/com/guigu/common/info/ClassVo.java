package com.guigu.common.info;

public class ClassVo {

	private String id;//班级编号
	private String text;//班级名称
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
	@Override
	public String toString() {
		return "ClassVo [id=" + id + ", text=" + text + "]";
	}
	public ClassVo(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public ClassVo() {
		super();
	}
	
}
