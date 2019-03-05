package com.guigu.dao.materials;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.GoodsType;

/**
 * 物资信息接口
 */
@Mapper
public interface MaterialInfoMapper {
	// 查询物资信息
	List<Goods> queryMaterial() throws Exception;

	// 查询物资类型
	List<GoodsType> queryGoodsType() throws Exception;

	// 查询具体的物资信息
	Goods queryGoods(String id) throws Exception;

	// 保存修改的物资
	void updateGoods(Goods goods) throws Exception;

	// 下架物资
	void updateMId(String id) throws Exception;

	// 上架该物资
	void addGoodsId(String id) throws Exception;

	// 添加物资
	void addsGoods(Goods goods) throws Exception;
}
