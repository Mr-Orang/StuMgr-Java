package com.guigu.dao.materials;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.Use;
import com.guigu.domain.materials.UseAndEmpView;
import com.guigu.domain.materials.UseDetail;

/**
 * 物资领用信息模块
 * 
 * @author ExcellentLiuYang
 */
@Mapper
public interface PickingManageMapper {
	/**
	 * 查询当前用户的物资申请信息
	 */
	List<Use> queryPickingManage(String EmpId) throws Exception;

	/**
	 * 查询当前领用编号的领用明细
	 */
	List<Goods> queryGoodsDetail(String id) throws Exception;

	/**
	 * 查询物资信息
	 */
	List<Goods> quertGoods() throws Exception;

	/**
	 * 插入申请表
	 */
	void insertUse(Use use) throws Exception;

	/**
	 * 插入明细表
	 */
	void insertUseDetail(List<UseDetail> useDetailList) throws Exception;

	/**
	 * 查询未审核的订单信息
	 */
	List<UseAndEmpView> queryUserAndEmp() throws Exception;

	/**
	 * 审批采购申请
	 */
	void updateUse(Use use) throws Exception;

	/**
	 * 查询申请单号申请的物资
	 */
	List<Goods> queryapplyForGoods(String id) throws Exception;

	/**
	 * 分页查询，当前账户的物料申请记录
	 *
	 * @return
	 */
	List<Use> queryUse(String empId) throws Exception;

	/**
	 * 查询历史物资审批记录(所有账户的)
	 */
	List<Use> queryUsesgo() throws Exception;
}
