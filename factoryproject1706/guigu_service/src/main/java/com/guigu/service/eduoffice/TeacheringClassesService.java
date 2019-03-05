package com.guigu.service.eduoffice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.domain.authority.vo.MenuVO;
import com.guigu.domain.curriculum.Course_section;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.eduoffice.vo.CuedClassesVO;
import com.guigu.domain.eduoffice.vo.StudentVO;
import com.guigu.domain.marketing.PageInfo;
/**
 * 授课业务接口
 * @author FIVFI
 *
 */
public interface TeacheringClassesService {
	/**
	 * 老师根据自己的账号查询自己所带的班级以及课程
	 * 
	 * @return
	 */
	List<CuedClassesVO> queryCuedClassListByAccid(String id);
	
	
	/**
	 * 通过班级id获取学生
	 * 
	 * @return
	 */
	LayUiPageInfo queryStudentsByCid(int page,int limit,String id);
	
	/**
	 * 通过课程id获取章节
	 * 
	 * @return
	 */
	LayUiPageInfo queryCuedListByAccid(int page,int limit,String id);
}
