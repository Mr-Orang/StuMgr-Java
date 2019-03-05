package com.guigu.domain.materials;

/**
 * 领用申请信息和员工信息联合实体类
 */
public class UseAndEmpView {
	private String useId;
	private String empName;
	private String fillTime;
	private String latesTime;

	public UseAndEmpView() {

	}

	public UseAndEmpView(String useId, String empName, String fillTime, String latesTime) {
		this.useId = useId;
		this.empName = empName;
		this.fillTime = fillTime;
		this.latesTime = latesTime;
	}

	public String getUseId() {
		return useId;
	}

	public void setUseId(String useId) {
		this.useId = useId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
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
}
