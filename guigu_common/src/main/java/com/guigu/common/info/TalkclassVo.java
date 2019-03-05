package com.guigu.common.info;

/**
 * 查询班级阶段和班级的信息资料用于谈话管理
 * @author 
 *
 */
public class TalkclassVo {

	String tl_name;//班级阶段名称
	String tc_name;//班级名称
	String tc_technology;//专业方向
	String emp_id;//负责人编号
	String te_name;//班级负责人
	int tc_personnum;//班级人数
	
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getTl_name() {
		return tl_name;
	}
	public void setTl_name(String tl_name) {
		this.tl_name = tl_name;
	}
	public String getTc_name() {
		return tc_name;
	}
	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}
	public String getTc_technology() {
		return tc_technology;
	}
	public void setTc_technology(String tc_technology) {
		this.tc_technology = tc_technology;
	}
	public String getTe_name() {
		return te_name;
	}
	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}
	public int getTc_personnum() {
		return tc_personnum;
	}
	public void setTc_personnum(int tc_personnum) {
		this.tc_personnum = tc_personnum;
	}
	
	public TalkclassVo(String tl_name, String tc_name, String tc_technology, String emp_id, String te_name,
			int tc_personnum) {
		super();
		this.tl_name = tl_name;
		this.tc_name = tc_name;
		this.tc_technology = tc_technology;
		this.emp_id = emp_id;
		this.te_name = te_name;
		this.tc_personnum = tc_personnum;
	}
	@Override
	public String toString() {
		return "TalkclassVo [tl_name=" + tl_name + ", tc_name=" + tc_name + ", tc_technology=" + tc_technology
				+ ", emp_id=" + emp_id + ", te_name=" + te_name + ", tc_personnum=" + tc_personnum + "]";
	}
	public TalkclassVo() {
		super();
	}
	
	
}
