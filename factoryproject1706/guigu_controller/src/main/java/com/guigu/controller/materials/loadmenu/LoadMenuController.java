package com.guigu.controller.materials.loadmenu;

import com.guigu.domain.authority.vo.AccountVO;
import com.guigu.domain.materials.MaterialsMenu;
import com.guigu.service.materials.ILoadMenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 加载菜单处理器类
 */
@Controller
@RequestMapping("/menuController")
public class LoadMenuController {
	@Autowired
	private ILoadMenuService iLoadMenuService;

	// 查询顶层父菜单
	@RequestMapping("/loadMenuDataInfo")

	public @ResponseBody List<MaterialsMenu> loadMenu(HttpServletRequest request) {
		AccountVO user = (AccountVO) request.getSession().getAttribute("account");
		List<MaterialsMenu> menu_list = null;
		try {
			menu_list = this.iLoadMenuService.queryMenu(user.getAccount());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menu_list;
	}

	// 查询子菜单
	@RequestMapping("/loadMenuSonData")
	public @ResponseBody List<MaterialsMenu> loadMenuSon(HttpServletRequest request, String text) {
		AccountVO user = (AccountVO) request.getSession().getAttribute("account");
		List<MaterialsMenu> list = null;
		try {
			list = this.iLoadMenuService.queryMenuSon(text, user.getAccount());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
