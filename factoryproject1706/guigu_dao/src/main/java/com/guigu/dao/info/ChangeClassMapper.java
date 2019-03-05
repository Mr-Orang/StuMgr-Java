package com.guigu.dao.info;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.guigu.domain.info.ChangeClassSearch;
import com.guigu.domain.info.ChangeClassView;
import com.guigu.domain.info.Student;
import com.guigu.domain.marketing.Classes;
/**
 * 学生转班数据访问层
 * @author cyd
 *
 */
@Mapper
public interface ChangeClassMapper {
	/**
	 * 根据教师查询对应班级所有转班申请
	 * @param teacher_id 老师编号
	 * @param changeClassSearch 查询条件
	 * @return
	 * @throws Exception
	 */
	 List<ChangeClassView> queryChangeClassApply(@Param("teacher_id")String teacher_id,@Param("changeClassSearch")ChangeClassSearch changeClassSearch) throws Exception;
	 
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
	 List<Classes> queryClassByTeId(@Param("te_id")String te_id)throws Exception;
	 
	 /**
	  * 根据班级编号查询所有学生
	  * @param tc_id
	  * @return
	  */
	 List<Student> queryStudentByTcId(@Param("tc_id")String tc_id)throws Exception;
	 
	 /**
	  * 查询所有班级
	  * @return
	  */
	 List<Classes> queryAllClassByTcId(@Param("tc_id")String tc_id)throws Exception;
	 
	 /**
	  * 添加转班申请
	  * @param changeClassView
	  * @return
	  */
	 int addChangeClassApply(@Param("changeClassView")ChangeClassView changeClassView)throws Exception;
	 
	 /**
	  * 修改转班申请
	  * @param changeClassView
	  * @return
	  */
	 int updateChangeClassApply(@Param("changeClassView")ChangeClassView changeClassView)throws Exception;
	
	 /**
	  * 根据学号查询该学生的所有转班申请
	  * @param stu_id 学号
	  * @return
	  */
	List<ChangeClassView> queryChangeClassApplyByStuId(@Param("stu_id")String stu_id)throws Exception;
	
	/**
	 * 根据登入用户查询转入到本班的审核信息
	 * @param te_id 老师编号
	 * @return
	 */
	List<ChangeClassView> queryChangeClassCheck(@Param("te_id")String te_id,@Param("changeClassView")ChangeClassView changeClassView)throws Exception;
	
	/**
	 * 修改转入班级审核状态
	 * @param changeClassView 转班信息
	 * @return
	 * @throws Exception
	 */
	int updateChangeClassInStatus(@Param("changeClassView")ChangeClassView changeClassView) throws Exception;
	
	/**
	 * 根据学生编号修改学生班级信息
	 * @param changeClassView
	 * @return
	 * @throws Exception
	 */
	int updateStudentClassInfoByStuId(@Param("changeClassView")ChangeClassView changeClassView) throws Exception;
}
