package com.guigu.service.materials;

import com.guigu.domain.materials.MaterialsMenu;

import java.util.List;

/**
 * 记载菜单service业务类
 */
public interface ILoadMenuService {
	// 查询当前账户所拥有的菜单信息
	List<MaterialsMenu> queryMenu(String account) throws Exception;

	// 查询当前账户的子菜单信息
	List<MaterialsMenu> queryMenuSon(String title, String account) throws Exception;
}
