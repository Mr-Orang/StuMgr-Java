package com.guigu.service.authority;

import java.util.List;

import com.guigu.domain.authority.view.UserManageView;
import com.guigu.domain.authority.vo.DepartmentVO;
import com.guigu.domain.authority.vo.RoleVO;
import com.guigu.domain.marketing.PageInfo;

public interface IUserManageService {
	// 查询所有为员工的账户信息
	PageInfo queryAllUser(int page,int rows);

	// 根据员工ID查询该员工的账户信息
	UserManageView queryUserById(String id);

	// 查询所有角色
	List<RoleVO> queryRoles();

	// 查询所有部门
	List<DepartmentVO> queryDeparts();

	// 修改员工账号信息
	boolean updateUser(String password, int status, String account);

	// 修改员工角色
	boolean updateRole(String role_ID, String account);

	// 修改员工姓名和部门
	boolean updateDept(String te_NAME, String deptId, String te_ID);
	
	//添加员工
	boolean addEmp(String te_name,String te_mobile,String te_card_id,String te_sex,int te_age,String te_marry_status,String te_address,String deptId,String role_ID);

	//添加账号
	boolean addUser();

	//添加账号角色关联表
	boolean addaccRole(String role_ID);
}
