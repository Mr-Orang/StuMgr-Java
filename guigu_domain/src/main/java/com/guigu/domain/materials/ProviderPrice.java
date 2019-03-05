package com.guigu.domain.materials;

/**
 * 供应商报价表
 */
public class ProviderPrice {
	private String proprId;
	private String pceId;
	private String providerId;
	private int status;

	public ProviderPrice() {

	}

	public ProviderPrice(String proprId, String pceId, String providerId, int status) {
		this.proprId = proprId;
		this.pceId = pceId;
		this.providerId = providerId;
		this.status = status;
	}

	public String getProprId() {
		return proprId;
	}

	public void setProprId(String proprId) {
		this.proprId = proprId;
	}

	public String getPceId() {
		return pceId;
	}

	public void setPceId(String pceId) {
		this.pceId = pceId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
