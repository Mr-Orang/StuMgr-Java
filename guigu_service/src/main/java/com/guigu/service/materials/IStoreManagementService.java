package com.guigu.service.materials;

import java.util.List;
import java.util.Map;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.Store;
import com.guigu.domain.materials.StoreArea;
import com.guigu.domain.materials.StoreAreaPosition;
import com.guigu.domain.materials.WarehouseArea;

/**
 * 仓库服务接口
 * 
 * @author ExcellentLiuYang
 *
 */
public interface IStoreManagementService {
	/**
	 * 仓库管理
	 */
	PageInfo queryStore(int page, int rows) throws Exception;

	/**
	 * a 查询区域
	 * 
	 * @param storeId
	 * @return
	 * @throws Exception
	 */
	List<StoreArea> queryStoreArea(String storeId) throws Exception;

	/**
	 * 查询仓库信息
	 */
	List<Store> queryStore() throws Exception;

	/**
	 * 查询仓库和区域
	 */
	List<Map<String, Object>> aueryTheWarehouseAndArea() throws Exception;

	/**
	 * 验证仓库取名是否有效
	 */
	boolean verifyThatTheWarehouseNameIsUseful(String name) throws Exception;

	/**
	 * 保存仓库信息
	 */
	void SaveWarehouseInformation(String name) throws Exception;

	/**
	 * 验证区域是否可用
	 */
	boolean AddWarehouseInformation(String name, String wreaName) throws Exception;

	/**
	 * 添加区域
	 */
	boolean addedAreaStr(String id, String name, String capacity) throws Exception;

	/**
	 * 验证区域名称是否有效
	 */
	boolean verifyThatTheShelfNameIsValid(String areaId, String nameOfShelfM) throws Exception;

	/**
	 * 查询区域的容量信息
	 */
	int queryAreaCapacityInformation(String areaName) throws Exception;

	/**
	 * 添加货架
	 */
	int addShelf(String areaId, String shelfName, String shelfCapacity, String[] goodsTypeId) throws Exception;

	/**
	 * 查询仓库/区域/货架的联级信息
	 * 
	 * @return
	 * @throws Exception
	 */
	List<WarehouseArea> modifyshelvesinwarehousearea() throws Exception;

	/**
	 * 查询单个仓库信息
	 */
	Store queryStoresone(String id) throws Exception;

	/**
	 * 查询区域信息
	 */
	StoreArea queryStoreAreaOne(String id) throws Exception;

	/**
	 * 查询货架
	 */
	StoreAreaPosition queryStoreAreaPositionOne(String id) throws Exception;

	/**
	 * 仓库信息修改提交
	 */
	void warehouseinformationmodificationsubmission(Store store) throws Exception;

	/**
	 * 区域信息修改提交
	 */
	void areainformationmodificationsubmission(StoreArea storeArea) throws Exception;

	/**
	 * 修改货架信息
	 */
	void shelfInformationModification(StoreAreaPosition storAreaPosition) throws Exception;
}
