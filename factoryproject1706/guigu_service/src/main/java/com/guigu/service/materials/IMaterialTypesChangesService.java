package com.guigu.service.materials;

import java.util.List;

import com.guigu.domain.materials.GoodsTypView;
import com.guigu.domain.materials.ReturnView;

/**
 * 物资类型的增删改查的服务接口
 */
public interface IMaterialTypesChangesService {
	// 查询父类型
	List<GoodsTypView> queryParentMaterial() throws Exception;

	// 添加节点
	String addNode(ReturnView returnView) throws Exception;

	// 修改节点名
	void updateNode(String id, String text) throws Exception;

	// 拖拽修改子类型的父类型
	void dragAndDropTheParentTypeOfTheModifiedSubtype(String id, String targetId, String point) throws Exception;

	// 禁用节点
	void modifyStatus(String id, String status) throws Exception;
}
