package com.guigu.service.authority.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.dao.authority.RoleManageMapper;
import com.guigu.domain.authority.view.AuthorizationView;
import com.guigu.domain.authority.view.RoleAuthorizationView;
import com.guigu.domain.authority.view.RoleImplentView;
import com.guigu.domain.marketing.PageInfo;
import com.guigu.service.authority.IRoleManageService;

@Service
public class RoleManageServiceImpl implements IRoleManageService {

	@Autowired
	private RoleManageMapper roleManageMapper;

	@Override
	public PageInfo queryAllRole(int page,int rows) {
		PageInfo pageInfo=new PageInfo();
		Page page1=PageHelper.startPage(page, rows);
		pageInfo.setRows(this.roleManageMapper.queryAllRole());
		pageInfo.setTotal(page1.getTotal());
		return pageInfo;
	}

	@Override
	public List<RoleImplentView> queryAutByRoleId(String role_ID) {

		return roleManageMapper.queryAutByRoleId(role_ID);
	}

	@Override
	public RoleAuthorizationView queryRoleById(String role_ID) {

		return roleManageMapper.queryRoleById(role_ID);
	}

	@Override
	public boolean updateRoleById(String role_Name, String status, String role_ID) {
		try {
			roleManageMapper.updateRoleById(role_Name, status, role_ID);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteByid(String role_ID) {
		try {
			roleManageMapper.deleteByid(role_ID);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insertTRA(String role_ID, String au_Id) {
		try {
			String[] au_Ids = au_Id.split(",");
			for (String au_id : au_Ids) {
				roleManageMapper.insertTRA(role_ID, au_id);
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<AuthorizationView> selectAllTA() {

		return roleManageMapper.selectAllTA();
	}

	@Override
	public boolean insertRole(String role_Name, String status) {
		try {
			roleManageMapper.insertRole(role_Name, status);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean insertTRAs(String au_Id) {
		try {
			String[] au_Ids = au_Id.split(",");
			for (String au_id : au_Ids) {
				roleManageMapper.insertTRAs(au_id);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
