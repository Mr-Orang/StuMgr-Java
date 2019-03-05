package com.guigu.domain.marketing;

public class StatisticsSale {
	/**
	 * sts_id VARCHAR2(10) primary key,--编号、
	sts_empid VARCHAR2(10),--市场人员、
	sts_sourceNmber NUMBER(5),--生源人数、
	sts_applyCount NUMBER(5),--报名人数、
	sts_enrollment number(3,2)--报名率
	 */
	
	private String sts_id;
	private String sts_empid;
	private int sts_sourceNmber;
	private int sts_applyCount;
	private double sts_enrollment;
	
	public StatisticsSale() {
		super();
	}

	public StatisticsSale(String sts_id, String sts_empid, int sts_sourceNmber, int sts_applyCount,
			double sts_enrollment) {
		super();
		this.sts_id = sts_id;
		this.sts_empid = sts_empid;
		this.sts_sourceNmber = sts_sourceNmber;
		this.sts_applyCount = sts_applyCount;
		this.sts_enrollment = sts_enrollment;
	}

	public String getSts_id() {
		return sts_id;
	}

	public void setSts_id(String sts_id) {
		this.sts_id = sts_id;
	}

	public String getSts_empid() {
		return sts_empid;
	}

	public void setSts_empid(String sts_empid) {
		this.sts_empid = sts_empid;
	}

	public int getSts_sourceNmber() {
		return sts_sourceNmber;
	}

	public void setSts_sourceNmber(int sts_sourceNmber) {
		this.sts_sourceNmber = sts_sourceNmber;
	}

	public int getSts_applyCount() {
		return sts_applyCount;
	}

	public void setSts_applyCount(int sts_applyCount) {
		this.sts_applyCount = sts_applyCount;
	}

	public double getSts_enrollment() {
		return sts_enrollment;
	}

	public void setSts_enrollment(double sts_enrollment) {
		this.sts_enrollment = sts_enrollment;
	}

	@Override
	public String toString() {
		return "StatisticsSale [sts_id=" + sts_id + ", sts_empid=" + sts_empid + ", sts_sourceNmber=" + sts_sourceNmber
				+ ", sts_applyCount=" + sts_applyCount + ", sts_enrollment=" + sts_enrollment + "]";
	}
}
