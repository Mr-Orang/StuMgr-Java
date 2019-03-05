package com.guigu.controller.authority;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.guigu.domain.authority.view.UserManageView;
import com.guigu.domain.authority.vo.DepartmentVO;
import com.guigu.domain.authority.vo.RoleVO;
import com.guigu.domain.marketing.PageInfo;
import com.guigu.service.authority.IUserManageService;

@Controller
@RequestMapping("/authority/UserSoure")
public class UserManageController {
	@Autowired
	private IUserManageService iUserManageService;

	// 查询所有员工信息
	@RequestMapping("/queryAllUser")
	public @ResponseBody PageInfo queryAllUser(int page,int rows) {
		return iUserManageService.queryAllUser(page,rows);
	}

	// 根据员工id查询信息
	@RequestMapping("/queryUserById")
	public @ResponseBody UserManageView queryUserById(String te_ID) {
		return iUserManageService.queryUserById(te_ID);
	}

	// 查询所有角色
	@RequestMapping("/queryRole")
	public @ResponseBody List<RoleVO> queryRole() {
		return iUserManageService.queryRoles();
	}

	// 查询所有部门
	@RequestMapping("/queryDepart")
	public @ResponseBody List<DepartmentVO> queryDepart() {
		return iUserManageService.queryDeparts();
	}

	// 修改用户数据
	@RequestMapping("/updateUser")
	public @ResponseBody String updateUser(String te_ID,String te_NAME,String account,String password,int status,String role_ID,String deptId) {
		try {
			iUserManageService.updateRole(role_ID, account);
			iUserManageService.updateUser(password, status, account);
			iUserManageService.updateDept(te_NAME, deptId, te_ID);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
	}
	
	//添加员工
	@RequestMapping("/addEmp")
	public @ResponseBody String addEmp(String te_name,String te_mobile,String te_card_id,String te_sex,int te_age,String te_marry_status,String te_address,String deptId,String role_ID) {
		try {
			iUserManageService.addEmp(te_name, te_mobile, te_card_id, te_sex, te_age, te_marry_status, te_address, deptId,role_ID);
			iUserManageService.addUser();
			iUserManageService.addaccRole(role_ID);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
}
