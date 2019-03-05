package com.guigu.dao.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.guigu.domain.marketing.Menu;

@Mapper
public interface MenuMapper {
	/**
	 * 查询父菜单
	 * @return
	 */
	List<Menu> queryMenu(@Param("account")String account);
	/**
	 * 根据父菜单查询子菜单
	 * @param text
	 * @return
	 */
	List<Menu> queryMenuByName(@Param("text")String text,@Param("account")String account);
	 
	 
}
