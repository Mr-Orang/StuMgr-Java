package com.guigu.controller.authority;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.domain.authority.view.MenuView;
import com.guigu.service.authority.IMainMenuService;

@Controller
@RequestMapping("/authority/menuSoure")
public class MainMenuController {

	@Autowired
	private IMainMenuService iMainMenuService;

	@RequestMapping("/queryfatherMenu")
	public @ResponseBody List<MenuView> queryfatherMenu() {
		
		return iMainMenuService.queryFatherMenu();
	}
}
