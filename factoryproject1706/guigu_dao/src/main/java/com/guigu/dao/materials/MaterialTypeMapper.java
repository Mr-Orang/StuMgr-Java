package com.guigu.dao.materials;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.guigu.domain.materials.GoodsTypView;
import com.guigu.domain.materials.ReturnView;

@Mapper
public interface MaterialTypeMapper {
	// 查询父节点
	List<GoodsTypView> queryGoodsType() throws Exception;

	// 添加节点
	void addNode(ReturnView returnView) throws Exception;

	// 修改节点名
	void updateNode(String id, String text) throws Exception;

	// 修改子类型的父类型
	void dragAndDropTheParentTypeOfTheModifiedSubtype(String id, String targetId) throws Exception;

	// 禁用节点
	void modifyStatus(String id, String status) throws Exception;
}
