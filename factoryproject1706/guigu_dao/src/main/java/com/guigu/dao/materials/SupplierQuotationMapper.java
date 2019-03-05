package com.guigu.dao.materials;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.guigu.domain.materials.ChoicePriceDetail;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.ProtocalDetail;
import com.guigu.domain.materials.ProviderPrice;
import com.guigu.domain.materials.ProviderPriceDeTail;
import com.guigu.domain.materials.Purchase;

@Mapper
public interface SupplierQuotationMapper {
	// 查询当前供应商可报价物资信息
	List<Purchase> queryGoods(String id) throws Exception;

	// 查询当前供应商可供物资列表
	List<Goods> queryGoodsUser(String pceId, String gysId) throws Exception;

	// 插入报价表
	void insertPriPrice(ProviderPrice providerPrice) throws Exception;

	// 插入明细
	void insertPrigPrce(List<ProviderPriceDeTail> providerPriceDeTails) throws Exception;

	// 查看签约成功的合同（该供应商部分）
	List<ProtocalDetail> queryProtocalDetail(String proId) throws Exception;

	// 查询该合同的采购信息
	List<ChoicePriceDetail> queryChoicePriceDetail(String pceId, String provider) throws Exception;
}
