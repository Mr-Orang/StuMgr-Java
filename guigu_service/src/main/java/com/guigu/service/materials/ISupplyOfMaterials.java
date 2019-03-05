package com.guigu.service.materials;

import java.util.List;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.Goods;

/**
 * 供应商接口服务类
 */
public interface ISupplyOfMaterials {
	// 查询当前供应商可供物资详情
	PageInfo queryGoodsMaterials(String id, int page, int rows) throws Exception;

	// 查询供应商可供物资
	PageInfo queryMaterial(int page, int rows, String Id) throws Exception;

	// 添加供应物资
	boolean addSupplies(List<Goods> goods) throws Exception;

	// 异步判断该供应商是否已经添加了该物资
	boolean queryIsAdd(String goodsId, String gyId) throws Exception;

	// 移除可供应的物资
	boolean removalOfSuppliesAvailable(String id, String gysId) throws Exception;
}
