package com.guigu.domain.info;

import java.io.Serializable;
import java.util.Date;

//学生请假申请
public class Leave implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String leave_id;			//请假编号	
	private String stu_id;				//学生学号	
	private Date leave_starttime;		//开始时间	
	private Date leave_endtime;			//结束时间	
	private String leave_reason;		//请假原因	
	private Date leave_time;			//申请时间	
	private String approver_id;			//审批人	
	private String approver_reason;		//审批不同意意见	
	private int approver_status;		//审批状态	同意1，不同意2，未审批0
	private Date approver_time;			//审批时间	
	private String review_id;			//审批人(休学，长假)	
	private int review_status;			//审批状态	同意1，不同意2，未审批0
	private String review_reason;		//审批不同意原因	
	private Date review_time;			//审批时间	
	private String review_image;		//长假/休学图片	
	public Leave(String leave_id, String stu_id, Date leave_starttime, Date leave_endtime, String leave_reason,
			Date leave_time, String approver_id, String approver_reason, int approver_status, Date approver_time,
			String review_id, int review_status, String review_reason, Date review_time, String review_image) {
		super();
		this.leave_id = leave_id;
		this.stu_id = stu_id;
		this.leave_starttime = leave_starttime;
		this.leave_endtime = leave_endtime;
		this.leave_reason = leave_reason;
		this.leave_time = leave_time;
		this.approver_id = approver_id;
		this.approver_reason = approver_reason;
		this.approver_status = approver_status;
		this.approver_time = approver_time;
		this.review_id = review_id;
		this.review_status = review_status;
		this.review_reason = review_reason;
		this.review_time = review_time;
		this.review_image = review_image;
	}
	public Leave() {
		super();
	}
	public String getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(String leave_id) {
		this.leave_id = leave_id;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public Date getLeave_starttime() {
		return leave_starttime;
	}
	public void setLeave_starttime(Date leave_starttime) {
		this.leave_starttime = leave_starttime;
	}
	public Date getLeave_endtime() {
		return leave_endtime;
	}
	public void setLeave_endtime(Date leave_endtime) {
		this.leave_endtime = leave_endtime;
	}
	public String getLeave_reason() {
		return leave_reason;
	}
	public void setLeave_reason(String leave_reason) {
		this.leave_reason = leave_reason;
	}
	public Date getLeave_time() {
		return leave_time;
	}
	public void setLeave_time(Date leave_time) {
		this.leave_time = leave_time;
	}
	public String getApprover_id() {
		return approver_id;
	}
	public void setApprover_id(String approver_id) {
		this.approver_id = approver_id;
	}
	public String getApprover_reason() {
		return approver_reason;
	}
	public void setApprover_reason(String approver_reason) {
		this.approver_reason = approver_reason;
	}
	public int getApprover_status() {
		return approver_status;
	}
	public void setApprover_status(int approver_status) {
		this.approver_status = approver_status;
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
		return "Leave [leave_id=" + leave_id + ", stu_id=" + stu_id + ", leave_starttime=" + leave_starttime
				+ ", leave_endtime=" + leave_endtime + ", leave_reason=" + leave_reason + ", leave_time=" + leave_time
				+ ", approver_id=" + approver_id + ", approver_reason=" + approver_reason + ", approver_status="
				+ approver_status + ", approver_time=" + approver_time + ", review_id=" + review_id + ", review_status="
				+ review_status + ", review_reason=" + review_reason + ", review_time=" + review_time
				+ ", review_image=" + review_image + "]";
	}
	
	
}
