package com.guigu.service.materials.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.common.materials.PageInfo;
import com.guigu.dao.materials.SupplyOfMaterialsMapper;
import com.guigu.domain.materials.Goods;
import com.guigu.service.materials.ISupplyOfMaterials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyOfMaterialsImpl implements ISupplyOfMaterials {
	@Autowired
	private SupplyOfMaterialsMapper supplyOfMaterialsMapper;

	// 查询供应商可供物资列表
	@Override
	public PageInfo queryGoodsMaterials(String id, int page, int rows) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Goods> pageInfo1 = PageHelper.startPage(page, rows).doSelectPageInfo(() -> {
			try {
				this.supplyOfMaterialsMapper.querySupplierGoods(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		pageInfo.setTotal(pageInfo1.getTotal());
		pageInfo.setRows(pageInfo1.getList());
		return pageInfo;
	}

	@Override
	public PageInfo queryMaterial(int page, int rows, String Id) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Goods> pageInfo1 = PageHelper.startPage(page, rows).doSelectPageInfo(() -> {
			try {
				this.supplyOfMaterialsMapper.queryGoods(Id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		pageInfo.setTotal(pageInfo1.getTotal());
		pageInfo.setRows(pageInfo1.getList());
		return pageInfo;
	}

	// 添加供应物资
	@Override
	public boolean addSupplies(List<Goods> goods) throws Exception {
		try {
			this.supplyOfMaterialsMapper.addSupplies(goods);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean queryIsAdd(String goodsId, String gyId) throws Exception {
		Goods goods = this.supplyOfMaterialsMapper.queryIsGoods(goodsId, gyId);
		if (goods == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removalOfSuppliesAvailable(String id, String gysId) {
		try {
			this.supplyOfMaterialsMapper.removalOfSuppliesAvailable(id, gysId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
