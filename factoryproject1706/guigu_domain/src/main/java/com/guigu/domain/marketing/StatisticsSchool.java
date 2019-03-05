package com.guigu.domain.marketing;

public class StatisticsSchool {
	/**
	 * tst_id VARCHAR2(10) primary key,--编号、
	tst_academy VARCHAR2(20),--生源地区/院校、
	tst_sourceNumber number(5),--生源人数、
	tst_applyCount number(5),--报名人数、
	tst_enrollment number(3,2)--报名率
	 */
	
	private String tst_id;
	private String tst_academy;
	private int tst_sourceNumber;
	private int tst_applyCount;
	private double tst_enrollment;
	
	public StatisticsSchool() {
		super();
	}

	public StatisticsSchool(String tst_id, String tst_academy, int tst_sourceNumber, int tst_applyCount,
			double tst_enrollment) {
		super();
		this.tst_id = tst_id;
		this.tst_academy = tst_academy;
		this.tst_sourceNumber = tst_sourceNumber;
		this.tst_applyCount = tst_applyCount;
		this.tst_enrollment = tst_enrollment;
	}

	public String getTst_id() {
		return tst_id;
	}

	public void setTst_id(String tst_id) {
		this.tst_id = tst_id;
	}

	public String getTst_academy() {
		return tst_academy;
	}

	public void setTst_academy(String tst_academy) {
		this.tst_academy = tst_academy;
	}

	public int getTst_sourceNumber() {
		return tst_sourceNumber;
	}

	public void setTst_sourceNumber(int tst_sourceNumber) {
		this.tst_sourceNumber = tst_sourceNumber;
	}

	public int getTst_applyCount() {
		return tst_applyCount;
	}

	public void setTst_applyCount(int tst_applyCount) {
		this.tst_applyCount = tst_applyCount;
	}

	public double getTst_enrollment() {
		return tst_enrollment;
	}

	public void setTst_enrollment(double tst_enrollment) {
		this.tst_enrollment = tst_enrollment;
	}

	@Override
	public String toString() {
		return "StatisticsSchool [tst_id=" + tst_id + ", tst_academy=" + tst_academy + ", tst_sourceNumber="
				+ tst_sourceNumber + ", tst_applyCount=" + tst_applyCount + ", tst_enrollment=" + tst_enrollment + "]";
	}

}
