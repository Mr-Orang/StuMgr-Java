package com.guigu.service.info;


import java.util.List;

import com.guigu.common.info.PageVo;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.info.ChangeClassSearch;
import com.guigu.domain.info.ChangeClassView;
import com.guigu.domain.info.Student;
import com.guigu.domain.marketing.Classes;

/**
 * 学生转班业务处理接口
 * @author cyd
 *
 */
public interface IChangeClassService {
	/**
	 * 根据教师查询对应班级所有转班申请
	 * @param teacher_id 老师编号
	 * @param rows 页面大小
	 * @param page 当前页面
	 */
	 PageVo<ChangeClassView> queryChangeClassApply(String teacher_id,Integer rows,Integer page,ChangeClassSearch changeClassSearch) throws Exception;
	 
	 /**
	  * 根据转班编号查询对应信息
	  * @param tcc_id 转班编号
	  * @return
	  */
	 List<ChangeClassView> queryChangeClassByTccId(String tcc_id)throws Exception;
	 
	 /**
	  * 查询添加操作老师所交的班级
	  * @param te_id 老师编号
	  * @return
	  */
	 List<Classes> queryClassByTeId(String te_id)throws Exception;

	 /**
	  * 根据班级编号查询所有学生
	  * @param tc_id
	  * @return
	  */
	 List<Student> queryStudentByTcId(String tc_id)throws Exception;

	 /**
	  * 查询所有班级
	  * @return
	  */
	 List<Classes> queryAllClassByTcId(String tc_id)throws Exception;
	 /**
	  * 添加转班申请
	  * @param changeClassView
	  * @return
	  */
	 boolean addChangeClassApply(ChangeClassView changeClassView)throws Exception;
	 
	 /**
	  * 修改转班申请
	  * @param changeClassView
	  * @return
	  */
	 boolean updateChangeClassApply(ChangeClassView changeClassView)throws Exception;
	 
	 /**
	  * 根据学号查询该学生的所有转班申请
	  * @param page 当前页面
	  * @param rows 页面大小
	  * @param stu_id 学号
	  * @return
	  */
	 LayUiPageInfo queryChangeClassApplyByStuId(Integer page,Integer limit,String stu_id)throws Exception;
	 
	 /**
	 * 根据登入用户查询转入到本班的审核信息
	 * @param te_id 老师编号
	 * @return
	 */
	PageVo<ChangeClassView> queryChangeClassCheck(Integer page,Integer rows,String te_id,ChangeClassView changeClassView)throws Exception;
	
	/**
	 * 修改转入班级审核状态
	 * @param changeClassView 转班信息
	 * @return
	 * @throws Exception
	 */
	boolean updateChangeClassInStatus(ChangeClassView changeClassView) throws Exception;
}
