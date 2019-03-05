package com.guigu.dao.materials;

import com.guigu.domain.materials.MaterialsMenu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 加载菜单mapper
 */
@Mapper
public interface LoadMenuMapper {
	// 查询父菜单
	List<MaterialsMenu> queryMenu(String account) throws Exception;

	// 查询子菜单
	List<MaterialsMenu> queryMenuSon(String title, String account) throws Exception;
}
