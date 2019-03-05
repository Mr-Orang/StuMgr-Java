package com.guigu.domain.info;

public class Rewards_details {

	String details_id;//奖惩详情编号
	String rewards_id;//奖惩编号
	int rewards_type;//奖惩类型
	String stu_id;//学生学号
	String rewards_apply_reason;//奖惩原因
	public String getDetails_id() {
		return details_id;
	}
	public void setDetails_id(String details_id) {
		this.details_id = details_id;
	}
	public String getRewards_id() {
		return rewards_id;
	}
	public void setRewards_id(String rewards_id) {
		this.rewards_id = rewards_id;
	}
	public int getRewards_type() {
		return rewards_type;
	}
	public void setRewards_type(int rewards_type) {
		this.rewards_type = rewards_type;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getRewards_apply_reason() {
		return rewards_apply_reason;
	}
	public void setRewards_apply_reason(String rewards_apply_reason) {
		this.rewards_apply_reason = rewards_apply_reason;
	}
	@Override
	public String toString() {
		return "Rewards_details [details_id=" + details_id + ", rewards_id=" + rewards_id + ", rewards_type="
				+ rewards_type + ", stu_id=" + stu_id + ", rewards_apply_reason=" + rewards_apply_reason + "]";
	}
	public Rewards_details(String details_id, String rewards_id, int rewards_type, String stu_id,
			String rewards_apply_reason) {
		super();
		this.details_id = details_id;
		this.rewards_id = rewards_id;
		this.rewards_type = rewards_type;
		this.stu_id = stu_id;
		this.rewards_apply_reason = rewards_apply_reason;
	}
	public Rewards_details() {
		super();
	}
	
}
