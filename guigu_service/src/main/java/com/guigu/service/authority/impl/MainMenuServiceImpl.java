package com.guigu.service.authority.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.authority.MainMenuMapper;
import com.guigu.domain.authority.view.MenuView;
import com.guigu.service.authority.IMainMenuService;
@Service
public class MainMenuServiceImpl implements IMainMenuService {

	@Autowired
	private MainMenuMapper mainMenuMapper;
	@Override
	public List<MenuView> queryFatherMenu() {
		return (List<MenuView>) mainMenuMapper.queryFatherMenu();
	}
	

}
