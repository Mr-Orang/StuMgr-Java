package com.guigu.dao.materials;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.guigu.domain.materials.InboundSubinformation;
import com.guigu.domain.materials.IncomingInfo;

/**
 * 入库管理映射文件类
 * 
 * @author ExcellentLiuYang
 *
 */
@Mapper
public interface InboundInfoMapper {
	// 查询入库信息
	List<IncomingInfo> queryIncomingInfo() throws Exception;

	// 查询合同下的供应商应供应数量，和实际供应数量
	List<InboundSubinformation> supplierSupplyQuantityQuantityActualSupply(String id) throws Exception;

	// 查询供应商所供应的物资信息
	List<InboundSubinformation> inquireAboutTheSupplyOfMaterialsSuppliedByTheSupplier(String pceId, String providerId) throws Exception;
}
