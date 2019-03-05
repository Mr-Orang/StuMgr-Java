package com.guigu.dao.materials;

import java.util.List;

import com.guigu.domain.materials.ChoicePrice;
import com.guigu.domain.materials.ChoicePriceDetail;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.MaterialAndQuotation;
import com.guigu.domain.materials.Purchase;
import com.guigu.domain.materials.RowsNumber;

/**
 * 选价数据访问类
 */
public interface PurchasePriceMapper {
	// 查询采购单列表
	List<Purchase> queryQuotationIntegratedEntityClassView() throws Exception;

	// 查询采购单物资详细信息
	List<Goods> queryGoos(String id) throws Exception;

	// 查询物资的报价情况
	List<MaterialAndQuotation> queryMaterialAndQuotation(String pceId, String goodsId) throws Exception;

	// 插入选价表
	void InsertTheSelectedPriceList(ChoicePrice choicePrice) throws Exception;

	// 插入明细
	void InsertDetails(List<ChoicePriceDetail> choicePriceDetailList) throws Exception;

	// 查询采购单是否已经报价完毕
	RowsNumber queryRow(String id) throws Exception;
}
