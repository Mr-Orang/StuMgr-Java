package com.guigu.service.info;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.domain.info.MenuView;
import com.guigu.domain.info.Menus;

public interface TeacherMenuService {
	/**
	 * 根据账户查询菜单
	 * @param account
	 * @return
	 */
	List<Menus> queryMenuByAccount(String account);
	
	/**
	 * 根据账户与父名称查询菜单
	 * @param account
	 * @param text
	 * @return
	 */
	List<MenuView> queryMenuByParentName(@Param("account")String account,@Param("text")String text);
}
