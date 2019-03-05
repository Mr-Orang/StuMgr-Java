package com.guigu.controller.materials.warehouseinfmant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.domain.materials.InboundSubinformation;
import com.guigu.domain.materials.IncomingInfo;
import com.guigu.service.materials.InboundInfoService;

/**
 * 入库信息管理
 * 
 * @author ExcellentLiuYang
 *
 */
@Controller
@RequestMapping("/inboundInfo")
public class InboundInfo {
	@Autowired
	private InboundInfoService inboundInfoService;

	/**
	 * 入库信息管理
	 */
	@RequestMapping("/queryInboundInfo")
	public @ResponseBody List<IncomingInfo> queryInboundInfo() {
		List<IncomingInfo> list = null;
		try {
			list = this.inboundInfoService.queryIncomingInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询某合同下的物资供应情况
	 */
	@RequestMapping("/materialAvailability")
	public @ResponseBody List<InboundSubinformation> materialAvailability(String id, String pceId) {
		List<InboundSubinformation> list = null;
		try {
			list = this.inboundInfoService.querymaterialAvailability(id, pceId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
