package com.guigu.controller.materials.warehouseinfmant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.Store;
import com.guigu.domain.materials.StoreArea;
import com.guigu.domain.materials.StoreAreaPosition;
import com.guigu.domain.materials.WarehouseArea;
import com.guigu.service.materials.IStoreManagementService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 仓库管理处理类
 */
@Controller
@RequestMapping("/storeManagementController")
public class StoreManagementController {
	@Autowired
	private IStoreManagementService iStoreManagement;

	/**
	 * 查询仓库信息
	 *
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/queryListStore")
	public @ResponseBody PageInfo queryListStore(int page, int rows) {
		PageInfo pageinfo = null;
		try {
			pageinfo = this.iStoreManagement.queryStore(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}

	/**
	 * 加载区域和货架信息
	 */
	@RequestMapping("/loadAreaAndShelfInformation")
	public @ResponseBody List<StoreArea> LoadAreaAndShelfInformation(String storeId) {
		List<StoreArea> list = null;
		try {
			list = this.iStoreManagement.queryStoreArea(storeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询仓库信息
	 */
	@RequestMapping("/queryWarehouseInformation")
	public @ResponseBody List<Map<String, Object>> queryWarehouseInformation(String storeId) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		List<Store> list = null;
		try {
			list = this.iStoreManagement.queryStore();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Store store : list) {
			Map<String, Object> objectMap = new HashMap<String, Object>();
			objectMap.put("id", store.getStoreId());
			objectMap.put("text", store.getAddress());
			mapList.add(objectMap);
		}
		return mapList;
	}

	/**
	 * 查询仓库与区域
	 */
	@RequestMapping("/aueryTheWarehouseAndArea")
	public @ResponseBody List<Map<String, Object>> aueryTheWarehouseAndArea() {
		List<Map<String, Object>> list = null;
		try {
			list = this.iStoreManagement.aueryTheWarehouseAndArea();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 验证仓库取名是否有用
	 */
	@RequestMapping("/verifyThatTheWarehouseNameIsUseful")
	public @ResponseBody String verifyThatTheWarehouseNameIsUseful(String name) {
		boolean boo = false;
		try {
			boo = this.iStoreManagement.verifyThatTheWarehouseNameIsUseful(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "ok";
		}
		return "no";
	}

	/**
	 * 添加仓库信息
	 */
	@RequestMapping("/addWarehouseInformation")
	public @ResponseBody String AddWarehouseInformation(String wareHouseName) {
		try {
			this.iStoreManagement.SaveWarehouseInformation(wareHouseName);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
	}

	/**
	 * 验证区域名称是否可用
	 */
	@RequestMapping("/verifyThatTheRegionNameIsAvailable")
	public @ResponseBody String VerifyThatTheRegionNameIsAvailable(String name, String wareName) {
		try {
			boolean boo = this.iStoreManagement.AddWarehouseInformation(name, wareName);
			if (boo) {
				return "ok";
			} else {
				return "no";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加区域
	 */
	@RequestMapping("/addedAreaStr")
	public @ResponseBody String addedAreaStr(String id, String name, String capacity) {
		boolean boo = false;
		try {
			boo = this.iStoreManagement.addedAreaStr(id, name, capacity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "ok";
		} else {
			return "no";
		}
	}

	/**
	 * 验证货架名称是否有效 1.货架id 2.区域名称
	 */
	@RequestMapping("/verifyThatTheShelfNameIsValid")
	public @ResponseBody String verifyThatTheShelfNameIsValid(String areaId, String nameOfShelfM) {
		boolean boo = false;
		try {
			boo = this.iStoreManagement.verifyThatTheShelfNameIsValid(areaId, nameOfShelfM);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "ok";
		} else {
			return "no";
		}
	}

	/**
	 * 查询区域的容量信息
	 */
	@RequestMapping("/queryAreaCapacityInformation")
	public @ResponseBody String queryAreaCapacityInformation(String areaName) {
		try {
			return String.valueOf(this.iStoreManagement.queryAreaCapacityInformation(areaName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加货架 1.区域编号 2.货架名称 3.货架容量
	 */
	@RequestMapping("/addShelf")
	public @ResponseBody String addShelf(String areaId, String shelfName, String shelfCapacity, String[] goodsTypeId) {
		int choose = 0;
		try {
			choose = this.iStoreManagement.addShelf(areaId, shelfName, shelfCapacity, goodsTypeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (choose > 0) {
			return "ok";
		} else {
			return "no";
		}
	}

	/**
	 * 修改仓库/区域/货架
	 */
	// 查询树形结构的仓库/区域/货架
	@RequestMapping("/modifyshelvesinwarehousearea")
	public @ResponseBody List<WarehouseArea> modifyshelvesinwarehousearea() {
		List<WarehouseArea> list = null;
		try {
			list = this.iStoreManagement.modifyshelvesinwarehousearea();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按id查询仓库信息和仓库下的区域状态
	 */
	@RequestMapping("/queryStoresone")
	public @ResponseBody Store queryStoresone(String storeId) {
		Store store = null;
		try {
			store = this.iStoreManagement.queryStoresone(storeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return store;
	}

	// 查询区域信息
	@RequestMapping("/queryAreaOne")
	public @ResponseBody StoreArea queryAreaOne(String id) {
		StoreArea storearea = null;
		try {
			storearea = this.iStoreManagement.queryStoreAreaOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return storearea;
	}

	// 查询货架信息(单个)
	@RequestMapping("/queryStoreAreaPosition")
	public @ResponseBody StoreAreaPosition queryStoreAreaPosition(String id) {
		StoreAreaPosition storeAreaPosition = null;
		try {
			storeAreaPosition = this.iStoreManagement.queryStoreAreaPositionOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return storeAreaPosition;
	}

	// 仓库信息修改提交
	@RequestMapping("/warehouseinformationmodificationsubmission")
	public @ResponseBody String warehouseinformationmodificationsubmission(Store store) {
		try {
			this.iStoreManagement.warehouseinformationmodificationsubmission(store);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 区域信息修改提交
	@RequestMapping("/areainformationmodificationsubmission")
	public @ResponseBody String areainformationmodificationsubmission(StoreArea storeArea) {
		try {
			this.iStoreManagement.areainformationmodificationsubmission(storeArea);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 货架信息修改
	@RequestMapping("/shelfInformationModification")
	public @ResponseBody String shelfInformationModification(StoreAreaPosition storAreaPosition) {
		try {
			this.iStoreManagement.shelfInformationModification(storAreaPosition);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
