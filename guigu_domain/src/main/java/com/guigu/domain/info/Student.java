package com.guigu.domain.info;

import java.util.Date;

public class Student {
private String stuid;//学生学号
private String stuname;//学生姓名
private String stusex;//学生性别
private Date stubirthday;//出生日期
private String stucid;
private String stuphone;
private String parphone;
private String address;
private String classid;
private String apartmentid;
private int stustatus;
private String school;
private String rouid;
public String getStuid() {
	return stuid;
}
public void setStuid(String stuid) {
	this.stuid = stuid;
}
public String getStuname() {
	return stuname;
}
public void setStuname(String stuname) {
	this.stuname = stuname;
}
public String getStusex() {
	return stusex;
}
public void setStusex(String stusex) {
	stusex = stusex;
}
public Date getStubirthday() {
	return stubirthday;
}
public void setStubirthday(Date stubirthday) {
	this.stubirthday = stubirthday;
}
public String getStucid() {
	return stucid;
}
public void setStucid(String stucid) {
	this.stucid = stucid;
}
public String getStuphone() {
	return stuphone;
}
public void setStuphone(String stuphone) {
	this.stuphone = stuphone;
}
public String getParphone() {
	return parphone;
}
public void setParphone(String parphone) {
	this.parphone = parphone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getClassid() {
	return classid;
}
public void setClassid(String classid) {
	this.classid = classid;
}
public String getApartmentid() {
	return apartmentid;
}
public void setApartmentid(String apartmentid) {
	this.apartmentid = apartmentid;
}
public int getStustatus() {
	return stustatus;
}
public void setStustatus(int stustatus) {
	this.stustatus = stustatus;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}
public String getRouid() {
	return rouid;
}
public void setRouid(String rouid) {
	this.rouid = rouid;
}
@Override
public String toString() {
	return "Student [stuid=" + stuid + ", stuname=" + stuname + ", Stusex=" + stusex + ", stubirthday=" + stubirthday
			+ ", stucid=" + stucid + ", stuphone=" + stuphone + ", parphone=" + parphone + ", address=" + address
			+ ", classid=" + classid + ", apartmentid=" + apartmentid + ", stustatus=" + stustatus + ", school="
			+ school + ", rouid=" + rouid + "]";
}
public Student(String stuid, String stuname, String stusex, Date stubirthday, String stucid, String stuphone,
		String parphone, String address, String classid, String apartmentid, int stustatus, String school,
		String rouid) {
	super();
	this.stuid = stuid;
	this.stuname = stuname;
	stusex = stusex;
	this.stubirthday = stubirthday;
	this.stucid = stucid;
	this.stuphone = stuphone;
	this.parphone = parphone;
	this.address = address;
	this.classid = classid;
	this.apartmentid = apartmentid;
	this.stustatus = stustatus;
	this.school = school;
	this.rouid = rouid;
}
public Student() {
	// TODO Auto-generated constructor stub
}
}