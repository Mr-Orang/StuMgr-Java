package com.guigu.service.materials.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.common.materials.PageInfo;
import com.guigu.dao.materials.PurchaseRequisitionMapper;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.GoodsAndGoodsTypeView;
import com.guigu.domain.materials.Purchase;
import com.guigu.domain.materials.PurchaseDetails;
import com.guigu.service.materials.IPurchaseRequisitionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseRequisitionServiceImpl implements IPurchaseRequisitionService {
	@Autowired
	private PurchaseRequisitionMapper purchaseRequisitionMapper;

	@Override
	public PageInfo queryGoods(int currentPage, int pageSize) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<GoodsAndGoodsTypeView> pageInfo1 = PageHelper
				.startPage(currentPage, pageSize, true).doSelectPageInfo(() -> {
					try {
						this.purchaseRequisitionMapper.queryGoods();
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	/**
	 * 手动采购实现类
	 *
	 * @param purchaseDetails_list
	 * @param empId
	 * @return
	 */
	@Override
	public boolean insertManualPurchase(List<PurchaseDetails> purchaseDetails_list, String empId) throws Exception {
		try {
			// 插入采购信息表
			Purchase purchase = new Purchase(null, empId, null, "手动采购", null, null, null, null, null, null, null, null,
					null, null);
			this.purchaseRequisitionMapper.manualPurchase(purchase);
			for (PurchaseDetails purchaseDetails : purchaseDetails_list) {
				purchaseDetails.setPceId(purchase.getPceId());
			}
			// 插入采购明细
			this.purchaseRequisitionMapper.insertPurchaseDetails(purchaseDetails_list);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageInfo queryUseDetail(String empId, int currentPage, int pageSize) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Purchase> pageInfo1 = PageHelper.startPage(currentPage, pageSize, true)
				.doSelectPageInfo(() -> {
					try {
						this.purchaseRequisitionMapper.queryUseDetail(empId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	/**
	 * 查询采购信息
	 *
	 * @return
	 */
	@Override
	public PageInfo queryPurchase(int currentPage, int pageSize) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Purchase> pageInfo1 = PageHelper.startPage(currentPage, pageSize, true)
				.doSelectPageInfo(() -> {
					try {
						this.purchaseRequisitionMapper.queryPurchase();
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo.getTotal());
		return pageInfo;
	}

	/**
	 * 查询采购信息的物资
	 *
	 * @param pceId
	 * @return
	 */
	@Override
	public List<Goods> queryApprovedMaterials(String pceId) throws Exception {
		return this.purchaseRequisitionMapper.queryTheMaterialsInThePurchaseInformation(pceId);
	}

	@Override
	public boolean processingReview(Purchase purchase, List<Goods> list) throws Exception {
		try {
			this.purchaseRequisitionMapper.processingApproval(purchase);
			if (list.size() != 0) {
				for (Goods goods : list) {
					this.purchaseRequisitionMapper.addAppend(goods.getGoodsId(), goods.getAccountNum() + "",
							goods.getTypeName());
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageInfo queryPurchaseDetails(String id, int page, int rows) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Goods> pageInfo1 = PageHelper.startPage(page, rows, true)
				.doSelectPageInfo(() -> {
					try {
						this.purchaseRequisitionMapper.queryPurchaseDetails(id);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	@Override
	public PageInfo queryHistoricalApprovalInformation(int page, int rows) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Purchase> pageInfo1 = PageHelper.startPage(page, rows, true)
				.doSelectPageInfo(() -> {
					try {
						this.purchaseRequisitionMapper.queryHistoricalApprovalInformation();
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}
}
