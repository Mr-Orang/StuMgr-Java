package com.guigu.service.authority.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.dao.authority.UserManageMapper;
import com.guigu.domain.authority.view.UserManageView;
import com.guigu.domain.authority.vo.DepartmentVO;
import com.guigu.domain.authority.vo.RoleVO;
import com.guigu.domain.marketing.PageInfo;
import com.guigu.service.authority.IUserManageService;
@Service
public class UserManageServiceImpl implements IUserManageService {

	@Autowired
	private UserManageMapper userManageMapper;
	@Override
	public PageInfo queryAllUser(int page,int rows) {
		PageInfo pageInfo=new PageInfo();
		Page page1=PageHelper.startPage(page,rows);
		pageInfo.setRows(userManageMapper.queryAllUser());
		pageInfo.setTotal(page1.getTotal());
		return pageInfo;
	}
	@Override
	public UserManageView queryUserById(String id) {
		
		return userManageMapper.queryUserById(id);
	}
	@Override
	public List<RoleVO> queryRoles() {

		return userManageMapper.queryRoles();
	}
	@Override
	public List<DepartmentVO> queryDeparts() {

		return userManageMapper.queryDeparts();
	}
	@Override
	public boolean updateUser(String password, int status, String account) {
		try {
			userManageMapper.updateUser(password, status, account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		 
	}
	@Override
	public boolean updateRole(String role_ID, String account) {
		try {
			userManageMapper.updateRole(role_ID, account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	@Override
	public boolean updateDept(String te_NAME, String deptId, String te_ID) {
		try {
			userManageMapper.updateDept(te_NAME, deptId, te_ID);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean addEmp(String te_name, String te_mobile, String te_card_id, String te_sex, int te_age,
			String te_marry_status, String te_address, String deptId ,String role_ID) {
		try {
			userManageMapper.addEmp(te_name, te_mobile, te_card_id, te_sex, te_age, te_marry_status, te_address, deptId,role_ID);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean addUser() {
		try {
			userManageMapper.addUser();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean addaccRole(String deptId) {
		try {
			userManageMapper.addaccRole(deptId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
