package com.guigu.dao.eduoffice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.domain.curriculum.Course_section;
import com.guigu.domain.eduoffice.EmpCourse;
import com.guigu.domain.eduoffice.vo.CuedClassesVO;
import com.guigu.domain.eduoffice.vo.EmpVo;
import com.guigu.domain.eduoffice.vo.EmpVo2;
import com.guigu.domain.eduoffice.vo.StudentVO;

/**
 * 作业业务接口
 * 
 * @author FIVFI
 *
 */
public interface TeacheringClassesMapper {
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
	List<StudentVO> queryStudentsByCid(String id);
	
	/**
	 * 通过课程id获取章节
	 * 
	 * @return
	 */
	List<Course_section> queryCuedListByAccid(String id);

}
