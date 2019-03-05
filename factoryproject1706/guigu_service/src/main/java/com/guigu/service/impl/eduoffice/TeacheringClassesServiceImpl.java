package com.guigu.service.impl.eduoffice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.dao.eduoffice.CuedMenuMapper;
import com.guigu.dao.eduoffice.EmpCourseMapper;
import com.guigu.dao.eduoffice.TeacheringClassesMapper;
import com.guigu.domain.authority.vo.MenuVO;
import com.guigu.domain.curriculum.Course_section;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.eduoffice.vo.CuedClassesVO;
import com.guigu.domain.eduoffice.vo.StudentVO;
import com.guigu.domain.marketing.PageInfo;
import com.guigu.service.eduoffice.CuedMenuService;
import com.guigu.service.eduoffice.EmpCourseService;
import com.guigu.service.eduoffice.TeacheringClassesService;
/**
 * 授课业务接口实现类
 * @author FIVFI
 *
 */
@Service
public class TeacheringClassesServiceImpl implements TeacheringClassesService{
	
	@Autowired
	private TeacheringClassesMapper mapper;

	/**
	 * 老师根据自己的账号查询自己所带的班级以及课程
	 * 
	 * @return
	 */    
	@Override
	public List<CuedClassesVO> queryCuedClassListByAccid(String id) {
		// TODO Auto-generated method stub
		return mapper.queryCuedClassListByAccid(id);
	}

	@Override
	public LayUiPageInfo queryStudentsByCid(int page,int limit,String id) {
		LayUiPageInfo layUiPageInfo=new LayUiPageInfo();
		Page page1=PageHelper.startPage(page, limit);
		layUiPageInfo.setCode(0);
		layUiPageInfo.setData(this.mapper.queryStudentsByCid(id));
		layUiPageInfo.setCount(page1.getTotal());
		return layUiPageInfo;
	}

	@Override
	public LayUiPageInfo queryCuedListByAccid(int page,int limit,String id) {
		// TODO Auto-generated method stub
		LayUiPageInfo layUiPageInfo=new LayUiPageInfo();
		Page page1=PageHelper.startPage(page, limit);
		layUiPageInfo.setCode(0);
		layUiPageInfo.setData(this.mapper.queryCuedListByAccid(id));
		layUiPageInfo.setCount(page1.getTotal());
		return layUiPageInfo;
	}





}
