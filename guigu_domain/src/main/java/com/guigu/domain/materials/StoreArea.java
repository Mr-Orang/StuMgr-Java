package com.guigu.domain.materials;

import java.util.List;
import java.util.Map;

/**
 * 仓库区域信息表
 */
public class StoreArea {
	private String areaId;
	private String areaName;
	private int areaCount;
	private String storeId;
	private String typeId;
	private List<Map<String, Object>> children;
	private String status;

	public StoreArea() {

	}

	public StoreArea(String areaId, String areaName, int areaCount, String storeId, String typeId,
			List<Map<String, Object>> children, String status) {
		this.areaId = areaId;
		this.areaName = areaName;
		this.areaCount = areaCount;
		this.storeId = storeId;
		this.typeId = typeId;
		this.children = children;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Map<String, Object>> getChildren() {
		return children;
	}

	public void setChildren(List<Map<String, Object>> children) {
		this.children = children;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getAreaCount() {
		return areaCount;
	}

	public void setAreaCount(int areaCount) {
		this.areaCount = areaCount;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
}
