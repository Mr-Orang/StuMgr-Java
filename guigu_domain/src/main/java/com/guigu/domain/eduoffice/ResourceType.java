package com.guigu.domain.eduoffice;

/**
 * 资源类型实体类
 * 
 * @author zy
 *
 */
public class ResourceType {
	// 资源类型编号
	private String rt_id;
	// 资源类型名称
	private String rt_name;
	// 备注
	private String remake;

	public ResourceType(String rt_id, String rt_name, String remake) {
		super();
		this.rt_id = rt_id;
		this.rt_name = rt_name;
		this.remake = remake;
	}

	public ResourceType() {
		super();
	}

	public String getRt_id() {
		return rt_id;
	}

	public void setRt_id(String rt_id) {
		this.rt_id = rt_id;
	}

	public String getRt_name() {
		return rt_name;
	}

	public void setRt_name(String rt_name) {
		this.rt_name = rt_name;
	}

	public String getRemake() {
		return remake;
	}

	public void setRemake(String remake) {
		this.remake = remake;
	}

	@Override
	public String toString() {
		return "ResourceType [rt_id=" + rt_id + ", rt_name=" + rt_name + ", remake=" + remake + "]";
	}

}
