package com.guigu.controller.materials.acquisitionman;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.marketing.Employee;
import com.guigu.domain.materials.Use;
import com.guigu.domain.materials.UseDetail;
import com.guigu.service.materials.IPickingManageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 物料申请处理器类
 */
@Controller
@RequestMapping("/pickingManagement")
public class PickingManagementController {
	@Autowired
	private IPickingManageService iPickingManageService;

	// 查询当前账户的物资申请信息
	@RequestMapping("/queryPicking")
	public @ResponseBody PageInfo queryRetrievalInformation(HttpServletRequest request, int page, int rows) {
		// 获取当前账号的员工信息
		Employee emplyee = (Employee) request.getSession().getAttribute("emplyee");
		PageInfo pageinfo = null;
		try {
			pageinfo = this.iPickingManageService.queryApplicationInformation(page, rows, emplyee.getTe_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}

	/**
	 * 查询当前领用id的领用明细
	 */
	@RequestMapping("/pickupDetails")
	@ResponseBody
	public PageInfo pickupDetails(String id, int page, int rows) {
		PageInfo pageInfo = null;
		try {
			pageInfo = this.iPickingManageService.queryPickupDetails(id, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

	/**
	 * 查询物资信息
	 */
	@RequestMapping("/queryGoods")
	public @ResponseBody PageInfo queryGoods(int page, int rows) {
		PageInfo pageinfo = null;
		try {
			pageinfo = this.iPickingManageService.queryGoods(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}

	/**
	 * 保存物资申请
	 */
	@RequestMapping("/insertMater")
	public @ResponseBody String insertMaterInfo(HttpServletRequest request, String[] idsArray, int[] numsArray,
			String latestTime) {
		Employee emplyee = (Employee) request.getSession().getAttribute("emplyee");
		// 领用申请信息
		Use use = new Use("0", emplyee.getTe_id(), null, latestTime, 0, null, null, null, null, 0, null, null);
		// 领用申请明细
		List<UseDetail> useDetails = new ArrayList<UseDetail>();
		for (int i = 0; i < idsArray.length; i++) {
			UseDetail useDetail = new UseDetail("0", "0", idsArray[i], numsArray[i]);
			useDetails.add(useDetail);
		}
		boolean boo = false;
		try {
			boo = this.iPickingManageService.insertMateriData(use, useDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "yes";
		}
		return "no";
	}

	/**
	 * 处理物料申请审批请求
	 */
	@RequestMapping("/processApproval")
	public @ResponseBody String ProcessApprovalRequests(String userId, String text, int decide,
			HttpServletRequest request) {
		Employee emplyee = (Employee) request.getSession().getAttribute("emplyee");
		Use use = null;
		// 申请id 申请内容 结果
		if (decide == 1) {
			// 不同意
			use = new Use(userId, null, null, null, 1, emplyee.getTe_id(), null, text, null, 0, null, null);
		} else {
			// 同意
			use = new Use(userId, null, null, null, 2, emplyee.getTe_id(), null, null, null, 0, null, null);
		}
		boolean boo = false;
		try {
			boo = this.iPickingManageService.updateUse(use);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "yes";
		}
		return "no";
	}

	/**
	 * 查询物资详细信息
	 * 
	 * @param id
	 * @param page
	 * @param rows
	 * @return
	 */

	@RequestMapping("/applicationInquiry")
	public @ResponseBody PageInfo queryApplicationInquiry(String id, int page, int rows) {
		PageInfo pageinfo = null;
		try {
			pageinfo = this.iPickingManageService.queryApplicationInquiry(id, page, rows);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}

	/**
	 * 查询历史审批记录
	 */
	@RequestMapping("/queryHistoryApprovalRecords")
	public @ResponseBody PageInfo QueryHistoryApprovalRecords(int page, int rows) {
		PageInfo pageinfo = null;
		try {
			pageinfo = this.iPickingManageService.queryHistoryApprovalRecords(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}

	/**
	 * 查询未审批的物料信息
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/queryApplicationInformation")
	public @ResponseBody PageInfo queryUserAndEmp(int page, int rows) {
		PageInfo pageinfo = null;
		try {
			pageinfo = this.iPickingManageService.queryUseANdEmp(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}
}
