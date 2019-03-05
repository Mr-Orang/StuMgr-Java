package com.guigu.domain.marketing;
/**
 * 宿舍楼层信息
 * @author lijianghua
 *
 */
public class DormFloor {

	private String tdf_id;
	private int tdf_number;
	private int floor_number;
	private int floor_house;
	private int floor_bed;
	public DormFloor() {
		super();
	}
	public DormFloor(String tdf_id, int tdf_number, int floor_number, int floor_house, int floor_bed) {
		super();
		this.tdf_id = tdf_id;
		this.tdf_number = tdf_number;
		this.floor_number = floor_number;
		this.floor_house = floor_house;
		this.floor_bed = floor_bed;
	}
	public String getTdf_id() {
		return tdf_id;
	}
	public void setTdf_id(String tdf_id) {
		this.tdf_id = tdf_id;
	}
	public int getTdf_number() {
		return tdf_number;
	}
	public void setTdf_number(int tdf_number) {
		this.tdf_number = tdf_number;
	}
	public int getFloor_number() {
		return floor_number;
	}
	public void setFloor_number(int floor_number) {
		this.floor_number = floor_number;
	}
	public int getFloor_house() {
		return floor_house;
	}
	public void setFloor_house(int floor_house) {
		this.floor_house = floor_house;
	}
	public int getFloor_bed() {
		return floor_bed;
	}
	public void setFloor_bed(int floor_bed) {
		this.floor_bed = floor_bed;
	}
	@Override
	public String toString() {
		return "DormFloor [tdf_id=" + tdf_id + ", tdf_number=" + tdf_number + ", floor_number=" + floor_number
				+ ", floor_house=" + floor_house + ", floor_bed=" + floor_bed + "]";
	}
	
}
