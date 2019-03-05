package com.guigu.service.materials.impl;

import com.guigu.service.materials.ILoadMenuService;
import com.guigu.dao.materials.LoadMenuMapper;
import com.guigu.domain.materials.MaterialsMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadMenuServiceImpl implements ILoadMenuService {
	@Autowired
	private LoadMenuMapper loadMenuMapper;

	@Override
	public List<MaterialsMenu> queryMenu(String account) throws Exception {
		return this.loadMenuMapper.queryMenu(account);
	}

	@Override
	public List<MaterialsMenu> queryMenuSon(String title, String account) throws Exception {
		return this.loadMenuMapper.queryMenuSon(title, account);
	}
}
