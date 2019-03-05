package com.guigu.common.info;

public class TalkClassStudentVo {

	String talk_details_id;//谈话编号
	String talk_type;//谈话类型
	String stu_name;//现实姓名
	String talk_content;//谈话内容
	String talk_person;//谈话人
	int viewpoint;//状态
	String reason;//不同意本次谈话的理由
	String talk_time;//谈话时间
	public String getTalk_details_id() {
		return talk_details_id;
	}
	public void setTalk_details_id(String talk_details_id) {
		this.talk_details_id = talk_details_id;
	}
	public String getTalk_type() {
		return talk_type;
	}
	public void setTalk_type(String talk_type) {
		this.talk_type = talk_type;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getTalk_content() {
		return talk_content;
	}
	public void setTalk_content(String talk_content) {
		this.talk_content = talk_content;
	}
	public String getTalk_person() {
		return talk_person;
	}
	public void setTalk_person(String talk_person) {
		this.talk_person = talk_person;
	}
	public int getViewpoint() {
		return viewpoint;
	}
	public void setViewpoint(int viewpoint) {
		this.viewpoint = viewpoint;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getTalk_time() {
		return talk_time;
	}
	public void setTalk_time(String talk_time) {
		this.talk_time = talk_time;
	}
	@Override
	public String toString() {
		return "TalkClassStudentVo [talk_details_id=" + talk_details_id + ", talk_type=" + talk_type + ", stu_name="
				+ stu_name + ", talk_content=" + talk_content + ", talk_person=" + talk_person + ", viewpoint="
				+ viewpoint + ", reason=" + reason + ", talk_time=" + talk_time + "]";
	}
	public TalkClassStudentVo(String talk_details_id, String talk_type, String stu_name, String talk_content,
			String talk_person, int viewpoint, String reason, String talk_time) {
		super();
		this.talk_details_id = talk_details_id;
		this.talk_type = talk_type;
		this.stu_name = stu_name;
		this.talk_content = talk_content;
		this.talk_person = talk_person;
		this.viewpoint = viewpoint;
		this.reason = reason;
		this.talk_time = talk_time;
	}
	public TalkClassStudentVo() {
		super();
	}
	
}
