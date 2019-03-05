package com.guigu.dao.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.guigu.common.marketing.StudentSourceView;
import com.guigu.domain.info.StudentInfo;
import com.guigu.domain.marketing.Classes;
import com.guigu.domain.marketing.Menu;
/**
 * 学生入班--许永康
 * @author vip
 *
 */
@Mapper
public interface ClassesMapper {
	/**
	 * 查询s1未满班的班级
	 * @return
	 * @throws Exception
	 */
	List<Menu> queryJoinClass()throws Exception;
	/**
	 *  查询以为报名或预座的生源信息
	 * @return
	 * @throws Exception
	 */
	List<StudentSourceView> queryStudentSource()throws Exception;
	/**
	 * 查询班级信息 
	 * @return
	 * @throws Exception
	 */
	Classes queryClass(String td_id)throws Exception;
	/**
	 * 根据id查询生源信息表 -
	 * @param tss_id
	 * @return
	 * @throws Exception
	 */
	StudentSourceView queryStudentById(String tss_id)throws Exception;
	/**
	 * 添加学生信息表
	 * @param studentinfo
	 * @return
	 * @throws Exception
	 */
	void saveStudent(StudentInfo studentinfo)throws Exception;
	/**
	 * 修改班级表
	 * @param rouid
	 * @return
	 * @throws Exception
	 */
	void updetaStudent(String classid)throws Exception;
	/**
	 * 修改生源信息的招生状态
	 * @param apply
	 * @param rouid
	 * @throws Exception
	 */
	void updateApply(@Param("applyid")String applyid,@Param("rouid")String rouid)throws Exception;
	/**
	 * 根据员工编号查询（T_STATISTICS_SALE）报表编号
	 * 
	 * @param empID
	 * @return
	 */
	String queryStsID(String empID);

	/**
	 * 根据地区或院校名称（T_STATISTICS_SCHOOL）查询报表编号
	 * 
	 * @param stuSourceArea
	 * @return
	 */
	String queryTstID(String stuSourceArea);

	/**
	 * 当生源为报名时修改报名人数及报名率（t_statistics_sale）
	 * 
	 * @param sts_id
	 * @throws Exception
	 */
	void updateSaleEnrollment(String sts_id) throws Exception;

	/**
	 * 当生源为报名时修改报名人数及报名率（t_statistics_school）
	 * 
	 * @param tst_id
	 * @throws Exception
	 */
	void updateSchoolEnrollment(String tst_id) throws Exception;
	
}
