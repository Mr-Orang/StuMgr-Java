package com.guigu.domain.info;

public class Talk {

	String talk_id;//谈话编号
	String talk_person;//谈话人编号
	String talk_time;//谈话日期
	public String getTalk_id() {
		return talk_id;
	}
	public void setTalk_id(String talk_id) {
		this.talk_id = talk_id;
	}
	public String getTalk_person() {
		return talk_person;
	}
	public void setTalk_person(String talk_person) {
		this.talk_person = talk_person;
	}
	public String getTalk_time() {
		return talk_time;
	}
	public void setTalk_time(String talk_time) {
		this.talk_time = talk_time;
	}
	@Override
	public String toString() {
		return "Talk [talk_id=" + talk_id + ", talk_person=" + talk_person + ", talk_time=" + talk_time + "]";
	}
	public Talk(String talk_id, String talk_person, String talk_time) {
		super();
		this.talk_id = talk_id;
		this.talk_person = talk_person;
		this.talk_time = talk_time;
	}
	public Talk() {
		super();
	}
	
	
}
