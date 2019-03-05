package com.guigu.service.authority;

import java.util.List;

import com.guigu.domain.authority.view.MenuView;

public interface IMainMenuService {

	List<MenuView> queryFatherMenu();
}
