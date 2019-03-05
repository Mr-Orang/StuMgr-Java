package com.guigu.service.materials;

import java.util.List;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.Purchase;
import com.guigu.domain.materials.PurchaseDetails;

/**
 * 采购管理业务类
 */
public interface IPurchaseRequisitionService {
	/**
	 * 查询物资信息
	 */
	PageInfo queryGoods(int currentPage, int pageSize) throws Exception;

	/**
	 * 手动采购
	 */
	boolean insertManualPurchase(List<PurchaseDetails> purchaseDetails_list, String empId) throws Exception;

	/**
	 * 当前用户采购明细
	 */
	PageInfo queryUseDetail(String empId, int currentPage, int pageSize) throws Exception;

	/**
	 * 查询采购信息
	 */
	PageInfo queryPurchase(int currentPage, int pageSize) throws Exception;

	/**
	 * 查询审批的物资
	 */
	List<Goods> queryApprovedMaterials(String pceId) throws Exception;

	/**
	 * 处理审核
	 */
	boolean processingReview(Purchase purchase, List<Goods> list) throws Exception;

	/**
	 * 查询采购明细
	 */
	PageInfo queryPurchaseDetails(String id, int page, int rows) throws Exception;

	/**
	 * 查询历史采购审批记录
	 */
	PageInfo queryHistoricalApprovalInformation(int page, int rows) throws Exception;
}
