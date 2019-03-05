package com.guigu.common.info;

/**
 * 学生退学申请信息
 * @author dyc
 *
 */
public class StuOutschool {

	private String dropout_id;
	private String stu_id;
	private String stu_name;
	private String dropout_reason;
	private String approver_time;
	private String review_id;
	private int review_status;
	private String review_reason;
	private String review_time;
	public String getDropout_id() {
		return dropout_id;
	}
	public void setDropout_id(String dropout_id) {
		this.dropout_id = dropout_id;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getDropout_reason() {
		return dropout_reason;
	}
	public void setDropout_reason(String dropout_reason) {
		this.dropout_reason = dropout_reason;
	}
	public String getApprover_time() {
		return approver_time;
	}
	public void setApprover_time(String approver_time) {
		this.approver_time = approver_time;
	}
	public String getReview_id() {
		return review_id;
	}
	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}
	public int getReview_status() {
		return review_status;
	}
	public void setReview_status(int review_status) {
		this.review_status = review_status;
	}
	public String getReview_reason() {
		return review_reason;
	}
	public void setReview_reason(String review_reason) {
		this.review_reason = review_reason;
	}
	public String getReview_time() {
		return review_time;
	}
	public void setReview_time(String review_time) {
		this.review_time = review_time;
	}
	public StuOutschool(String dropout_id, String stu_id, String stu_name, String dropout_reason, String approver_time,
			String review_id, int review_status, String review_reason, String review_time) {
		super();
		this.dropout_id = dropout_id;
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.dropout_reason = dropout_reason;
		this.approver_time = approver_time;
		this.review_id = review_id;
		this.review_status = review_status;
		this.review_reason = review_reason;
		this.review_time = review_time;
	}
	public StuOutschool() {
		super();
	}
	@Override
	public String toString() {
		return "StuOutschool [dropout_id=" + dropout_id + ", stu_id=" + stu_id + ", stu_name=" + stu_name
				+ ", dropout_reason=" + dropout_reason + ", approver_time=" + approver_time + ", review_id=" + review_id
				+ ", review_status=" + review_status + ", review_reason=" + review_reason + ", review_time="
				+ review_time + "]";
	}
	
	
}
