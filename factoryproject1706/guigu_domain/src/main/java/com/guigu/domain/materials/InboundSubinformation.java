package com.guigu.domain.materials;

import java.util.List;
import java.util.Map;

/**
 * 入库子信息实体类
 * 
 * @author ExcellentLiuYang
 * 
 */
public class InboundSubinformation {
	// 供应商编号/物资编号
	private String supplierIdOrGoodsId;
	// 供应商名称/物资名称
	private String suppliersNameOrgoodsName;
	// 应送数量
	private Integer shouldSendTheNumber;
	// 实送数量
	private Integer realNumberSend;
	// 缺送数量
	private Integer missingToSendTheNumber;
	// 子类型
	private List<Map<String, Object>> children;

	public InboundSubinformation() {

	}

	public InboundSubinformation(String supplierIdOrGoodsId, String suppliersNameOrgoodsName,
			Integer shouldSendTheNumber, Integer realNumberSend, Integer missingToSendTheNumber,
			List<Map<String, Object>> children) {
		super();
		this.supplierIdOrGoodsId = supplierIdOrGoodsId;
		this.suppliersNameOrgoodsName = suppliersNameOrgoodsName;
		this.shouldSendTheNumber = shouldSendTheNumber;
		this.realNumberSend = realNumberSend;
		this.missingToSendTheNumber = missingToSendTheNumber;
		this.children = children;
	}

	public List<Map<String, Object>> getChildren() {
		return children;
	}

	public void setChildren(List<Map<String, Object>> children) {
		this.children = children;
	}

	public String getSupplierIdOrGoodsId() {
		return supplierIdOrGoodsId;
	}

	public void setSupplierIdOrGoodsId(String supplierIdOrGoodsId) {
		this.supplierIdOrGoodsId = supplierIdOrGoodsId;
	}

	public String getSuppliersNameOrgoodsName() {
		return suppliersNameOrgoodsName;
	}

	public void setSuppliersNameOrgoodsName(String suppliersNameOrgoodsName) {
		this.suppliersNameOrgoodsName = suppliersNameOrgoodsName;
	}

	public Integer getShouldSendTheNumber() {
		return shouldSendTheNumber;
	}

	public void setShouldSendTheNumber(Integer shouldSendTheNumber) {
		this.shouldSendTheNumber = shouldSendTheNumber;
	}

	public Integer getRealNumberSend() {
		return realNumberSend;
	}

	public void setRealNumberSend(Integer realNumberSend) {
		this.realNumberSend = realNumberSend;
	}

	public Integer getMissingToSendTheNumber() {
		return missingToSendTheNumber;
	}

	public void setMissingToSendTheNumber(Integer missingToSendTheNumber) {
		this.missingToSendTheNumber = missingToSendTheNumber;
	}

}
