package com.guigu.service.impl.marketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.marketing.MenuMapper;
import com.guigu.domain.marketing.Menu;
import com.guigu.service.marketing.IMenuService;
@Service
public class MenuServiceImpl implements IMenuService {
	@Autowired
	private MenuMapper menumapper;

	@Override
	public List<Menu> queryMenu(String account) {
		// TODO Auto-generated method stub
		return this.menumapper.queryMenu(account);
	}

	@Override
	public List<Menu> queryMenuByName(String text, String account) {
		// TODO Auto-generated method stub
		return this.menumapper.queryMenuByName(text, account);
	}
	
}
