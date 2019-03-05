package com.guigu.common.info;
/**
 * 奖罚未审批申请单视图
 * @author Administrator
 *
 */
public class RewardsInfo {

	private String rewards_id;
	private String te_name;
	private String Rewards_apply_time;
	public String getRewards_id() {
		return rewards_id;
	}
	public void setRewards_id(String rewards_id) {
		this.rewards_id = rewards_id;
	}
	public String getTe_name() {
		return te_name;
	}
	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}
	public String getRewards_apply_time() {
		return Rewards_apply_time;
	}
	public void setRewards_apply_time(String rewards_apply_time) {
		Rewards_apply_time = rewards_apply_time;
	}
	public RewardsInfo(String rewards_id, String te_name, String rewards_apply_time) {
		super();
		this.rewards_id = rewards_id;
		this.te_name = te_name;
		Rewards_apply_time = rewards_apply_time;
	}
	public RewardsInfo() {
		super();
	}
	@Override
	public String toString() {
		return "RewardsInfo [rewards_id=" + rewards_id + ", te_name=" + te_name + ", Rewards_apply_time="
				+ Rewards_apply_time + "]";
	}
	
}
