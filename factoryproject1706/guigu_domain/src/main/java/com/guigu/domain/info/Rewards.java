package com.guigu.domain.info;

public class Rewards {

	String rewards_id;//奖惩编号
	String review_tid;//举荐人
	String rewards_apply_time;//申请日期
	String review_id;//审批人
	int rewards_status;//审批状态
	String rewards_reason;//不同意原因
	String rewards_time;//审批日期
	public String getRewards_id() {
		return rewards_id;
	}
	public void setRewards_id(String rewards_id) {
		this.rewards_id = rewards_id;
	}
	public String getReview_tid() {
		return review_tid;
	}
	public void setReview_tid(String review_tid) {
		this.review_tid = review_tid;
	}
	public String getRewards_apply_time() {
		return rewards_apply_time;
	}
	public void setRewards_apply_time(String rewards_apply_time) {
		this.rewards_apply_time = rewards_apply_time;
	}
	public String getReview_id() {
		return review_id;
	}
	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}
	public int getRewards_status() {
		return rewards_status;
	}
	public void setRewards_status(int rewards_status) {
		this.rewards_status = rewards_status;
	}
	public String getRewards_reason() {
		return rewards_reason;
	}
	public void setRewards_reason(String rewards_reason) {
		this.rewards_reason = rewards_reason;
	}
	public String getRewards_time() {
		return rewards_time;
	}
	public void setRewards_time(String rewards_time) {
		this.rewards_time = rewards_time;
	}
	@Override
	public String toString() {
		return "Rewards [rewards_id=" + rewards_id + ", review_tid=" + review_tid + ", rewards_apply_time="
				+ rewards_apply_time + ", review_id=" + review_id + ", rewards_status=" + rewards_status
				+ ", rewards_reason=" + rewards_reason + ", rewards_time=" + rewards_time + "]";
	}
	public Rewards(String rewards_id, String review_tid, String rewards_apply_time, String review_id,
			int rewards_status, String rewards_reason, String rewards_time) {
		super();
		this.rewards_id = rewards_id;
		this.review_tid = review_tid;
		this.rewards_apply_time = rewards_apply_time;
		this.review_id = review_id;
		this.rewards_status = rewards_status;
		this.rewards_reason = rewards_reason;
		this.rewards_time = rewards_time;
	}
	public Rewards() {
		super();
	}
	
}
