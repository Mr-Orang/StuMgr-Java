package com.guigu.dao.materials;

import java.util.List;

import com.guigu.domain.materials.Goods;

/**
 * 供应商查询类
 */
public interface SupplyOfMaterialsMapper {
	// 查询当前供应商可供物资列表
	List<Goods> querySupplierGoods(String id) throws Exception;

	// 查询可供应的物资信息
	List<Goods> queryGoods(String Id) throws Exception;

	// 添加供应物资信息
	void addSupplies(List<Goods> goods) throws Exception;

	// 判断该物资是否存在
	Goods queryIsGoods(String goodsId, String gyId) throws Exception;

	// 移除可供应的物资
	void removalOfSuppliesAvailable(String id, String gysId) throws Exception;
}
