package com.guigu.domain.info;
//学生谈话详情信息表
public class Talk_Details {
	private String talk_details_id;	//谈话详情编号	
	private String talk_id;			//谈话编号	引用谈话休息表id
	private String stu_id;			//学生编号	
	private String talk_content;    //谈话内容
	private int talk_conte;		//是否确认（学生）	是0，否1
	private String reason;			//未确认原因	
	private String talk_type;		//谈话类型	
	public String getTalk_details_id() {
		return talk_details_id;
	}
	public void setTalk_details_id(String talk_details_id) {
		this.talk_details_id = talk_details_id;
	}
	public String getTalk_id() {
		return talk_id;
	}
	public void setTalk_id(String talk_id) {
		this.talk_id = talk_id;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getTalk_content() {
		return talk_content;
	}
	public void setTalk_content(String talk_content) {
		this.talk_content = talk_content;
	}
	public int getTalk_conte() {
		return talk_conte;
	}
	public void setTalk_conte(int talk_conte) {
		this.talk_conte = talk_conte;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getTalk_type() {
		return talk_type;
	}
	public void setTalk_type(String talk_type) {
		this.talk_type = talk_type;
	}
	@Override
	public String toString() {
		return "Talk_Details [talk_details_id=" + talk_details_id + ", talk_id=" + talk_id + ", stu_id=" + stu_id
				+ ", talk_content=" + talk_content + ", talk_conte=" + talk_conte + ", reason=" + reason
				+ ", talk_type=" + talk_type + "]";
	}
	public Talk_Details(String talk_details_id, String talk_id, String stu_id, String talk_content, int talk_conte,
			String reason, String talk_type) {
		super();
		this.talk_details_id = talk_details_id;
		this.talk_id = talk_id;
		this.stu_id = stu_id;
		this.talk_content = talk_content;
		this.talk_conte = talk_conte;
		this.reason = reason;
		this.talk_type = talk_type;
	}
	public Talk_Details() {
		super();
	}
	
	
}