package com.guigu.domain.materials;

/**
 * 选价明细实体类
 */
public class ChoicePriceDetail {
	private String cpdId;
	private String chPriceID;
	private String providerId;
	private String goodsId;
	private int amount;
	private double price;

	public ChoicePriceDetail() {

	}

	public ChoicePriceDetail(String cpdId, String chPriceID, String providerId, String goodsId, int amount,
			double price) {
		this.cpdId = cpdId;
		this.chPriceID = chPriceID;
		this.providerId = providerId;
		this.goodsId = goodsId;
		this.amount = amount;
		this.price = price;
	}

	public String getCpdId() {
		return cpdId;
	}

	public void setCpdId(String cpdId) {
		this.cpdId = cpdId;
	}

	public String getChPriceID() {
		return chPriceID;
	}

	public void setChPriceID(String chPriceID) {
		this.chPriceID = chPriceID;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
