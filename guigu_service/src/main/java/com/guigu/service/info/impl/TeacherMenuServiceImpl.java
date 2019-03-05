package com.guigu.service.info.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.info.TeacherMenuMapper;
import com.guigu.domain.info.MenuView;
import com.guigu.domain.info.Menus;
import com.guigu.service.info.TeacherMenuService;

@Service
public class TeacherMenuServiceImpl implements TeacherMenuService{

	@Autowired
	private TeacherMenuMapper teacherMenuMapper;

	@Override
	public List<Menus> queryMenuByAccount(String account) {
		// TODO Auto-generated method stub
		
		return teacherMenuMapper.queryMenuByAccount(account);
	}

	@Override
	public List<MenuView> queryMenuByParentName(String account, String text) {
		// TODO Auto-generated method stub
		return teacherMenuMapper.queryMenuByParentName(account, text);
	}
	
}
