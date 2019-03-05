package com.guigu.controller.marketing;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guigu.domain.authority.vo.AccountVO;
import com.guigu.domain.marketing.Menu;
import com.guigu.service.marketing.IMenuService;

@Controller
public class MenuController{
	@Autowired
	private IMenuService menuservice;

	@RequestMapping("/queryMenu")

	//查询父菜单
	public @ResponseBody List<Menu> queryMenu(HttpServletRequest request){
		AccountVO account = (AccountVO) request.getSession().getAttribute("account");
		List<Menu> menulist=this.menuservice.queryMenu(account.getAccount());
		return menulist;
	}

	@RequestMapping("/queryMenuByName")
	// 根据父菜单名字查询子菜单
	public @ResponseBody List<Menu> queryMenuByName(HttpServletRequest request,String text) {
		AccountVO account = (AccountVO) request.getSession().getAttribute("account");
		List<Menu> menuList = this.menuservice.queryMenuByName(text,account.getAccount());
		return menuList;
	}
}
