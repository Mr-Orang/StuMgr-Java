package com.guigu.domain.materials;

/**
 * 物资类型视图类
 */
public class GoodsTypView {
	// 类型id
	private String id;
	// 类型名称
	private String text;
	// 父类型id
	private String parentId;
	// 状态
	private int status;

	public GoodsTypView() {

	}

	public GoodsTypView(String id, String text, String parentId, int status) {
		this.id = id;
		this.text = text;
		this.parentId = parentId;
		this.status = status;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
