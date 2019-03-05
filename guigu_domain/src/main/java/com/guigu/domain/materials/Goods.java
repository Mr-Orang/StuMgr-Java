package com.guigu.domain.materials;

import java.util.List;

/**
 * 物资实体类
 */
public class Goods {
	private String goodsId;
	private String brand;
	private String company;
	private String description;
	private String typeId;
	private int status;
	private int goodStock;
	private int upStore;
	private int floorStore;
	// 物资数量（外加）
	private int countNum;
	// 物资类型名称（外加）
	private String typeName;
	// 采购数量
	private int accountNum;
	// 报价情况
	private List<MaterialAndQuotation> list;

	public List<MaterialAndQuotation> getList() {
		return list;
	}

	public void setList(List<MaterialAndQuotation> list) {
		this.list = list;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getGoodStock() {
		return goodStock;
	}

	public void setGoodStock(int goodStock) {
		this.goodStock = goodStock;
	}

	public int getUpStore() {
		return upStore;
	}

	public void setUpStore(int upStore) {
		this.upStore = upStore;
	}

	public int getFloorStore() {
		return floorStore;
	}

	public void setFloorStore(int floorStore) {
		this.floorStore = floorStore;
	}

	public int getCountNum() {
		return countNum;
	}

	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
}
