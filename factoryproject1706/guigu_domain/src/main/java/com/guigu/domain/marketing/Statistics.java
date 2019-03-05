package com.guigu.domain.marketing;

public class Statistics {
	private String sts_id;
	private String te_name ;
	private int sts_sourceNmber;
	private int sts_applyCount;
	private double sts_enrollment;
	
	public Statistics() {
		super();
	}

	public Statistics(String sts_id, String te_name, int sts_sourceNmber, int sts_applyCount, double sts_enrollment) {
		super();
		this.sts_id = sts_id;
		this.te_name = te_name;
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

	public String getTe_name() {
		return te_name;
	}

	public void setTe_name(String te_name) {
		this.te_name = te_name;
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
		return "Statistics [sts_id=" + sts_id + ", te_name=" + te_name + ", sts_sourceNmber=" + sts_sourceNmber
				+ ", sts_applyCount=" + sts_applyCount + ", sts_enrollment=" + sts_enrollment + "]";
	}
	
	
}
