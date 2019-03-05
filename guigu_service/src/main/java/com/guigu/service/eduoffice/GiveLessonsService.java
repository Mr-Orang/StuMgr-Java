package com.guigu.service.eduoffice;

import java.util.List;

import com.guigu.domain.eduoffice.Classes;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.eduoffice.vo.CourseInfoVo;
import com.guigu.domain.eduoffice.vo.EmpVo;

/**
 * 授课业务接口
 * @author zy
 *
 */
public interface GiveLessonsService {
	/**
	 * 查询授课信息
	 * @return
	 */
	LayUiPageInfo queryGiveLessons(int page,int rows,String tc_name,String tc_cname,String te_name);
	
	/**
	 * 根据课程编号查询可授课的老师
	 * @param sc_id
	 * @return
	 */
	List<EmpVo> loadSelectDataByScId(String sc_id);
	
	/**
	 * 修改授课老师
	 * @param gl_id
	 * @param te_name
	 */
	String editGiveLessonsTeacher(String gl_id,String te_name,String status);
	
	/**
	 * 加载班级下拉框数据
	 * @return
	 */
	List<Classes> loadClassSelect();
	
	/**
	 * 根据班级id加载课程下拉框
	 * @param tc_id
	 * @return
	 */
	List<CourseInfoVo> loadCourseSelectByTcId(String tc_id);
	
	/**
	 * 添加授课信息
	 * @param class_id
	 * @param sc_id
	 * @param ter_id
	 */
	String addGiveLessons(String class_id,String sc_id,String ter_id);
	
	/**
	 * 结课 修改授课状态
	 * @param gl_id
	 */
	String editGiveLessonsStatus(String gl_id);
}
