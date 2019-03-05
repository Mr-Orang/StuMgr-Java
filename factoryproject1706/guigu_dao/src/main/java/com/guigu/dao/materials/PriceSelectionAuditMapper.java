package com.guigu.dao.materials;

import java.util.List;

import com.guigu.domain.materials.ChoicePrice;
import com.guigu.domain.materials.ChoicePriceDetail;
import com.guigu.domain.materials.Protocal;
import com.guigu.domain.materials.ProtocalDetail;
import com.guigu.domain.materials.Purchase;

/**
 * 选价审批数据访问映射类
 */
public interface PriceSelectionAuditMapper {
	// 查询可以审批的物资报价信息
	List<ChoicePrice> queryChoicePrice() throws Exception;

	/**
	 * 查询报价物资明细
	 */
	List<ChoicePriceDetail> queryChoicePriceDetail(String id) throws Exception;

	/**
	 * 查询物资中供应商的情况
	 */
	List<ChoicePriceDetail> queryCheckSupplierSupplyQuantityAndAmount(String pro, String goodsId) throws Exception;

	/**
	 * 处理选价审批
	 */
	void HandlePriceSelectionApprovals(Purchase purchase) throws Exception;

	/**
	 * 生成合同
	 */
	void GenerateAcontract(Protocal protocal) throws Exception;

	/**
	 * 查询采购单的合同明细 id 为采购单编号
	 */
	List<ProtocalDetail> queryProtocalDetail(String id) throws Exception;

	/**
	 * 生成合同明细（供应商编号，合同金额）
	 */
	void GenerateContractDetails(List<ProtocalDetail> list) throws Exception;
}
