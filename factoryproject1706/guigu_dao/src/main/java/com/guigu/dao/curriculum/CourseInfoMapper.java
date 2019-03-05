package com.guigu.dao.curriculum;

import java.util.List;

import com.guigu.domain.curriculum.Course_section;
import com.guigu.domain.curriculum.vo.Course_addInfo;
import com.guigu.domain.curriculum.vo.Course_detailInfo;
import com.guigu.domain.curriculum.vo.Course_search;
import com.guigu.domain.curriculum.vo.Course_showInfo;
import com.guigu.domain.eduoffice.EmpCourse;
/**
 * 课程信息数据访问接口
 * @author zy
 *
 */
public interface CourseInfoMapper {
	
	/**
	 * 加载下拉框课程数据
	 * @return
	 */
	List<CourseInfoMapper> loadSelectCourseInfoByEmpId(String emp_id);
	
	/**
	 * 查询所有课程的显示信息
	 */
	List<Course_showInfo> queryAllCourseInfo(Course_search c_search);
	
	/**
	 * 根据课程编号查询该所有信息
	 */
	Course_detailInfo queryCourseInfoById(String tc_cid);
	
	/**
	 * 根据课程编号查询出该课程所有章节信息
	 */
	List<Course_section> querySectionsByCourseId(String tc_id);
	
	/**
	 * 
	 *删除课程（逻辑删除，修改课程状态） 
	 */
	void deleteCourseById(String tc_cid)throws Exception;
	
	/**
	 * 根据客户端提交的课程信息进行修改
	 */
	void updateCourseInfoById(Course_detailInfo c_d)throws Exception;
	
	/**
	 * 修改课程的教学大纲
	 */
	void updateCoutlineById(String url,String tc_cid)throws Exception;
	
	/**
	 * 修改课程的所属阶段
	 */
	void updateCourseStageById(String sid,String tc_cid)throws Exception;
	
	/**
	 * 删除某个课程的章节(逻辑删除:修改状态)
	 */
	void deleteCourseSectionById(String sid)throws Exception;
	
	/**
	 * 添加课程信息
	 */
	void addCouseInfo(Course_addInfo a_c)throws Exception;
	
	/**
	 * 添加课程的阶段信息
	 */
	void addCourseStage(String sid)throws Exception;
}
