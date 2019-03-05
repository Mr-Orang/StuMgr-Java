package com.guigu.domain.materials;

/**
 * 供货商报价明细表
 */
public class ProviderPriceDeTail {
	private String prodde;
	private String properId;
	private String goodsId;
	private double price;

	public ProviderPriceDeTail() {

	}

	public ProviderPriceDeTail(String prodde, String properId, String goodsId, double price) {
		this.prodde = prodde;
		this.properId = properId;
		this.goodsId = goodsId;
		this.price = price;
	}

	public String getProdde() {
		return prodde;
	}

	public void setProdde(String prodde) {
		this.prodde = prodde;
	}

	public String getProperId() {
		return properId;
	}

	public void setProperId(String properId) {
		this.properId = properId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
