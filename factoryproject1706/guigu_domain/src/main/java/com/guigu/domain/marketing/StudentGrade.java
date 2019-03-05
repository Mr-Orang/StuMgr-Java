package com.guigu.domain.marketing;

public class StudentGrade {
	/**
	 * tsg_id	VARCHAR2(2) primary key,--生源等级编号

	tsg_name	VARCHAR2(20),--等级名称

	tsg_statement VARCHAR2(10)--等级状态

	 */
	
	private String tsg_id;
	private String tsg_name;
	private String tsg_statement;
	
	public StudentGrade() {
		super();
	}

	public StudentGrade(String tsg_id, String tsg_name, String tsg_statement) {
		super();
		this.tsg_id = tsg_id;
		this.tsg_name = tsg_name;
		this.tsg_statement = tsg_statement;
	}

	public String getTsg_id() {
		return tsg_id;
	}

	public void setTsg_id(String tsg_id) {
		this.tsg_id = tsg_id;
	}

	public String getTsg_name() {
		return tsg_name;
	}

	public void setTsg_name(String tsg_name) {
		this.tsg_name = tsg_name;
	}

	public String getTsg_statement() {
		return tsg_statement;
	}

	public void setTsg_statement(String tsg_statement) {
		this.tsg_statement = tsg_statement;
	}

	@Override
	public String toString() {
		return "StudentGrade [tsg_id=" + tsg_id + ", tsg_name=" + tsg_name + ", tsg_statement=" + tsg_statement + "]";
	}
	
	
}
