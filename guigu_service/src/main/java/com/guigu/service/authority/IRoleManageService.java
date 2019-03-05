package com.guigu.service.authority;

import java.util.List;

import com.guigu.domain.authority.view.AuthorizationView;
import com.guigu.domain.authority.view.RoleAuthorizationView;
import com.guigu.domain.authority.view.RoleImplentView;
import com.guigu.domain.marketing.PageInfo;

public interface IRoleManageService {
	// 查询所有角色
	PageInfo queryAllRole(int page,int rows);

	// 查询该角色所具有的权限
	List<RoleImplentView> queryAutByRoleId(String role_ID);

	// 查询角色
	RoleAuthorizationView queryRoleById(String role_ID);

	// 修改角色信息
	boolean updateRoleById(String role_Name, String status, String role_ID);

	// 删除角色权限表
	boolean deleteByid(String role_ID);

	// 添加角色权限表
	boolean insertTRA(String role_ID, String au_Id);

	// 查询所有权限
	List<AuthorizationView> selectAllTA();

	// 添加角色
	boolean insertRole(String role_Name, String status);
	
	//添加角色权限表
	boolean insertTRAs(String au_Id);

}
