package com.guigu.service.materials.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.common.materials.PageInfo;
import com.guigu.dao.materials.MaterialInfoMapper;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.GoodsType;
import com.guigu.service.materials.ImaterialInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialInfoServiceImpl implements ImaterialInfoService {
	@Autowired
	private MaterialInfoMapper materialInfoMapper;

	@Override
	public PageInfo querymaterial(int page, int rows) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Goods> pages = PageHelper.startPage(page, rows, true).doSelectPageInfo(() -> {
			try {
				this.materialInfoMapper.queryMaterial();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		pageInfo.setRows(pages.getList());
		pageInfo.setTotal(pages.getTotal());
		return pageInfo;
	}

	// 查询物资详细信息
	@Override
	public List<GoodsType> queryGoodsType() throws Exception {
		List<GoodsType> list = this.materialInfoMapper.queryGoodsType();
		for (int i = 0; i < list.size(); i++) {
			// 该物资类型为不可用
			if (list.get(i).getStatus() == 1) {
				// 获取该类型id，删除其下属子类
				for (int j = 0; j < list.size(); j++) {
					if (list.get(i).getTypeId().equals(list.get(j).getPtId())) {
						list.remove(list.get(j));
						j--;
					}
				}
				list.remove(list.get(i));
			}
		}
		return list;
	}

	@Override
	public Goods queryGoods(String id) throws Exception {
		return this.materialInfoMapper.queryGoods(id);
	}

	// 保存修改的物资
	@Override
	public void updateGoods(Goods goods) throws Exception {
		this.materialInfoMapper.updateGoods(goods);
	}

	// 下架物资
	@Override
	public void updateGoodsId(String id) throws Exception {
		this.materialInfoMapper.updateMId(id);
	}

	// 上架该物资
	@Override
	public void addGoodsId(String id) throws Exception {
		this.materialInfoMapper.addGoodsId(id);
	}

	// 添加物资
	@Override
	public void addgs(Goods goods) throws Exception {
		this.materialInfoMapper.addsGoods(goods);
	}

}
