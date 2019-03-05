package com.guigu.controller.materials.purchasingman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.marketing.Employee;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.Purchase;
import com.guigu.domain.materials.PurchaseDetails;
import com.guigu.service.materials.IPurchaseRequisitionService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 采购申请处理器类
 */
@Controller
@RequestMapping("/purchaseRequisition")
public class PurchaseRequisitionController {
	@Autowired
	private IPurchaseRequisitionService iPurchaseRequisitionService;

	/**
	 * 查询物资信息
	 *
	 * @return
	 */
	@RequestMapping("/queryGoodsAndType")
	public @ResponseBody PageInfo queryGoods(int page, int rows) {
		PageInfo pageInfo = null;
		try {
			pageInfo = this.iPurchaseRequisitionService.queryGoods(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

	@RequestMapping("/manualPurchase")
	public @ResponseBody String manualPurchase(String[] idArray, int[] numArrays, HttpServletRequest request) {
		Employee emplyee = (Employee) request.getSession().getAttribute("emplyee");
		List<PurchaseDetails> purchaseDetails_list = new ArrayList<PurchaseDetails>();
		// 将数组参数添加的采购明细表
		for (int i = 0; i < idArray.length; i++) {
			PurchaseDetails purchaseDetails = new PurchaseDetails(null, null, idArray[i], numArrays[i], null);
			purchaseDetails_list.add(purchaseDetails);
		}
		boolean boo = false;
		try {
			boo = this.iPurchaseRequisitionService.insertManualPurchase(purchaseDetails_list, emplyee.getTe_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "yes";
		}
		return "no";
	}

	/**
	 * 查询当前账户的申请采购
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/userPurchaseDetails")
	public @ResponseBody PageInfo UserPurchaseDetails(HttpServletRequest request, int page, int rows) {
		Employee emplyee = (Employee) request.getSession().getAttribute("emplyee");
		PageInfo pageInfo = null;
		try {
			pageInfo = this.iPurchaseRequisitionService.queryUseDetail(emplyee.getTe_id(), page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

	/**
	 * 未审批的采购信息
	 */
	@RequestMapping("/queryPurchase")
	public @ResponseBody PageInfo queryPurchase(int page, int rows) {
		PageInfo pageinfo = null;
		try {
			pageinfo = this.iPurchaseRequisitionService.queryPurchase(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}

	/**
	 * 申请的采购物资列表
	 */
	@RequestMapping("/listOfPurchasedMaterialsForApplication")
	public @ResponseBody List<Goods> queryApprovedMaterials(String pceId) {
		List<Goods> list = null;
		try {
			list = this.iPurchaseRequisitionService.queryApprovedMaterials(pceId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 最后决定是否审批该采购
	 */
	@RequestMapping("/finalDecisionWhetherToApproveThePurchase")
	public @ResponseBody String FinalDecisionWhetherToApproveThePurchase(String decide, String text, String pceId,
			HttpServletRequest request, String[] Array) {
		Employee emplyee = (Employee) request.getSession().getAttribute("emplyee");
		Purchase purchase = null;
		List<Goods> goodsList = new ArrayList<Goods>();
		if ("0".equals(decide)) {
			// 不同意
			purchase = new Purchase(pceId, null, null, null, "1", emplyee.getTe_id(), null, text.trim(), null, null,
					null, null, null, null);
		} else {
			// 同意
			purchase = new Purchase(pceId, null, null, null, "2", emplyee.getTe_id(), null, null, null, null, null,
					null, null, null);
			// 封装追加数量
			for (int i = 0; i < Array.length; i++) {
				String go[] = Array[i].split(":");
				Goods goods = new Goods();
				goods.setGoodsId(go[0]);
				goods.setAccountNum(Integer.parseInt(go[1]));
				goods.setTypeName(pceId);
				goodsList.add(goods);
			}
		}
		boolean boo = false;
		try {
			boo = this.iPurchaseRequisitionService.processingReview(purchase, goodsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "yes";
		}
		return "no";
	}

	/**
	 * 查询采购明细
	 */
	@RequestMapping("/queryPurchaseDetails")
	@ResponseBody
	public PageInfo queryPurchaseDetails(String id, int page, int rows) {
		PageInfo pageinfo = null;
		try {
			pageinfo = this.iPurchaseRequisitionService.queryPurchaseDetails(id, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}

	/**
	 * 查询历史审批信息
	 */
	@RequestMapping("/queryHistoricalApprovalInformation")
	@ResponseBody
	public PageInfo QueryHistoricalApprovalInformation(int page, int rows) {
		PageInfo pageinfo = null;
		try {
			pageinfo = this.iPurchaseRequisitionService.queryHistoricalApprovalInformation(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}
}
