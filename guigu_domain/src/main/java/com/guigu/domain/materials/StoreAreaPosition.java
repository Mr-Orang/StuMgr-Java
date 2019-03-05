package com.guigu.domain.materials;

/**
 * 货架信息表
 */
public class StoreAreaPosition {
	private String positionId;
	private String positionName;
	private int positionCount;
	private String areaId;
	private String typeId;
	private int positionNumber;
	private int status;

	public StoreAreaPosition(String positionId, String positionName, int positionCount, String areaId, String typeId,
			int positionNumber, int status) {
		this.positionId = positionId;
		this.positionName = positionName;
		this.positionCount = positionCount;
		this.areaId = areaId;
		this.typeId = typeId;
		this.positionNumber = positionNumber;
		this.status = status;
	}

	public StoreAreaPosition() {

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public int getPositionCount() {
		return positionCount;
	}

	public void setPositionCount(int positionCount) {
		this.positionCount = positionCount;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public int getPositionNumber() {
		return positionNumber;
	}

	public void setPositionNumber(int positionNumber) {
		this.positionNumber = positionNumber;
	}
}
