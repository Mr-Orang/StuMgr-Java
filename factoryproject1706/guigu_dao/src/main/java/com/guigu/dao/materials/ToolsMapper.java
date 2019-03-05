package com.guigu.dao.materials;

import java.util.List;

import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.GoodsType;
import com.guigu.domain.materials.TableNameView;

/**
 * a 工具数据访问类
 */
public interface ToolsMapper {
	// 查询可选类型
	List<GoodsType> queryGoodsType() throws Exception;

	// 查询表中字段
	List<TableNameView> queryTableName() throws Exception;

	// 验证字符串是否存在
	String checkGo(String info) throws Exception;

	// 批量插入数据
	void insertData(List<Goods> list) throws Exception;
}
