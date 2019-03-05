package com.guigu.domain.info;

import java.util.Date;

//学生退学状态信息
public class Dropout {
	private String dropout_id;		//退学编号	
	private String stu_id;			//申请学生学号	
	private String dropout_reason;	//退学原因	
	private Date approver_time;		//申请日期	
	private String review_id;		//审批人	
	private int review_status;		//审批状态	同意1，不同意2，未审批0
	private String review_reason;	//不同意原因	
	private Date review_time;		//审批日期	
	private String review_image;	//退学图片	
	public Dropout(String dropout_id, String stu_id, String dropout_reason, Date approver_time, String review_id,
			int review_status, String review_reason, Date review_time, String review_image) {
		super();
		this.dropout_id = dropout_id;
		this.stu_id = stu_id;
		this.dropout_reason = dropout_reason;
		this.approver_time = approver_time;
		this.review_id = review_id;
		this.review_status = review_status;
		this.review_reason = review_reason;
		this.review_time = review_time;
		this.review_image = review_image;
	}
	public Dropout() {
		super();
	}
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
	public String getDropout_reason() {
		return dropout_reason;
	}
	public void setDropout_reason(String dropout_reason) {
		this.dropout_reason = dropout_reason;
	}
	public Date getApprover_time() {
		return approver_time;
	}
	public void setApprover_time(Date approver_time) {
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
	public Date getReview_time() {
		return review_time;
	}
	public void setReview_time(Date review_time) {
		this.review_time = review_time;
	}
	public String getReview_image() {
		return review_image;
	}
	public void setReview_image(String review_image) {
		this.review_image = review_image;
	}
	@Override
	public String toString() {
		return "Dropout [dropout_id=" + dropout_id + ", stu_id=" + stu_id + ", dropout_reason=" + dropout_reason
				+ ", approver_time=" + approver_time + ", review_id=" + review_id + ", review_status=" + review_status
				+ ", review_reason=" + review_reason + ", review_time=" + review_time + ", review_image=" + review_image
				+ "]";
	}
	
	
}
