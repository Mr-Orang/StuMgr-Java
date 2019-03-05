package com.guigu.domain.marketing;

import java.io.Serializable;
/**
 * 宿舍类型实体类
 * @author maomao
 *
 */
public class DormType implements Serializable {
	private int tdm_typeID;//类型编号
	private String tdm_typeName;//类型名称
	private String tdm_typeState;//类型状态
	public DormType(int tdm_typeID, String tdm_typeName, String tdm_typeState) {
		super();
		this.tdm_typeID = tdm_typeID;
		this.tdm_typeName = tdm_typeName;
		this.tdm_typeState = tdm_typeState;
	}
	public DormType() {
		super();
	}
	public int getTdm_typeID() {
		return tdm_typeID;
	}
	public void setTdm_typeID(int tdm_typeID) {
		this.tdm_typeID = tdm_typeID;
	}
	public String getTdm_typeName() {
		return tdm_typeName;
	}
	public void setTdm_typeName(String tdm_typeName) {
		this.tdm_typeName = tdm_typeName;
	}
	public String getTdm_typeState() {
		return tdm_typeState;
	}
	public void setTdm_typeState(String tdm_typeState) {
		this.tdm_typeState = tdm_typeState;
	}
	
	
}
