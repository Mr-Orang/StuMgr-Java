package com.guigu.dao.eduoffice;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import com.guigu.domain.eduoffice.EmpCourse;
import com.guigu.domain.eduoffice.vo.EmpVo;
import com.guigu.domain.eduoffice.vo.EmpVo2;
import com.guigu.domain.eduoffice.vo.GiveLessonsVo;

/**
 * 课程老师关系数据访问接口
 * 
 * @author zy
 *
 */
public interface EmpCourseMapper {
	/**
	 * 查询所有老师于课程关系信息
	 * 
	 * @return
	 */
	List<EmpCourse> queryEmpCourseList(@Param("ec_id") String ec_id, @Param("tc_cname") String tc_cname,
			@Param("te_name") String te_name);

	/**
	 * 进行逻辑删除 修改状态为1
	 * 
	 * @param ec_id
	 */
	void updateStatus(String ec_id);

	/**
	 * 启用老师课程关系 修改状态为0
	 * 
	 * @param ec_id
	 */
	void updateStatus2(String ec_id);

	/**
	 * 加载下拉框老师信息
	 * 
	 * @return
	 */
	List<EmpVo> loadEmpSelect();

	/**
	 * 添加老师课程关系
	 * 
	 * @param emp_id
	 * @param courseInfo1
	 */
	void addEmpCourse(@Param("emp_id") String emp_id, @Param("courseInfo1") String courseInfo1);

	/**
	 * 查询课程信息
	 * 
	 * @return
	 */
	List<EmpVo2> queryCourseInfoVo();

	
}
