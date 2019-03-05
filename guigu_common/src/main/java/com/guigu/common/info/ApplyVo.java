package com.guigu.common.info;
/**
 * 老师申请信息视图
 * @author Administrator
 *
 */
public class ApplyVo {

	private String stu_name;//学生姓名
	private String stu_sex;//学生性别
	private String tc_name;//班级名称
	private String tname;//举荐人名字
	private String rewards_type;//奖罚类型
	private String rewards_apply_reason;//奖罚原因
	private String rewards_apply_time;//申请时间
	private String rewards_time;//审核时间
	private String rewards_status;//审核状态
	private String rewards_reason;//不同意理由
	private String review_id;//审核人编号
	private String te_name;//审核人名字
	
	
	public ApplyVo(String stu_name, String stu_sex, String tc_name, String tname, String rewards_type,
			String rewards_apply_reason, String rewards_apply_time, String rewards_time, String rewards_status,
			String rewards_reason, String review_id, String te_name) {
		super();
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.tc_name = tc_name;
		this.tname = tname;
		this.rewards_type = rewards_type;
		this.rewards_apply_reason = rewards_apply_reason;
		this.rewards_apply_time = rewards_apply_time;
		this.rewards_time = rewards_time;
		this.rewards_status = rewards_status;
		this.rewards_reason = rewards_reason;
		this.review_id = review_id;
		this.te_name = te_name;
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
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
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
	public String getReview_id() {
		return review_id;
	}
	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}
	public String getTe_name() {
		return te_name;
	}
	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}
	public ApplyVo() {
		super();
	}
	@Override
	public String toString() {
		return "ApplyVo [stu_name=" + stu_name + ", tc_name=" + tc_name + ", tname=" + tname + ", rewards_type="
				+ rewards_type + ", rewards_apply_reason=" + rewards_apply_reason + ", rewards_apply_time="
				+ rewards_apply_time + ", rewards_time=" + rewards_time + ", rewards_status=" + rewards_status
				+ ", rewards_reason=" + rewards_reason + ", review_id=" + review_id + ", te_name=" + te_name + "]";
	}
	
}
