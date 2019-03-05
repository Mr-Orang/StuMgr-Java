package com.guigu.service.materials;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.Use;
import com.guigu.domain.materials.UseDetail;

import java.util.List;

/**
 * 物料领取接口
 */
public interface IPickingManageService {
	/**
	 * 查询员工申请的物资信息 领用编号 填写日期 最迟日期 审批状态
	 */
	List<Use> queryIPickingMan(String EmpId) throws Exception;

	/**
	 * 查询当前领用编号下的物资明细
	 */
	PageInfo queryPickupDetails(String id, int page, int rows) throws Exception;

	/**
	 * 查询物资信息
	 */
	PageInfo queryGoods(int currentPage, int pageSize) throws Exception;

	/**
	 * 插入物资申请
	 */
	boolean insertMateriData(Use use, List<UseDetail> useDetailList) throws Exception;

	/**
	 * 查询所有未审批的信息
	 */
	PageInfo queryUseANdEmp(int currentPage, int pageSize) throws Exception;

	/**
	 * 修改申请信息（处理审批）
	 */
	boolean updateUse(Use use) throws Exception;

	/**
	 * 申请物资查询
	 */
	PageInfo queryApplicationInquiry(String id, int page, int rows) throws Exception;

	/**
	 * 分页查询
	 */
	PageInfo queryApplicationInformation(int currentPage, int pageSize, String empId) throws Exception;

	/**
	 * 查询历史审批记录
	 */
	PageInfo queryHistoryApprovalRecords(int currentPage, int pageSize) throws Exception;
}
