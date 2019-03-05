package com.guigu.controller.materials.businessman;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.ChoicePriceDetail;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.Provider;
import com.guigu.domain.materials.ProviderPriceDeTail;
import com.guigu.service.materials.ISupplierQuotationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 供应商报价处理类
 */
@Controller
@RequestMapping("/supplierQuotationController")
public class SupplierQuotationController {
	@Autowired
	private ISupplierQuotationService iSupplierQuotationService;

	/**
	 * 查询当前供应商可报价物资列表
	 *
	 * @param request
	 * @return
	 */

	@RequestMapping("/queryQuotation")
	public @ResponseBody PageInfo queryQuotation(HttpServletRequest request, int page, int rows) {
		// 获取当前供应商信息
		Provider provider = (Provider) request.getSession().getAttribute("provider");
		PageInfo pageInfo = null;
		try {
			pageInfo = this.iSupplierQuotationService.queryQuotation(page, rows, provider.getProviderId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

	/**
	 * 查询当前采购单当前用户的物资详细信息
	 */
	@RequestMapping("/queryGoodsUser")
	public @ResponseBody List<Goods> queryGoodsUser(HttpServletRequest request, String id) {
		Provider provider = (Provider) request.getSession().getAttribute("provider");
		List<Goods> list = null;
		try {
			list = this.iSupplierQuotationService.qeruyGoodsUser(id, provider.getProviderId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 供应商提交报价
	 */
	@RequestMapping("/querySubmitPrice")
	public @ResponseBody String querySubmitPrice(String pceId, String[] goodsIdArrays, double[] priceArrays,
			HttpServletRequest request) {
		Provider provider = (Provider) request.getSession().getAttribute("provider");
		// 封装报价明细
		List<ProviderPriceDeTail> list = new ArrayList<ProviderPriceDeTail>();
		for (int i = 0; i < goodsIdArrays.length; i++) {
			ProviderPriceDeTail providerPriceDeTail = new ProviderPriceDeTail();
			providerPriceDeTail.setGoodsId(goodsIdArrays[i]);
			providerPriceDeTail.setPrice(priceArrays[i]);
			list.add(providerPriceDeTail);
		}
		boolean boo = false;
		try {
			boo = this.iSupplierQuotationService.submitPrice(provider.getProviderId(), pceId, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "yes";
		}
		return "no";
	}

	/**
	 * 查看报价签约成功的合同
	 */
	@RequestMapping("/queryViewQuotationsSignedContractsSorSuccess")
	@ResponseBody
	public PageInfo queryViewQuotationsSignedContractsSorSuccess(HttpServletRequest request, int page, int rows) {
		// 获取当前供应商信息
		Provider provider = (Provider) request.getSession().getAttribute("provider");
		PageInfo pageinfo = null;
		try {
			pageinfo = this.iSupplierQuotationService
					.queryViewQuotationsSignedContractsSorSuccess(provider.getProviderId(), page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}

	/**
	 * 查询该合同下的物资个数和单价
	 */
	@RequestMapping("/queryChoicePriceDetail")
	public @ResponseBody List<ChoicePriceDetail> queryChoicePriceDetail(String pceId, HttpServletRequest request) {
		// 获取当前供应商信息
		Provider provider = (Provider) request.getSession().getAttribute("provider");
		List<ChoicePriceDetail> list = null;
		try {
			list = this.iSupplierQuotationService.queryChoicePriceDetail(pceId, provider.getProviderId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
