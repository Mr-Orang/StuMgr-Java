package com.guigu.domain.marketing;

import java.io.Serializable;
/**
 * 更换宿舍类型实体类
 * @author maomao
 *
 */
public class Migrate implements Serializable {
	private Integer tm_id;//类型编号
	private String tm_type;//类型名称
	public Migrate() {
		super();
	}
	public Migrate(Integer tm_id, String tm_type) {
		super();
		this.tm_id = tm_id;
		this.tm_type = tm_type;
	}
	public Integer getTm_id() {
		return tm_id;
	}
	public void setTm_id(Integer tm_id) {
		this.tm_id = tm_id;
	}
	public String getTm_type() {
		return tm_type;
	}
	public void setTm_type(String tm_type) {
		this.tm_type = tm_type;
	}
	
	
}
