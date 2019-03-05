package com.guigu.controller.materials.purchasingman;

import com.guigu.domain.marketing.Employee;
import com.guigu.domain.materials.ChoicePrice;
import com.guigu.domain.materials.DataGrid;
import com.guigu.domain.materials.Purchase;
import com.guigu.service.materials.IPriceSelectionAuditService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 选价处理类
 */
@Controller
@RequestMapping("/priceSelectionAuditController")
public class PriceSelectionAuditController {
	@Autowired
	private IPriceSelectionAuditService priceSelectionAuditService;

	/**
	 * 节点的id相同，那么事件也相同
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryDataGrid")
	@ResponseBody
	public DataGrid queryDataGrid(String id) {
		DataGrid dg = new DataGrid();
		List<Map<String, Object>> list = null;
		try {
			list = this.priceSelectionAuditService.queryDataGrid(id);
			dg.setRows(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dg;
	}

	/**
	 * 查询可审批的采购报价单
	 */
	@RequestMapping("/queryChoicePrice")
	@ResponseBody
	public List<ChoicePrice> queryChoicePrice() {
		List<ChoicePrice> list = null;
		try {
			list = this.priceSelectionAuditService.queryChoicePrice();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 处理审批
	 */
	@RequestMapping("/processingApprovals")
	@ResponseBody
	public String ProcessingApprovals(String proId, String excuseInfo, String text, HttpServletRequest request) {
		Employee emplyee = (Employee) request.getSession().getAttribute("emplyee");
		Purchase purchase = new Purchase();
		if ("0".equals(excuseInfo.trim())) {
			// 同意
			purchase.setPceId(proId);
			purchase.setGivePrice(excuseInfo.trim());
			purchase.setAgreeEmpNo(emplyee.getTe_id());
		} else {
			// 不同意
			purchase.setPceId(proId);
			purchase.setGivePrice(excuseInfo.trim());
			purchase.setAgreeEmpNo(emplyee.getTe_id());
			purchase.setAgreeReason(text.trim());
		}
		boolean boo = false;
		try {
			boo = this.priceSelectionAuditService.HandlePriceSelectionApprovals(purchase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "yes";
		}
		return "no";
	}

}
