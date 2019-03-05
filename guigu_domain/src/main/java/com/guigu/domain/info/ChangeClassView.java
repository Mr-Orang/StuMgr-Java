package com.guigu.domain.info;


public class ChangeClassView {
	//转班编号
	private String tcc_id;
	//学号
	private String stu_id;
	//学生姓名
	private String stu_name;
	//转入班级编号
	private String in_classid;
	//转入班级名称
	private String in_classname;
	//转出班级编号
	private String out_classid;
	//转出班级名称
	private String out_classname;
	//学生申请原因
	private String put_reason;
	//转班状态
	private int state;
	//学生申请时间
	private String time;
	//转出审核人编号
	private String out_check;
	//转出审核人名称
	private String out_person;
	//转出不同意原因
	private String out_reason;
	//转出审批状态
	private int out_status;
	//转出审批日期
	private String out_time;
	//转入审批人编号
	private String in_check;
	//转入审批人名称
	private String in_person;
	//转入不同意原因
	private String in_reason;
	//转入审批状态
	private Integer in_status;
	//转入审批日期
	private String in_time;
	
	public ChangeClassView() {
		// TODO Auto-generated constructor stub
	}

	public ChangeClassView(String tcc_id, String stu_id, String stu_name, String in_classid, String in_classname,
			String out_classid, String out_classname, String put_reason, int state, String time, String out_check,
			String out_person, String out_reason, int out_status, String out_time, String in_check, String in_person,
			String in_reason, int in_status, String in_time) {
		super();
		this.tcc_id = tcc_id;
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.in_classid = in_classid;
		this.in_classname = in_classname;
		this.out_classid = out_classid;
		this.out_classname = out_classname;
		this.put_reason = put_reason;
		this.state = state;
		this.time = time;
		this.out_check = out_check;
		this.out_person = out_person;
		this.out_reason = out_reason;
		this.out_status = out_status;
		this.out_time = out_time;
		this.in_check = in_check;
		this.in_person = in_person;
		this.in_reason = in_reason;
		this.in_status = in_status;
		this.in_time = in_time;
	}

	public String getTcc_id() {
		return tcc_id;
	}

	public void setTcc_id(String tcc_id) {
		this.tcc_id = tcc_id;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getIn_classid() {
		return in_classid;
	}

	public void setIn_classid(String in_classid) {
		this.in_classid = in_classid;
	}

	public String getIn_classname() {
		return in_classname;
	}

	public void setIn_classname(String in_classname) {
		this.in_classname = in_classname;
	}

	public String getOut_classid() {
		return out_classid;
	}

	public void setOut_classid(String out_classid) {
		this.out_classid = out_classid;
	}

	public String getOut_classname() {
		return out_classname;
	}

	public void setOut_classname(String out_classname) {
		this.out_classname = out_classname;
	}

	public String getPut_reason() {
		return put_reason;
	}

	public void setPut_reason(String put_reason) {
		this.put_reason = put_reason;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getOut_check() {
		return out_check;
	}

	public void setOut_check(String out_check) {
		this.out_check = out_check;
	}

	public String getOut_person() {
		return out_person;
	}

	public void setOut_person(String out_person) {
		this.out_person = out_person;
	}

	public String getOut_reason() {
		return out_reason;
	}

	public void setOut_reason(String out_reason) {
		this.out_reason = out_reason;
	}

	public int getOut_status() {
		return out_status;
	}

	public void setOut_status(int out_status) {
		this.out_status = out_status;
	}

	public String getOut_time() {
		return out_time;
	}

	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}

	public String getIn_check() {
		return in_check;
	}

	public void setIn_check(String in_check) {
		this.in_check = in_check;
	}

	public String getIn_person() {
		return in_person;
	}

	public void setIn_person(String in_person) {
		this.in_person = in_person;
	}

	public String getIn_reason() {
		return in_reason;
	}

	public void setIn_reason(String in_reason) {
		this.in_reason = in_reason;
	}

	public Integer getIn_status() {
		return in_status;
	}

	public void setIn_status(Integer in_status) {
		this.in_status = in_status;
	}

	public String getIn_time() {
		return in_time;
	}

	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}

	@Override
	public String toString() {
		return "ChangeClassView [tcc_id=" + tcc_id + ", stu_id=" + stu_id + ", stu_name=" + stu_name + ", in_classid="
				+ in_classid + ", in_classname=" + in_classname + ", out_classid=" + out_classid + ", out_classname="
				+ out_classname + ", put_reason=" + put_reason + ", state=" + state + ", time=" + time + ", out_check="
				+ out_check + ", out_person=" + out_person + ", out_reason=" + out_reason + ", out_status=" + out_status
				+ ", out_time=" + out_time + ", in_check=" + in_check + ", in_person=" + in_person + ", in_reason="
				+ in_reason + ", in_status=" + in_status + ", in_time=" + in_time + "]";
	}

	
	
}
