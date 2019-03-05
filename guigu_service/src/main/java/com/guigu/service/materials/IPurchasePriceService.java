package com.guigu.service.materials;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.ChoicePrice;
import com.guigu.domain.materials.ChoicePriceDetail;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.MaterialAndQuotation;

import java.util.List;

/**
 * 查询采购报价信息
 */
public interface IPurchasePriceService {
	// 查询报价信息
	PageInfo queryPJInfo(int page, int rows) throws Exception;

	// 查询物资详细信息
	List<Goods> queryMaterInfoGo(String id) throws Exception;

	// 查询某种物资的报价情况
	List<MaterialAndQuotation> inquireAboutSupplierQuotationsForMaterialsInProcurement(String pceID, String goodsId)
			throws Exception;

	// 选价
	boolean PriceSelection(List<ChoicePriceDetail> choicePriceDetailList, ChoicePrice choicePrice) throws Exception;

	//查询该采购单是否已经填满
	boolean queryPceGoods(String id) throws Exception;
}
