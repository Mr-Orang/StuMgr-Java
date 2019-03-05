package com.guigu.domain.marketing;

public class Employee {
	/**
	 * te_id VARCHAR2(10) primary key,--编号
	 * 
	 * te_name VARCHAR2(18),--姓名
	 * 
	 * te_mobile VARCHAR2(30),--联系电话
	 * 
	 * te_card_id VARCHAR2(38),--身份证号码
	 * 
	 * te_sex VARCHAR2(10),--性别
	 * 
	 * te_age number(3),--年龄
	 * 
	 * te_marry_status VARCHAR2(10),--是否已婚
	 * 
	 * te_address VARCHAR2(38),--住址
	 * 
	 * te_state VARCHAR2(10)--离职状态
	 */

	private String te_id;
	private String te_name;
	private String te_mobile;
	private String te_card_id;
	private String te_sex;
	private int te_age;
	private String te_marry_status;
	private String te_address;
	private String te_state;

	private String deptID;
	
	public Employee() {
		super();
	}

	
	public Employee(String te_id, String te_name, String te_mobile, String te_card_id, String te_sex, int te_age,
			String te_marry_status, String te_address, String te_state, String deptID) {
		super();
		this.te_id = te_id;
		this.te_name = te_name;
		this.te_mobile = te_mobile;
		this.te_card_id = te_card_id;
		this.te_sex = te_sex;
		this.te_age = te_age;
		this.te_marry_status = te_marry_status;
		this.te_address = te_address;
		this.te_state = te_state;
		this.deptID = deptID;
	}


	public String getDeptID() {
		return deptID;
	}


	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}


	public String getTe_id() {
		return te_id;
	}

	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}

	public String getTe_name() {
		return te_name;
	}

	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}

	public String getTe_mobile() {
		return te_mobile;
	}

	public void setTe_mobile(String te_mobile) {
		this.te_mobile = te_mobile;
	}

	public String getTe_card_id() {
		return te_card_id;
	}

	public void setTe_card_id(String te_card_id) {
		this.te_card_id = te_card_id;
	}

	public String getTe_sex() {
		return te_sex;
	}

	public void setTe_sex(String te_sex) {
		this.te_sex = te_sex;
	}

	public int getTe_age() {
		return te_age;
	}

	public void setTe_age(int te_age) {
		this.te_age = te_age;
	}

	public String getTe_marry_status() {
		return te_marry_status;
	}

	public void setTe_marry_status(String te_marry_status) {
		this.te_marry_status = te_marry_status;
	}

	public String getTe_address() {
		return te_address;
	}

	public void setTe_address(String te_address) {
		this.te_address = te_address;
	}

	public String getTe_state() {
		return te_state;
	}

	public void setTe_state(String te_state) {
		this.te_state = te_state;
	}

	@Override
	public String toString() {
		return "Employee [te_id=" + te_id + ", te_name=" + te_name + ", te_mobile=" + te_mobile + ", te_card_id="
				+ te_card_id + ", te_sex=" + te_sex + ", te_age=" + te_age + ", te_marry_status=" + te_marry_status
				+ ", te_address=" + te_address + ", te_state=" + te_state + "]";
	}

}
