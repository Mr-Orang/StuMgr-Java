package com.guigu.service.materials.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.materials.MaterialTypeMapper;
import com.guigu.domain.materials.GoodsTypView;
import com.guigu.domain.materials.ReturnView;
import com.guigu.service.materials.IMaterialTypesChangesService;

import java.util.List;

/**
 * 物资类型增删改查服务实现类
 */
@Service
public class MaterialTypesChangesServiceImpl implements IMaterialTypesChangesService {
	@Autowired
	private MaterialTypeMapper materialTypeMapper;

	@Override
	public List<GoodsTypView> queryParentMaterial() throws Exception {
		return this.materialTypeMapper.queryGoodsType();
	}

	@Override
	public String addNode(ReturnView returnView) throws Exception {
		try {
			this.materialTypeMapper.addNode(returnView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnView.getId();
	}

	// 修改节点名
	@Override
	public void updateNode(String id, String text) throws Exception {
		this.materialTypeMapper.updateNode(id, text);
	}

	@Override
	public void dragAndDropTheParentTypeOfTheModifiedSubtype(String id, String targetId, String point)
			throws Exception {
		if ("append".equals(point)) {
			// 修改该元素的父系id
			this.materialTypeMapper.dragAndDropTheParentTypeOfTheModifiedSubtype(id, targetId);
		}
		if ("buttom".equals(point) || "top".equals(point)) {
			this.materialTypeMapper.dragAndDropTheParentTypeOfTheModifiedSubtype(id, "0");
		}
	}

	// 禁用节点
	@Override
	public void modifyStatus(String id, String status) throws Exception {
		this.materialTypeMapper.modifyStatus(id, status);
	}
}
