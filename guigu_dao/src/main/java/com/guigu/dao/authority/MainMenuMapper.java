package com.guigu.dao.authority;

import java.util.List;

import com.guigu.domain.authority.view.MenuView;


/**
 * 查詢父菜單
 * @author ASUS
 *
 */
public interface MainMenuMapper {
	
	List<MenuView> queryFatherMenu();
}
