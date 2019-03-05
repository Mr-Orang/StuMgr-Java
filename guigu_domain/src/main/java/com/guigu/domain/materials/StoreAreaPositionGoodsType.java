package com.guigu.domain.materials;

/**
 * 货架管理物资类型实体类
 */
public class StoreAreaPositionGoodsType {
	private String sapId;
	// private String sapAreaId;
	private String sapPositionId;
	private String sapGoodsTypeId;

	public StoreAreaPositionGoodsType() {

	}

	public StoreAreaPositionGoodsType(String sapId, String sapPositionId, String sapGoodsTypeId) {
		this.sapId = sapId;
		this.sapPositionId = sapPositionId;
		this.sapGoodsTypeId = sapGoodsTypeId;
	}

	public String getSapId() {
		return sapId;
	}

	public void setSapId(String sapId) {
		this.sapId = sapId;
	}

	public String getSapPositionId() {
		return sapPositionId;
	}

	public void setSapPositionId(String sapPositionId) {
		this.sapPositionId = sapPositionId;
	}

	public String getSapGoodsTypeId() {
		return sapGoodsTypeId;
	}

	public void setSapGoodsTypeId(String sapGoodsTypeId) {
		this.sapGoodsTypeId = sapGoodsTypeId;
	}
}
