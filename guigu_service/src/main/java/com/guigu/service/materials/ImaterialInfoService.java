package com.guigu.service.materials;

import java.util.List;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.GoodsType;

/**
 * 物资信息实体类
 */
public interface ImaterialInfoService {
	// 查询物资信息
	PageInfo querymaterial(int page, int rows) throws Exception;

	// 查询物资类型
	List<GoodsType> queryGoodsType() throws Exception;

	// 查询具体的物资信息
	Goods queryGoods(String id) throws Exception;

	// 保存修改的物资
	void updateGoods(Goods goods) throws Exception;

	// 下架物资
	void updateGoodsId(String id) throws Exception;

	// 上架物资
	void addGoodsId(String id) throws Exception;

	// 添加物资
	void addgs(Goods goods) throws Exception;
}
