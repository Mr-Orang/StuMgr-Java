package com.guigu.service.materials;

import java.util.List;
import java.util.Map;

import com.guigu.domain.materials.ChoicePrice;
import com.guigu.domain.materials.ChoicePriceDetail;
import com.guigu.domain.materials.Purchase;

/**
 * 选价审批服务类
 */
public interface IPriceSelectionAuditService {
	/**
	 * 查询所有可审批的选价
	 */
	List<ChoicePrice> queryChoicePrice() throws Exception;

	/**
	 * 查询以及报价的采购单
	 */
	List<Map<String, Object>> queryDataGrid(String id) throws Exception;

	/**
	 * 查询物资的详细供应商情况
	 */
	List<ChoicePriceDetail> queryCheckSupplierSupplyQuantityAndAmount(String pro, String goodsId) throws Exception;

	/**
	 * 处理选价审批
	 */
	boolean HandlePriceSelectionApprovals(Purchase purchase) throws Exception;
}
