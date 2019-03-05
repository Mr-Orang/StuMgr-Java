package com.guigu.domain.eduoffice;

import java.util.List;
/**
 * layui 分页查询工具类
 * @author zy
 *
 */
public class LayUiPageInfo {
	private int code;
	private String msg;
	private Long count;
	private List data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public LayUiPageInfo(int code, String msg, Long count, List data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	public LayUiPageInfo() {
		super();
	}
	
	
}
