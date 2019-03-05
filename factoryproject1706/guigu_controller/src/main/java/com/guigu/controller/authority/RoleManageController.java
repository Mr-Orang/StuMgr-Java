package com.guigu.controller.authority;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.domain.authority.view.AuthorizationView;
import com.guigu.domain.authority.view.RoleAuthorizationView;
import com.guigu.domain.authority.view.RoleImplentView;
import com.guigu.domain.authority.vo.RoleVO;
import com.guigu.domain.marketing.PageInfo;
import com.guigu.service.authority.IRoleManageService;

@Controller
@RequestMapping("/authority/RoleSoure")
public class RoleManageController {
	@Autowired
	private IRoleManageService iRoleManageService;

	@RequestMapping("/queryAllRole")
	public @ResponseBody PageInfo queryAllRole(int page,int rows) {

		return iRoleManageService.queryAllRole(page,rows);

	}

	@RequestMapping("/queryAutByRoleId")
	public @ResponseBody List<RoleImplentView> queryAutByRoleId(String role_ID) {

		return iRoleManageService.queryAutByRoleId(role_ID);
	}

	@RequestMapping("/queryRoleById")
	public @ResponseBody RoleAuthorizationView queryRoleById(String role_ID) {
		return iRoleManageService.queryRoleById(role_ID);
	}

	@RequestMapping("/updateRole")
	public @ResponseBody String updateRole(String role_ID, String au_Ids, String role_Name, String status) {
		boolean f=iRoleManageService.updateRoleById(role_Name, status, role_ID);
		boolean f1=iRoleManageService.deleteByid(role_ID);
		boolean f2=iRoleManageService.insertTRA(role_ID, au_Ids);
		if(f==true&&f1==true&&f2==true) {
			return "ok";
			
		}else {
			return "fail";
			
		}
	}
	@RequestMapping("/selectAllTA")
	public @ResponseBody List<AuthorizationView> selectAllTA(){
		return iRoleManageService.selectAllTA();
		
	}
	@RequestMapping("/insertRole")
	public @ResponseBody String insertRole(String role_Name,String status,String au_Ids) {
		System.out.println(role_Name);
		if(iRoleManageService.insertRole(role_Name, status)&&iRoleManageService.insertTRAs(au_Ids)) {
			return "ok";
		}else
			return "fail";
	}

}
