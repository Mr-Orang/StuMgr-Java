package com.guigu.domain.materials;

/**
 * 采购明细表
 */
public class PurchaseDetails {
	private String pdId;
	private String pceId;
	private String goodsId;
	private Integer accountNum;
	private Integer appendAccountNum;

	public PurchaseDetails() {

	}

	public PurchaseDetails(String pdId, String pceId, String goodsId, Integer accountNum, Integer appendAccountNum) {
		this.pdId = pdId;
		this.pceId = pceId;
		this.goodsId = goodsId;
		this.accountNum = accountNum;
		this.appendAccountNum = appendAccountNum;
	}

	public String getPdId() {
		return pdId;
	}

	public void setPdId(String pdId) {
		this.pdId = pdId;
	}

	public String getPceId() {
		return pceId;
	}

	public void setPceId(String pceId) {
		this.pceId = pceId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}

	public Integer getAppendAccountNum() {
		return appendAccountNum;
	}

	public void setAppendAccountNum(Integer appendAccountNum) {
		this.appendAccountNum = appendAccountNum;
	}
}
