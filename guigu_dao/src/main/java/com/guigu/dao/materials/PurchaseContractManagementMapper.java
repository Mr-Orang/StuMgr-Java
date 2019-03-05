package com.guigu.dao.materials;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.guigu.domain.materials.Protocal;
import com.guigu.domain.materials.ProtocalDetail;
import com.guigu.domain.materials.Provider;

/**
 * 审核数据访问类l
 */
@Mapper
public interface PurchaseContractManagementMapper {
	// 查询可审批的合同信息
	List<Protocal> queryProtocal() throws Exception;

	// 查询该合同的供应商情况
	List<ProtocalDetail> queryProtocalDetail(String protdId) throws Exception;

	// 查询该供应商的物资情况
	List<ProtocalDetail> queryChoicePriceDetail(String pceId, String providerId) throws Exception;

	// 修改审批状态
	void ModifyApprovalStatus(Protocal protocal) throws Exception;

	// 查询该审核通过的采购合的供应商信息
	List<Provider> queryProvider(String contractNO) throws Exception;
}
