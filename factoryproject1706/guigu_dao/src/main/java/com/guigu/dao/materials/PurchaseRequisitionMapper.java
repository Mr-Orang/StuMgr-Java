package com.guigu.dao.materials;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.GoodsAndGoodsTypeView;
import com.guigu.domain.materials.Purchase;
import com.guigu.domain.materials.PurchaseDetails;

/**
 * 采购管理
 * 
 * @author ExcellentLiuYang
 *
 */
@Mapper
public interface PurchaseRequisitionMapper {
	/**
	 * 查询物资
	 *
	 * @return
	 */
	List<GoodsAndGoodsTypeView> queryGoods() throws Exception;

	/**
	 * 手动采购 插入采购单表
	 */
	void manualPurchase(Purchase purchase) throws Exception;

	/**
	 * 查询当前用户的采购明细
	 */
	List<Purchase> queryUseDetail(String empId) throws Exception;

	/**
	 * 批量插入采购明细
	 */
	void insertPurchaseDetails(List<PurchaseDetails> purchaseDetails_list) throws Exception;

	/**
	 * 采购信息
	 */
	List<Purchase> queryPurchase() throws Exception;

	/**
	 * 查询采购信息里面的物资
	 */
	List<Goods> queryTheMaterialsInThePurchaseInformation(String pceId) throws Exception;

	/**
	 * 处理审批
	 */
	void processingApproval(Purchase purchase) throws Exception;

	/**
	 * 添加追加
	 */
	void addAppend(String goodsId, String number, String pceId) throws Exception;

	/**
	 * 查询采购明细
	 */
	List<Goods> queryPurchaseDetails(String id) throws Exception;

	/**
	 * 查询历史采购审批记录
	 */
	List<Purchase> queryHistoricalApprovalInformation() throws Exception;
}
