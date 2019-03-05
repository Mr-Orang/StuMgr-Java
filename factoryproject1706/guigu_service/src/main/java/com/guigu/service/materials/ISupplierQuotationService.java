package com.guigu.service.materials;

import java.util.List;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.ChoicePriceDetail;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.ProviderPriceDeTail;

/**
 * 供应商报价实现接口
 */
public interface ISupplierQuotationService {
	/**
	 * 查询当前供应商可报价信息
	 */
	PageInfo queryQuotation(int page, int row, String id) throws Exception;

	/**
	 * 查询采购详细信息 供应商物资id
	 */
	List<Goods> qeruyGoodsUser(String pceId, String gysId) throws Exception;

	/**
	 * 提交报价
	 */
	boolean submitPrice(String provider, String pceId, List<ProviderPriceDeTail> providerPriceDeTails) throws Exception;

	/**
	 * 查看供应商签约成功的通知
	 */
	PageInfo queryViewQuotationsSignedContractsSorSuccess(String id, int page, int rows) throws Exception;

	/**
	 * 查看物资数量和单价
	 */
	List<ChoicePriceDetail> queryChoicePriceDetail(String pceId, String provider) throws Exception;
}
