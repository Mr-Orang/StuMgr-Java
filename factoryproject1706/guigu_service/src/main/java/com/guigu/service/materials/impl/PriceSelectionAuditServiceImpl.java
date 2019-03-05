package com.guigu.service.materials.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.materials.PriceSelectionAuditMapper;
import com.guigu.domain.materials.ChoicePrice;
import com.guigu.domain.materials.ChoicePriceDetail;
import com.guigu.domain.materials.Protocal;
import com.guigu.domain.materials.ProtocalDetail;
import com.guigu.domain.materials.Purchase;
import com.guigu.service.materials.IPriceSelectionAuditService;

import java.util.*;

/**
 * 选价审批服务实现类
 */
@Service
public class PriceSelectionAuditServiceImpl implements IPriceSelectionAuditService {
	@Autowired
	private PriceSelectionAuditMapper priceSelectionAuditMapper;

	@Override
	public List<ChoicePrice> queryChoicePrice() throws Exception {
		return this.priceSelectionAuditMapper.queryChoicePrice();
	}

	@Override
	public List<Map<String, Object>> queryDataGrid(String id) throws Exception {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		List<ChoicePriceDetail> list = this.priceSelectionAuditMapper.queryChoicePriceDetail(id);
		for (ChoicePriceDetail choicePriceDetail : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("goodsId", choicePriceDetail.getGoodsId());
			map.put("price", choicePriceDetail.getPrice());
			map.put("amount", choicePriceDetail.getAmount());
			map.put("chPriceID", choicePriceDetail.getChPriceID());
			List<ChoicePriceDetail> list1 = this.queryCheckSupplierSupplyQuantityAndAmount(id,
					choicePriceDetail.getGoodsId());
			map.put("children", list1);
			results.add(map);
		}
		return results;
	}

	@Override
	public List<ChoicePriceDetail> queryCheckSupplierSupplyQuantityAndAmount(String pro, String goodsId)
			throws Exception {
		List<ChoicePriceDetail> list = this.priceSelectionAuditMapper.queryCheckSupplierSupplyQuantityAndAmount(pro,
				goodsId);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setGoodsId(list.get(i).getGoodsId() + ":" + UUID.randomUUID());
		}
		return list;
	}

	@Override
	public boolean HandlePriceSelectionApprovals(Purchase purchase) throws Exception {
		try {
			// 修改审核结果
			this.priceSelectionAuditMapper.HandlePriceSelectionApprovals(purchase);
			if (purchase.getGivePrice().equals("0")) {
				// 生成合同明细
				Protocal protocal = new Protocal(null, purchase.getPceId(), null, null, null, null, 0);
				this.priceSelectionAuditMapper.GenerateAcontract(protocal);
				// 查询合同数据
				List<ProtocalDetail> list = this.priceSelectionAuditMapper.queryProtocalDetail(purchase.getPceId());
				// 放置主键
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setProtId(protocal.getProtId());
				}
				// 插入明细
				this.priceSelectionAuditMapper.GenerateContractDetails(list);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
