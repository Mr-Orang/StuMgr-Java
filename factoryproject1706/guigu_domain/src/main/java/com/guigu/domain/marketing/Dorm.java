package com.guigu.domain.marketing;

public class Dorm {
	/**
	 * tdm_id VARCHAR2(10) primary key,--宿舍ID，
	tdm_number VARCHAR2(10),--宿舍编号(1-1-1(栋号-楼层-宿舍号))，
	tdm_bed number(2),--宿舍床位，
	tdm_nowbed number(2),--实住床位（用于判断是否住满），
	tdm_state VARCHAR2(50)--说明
	tdm_typeID--类型编号
	 */
	
	private String tdm_id;
	private String tdm_number;
	private int tdm_bed;
	private int tdm_nowbed;
	private String tdm_state;
	private int tdm_typeID;
	
	public Dorm() {
		super();
	}

	

	public Dorm(String tdm_id, String tdm_number, int tdm_bed, int tdm_nowbed, String tdm_state, int tdm_typeID) {
		super();
		this.tdm_id = tdm_id;
		this.tdm_number = tdm_number;
		this.tdm_bed = tdm_bed;
		this.tdm_nowbed = tdm_nowbed;
		this.tdm_state = tdm_state;
		this.tdm_typeID = tdm_typeID;
	}



	public int getTdm_typeID() {
		return tdm_typeID;
	}



	public void setTdm_typeID(int tdm_typeID) {
		this.tdm_typeID = tdm_typeID;
	}



	public String getTdm_id() {
		return tdm_id;
	}

	public void setTdm_id(String tdm_id) {
		this.tdm_id = tdm_id;
	}

	public String getTdm_number() {
		return tdm_number;
	}

	public void setTdm_number(String tdm_number) {
		this.tdm_number = tdm_number;
	}

	public int getTdm_bed() {
		return tdm_bed;
	}

	public void setTdm_bed(int tdm_bed) {
		this.tdm_bed = tdm_bed;
	}

	public int getTdm_nowbed() {
		return tdm_nowbed;
	}

	public void setTdm_nowbed(int tdm_nowbed) {
		this.tdm_nowbed = tdm_nowbed;
	}

	public String getTdm_state() {
		return tdm_state;
	}

	public void setTdm_state(String tdm_state) {
		this.tdm_state = tdm_state;
	}

	@Override
	public String toString() {
		return "Dorm [tdm_id=" + tdm_id + ", tdm_number=" + tdm_number + ", tdm_bed=" + tdm_bed + ", tdm_nowbed="
				+ tdm_nowbed + ", tdm_state=" + tdm_state + "]";
	}
}
