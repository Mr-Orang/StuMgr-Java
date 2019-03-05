package com.guigu.domain.materials;

/**
 * 采购信息表
 */
public class Purchase {
	private String pceId;
	private String applyEmpNo;
	private String pceDate;
	private String pceType;
	private String status;
	private String checkEmpNo;
	private String checkDate;
	private String checkReason;
	private String givePrice;
	private String agreeEmpNo;
	private String agreeDate;
	private String agreeReason;
	// -------------------------------
	// 采购人姓名
	private String applyName;
	// -------------------------------
	// 审核人姓名
	private String checkEmpName;
	// --------------------------------
	private String quotationStatus;

	public Purchase() {

	}

	public Purchase(String pceId, String applyEmpNo, String pceDate, String pceType, String status, String checkEmpNo,
			String checkDate, String checkReason, String givePrice, String agreeEmpNo, String agreeDate,
			String agreeReason, String applyName, String checkEmpName) {
		this.pceId = pceId;
		this.applyEmpNo = applyEmpNo;
		this.pceDate = pceDate;
		this.pceType = pceType;
		this.status = status;
		this.checkEmpNo = checkEmpNo;
		this.checkDate = checkDate;
		this.checkReason = checkReason;
		this.givePrice = givePrice;
		this.agreeEmpNo = agreeEmpNo;
		this.agreeDate = agreeDate;
		this.agreeReason = agreeReason;
		this.applyName = applyName;
		this.checkEmpName = checkEmpName;
	}

	public String getQuotationStatus() {
		return quotationStatus;
	}

	public void setQuotationStatus(String quotationStatus) {
		this.quotationStatus = quotationStatus;
	}

	public String getPceId() {
		return pceId;
	}

	public void setPceId(String pceId) {
		this.pceId = pceId;
	}

	public String getApplyEmpNo() {
		return applyEmpNo;
	}

	public void setApplyEmpNo(String applyEmpNo) {
		this.applyEmpNo = applyEmpNo;
	}

	public String getPceDate() {
		return pceDate;
	}

	public void setPceDate(String pceDate) {
		this.pceDate = pceDate;
	}

	public String getPceType() {
		return pceType;
	}

	public void setPceType(String pceType) {
		this.pceType = pceType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCheckEmpNo() {
		return checkEmpNo;
	}

	public void setCheckEmpNo(String checkEmpNo) {
		this.checkEmpNo = checkEmpNo;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getCheckReason() {
		return checkReason;
	}

	public void setCheckReason(String checkReason) {
		this.checkReason = checkReason;
	}

	public String getGivePrice() {
		return givePrice;
	}

	public void setGivePrice(String givePrice) {
		this.givePrice = givePrice;
	}

	public String getAgreeEmpNo() {
		return agreeEmpNo;
	}

	public void setAgreeEmpNo(String agreeEmpNo) {
		this.agreeEmpNo = agreeEmpNo;
	}

	public String getAgreeDate() {
		return agreeDate;
	}

	public void setAgreeDate(String agreeDate) {
		this.agreeDate = agreeDate;
	}

	public String getAgreeReason() {
		return agreeReason;
	}

	public void setAgreeReason(String agreeReason) {
		this.agreeReason = agreeReason;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getCheckEmpName() {
		return checkEmpName;
	}

	public void setCheckEmpName(String checkEmpName) {
		this.checkEmpName = checkEmpName;
	}
}
