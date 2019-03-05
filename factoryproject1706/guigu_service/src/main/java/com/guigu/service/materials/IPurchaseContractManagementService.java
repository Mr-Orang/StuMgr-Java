package com.guigu.service.materials;

import java.util.List;
import java.util.Map;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.Protocal;
import com.guigu.domain.materials.Provider;

/**
 * 合同审核服务类
 */
public interface IPurchaseContractManagementService {
	// 查询可审核的合同
	PageInfo queryProtocal(int page, int rows) throws Exception;

	// 查询该合同的供应商情况
	List<Map<String, Object>> queryTheSupplierAndTotalAmountOfTheContract(String protdId) throws Exception;

	// 审批合同
	List<Provider> ApprovalContract(Protocal protocal) throws Exception;
}
