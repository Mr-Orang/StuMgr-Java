package com.guigu.common.info;

public class KaoqinTypeVo {
	private String id;//考勤类型编号
	private String text;//考勤类型名称
	private String inbegin;//考勤开始时间
	private String eend;//考勤结束时间
	@Override
	public String toString() {
		return "KaoqinTypeVo [id=" + id + ", text=" + text + ", inbegin=" + inbegin + ", eend=" + eend + "]";
	}
	public KaoqinTypeVo(){
		super();
	}
	public KaoqinTypeVo(String id, String text, String inbegin, String eend) {
		super();
		this.id = id;
		this.text = text;
		this.inbegin = inbegin;
		this.eend = eend;
	}
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
	public String getInbegin() {
		return inbegin;
	}
	public void setInbegin(String inbegin) {
		this.inbegin = inbegin;
	}
	public String getEend() {
		return eend;
	}
	public void setEend(String eend) {
		this.eend = eend;
	}
}
