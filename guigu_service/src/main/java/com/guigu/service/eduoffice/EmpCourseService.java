package com.guigu.service.eduoffice;

import java.util.List;


import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.eduoffice.vo.EmpVo;
import com.guigu.domain.eduoffice.vo.EmpVo2;
import com.guigu.domain.eduoffice.vo.GiveLessonsVo;
/**
 * 课程老师关系业务接口
 * @author zy
 *
 */
public interface EmpCourseService {
	/**
	 * 查询所有老师于课程关系信息
	 * @return
	 */
	LayUiPageInfo queryEmpCourseList(int page,int rows,String ec_id, String tc_cname,String te_name);
	
	/**
	 *  进行逻辑删除 修改状态为1
	 * @param ec_id
	 */
	boolean updateStatus(String ec_id);
	
	/**
	 * 启用老师课程关系 修改状态为0
	 * @param ec_id
	 */
	boolean updateStatus2(String ec_id);
	
	/**
	 * 加载下拉框老师信息
	 * @return
	 */
	List<EmpVo> loadEmpSelect();
	
	/**
	 * 添加老师课程关系
	 * @param emp_id
	 * @param courseInfo1
	 */
	boolean addEmpCourse(String emp_id,String courseInfo1);
	
	/**
	 * 查询课程信息
	 * @return
	 */
	List<EmpVo2> queryCourseInfoVo();
	
	
}
