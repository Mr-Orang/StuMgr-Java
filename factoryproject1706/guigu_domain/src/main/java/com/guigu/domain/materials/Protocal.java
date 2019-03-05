package com.guigu.domain.materials;

/**
 * 采购合同信息
 */
public class Protocal {
	private String protId;
	private String pceId;
	private String state;
	private String signDate;
	private String signEmpNo;
	private String checkReason;
	// 合同总金额(外加)
	private double theTotalAmountOfTheContract;

	public Protocal() {

	}

	public Protocal(String protId, String pceId, String state, String signDate, String signEmpNo, String checkReason,
			double theTotalAmountOfTheContract) {
		this.protId = protId;
		this.pceId = pceId;
		this.state = state;
		this.signDate = signDate;
		this.signEmpNo = signEmpNo;
		this.checkReason = checkReason;
		this.theTotalAmountOfTheContract = theTotalAmountOfTheContract;
	}

	public String getProtId() {
		return protId;
	}

	public void setProtId(String protId) {
		this.protId = protId;
	}

	public String getPceId() {
		return pceId;
	}

	public void setPceId(String pceId) {
		this.pceId = pceId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getSignEmpNo() {
		return signEmpNo;
	}

	public void setSignEmpNo(String signEmpNo) {
		this.signEmpNo = signEmpNo;
	}

	public String getCheckReason() {
		return checkReason;
	}

	public void setCheckReason(String checkReason) {
		this.checkReason = checkReason;
	}

	public double getTheTotalAmountOfTheContract() {
		return theTotalAmountOfTheContract;
	}

	public void setTheTotalAmountOfTheContract(double theTotalAmountOfTheContract) {
		this.theTotalAmountOfTheContract = theTotalAmountOfTheContract;
	}
}
