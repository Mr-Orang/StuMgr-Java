package com.guigu.domain.materials;

/**
 * 合同明细实体类
 */
public class ProtocalDetail {
	private String protdId;
	private String protId;
	private String providerId;
	private String conSum;
	private String status;

	public ProtocalDetail() {
	}

	public ProtocalDetail(String protdId, String protId, String providerId, String conSum, String status) {
		this.protdId = protdId;
		this.protId = protId;
		this.providerId = providerId;
		this.conSum = conSum;
		this.status = status;
	}

	public String getProtdId() {
		return protdId;
	}

	public void setProtdId(String protdId) {
		this.protdId = protdId;
	}

	public String getProtId() {
		return protId;
	}

	public void setProtId(String protId) {
		this.protId = protId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getConSum() {
		return conSum;
	}

	public void setConSum(String conSum) {
		this.conSum = conSum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
