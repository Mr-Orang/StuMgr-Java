package com.guigu.domain.info;



public class StudentInfo {
private String stuid;//学生学号
private String stuname;//学生姓名
private String stusex;//学生性别
private String stubirthday;//出生日期
private String stucid;
private String stuphone;
private String parphone;
private String address;
private String classid;
private String apartmentid;
private int  stustatus;
private String school;
private String rouid;
private String teid;
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
	this.stusex = stusex;
}
public String getStubirthday() {
	return stubirthday;
}
public void setStubirthday(String stubirthday) {
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
public String getTeid() {
	return teid;
}
public void setTeid(String teid) {
	this.teid = teid;
}
@Override
public String toString() {
	return "StudentInfo [stuid=" + stuid + ", stuname=" + stuname + ", stusex=" + stusex + ", stubirthday="
			+ stubirthday + ", stucid=" + stucid + ", stuphone=" + stuphone + ", parphone=" + parphone + ", address="
			+ address + ", classid=" + classid + ", apartmentid=" + apartmentid + ", stustatus=" + stustatus
			+ ", school=" + school + ", rouid=" + rouid + ", teid=" + teid + "]";
}
public StudentInfo(String stuid, String stuname, String stusex, String stubirthday, String stucid, String stuphone,
		String parphone, String address, String classid, String apartmentid, int stustatus, String school, String rouid,
		String teid) {
	super();
	this.stuid = stuid;
	this.stuname = stuname;
	this.stusex = stusex;
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
	this.teid = teid;
}
public StudentInfo() {
	// TODO Auto-generated constructor stub
}
}