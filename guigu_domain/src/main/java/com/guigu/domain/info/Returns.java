package com.guigu.domain.info;

import java.util.Date;

//学生复学申请
public class Returns {
	private String return_id;		//复学编号	
	private String leave_id;		//休学编号	
	private Date approver_time;		//申请时间	
	private Date return_time;		//复学时间	
	private String review_id;		//审批人	
	private int review_status;		//审批状态	同意1，不同意2，未审批0
	private String review_reason;	//审批不同意原因	
	private Date review_time;		//审批时间	
	public Returns(String return_id, String leave_id, Date approver_time, Date return_time, String review_id,
			int review_status, String review_reason, Date review_time) {
		super();
		this.return_id = return_id;
		this.leave_id = leave_id;
		this.approver_time = approver_time;
		this.return_time = return_time;
		this.review_id = review_id;
		this.review_status = review_status;
		this.review_reason = review_reason;
		this.review_time = review_time;
	}
	public Returns() {
		super();
	}
	public String getReturn_id() {
		return return_id;
	}
	public void setReturn_id(String return_id) {
		this.return_id = return_id;
	}
	public String getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(String leave_id) {
		this.leave_id = leave_id;
	}
	public Date getApprover_time() {
		return approver_time;
	}
	public void setApprover_time(Date approver_time) {
		this.approver_time = approver_time;
	}
	public Date getReturn_time() {
		return return_time;
	}
	public void setReturn_time(Date return_time) {
		this.return_time = return_time;
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
	@Override
	public String toString() {
		return "Returns [return_id=" + return_id + ", leave_id=" + leave_id + ", approver_time=" + approver_time
				+ ", return_time=" + return_time + ", review_id=" + review_id + ", review_status=" + review_status
				+ ", review_reason=" + review_reason + ", review_time=" + review_time + "]";
	}
	
	
}
