package com.guigu.domain.materials;

/**
 * 选价实体类
 */
public class ChoicePrice {
	private String chPriceId;
	private String pceId;
	private int status;
	private double totalAmount;

	public ChoicePrice() {

	}

	public ChoicePrice(String chPriceId, String pceId, int status, double totalAmount) {
		this.chPriceId = chPriceId;
		this.pceId = pceId;
		this.status = status;
		this.totalAmount = totalAmount;
	}

	public String getChPriceId() {
		return chPriceId;
	}

	public void setChPriceId(String chPriceId) {
		this.chPriceId = chPriceId;
	}

	public String getPceId() {
		return pceId;
	}

	public void setPceId(String pceId) {
		this.pceId = pceId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
