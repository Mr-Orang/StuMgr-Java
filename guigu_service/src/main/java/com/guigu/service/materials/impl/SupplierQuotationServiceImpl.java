package com.guigu.service.materials.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.common.materials.PageInfo;
import com.guigu.dao.materials.SupplierQuotationMapper;
import com.guigu.domain.materials.ChoicePriceDetail;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.ProtocalDetail;
import com.guigu.domain.materials.ProviderPrice;
import com.guigu.domain.materials.ProviderPriceDeTail;
import com.guigu.domain.materials.Purchase;
import com.guigu.service.materials.ISupplierQuotationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierQuotationServiceImpl implements ISupplierQuotationService {
	@Autowired
	private SupplierQuotationMapper supplierQuotationMapper;

	@Override
	public PageInfo queryQuotation(int page, int row, String id) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Purchase> pageInfo1 = PageHelper.startPage(page, row).doSelectPageInfo(() -> {
			try {
				this.supplierQuotationMapper.queryGoods(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	@Override
	public List<Goods> qeruyGoodsUser(String pceId, String gysId) throws Exception {
		return this.supplierQuotationMapper.queryGoodsUser(pceId, gysId);
	}

	@Override
	public boolean submitPrice(String provider, String pceId, List<ProviderPriceDeTail> providerPriceDeTails)
			throws Exception {
		// 插入报价表
		ProviderPrice providerPrice = new ProviderPrice("", pceId, provider, 1);
		try {
			this.supplierQuotationMapper.insertPriPrice(providerPrice);
			// 插入明细
			for (int i = 0; i < providerPriceDeTails.size(); i++) {
				providerPriceDeTails.get(i).setProperId(providerPrice.getProprId());
			}
			this.supplierQuotationMapper.insertPrigPrce(providerPriceDeTails);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageInfo queryViewQuotationsSignedContractsSorSuccess(String id, int page, int rows) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<ProtocalDetail> pageInfo1 = PageHelper.startPage(page, rows)
				.doSelectPageInfo(() -> {
					try {
						this.supplierQuotationMapper.queryProtocalDetail(id);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	@Override
	public List<ChoicePriceDetail> queryChoicePriceDetail(String pceId, String provider) throws Exception {
		return this.supplierQuotationMapper.queryChoicePriceDetail(pceId, provider);
	}
}
