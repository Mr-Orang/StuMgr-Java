package com.guigu.dao.materials;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.guigu.domain.materials.Store;
import com.guigu.domain.materials.StoreArea;
import com.guigu.domain.materials.StoreAreaPosition;
import com.guigu.domain.materials.StoreAreaPositionGoodsType;

/**
 * 查询仓库信息接口
 */
@Mapper
public interface StoreManagementMapper {
	// 查询仓库信息
	List<Store> queryStore() throws Exception;

	// 按仓库编号查询区域信息
	List<StoreArea> queryStoreArea(String storeId) throws Exception;

	// 查询全部区域信息
	List<StoreArea> queryStoreAreaAll() throws Exception;

	// 查询货架信息
	List<StoreAreaPosition> queryStoreAreaPosition(String areaId) throws Exception;

	// 查询全部货架信息
	List<StoreAreaPosition> queryStoreAreaPositionAll() throws Exception;

	// 查询货架物资类型
	List<StoreAreaPositionGoodsType> queryStoreAreaPositionGoodsType(String sapAreaId) throws Exception;

	// 验证仓库取名是否有效
	Store verifyThatTheWarehouseNameIsUseful(String name) throws Exception;

	// 保存仓库信息
	void SaveWarehouseInformation(String name) throws Exception;

	// 验证区域石是否可用
	StoreArea AddWarehouseInformation(String name, String wareName) throws Exception;

	// 添加区域
	void addedAreaStr(String id, String name, String capacity) throws Exception;

	// 验证货架名称是否有效
	StoreAreaPosition isStoreArea(String areaId, String nameOfShelfM) throws Exception;

	// 查询区域容量信息
	StoreArea queryAreaCapacityInformation(String areaId) throws Exception;

	// 添加货架
	int addShelf(String areaId, String shelfName, String shelfCapacity) throws Exception;

	// 插入货架表
	int insertAddShelf(StoreAreaPosition storeAreaPosition) throws Exception;

	// 插入货架与物资类型的关联表
	int shelfAndGoodsType(List<StoreAreaPositionGoodsType> storeAreaPositionGoodsTypes) throws Exception;

	// 查询单个仓库信息
	Store queryStoresone(String id) throws Exception;

	// 查询区域信息（单个）
	StoreArea queryStoreAreaOne(String id) throws Exception;

	// 查询货架信息（单个）
	StoreAreaPosition queryStoreAreaPositionOne(String id) throws Exception;

	// 仓库信息修改提交
	void warehouseinformationmodificationsubmission(Store store) throws Exception;

	// 区域信息修改提价
	void areainformationmodificationsubmission(StoreArea storeArea) throws Exception;

	// 修改货架信息
	void shelfInformationModification(StoreAreaPosition storAreaPosition) throws Exception;
}
