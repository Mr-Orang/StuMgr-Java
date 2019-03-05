package com.guigu.domain.materials;

/**
 * 入库信息查询接口
 * 
 * @author ExcellentLiuYang
 *
 */
public class IncomingInfo {
	// 采购单编号
	private String pceId;
	// 合同编号
	private String contractN;
	// 采购入库数量
	private int putInStorage;
	// 实际入库数量
	private int actualStorage;
	// 状态
	private String status;

	public IncomingInfo() {
		super();
	}

	public IncomingInfo(String pceId, String contractN, int putInStorage, int actualStorage, String status) {
		super();
		this.pceId = pceId;
		this.contractN = contractN;
		this.putInStorage = putInStorage;
		this.actualStorage = actualStorage;
		this.status = status;
	}

	public String getPceId() {
		return pceId;
	}

	public void setPceId(String pceId) {
		this.pceId = pceId;
	}

	public String getContractN() {
		return contractN;
	}

	public void setContractN(String contractN) {
		this.contractN = contractN;
	}

	public int getPutInStorage() {
		return putInStorage;
	}

	public void setPutInStorage(int putInStorage) {
		this.putInStorage = putInStorage;
	}

	public int getActualStorage() {
		return actualStorage;
	}

	public void setActualStorage(int actualStorage) {
		this.actualStorage = actualStorage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
