package com.guigu.domain.materials;

import java.util.List;

/**
 * 仓库/区域/货架联合视图类 人生路漫漫，，，，代码敲不完
 * 
 * @author ExcellentLiuYang
 *
 */
public class WarehouseArea {
	// 编号
	private String id;
	// 名称
	private String text;
	// 父类型编号
	private List<WarehouseArea> children;

	public WarehouseArea() {

	}

	public WarehouseArea(String id, String text, List<WarehouseArea> children) {
		this.id = id;
		this.text = text;
		this.children = children;
	}

	public List<WarehouseArea> getChildren() {
		return children;
	}

	public void setChildren(List<WarehouseArea> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
