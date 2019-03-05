package com.guigu.controller.materials.purchasingman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.ChoicePrice;
import com.guigu.domain.materials.ChoicePriceDetail;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.MaterialAndQuotation;
import com.guigu.domain.materials.Provider;
import com.guigu.service.materials.IPurchasePriceService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 采购选价处理类
 */
@Controller
@RequestMapping("/purchasePriceController")
public class PurchasePriceController {
	@Autowired
	private IPurchasePriceService iPurchasePriceService;

	/**
	 * 查询供货商采购单报价
	 */
	@RequestMapping("/querySupplierPurchaseOrderQuotation")
	public @ResponseBody PageInfo querySupplierPurchaseOrderQuotation(int page, int rows) {
		PageInfo pageinfo = null;
		try {
			pageinfo = this.iPurchasePriceService.queryPJInfo(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}

	/**
	 * 查询订单中的物资情况
	 */
	@RequestMapping("/checkTheMaterialsInTheOrder")
	public @ResponseBody List<Goods> CheckTheMaterialsInTheOrder(String id) {
		List<Goods> list = null;
		try {
			list = this.iPurchasePriceService.queryMaterInfoGo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询该采购单中的物资是否全部都报价完成
	 */
	@RequestMapping("/queryPceGoods")
	@ResponseBody
	public String queryPceGoods(String id) {
		boolean boo = false;
		try {
			boo = this.iPurchasePriceService.queryPceGoods(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "ok";
		}
		return "no";
	}

	/**
	 * 查询采购中物资的供应商报价情况
	 */
	@RequestMapping("/inquireAboutSupplierQuotationsForMaterialsInProcurement")
	@ResponseBody
	public List<MaterialAndQuotation> inquireAboutSupplierQuotationsForMaterialsInProcurement(String pceId,
			String goodsId) {
		List<MaterialAndQuotation> list = null;
		try {
			list = this.iPurchasePriceService.inquireAboutSupplierQuotationsForMaterialsInProcurement(pceId, goodsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 提交物资选价
	 */
	@RequestMapping("/submissionOfMaterialSelectionPrice")
	@ResponseBody
	public String SubmissionOfMaterialSelectionPrice(String[] ArrayOptions, String pceId, HttpServletRequest request) {
		Provider provider = (Provider) request.getSession().getAttribute("provider");
		// 封装选价明细
		List<ChoicePriceDetail> choicePriceDetailList = new ArrayList<ChoicePriceDetail>();
		for (int i = 0; i < ArrayOptions.length; i++) {
			String[] dataInfo = ArrayOptions[i].split(":");
			// 供货商id
			String providerId = dataInfo[1].substring(dataInfo[1].indexOf("=") + 1);
			// 物资编号
			String goodsId = dataInfo[0].substring(dataInfo[0].indexOf("=") + 1);
			// 供货数量
			String amount = dataInfo[3].substring(dataInfo[3].indexOf("=") + 1);
			// 供货价
			String price = dataInfo[2].substring(dataInfo[2].indexOf("=") + 1);
			ChoicePriceDetail choicePriceDetail = new ChoicePriceDetail(null, null, providerId, goodsId,
					Integer.parseInt(amount.trim()), Double.parseDouble(price.trim()));
			choicePriceDetailList.add(choicePriceDetail);
		}
		// 封装选择报价表
		ChoicePrice choicePrice = new ChoicePrice(null, pceId, 1, 0);
		boolean boo = false;
		try {
			boo = this.iPurchasePriceService.PriceSelection(choicePriceDetailList, choicePrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "yes";
		}
		return "no";
	}
}
