package com.guigu.common.info;

import java.sql.Date;

/**
 * 复学申请视图类
 * 
 * @author Administrator
 *
 */
public class ReturnVo {
	private String lEAVE_ID;// 休学编号1
	private String sTU_NAME;// 学生姓名1
	private String sTU_SEX;// 学生性别1
	private String tc_NAME; //原班级名称,
	private String tl_NAME; //阶段,
	private Date lEAVE_STARTTIME;// 请假时间1
	private String leave_reason;// 请假理由1
	private Date leave_endtime;// 结束时间1
	private int review_status;//审批状态
	private Date return_time;// 复学时间
	public ReturnVo(String lEAVE_ID, String sTU_NAME, String sTU_SEX, String tc_NAME, String tl_NAME,
			Date lEAVE_STARTTIME, String leave_reason, Date leave_endtime, int review_status, Date return_time) {
		super();
		this.lEAVE_ID = lEAVE_ID;
		this.sTU_NAME = sTU_NAME;
		this.sTU_SEX = sTU_SEX;
		this.tc_NAME = tc_NAME;
		this.tl_NAME = tl_NAME;
		this.lEAVE_STARTTIME = lEAVE_STARTTIME;
		this.leave_reason = leave_reason;
		this.leave_endtime = leave_endtime;
		this.review_status = review_status;
		this.return_time = return_time;
	}
	public ReturnVo() {
		super();
	}
	public String getlEAVE_ID() {
		return lEAVE_ID;
	}
	public void setlEAVE_ID(String lEAVE_ID) {
		this.lEAVE_ID = lEAVE_ID;
	}
	public String getsTU_NAME() {
		return sTU_NAME;
	}
	public void setsTU_NAME(String sTU_NAME) {
		this.sTU_NAME = sTU_NAME;
	}
	public String getsTU_SEX() {
		return sTU_SEX;
	}
	public void setsTU_SEX(String sTU_SEX) {
		this.sTU_SEX = sTU_SEX;
	}
	public String getTc_NAME() {
		return tc_NAME;
	}
	public void setTc_NAME(String tc_NAME) {
		this.tc_NAME = tc_NAME;
	}
	public String getTl_NAME() {
		return tl_NAME;
	}
	public void setTl_NAME(String tl_NAME) {
		this.tl_NAME = tl_NAME;
	}
	public Date getlEAVE_STARTTIME() {
		return lEAVE_STARTTIME;
	}
	public void setlEAVE_STARTTIME(Date lEAVE_STARTTIME) {
		this.lEAVE_STARTTIME = lEAVE_STARTTIME;
	}
	public String getLeave_reason() {
		return leave_reason;
	}
	public void setLeave_reason(String leave_reason) {
		this.leave_reason = leave_reason;
	}
	public Date getLeave_endtime() {
		return leave_endtime;
	}
	public void setLeave_endtime(Date leave_endtime) {
		this.leave_endtime = leave_endtime;
	}
	public int getReview_status() {
		return review_status;
	}
	public void setReview_status(int review_status) {
		this.review_status = review_status;
	}
	public Date getReturn_time() {
		return return_time;
	}
	public void setReturn_time(Date return_time) {
		this.return_time = return_time;
	}
}
