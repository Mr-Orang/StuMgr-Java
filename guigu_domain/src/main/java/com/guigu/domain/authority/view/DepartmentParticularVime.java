package com.guigu.domain.authority.view;

/*
 * 部门详细实体类
 */
public class DepartmentParticularVime {

	    //部门编号
		private String deptId;
		//员工编号
		private String te_Id;
		//员工姓名
		private String te_Name;
		//员工性别
		private String te_Sex;
		//员工年龄
		private Integer te_Age;
		//部门名称
		private String deptName;
		//部门描述
		private String remark;
		//部门状态
		private String status;
		
		//有参构造方法
		public DepartmentParticularVime(String deptId, String te_Id, String te_Name, String te_Sex, Integer te_Age,
				String deptName, String remark, String status) {
			super();
			this.deptId = deptId;
			this.te_Id = te_Id;
			this.te_Name = te_Name;
			this.te_Sex = te_Sex;
			this.te_Age = te_Age;
			this.deptName = deptName;
			this.remark = remark;
			this.status = status;
		}

		//无参构造方法
		public DepartmentParticularVime() {
			super();
		}

		//实体类get和set方法
		public String getDeptId() {
			return deptId;
		}

		public void setDeptId(String deptId) {
			this.deptId = deptId;
		}

		public String getTe_Id() {
			return te_Id;
		}

		public void setTe_Id(String te_Id) {
			this.te_Id = te_Id;
		}

		public String getTe_Name() {
			return te_Name;
		}

		public void setTe_Name(String te_Name) {
			this.te_Name = te_Name;
		}

		public String getTe_Sex() {
			return te_Sex;
		}

		public void setTe_Sex(String te_Sex) {
			this.te_Sex = te_Sex;
		}

		public Integer getTe_Age() {
			return te_Age;
		}

		public void setTe_Age(Integer te_Age) {
			this.te_Age = te_Age;
		}

		public String getDeptName() {
			return deptName;
		}

		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}		
}
