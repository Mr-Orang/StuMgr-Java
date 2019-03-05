package com.guigu.domain.info;

import java.io.Serializable;

public class LeaveView implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String leave_id;			//请假编号	
	private String stu_name;			//学生姓名	
	private String leave_starttime;		//开始时间	
	private String leave_endtime;			//结束时间	
	private String leave_reason;		//请假原因	
	private String leave_time;			//申请时间	
	private String te_name;			//审批人姓名	
	private String approver_reason;		//审批不同意意见	
	private int approver_status;		//审批状态	同意1，不同意2，未审批0
	private String approver_time;			//审批时间	
	private String te_namee;		//审批人姓名(休学，长假)	
	private int review_status;			//审批状态	同意1，不同意2，未审批0
	private String review_reason;		//审批不同意原因	
	private String review_time;			//审批时间	
	private String review_image;		//长假/休学图片	
	private String tc_name; //学生班级
	
	public LeaveView() {
		super();
	}
	public LeaveView(String leave_id, String stu_name, String leave_starttime, String leave_endtime,
			String leave_reason, String leave_time, String te_name, String approver_reason, int approver_status,
			String approver_time, String te_namee, int review_status, String review_reason, String review_time,
			String review_image, String tc_name) {
		super();
		this.leave_id = leave_id;
		this.stu_name = stu_name;
		this.leave_starttime = leave_starttime;
		this.leave_endtime = leave_endtime;
		this.leave_reason = leave_reason;
		this.leave_time = leave_time;
		this.te_name = te_name;
		this.approver_reason = approver_reason;
		this.approver_status = approver_status;
		this.approver_time = approver_time;
		this.te_namee = te_namee;
		this.review_status = review_status;
		this.review_reason = review_reason;
		this.review_time = review_time;
		this.review_image = review_image;
		this.tc_name = tc_name;
	}
	public String getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(String leave_id) {
		this.leave_id = leave_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getLeave_starttime() {
		return leave_starttime;
	}
	public void setLeave_starttime(String leave_starttime) {
		this.leave_starttime = leave_starttime;
	}
	public String getLeave_endtime() {
		return leave_endtime;
	}
	public void setLeave_endtime(String leave_endtime) {
		this.leave_endtime = leave_endtime;
	}
	public String getLeave_reason() {
		return leave_reason;
	}
	public void setLeave_reason(String leave_reason) {
		this.leave_reason = leave_reason;
	}
	public String getLeave_time() {
		return leave_time;
	}
	public void setLeave_time(String leave_time) {
		this.leave_time = leave_time;
	}
	public String getTe_name() {
		return te_name;
	}
	public void setTe_name(String te_name) {
		this.te_name = te_name;
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
	public String getApprover_time() {
		return approver_time;
	}
	public void setApprover_time(String approver_time) {
		this.approver_time = approver_time;
	}
	public String getTe_namee() {
		return te_namee;
	}
	public void setTe_namee(String te_namee) {
		this.te_namee = te_namee;
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
	public String getReview_image() {
		return review_image;
	}
	public void setReview_image(String review_image) {
		this.review_image = review_image;
	}
	
	public String getTc_name() {
		return tc_name;
	}
	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}
	@Override
	public String toString() {
		return "LeaveView [leave_id=" + leave_id + ", stu_name=" + stu_name + ", leave_starttime=" + leave_starttime
				+ ", leave_endtime=" + leave_endtime + ", leave_reason=" + leave_reason + ", leave_time=" + leave_time
				+ ", te_name=" + te_name + ", approver_reason=" + approver_reason + ", approver_status="
				+ approver_status + ", approver_time=" + approver_time + ", te_namee=" + te_namee + ", review_status="
				+ review_status + ", review_reason=" + review_reason + ", review_time=" + review_time
				+ ", review_image=" + review_image + ", tc_name=" + tc_name + "]";
	}
	
	
	
	
	
}
