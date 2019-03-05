package com.guigu.domain.materials;

/**
 * 领用明细
 */
public class UseDetail {
	private String usedlId;
	private String useId;
	private String goodsId;
	private int countNum;

	public UseDetail() {

	}

	public UseDetail(String usedlId, String useId, String goodsId, int countNum) {
		this.usedlId = usedlId;
		this.useId = useId;
		this.goodsId = goodsId;
		this.countNum = countNum;
	}

	public String getUsedlId() {
		return usedlId;
	}

	public void setUsedlId(String usedlId) {
		this.usedlId = usedlId;
	}

	public String getUseId() {
		return useId;
	}

	public void setUseId(String useId) {
		this.useId = useId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getCountNum() {
		return countNum;
	}

	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}
}
