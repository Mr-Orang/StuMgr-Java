package com.guigu.common.info;

public class StudentApplyInfo {

	private String Stu_name;
	private String Stu_sex;
	private String tc_name;
	private String te_name;
	private String Rewards_apply_time;
	private String Rewards_type;
	private String Rewards_apply_reason;
	
	
	public StudentApplyInfo(String stu_name, String stu_sex, String tc_name, String te_name, String rewards_apply_time,
			String rewards_type, String rewards_apply_reason) {
		super();
		Stu_name = stu_name;
		Stu_sex = stu_sex;
		this.tc_name = tc_name;
		this.te_name = te_name;
		Rewards_apply_time = rewards_apply_time;
		Rewards_type = rewards_type;
		Rewards_apply_reason = rewards_apply_reason;
	}


	public String getStu_name() {
		return Stu_name;
	}


	public void setStu_name(String stu_name) {
		Stu_name = stu_name;
	}


	public String getStu_sex() {
		return Stu_sex;
	}


	public void setStu_sex(String stu_sex) {
		Stu_sex = stu_sex;
	}


	public String getTc_name() {
		return tc_name;
	}


	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
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


	public String getRewards_type() {
		return Rewards_type;
	}


	public void setRewards_type(String rewards_type) {
		Rewards_type = rewards_type;
	}


	public String getRewards_apply_reason() {
		return Rewards_apply_reason;
	}


	public void setRewards_apply_reason(String rewards_apply_reason) {
		Rewards_apply_reason = rewards_apply_reason;
	}


	@Override
	public String toString() {
		return "StudentApplyInfo [Stu_name=" + Stu_name + ", Stu_sex=" + Stu_sex + ", tc_name=" + tc_name + ", te_name="
				+ te_name + ", Rewards_apply_time=" + Rewards_apply_time + ", Rewards_type=" + Rewards_type
				+ ", Rewards_apply_reason=" + Rewards_apply_reason + "]";
	}


	public StudentApplyInfo() {
		super();
	}
	
}
