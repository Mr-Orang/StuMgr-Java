package com.guigu.domain.info;

public class ChangeClassSearch {
	private String time;
	private Integer in_status;
	private String out_classid;
	
	public ChangeClassSearch() {
		// TODO Auto-generated constructor stub
	}

	public ChangeClassSearch(String time, Integer in_status, String out_classid) {
		super();
		this.time = time;
		this.in_status = in_status;
		this.out_classid = out_classid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getIn_status() {
		return in_status;
	}

	public void setIn_status(Integer in_status) {
		this.in_status = in_status;
	}

	public String getOut_classid() {
		return out_classid;
	}

	public void setOut_classid(String out_classid) {
		this.out_classid = out_classid;
	}

	@Override
	public String toString() {
		return "ChangeClassSearch [time=" + time + ", in_status=" + in_status + ", out_classid=" + out_classid + "]";
	}
	
	
	
}
