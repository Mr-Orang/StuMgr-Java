package com.guigu.domain.info;

public class Studorm {
private String id;
private String text;
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
	return "studorm [id=" + id + ", text=" + text + "]";
}
public Studorm(String id, String text) {
	super();
	this.id = id;
	this.text = text;
}
public Studorm() {
	// TODO Auto-generated constructor stub
}
}
