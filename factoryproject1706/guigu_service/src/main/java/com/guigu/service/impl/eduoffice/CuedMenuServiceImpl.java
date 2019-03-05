package com.guigu.service.impl.eduoffice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.dao.eduoffice.CuedMenuMapper;
import com.guigu.dao.eduoffice.EmpCourseMapper;
import com.guigu.domain.authority.vo.MenuVO;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.marketing.PageInfo;
import com.guigu.service.eduoffice.CuedMenuService;
import com.guigu.service.eduoffice.EmpCourseService;
/**
 * 授课业务接口实现类
 * @author FIVFI
 *
 */
@Service
public class CuedMenuServiceImpl implements CuedMenuService{
	
	@Autowired
	private CuedMenuMapper mapper;

	/**
	 * 角色菜单业务
	 */     
	@Override
	public List<MenuVO> queryMenu_cued(String roleId, String modelId) {
		return mapper.queryMenu_cued(roleId, modelId);
	}
	
	/**
	 * 查询所有老师于课程关系信息
	 * @return
	 */


}
