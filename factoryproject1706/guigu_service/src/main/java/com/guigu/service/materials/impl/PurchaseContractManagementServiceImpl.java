package com.guigu.service.materials.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.common.materials.PageInfo;
import com.guigu.common.materials.tools.email.SimpleMailSendTools;
import com.guigu.dao.materials.PurchaseContractManagementMapper;
import com.guigu.domain.materials.Protocal;
import com.guigu.domain.materials.ProtocalDetail;
import com.guigu.domain.materials.Provider;
import com.guigu.service.materials.IMailService;
import com.guigu.service.materials.IPurchaseContractManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.*;

@Service
public class PurchaseContractManagementServiceImpl implements IPurchaseContractManagementService {
	@Autowired
	private PurchaseContractManagementMapper purchaseContractManagementMapper;

	@Override
	public PageInfo queryProtocal(int page, int rows) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Protocal> pageInfo1 = PageHelper.startPage(page, rows).doSelectPageInfo(() -> {
			try {
				this.purchaseContractManagementMapper.queryProtocal();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	@Override
	public List<Map<String, Object>> queryTheSupplierAndTotalAmountOfTheContract(String protdId) throws Exception {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		List<ProtocalDetail> protocalDetailList = this.purchaseContractManagementMapper.queryProtocalDetail(protdId);
		for (ProtocalDetail protocalDetail : protocalDetailList) {
			Map<String, Object> map = new HashMap<String, Object>();
			// 供应商编号
			map.put("providerId", protocalDetail.getProviderId());
			// 供应商名称
			map.put("status", protocalDetail.getStatus());
			// 合同总金额
			map.put("conSum", protocalDetail.getConSum());
			List<ProtocalDetail> list = this.purchaseContractManagementMapper
					.queryChoicePriceDetail(protocalDetail.getProtId(), protocalDetail.getProviderId());
			map.put("children", list);
			results.add(map);
		}
		return results;
	}

	// 审核合同
	@Override
	public List<Provider> ApprovalContract(Protocal protocal) throws Exception {
		try {
			// 审批合同
			this.purchaseContractManagementMapper.ModifyApprovalStatus(protocal);
			if (protocal.getState().equals("2")) {
				// 同意合同 -> 发送邮件
				try {
					// 邮件编号 供应商名称 合同编号
					// 查询合同信息
					List<Provider> list = this.purchaseContractManagementMapper.queryProvider(protocal.getProtId());
					for (int i = 0; i < list.size(); i++) {
						list.get(i).setContractNO(protocal.getProtId());
					}
					return list;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
