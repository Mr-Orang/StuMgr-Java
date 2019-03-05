package com.guigu.common.info;

import java.util.Date;

/**
 * 老师查看学生奖励和处分视图类
 * @author Administrator
 *
 */
public class StudentRewardsVo {

	private String stu_name;//学生姓名
	private String stu_sex;//学生性别
	private String tc_name;//学生班级名称
	private String rewards_type;//奖惩类型
	private String rewards_apply_reason;//奖惩原因
	private String rewards_apply_time;//申请日期
	private String rewards_time;//审批日期
	private String te_name;//审批人
	private String rewards_status;//审批状态
	private String rewards_reason;//不同意原因
	
	public StudentRewardsVo(String stu_name, String stu_sex, String tc_name, String rewards_type,
			String rewards_apply_reason, String rewards_apply_time, String rewards_time, String te_name,
			String rewards_status, String rewards_reason) {
		super();
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.tc_name = tc_name;
		this.rewards_type = rewards_type;
		this.rewards_apply_reason = rewards_apply_reason;
		this.rewards_apply_time = rewards_apply_time;
		this.rewards_time = rewards_time;
		this.te_name = te_name;
		this.rewards_status = rewards_status;
		this.rewards_reason = rewards_reason;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public String getTc_name() {
		return tc_name;
	}

	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
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

	public String getRewards_apply_time() {
		return rewards_apply_time;
	}

	public void setRewards_apply_time(String rewards_apply_time) {
		this.rewards_apply_time = rewards_apply_time;
	}

	public String getRewards_time() {
		return rewards_time;
	}

	public void setRewards_time(String rewards_time) {
		this.rewards_time = rewards_time;
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

	public StudentRewardsVo() {
		super();
	}

	@Override
	public String toString() {
		return "StudentRewardsVo [stu_name=" + stu_name + ", stu_sex=" + stu_sex + ", tc_name=" + tc_name
				+ ", rewards_type=" + rewards_type + ", rewards_apply_reason=" + rewards_apply_reason
				+ ", rewards_apply_time=" + rewards_apply_time + ", rewards_time=" + rewards_time + ", te_name="
				+ te_name + ", rewards_reason=" + rewards_reason + "]";
	}

	
	
}
