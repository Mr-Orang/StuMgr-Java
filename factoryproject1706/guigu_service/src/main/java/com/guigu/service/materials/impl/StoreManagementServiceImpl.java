package com.guigu.service.materials.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.common.materials.PageInfo;
import com.guigu.dao.materials.StoreManagementMapper;
import com.guigu.domain.materials.Store;
import com.guigu.domain.materials.StoreArea;
import com.guigu.domain.materials.StoreAreaPosition;
import com.guigu.domain.materials.StoreAreaPositionGoodsType;
import com.guigu.domain.materials.WarehouseArea;
import com.guigu.service.materials.IStoreManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StoreManagementServiceImpl implements IStoreManagementService {
	@Autowired
	private StoreManagementMapper storeManagementMapper;

	@Override
	public PageInfo queryStore(int page, int rows) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Store> pageInfo1 = PageHelper.startPage(page, rows).doSelectPageInfo(() -> {
			try {
				this.storeManagementMapper.queryStore();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	// 查询区域信息
	@Override
	public List<StoreArea> queryStoreArea(String storeId) throws Exception {
		List<StoreArea> storeAreaList = this.storeManagementMapper.queryStoreArea(storeId);
		for (int i = 0; i < storeAreaList.size(); i++) {
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			List<StoreAreaPosition> storeAreaPositionList = this.storeManagementMapper
					.queryStoreAreaPosition(storeAreaList.get(i).getAreaId());
			for (StoreAreaPosition storeAreaPosition : storeAreaPositionList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("areaId", storeAreaPosition.getPositionId());
				map.put("positionCount", storeAreaPosition.getPositionCount());
				// 查询物资类型-------------------------------------------------------------
				List<StoreAreaPositionGoodsType> list = this.storeManagementMapper
						.queryStoreAreaPositionGoodsType(storeAreaPosition.getPositionId());
				String goodsTypeStr = "";
				for (StoreAreaPositionGoodsType storeAreaPositionGoodsType : list) {
					goodsTypeStr += storeAreaPositionGoodsType.getSapPositionId() + ",";
				}
				goodsTypeStr = goodsTypeStr.substring(0, goodsTypeStr.length() - 1);
				map.put("typeId", goodsTypeStr);
				// -------------------------------------------------------------------------
				map.put("positionNumber", storeAreaPosition.getPositionNumber());
				map.put("positionName", storeAreaPosition.getPositionName());
				map.put("status", storeAreaPosition.getStatus());
				mapList.add(map);
			}
			storeAreaList.get(i).setChildren(mapList);
		}
		return storeAreaList;
	}

	@Override
	public List<Store> queryStore() throws Exception {
		return this.storeManagementMapper.queryStore();
	}

	/**
	 * 查询仓库与区域
	 *
	 * @return
	 */
	@Override
	public List<Map<String, Object>> aueryTheWarehouseAndArea() throws Exception {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		List<Store> list = this.storeManagementMapper.queryStore();
		for (Store store : list) {
			Map<String, Object> stringObjectMap = new HashMap<String, Object>();
			stringObjectMap.put("id", store.getStoreId());
			stringObjectMap.put("text", store.getAddress());
			// 查询区域信息
			List<StoreArea> storeAreaList = this.storeManagementMapper.queryStoreArea(store.getStoreId());
			List<Map<String, Object>> mapList1 = new ArrayList<Map<String, Object>>();
			for (StoreArea storeArea : storeAreaList) {
				Map<String, Object> stringObjectMap1 = new HashMap<String, Object>();
				stringObjectMap1.put("id", storeArea.getAreaId());
				stringObjectMap1.put("text", store.getStoreId() + storeArea.getAreaName());
				mapList1.add(stringObjectMap1);
			}
			stringObjectMap.put("children", mapList1);
			mapList.add(stringObjectMap);
		}
		return mapList;
	}

	@Override
	public boolean verifyThatTheWarehouseNameIsUseful(String name) throws Exception {
		Store store = this.storeManagementMapper.verifyThatTheWarehouseNameIsUseful(name);
		if (store == null) {
			return true;
		}
		return false;
	}

	@Override
	public void SaveWarehouseInformation(String name) throws Exception {
		this.storeManagementMapper.SaveWarehouseInformation(name);
	}

	/**
	 * 验证区域是否可用
	 *
	 * @param name
	 * @return
	 */
	@Override
	public boolean AddWarehouseInformation(String name, String wreaName) throws Exception {
		StoreArea storeArea = this.storeManagementMapper.AddWarehouseInformation(name, wreaName);
		if (storeArea == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addedAreaStr(String id, String name, String capacity) throws Exception {
		try {
			this.storeManagementMapper.addedAreaStr(id, name, capacity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean verifyThatTheShelfNameIsValid(String areaId, String nameOfShelfM) throws Exception {
		StoreAreaPosition storeAreaPosition = this.storeManagementMapper.isStoreArea(areaId, nameOfShelfM);
		if (storeAreaPosition == null) {
			return true;
		}
		return false;
	}

	@Override
	public int queryAreaCapacityInformation(String areaName) throws Exception {
		StoreArea storeArea = this.storeManagementMapper.queryAreaCapacityInformation(areaName);
		return storeArea.getAreaCount();
	}

	/**
	 * 添加货架
	 *
	 * @param areaId
	 * @param shelfName
	 * @param shelfCapacity
	 * @param goodsTypeId
	 * @return
	 */
	@Override
	public int addShelf(String areaId, String shelfName, String shelfCapacity, String[] goodsTypeId) throws Exception {
		/**
		 * 封装物资类型
		 */
		List<StoreAreaPositionGoodsType> storeAreaPositionGoodsTypes = new ArrayList<StoreAreaPositionGoodsType>();
		for (String str : goodsTypeId) {
			storeAreaPositionGoodsTypes.add(new StoreAreaPositionGoodsType(null, null, str));
		}
		/**
		 * 封装货架信息表
		 */
		StoreAreaPosition storeAreaPosition = new StoreAreaPosition(null, shelfName, Integer.parseInt(shelfCapacity),
				areaId, null, 0, 0);
		/**
		 * 插入货架表，获取货架编号
		 */
		this.storeManagementMapper.insertAddShelf(storeAreaPosition);
		/**
		 * 更新关联表视图类
		 */
		for (int i = 0; i < storeAreaPositionGoodsTypes.size(); i++) {
			storeAreaPositionGoodsTypes.get(i).setSapPositionId(storeAreaPosition.getPositionId());
		}
		/**
		 * 插入货架关联表
		 */
		return this.storeManagementMapper.shelfAndGoodsType(storeAreaPositionGoodsTypes);
	}

	@Override
	public List<WarehouseArea> modifyshelvesinwarehousearea() throws Exception {
		List<WarehouseArea> wareHouseArea = new ArrayList<WarehouseArea>();
		// 查询仓库信息
		List<Store> store = this.storeManagementMapper.queryStore();
		for (Store s : store) {
			// 第一步，把仓库信息添加到容器中
			wareHouseArea.add(new WarehouseArea(s.getStoreId(), s.getAddress(), null));
		}
		// 查询区域信息
		List<StoreArea> queryStoreAreaAll = this.storeManagementMapper.queryStoreAreaAll();
		// 查询货架信息
		List<StoreAreaPosition> storeAreaPosition = this.storeManagementMapper.queryStoreAreaPositionAll();
		// 第二步，遍历第一步中仓库信息的容器
		for (int i = 0; i < wareHouseArea.size(); i++) {
			List<WarehouseArea> wareHouseArea2 = new ArrayList<WarehouseArea>();
			// 遍历区域信息中的容器
			for (int j = 0; j < queryStoreAreaAll.size(); j++) {
				// 判断仓库编号是否与区域中带有仓库编号的区域相同
				if (wareHouseArea.get(i).getId().equals(queryStoreAreaAll.get(j).getStoreId())) {
					List<WarehouseArea> wareHouseArea3 = new ArrayList<WarehouseArea>();
					for (int k = 0; k < storeAreaPosition.size(); k++) {
						// 判断该区域编号是否与货架编号相同
						if (queryStoreAreaAll.get(j).getAreaId().equals(storeAreaPosition.get(k).getAreaId())) {
							wareHouseArea3.add(new WarehouseArea(storeAreaPosition.get(k).getPositionId(),
									storeAreaPosition.get(k).getPositionName(), null));
						}
					}
					wareHouseArea2.add(new WarehouseArea(queryStoreAreaAll.get(j).getAreaId(),
							queryStoreAreaAll.get(j).getAreaName(), wareHouseArea3));
				}
			}
			wareHouseArea.get(i).setChildren(wareHouseArea2);
		}
		return wareHouseArea;
	}

	@Override
	public Store queryStoresone(String id) throws Exception {
		return this.storeManagementMapper.queryStoresone(id);
	}

	@Override
	public StoreArea queryStoreAreaOne(String id) throws Exception {
		return this.storeManagementMapper.queryStoreAreaOne(id);
	}

	@Override
	public StoreAreaPosition queryStoreAreaPositionOne(String id) throws Exception {
		return this.storeManagementMapper.queryStoreAreaPositionOne(id);
	}

	@Override
	public void warehouseinformationmodificationsubmission(Store store) throws Exception {
		this.storeManagementMapper.warehouseinformationmodificationsubmission(store);
	}

	@Override
	public void areainformationmodificationsubmission(StoreArea storeArea) throws Exception {
		this.storeManagementMapper.areainformationmodificationsubmission(storeArea);
	}

	@Override
	public void shelfInformationModification(StoreAreaPosition storAreaPosition) throws Exception {
		this.storeManagementMapper.shelfInformationModification(storAreaPosition);
	}
}
