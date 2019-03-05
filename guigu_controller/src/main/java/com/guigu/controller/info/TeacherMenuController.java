package com.guigu.controller.info;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.domain.authority.vo.AccountVO;
import com.guigu.domain.info.MenuView;
import com.guigu.domain.info.Menus;
import com.guigu.service.info.TeacherMenuService;

@Controller
@RequestMapping("teachermenu")
public class TeacherMenuController {
	@Autowired
	private TeacherMenuService teacherMenuService;

	@RequestMapping("/queryMenuByAccount")
	public @ResponseBody List<Menus> queryMenuByAccount(HttpServletRequest request){
		AccountVO account = (AccountVO) request.getSession().getAttribute("account");
		return teacherMenuService.queryMenuByAccount(account.getAccount());
	}
	
	@RequestMapping("/queryMenuByParentName")
	public @ResponseBody List<MenuView> queryMenuByParentName(String text,HttpServletRequest request){
		AccountVO account = (AccountVO) request.getSession().getAttribute("account");
		return teacherMenuService.queryMenuByParentName(account.getAccount(), text);
	}
}
