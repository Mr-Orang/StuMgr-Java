package com.guigu.service.materials.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.common.materials.PageInfo;
import com.guigu.dao.materials.PurchasePriceMapper;
import com.guigu.domain.materials.ChoicePrice;
import com.guigu.domain.materials.ChoicePriceDetail;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.MaterialAndQuotation;
import com.guigu.domain.materials.Purchase;
import com.guigu.domain.materials.RowsNumber;
import com.guigu.service.materials.IPurchasePriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasePriceServiceImpl implements IPurchasePriceService {
	@Autowired
	private PurchasePriceMapper purchasePriceMapper;

	@Override
	public PageInfo queryPJInfo(int page, int rows) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Purchase> pageInfo1 = PageHelper.startPage(page, rows).doSelectPageInfo(() -> {
			try {
				this.purchasePriceMapper.queryQuotationIntegratedEntityClassView();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		// 添加采购报价状态
		List<Purchase> listso = pageInfo1.getList();
		for (int i = 0; i < listso.size(); i++) {
			RowsNumber rowsNumber = this.purchasePriceMapper.queryRow(listso.get(i).getPceId());
			if (rowsNumber.getRowNums() == 0) {
				listso.get(i).setQuotationStatus("完毕");
			} else {
				listso.get(i).setQuotationStatus("待完成");
			}
		}
		pageInfo.setRows(listso);
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	@Override
	public List<Goods> queryMaterInfoGo(String id) throws Exception {
		/**
		 * 查询采购物资
		 */
		List<Goods> list = this.purchasePriceMapper.queryGoos(id);
		/**
		 * 查询采购物资的报价情况
		 */
		for (int i = 0; i < list.size(); i++) {
			List<MaterialAndQuotation> list1 = this.inquireAboutSupplierQuotationsForMaterialsInProcurement(id,
					list.get(i).getGoodsId());
			list.get(i).setList(list1);
		}
		return list;
	}

	@Override
	public List<MaterialAndQuotation> inquireAboutSupplierQuotationsForMaterialsInProcurement(String pceID,
			String goodsId) throws Exception {
		return this.purchasePriceMapper.queryMaterialAndQuotation(pceID, goodsId);
	}

	@Override
	public boolean PriceSelection(List<ChoicePriceDetail> choicePriceDetailList, ChoicePrice choicePrice)
			throws Exception {
		// 插入选价表
		try {
			this.purchasePriceMapper.InsertTheSelectedPriceList(choicePrice);
			for (int i = 0; i < choicePriceDetailList.size(); i++) {
				choicePriceDetailList.get(i).setChPriceID(choicePrice.getChPriceId());
			}
			// 插入明细
			this.purchasePriceMapper.InsertDetails(choicePriceDetailList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean queryPceGoods(String id) throws Exception {
		RowsNumber rowsNumber = this.purchasePriceMapper.queryRow(id);
		if (rowsNumber.getRowNums() == 0) {
			return true;
		}
		if (rowsNumber.getRowNums() < 0) {
			return false;
		}
		return false;
	}
}
