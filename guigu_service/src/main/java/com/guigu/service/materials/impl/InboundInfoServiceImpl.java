package com.guigu.service.materials.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.materials.InboundInfoMapper;
import com.guigu.domain.materials.InboundSubinformation;
import com.guigu.domain.materials.IncomingInfo;
import com.guigu.service.materials.InboundInfoService;

/**
 * 
 * @author ExcellentLiuYang
 *
 */
@Service
public class InboundInfoServiceImpl implements InboundInfoService {
	@Autowired
	private InboundInfoMapper inboundInfoMapper;

	@Override
	public List<IncomingInfo> queryIncomingInfo() throws Exception {
		List<IncomingInfo> list = this.inboundInfoMapper.queryIncomingInfo();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getActualStorage() == 0) {
				// 未入库
				list.get(i).setStatus("0");
			}
			if (list.get(i).getPutInStorage() < list.get(i).getActualStorage()) {
				// 部分入库
				list.get(i).setStatus("1");
			}
			if (list.get(i).getPutInStorage() == list.get(i).getActualStorage()) {
				// 入库完毕
				list.get(i).setStatus("2");
			}
		}
		return list;
	}

	@Override
	public List<InboundSubinformation> querymaterialAvailability(String id, String pceId) throws Exception {
		List<InboundSubinformation> list = this.inboundInfoMapper.supplierSupplyQuantityQuantityActualSupply(id);
		for (int i = 0; i < list.size(); i++) {
			List<InboundSubinformation> lists = this.inboundInfoMapper
					.inquireAboutTheSupplyOfMaterialsSuppliedByTheSupplier(pceId, list.get(i).getSupplierIdOrGoodsId());
			List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
			for (int j = 0; j < lists.size(); j++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("supplierIdOrGoodsId", lists.get(j).getSupplierIdOrGoodsId());
				map.put("suppliersNameOrgoodsName", lists.get(j).getSuppliersNameOrgoodsName());
				map.put("shouldSendTheNumber", lists.get(j).getShouldSendTheNumber());
				map.put("realNumberSend", lists.get(j).getRealNumberSend());
				listMap.add(map);
			}
			list.get(i).setChildren(listMap);
		}
		return list;
	}
}
