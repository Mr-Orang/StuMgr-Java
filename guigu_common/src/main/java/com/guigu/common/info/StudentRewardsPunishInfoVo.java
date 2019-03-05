package com.guigu.common.info;
/**
 * 学生奖罚信息视图类
 * @author Administrator
 *
 */
public class StudentRewardsPunishInfoVo {

	private String rewards_apply_time;//申请时间
	private String te_name;//审批人
	private String rewards_status;//审批状态
	private String rewards_reason;//不同意原因
	private String rewards_time;//审批日期
	private String rewards_type;//奖罚类型
	private String rewards_apply_reason ;//奖罚原因
	
	public StudentRewardsPunishInfoVo(String rewards_apply_time, String te_name, String rewards_status,
			String rewards_reason, String rewards_time, String rewards_type, String rewards_apply_reason) {
		super();
		this.rewards_apply_time = rewards_apply_time;
		this.te_name = te_name;
		this.rewards_status = rewards_status;
		this.rewards_reason = rewards_reason;
		this.rewards_time = rewards_time;
		this.rewards_type = rewards_type;
		this.rewards_apply_reason = rewards_apply_reason;
	}

	public String getRewards_apply_time() {
		return rewards_apply_time;
	}

	public void setRewards_apply_time(String rewards_apply_time) {
		this.rewards_apply_time = rewards_apply_time;
	}

	public String getTe_name() {
		return te_name;
	}

	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}

	public String getRewards_status() {
		return rewards_status;
	}

	public void setRewards_status(String rewards_status) {
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

	public String getRewards_type() {
		return rewards_type;
	}

	public void setRewards_type(String rewards_type) {
		this.rewards_type = rewards_type;
	}

	public String getRewards_apply_reason() {
		return rewards_apply_reason;
	}

	public void setRewards_apply_reason(String rewards_apply_reason) {
		this.rewards_apply_reason = rewards_apply_reason;
	}

	public StudentRewardsPunishInfoVo() {
		super();
	}
	
}
