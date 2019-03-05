package com.guigu.domain.eduoffice.vo;

/**
 * 加载下拉框老师信息实体类
 * 
 * @author zy
 *
 */
public class EmpVo {
	private String te_id;
	private String te_name;

	public EmpVo(String te_id, String te_name) {
		super();
		this.te_id = te_id;
		this.te_name = te_name;
	}

	public EmpVo() {
		super();
	}

	public String getTe_id() {
		return te_id;
	}

	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}

	public String getTe_name() {
		return te_name;
	}

	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}

	@Override
	public String toString() {
		return "EmpVo [te_id=" + te_id + ", te_name=" + te_name + "]";
	}

}
