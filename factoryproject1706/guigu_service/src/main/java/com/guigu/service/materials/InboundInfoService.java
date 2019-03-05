package com.guigu.service.materials;

import java.util.List;

import com.guigu.domain.materials.InboundSubinformation;
import com.guigu.domain.materials.IncomingInfo;

/**
 * 入库信息服务接口
 * 
 * @author ExcellentLiuYang
 * 
 */
public interface InboundInfoService {
	// 查询合同信息
	List<IncomingInfo> queryIncomingInfo() throws Exception;

	// 查询合同的供应商信息
	List<InboundSubinformation> querymaterialAvailability(String id, String pceId) throws Exception;

}
