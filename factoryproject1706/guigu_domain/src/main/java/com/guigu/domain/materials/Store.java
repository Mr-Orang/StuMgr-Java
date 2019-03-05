package com.guigu.domain.materials;

/**
 * 仓库信息表
 */
public class Store {
	private String storeId;
	private String address;
	private String status;

	public Store() {
	}

	public Store(String storeId, String address, String status) {
		this.storeId = storeId;
		this.address = address;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
