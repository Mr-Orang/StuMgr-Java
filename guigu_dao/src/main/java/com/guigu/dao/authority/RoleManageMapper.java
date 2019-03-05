package com.guigu.dao.authority;

import java.util.List;

import com.guigu.domain.authority.view.AuthorizationView;
import com.guigu.domain.authority.view.RoleAuthorizationView;
import com.guigu.domain.authority.view.RoleImplentView;
import com.guigu.domain.authority.vo.RoleVO;

public interface RoleManageMapper {

	//查询所有角色
	List<RoleVO> queryAllRole();
	
	//查询该角色所具有的权限
	List<RoleImplentView> queryAutByRoleId(String role_ID);
	
	//查询角色
	RoleAuthorizationView queryRoleById(String role_ID);
	//修改角色信息
	void updateRoleById(String role_Name,String status,String role_ID);
	//删除角色权限表
	void deleteByid(String role_ID);
	//添加角色权限表
	void insertTRA(String role_ID,String au_Id);
	//查询所有权限
	List<AuthorizationView> selectAllTA();
	//添加角色
	void insertRole(String role_Name,String status);
	
	void insertTRAs(String au_Id);
	
}
