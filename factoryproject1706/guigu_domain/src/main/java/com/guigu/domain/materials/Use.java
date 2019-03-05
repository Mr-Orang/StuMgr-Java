package com.guigu.domain.materials;

/**
 * 领用申请实体类
 */
public class Use {
	private String useId;
	private String takeEmpNO;
	private String fillTime;
	private String latesTime;
	private int examineStatus;
	private String checkEmpNo;
	private String examineTime;
	private String reason;
	private String userStatus;
	private int analysisStatus;

	/**
	 * 外加
	 */
	private String checkEmpName;
	private String te_name;

	public Use() {

	}

	public Use(String useId, String takeEmpNO, String fillTime, String latesTime, int examineStatus, String checkEmpNo,
			String examineTime, String reason, String userStatus, int analysisStatus, String checkEmpName,
			String te_name) {
		this.useId = useId;
		this.takeEmpNO = takeEmpNO;
		this.fillTime = fillTime;
		this.latesTime = latesTime;
		this.examineStatus = examineStatus;
		this.checkEmpNo = checkEmpNo;
		this.examineTime = examineTime;
		this.reason = reason;
		this.userStatus = userStatus;
		this.analysisStatus = analysisStatus;
		this.checkEmpName = checkEmpName;
		this.te_name = te_name;
	}

	public String getTe_name() {
		return te_name;
	}

	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}

	public String getUseId() {
		return useId;
	}

	public void setUseId(String useId) {
		this.useId = useId;
	}

	public String getTakeEmpNO() {
		return takeEmpNO;
	}

	public void setTakeEmpNO(String takeEmpNO) {
		this.takeEmpNO = takeEmpNO;
	}

	public String getFillTime() {
		return fillTime;
	}

	public void setFillTime(String fillTime) {
		this.fillTime = fillTime;
	}

	public String getLatesTime() {
		return latesTime;
	}

	public void setLatesTime(String latesTime) {
		this.latesTime = latesTime;
	}

	public int getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(int examineStatus) {
		this.examineStatus = examineStatus;
	}

	public String getCheckEmpNo() {
		return checkEmpNo;
	}

	public void setCheckEmpNo(String checkEmpNo) {
		this.checkEmpNo = checkEmpNo;
	}

	public String getExamineTime() {
		return examineTime;
	}

	public void setExamineTime(String examineTime) {
		this.examineTime = examineTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public int getAnalysisStatus() {
		return analysisStatus;
	}

	public void setAnalysisStatus(int analysisStatus) {
		this.analysisStatus = analysisStatus;
	}

	public String getCheckEmpName() {
		return checkEmpName;
	}

	public void setCheckEmpName(String checkEmpName) {
		this.checkEmpName = checkEmpName;
	}
}
