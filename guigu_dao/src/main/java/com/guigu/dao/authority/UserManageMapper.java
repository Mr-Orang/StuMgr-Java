package com.guigu.dao.authority;
/**
 * 用户管理模块
 * @author cjj
 *
 */

import java.util.List;

import com.guigu.domain.authority.view.UserManageView;
import com.guigu.domain.authority.vo.DepartmentVO;
import com.guigu.domain.authority.vo.RoleVO;

public interface UserManageMapper {
	//查询所有为员工的账户信息
	List<UserManageView> queryAllUser();
	
	//根据员工ID查询该员工的账户信息
	UserManageView queryUserById(String id);
	//修改员工账号信息
	void updateUser(String password ,int status,String account);
	//修改员工角色
	void updateRole(String role_ID,String account);
	//修改员工姓名和部门
	void updateDept(String te_NAME,String deptId,String te_ID);
	//查询所有角色
	List<RoleVO> queryRoles();
	//查询所有部门
	List<DepartmentVO> queryDeparts();
	//添加员工
	void addEmp(String te_name,String te_mobile,String te_card_id,String te_sex,int te_age,String te_marry_status,String te_address,String deptId,String role_ID);
	//添加账号
	void addUser();
	//添加账户角色关联表
	void addaccRole(String role_ID);
	
}
