package com.guigu.dao.info;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.common.info.KaoqinStudentVo;
import com.guigu.common.info.KaoqinTypeVo;
import com.guigu.domain.info.Attendance;
import com.guigu.domain.info.Attendance_details;
import com.guigu.domain.info.KaoqinLoginView;
import com.guigu.domain.info.Kaoqinclassshow;

public interface KaoqinMapper {
	/**
	 * 老师考勤登录
	 * @return List<KaoqinLoginView>
	 */
	List<KaoqinLoginView> KaoqinTeacherLogin(@Param("account")String account,@Param("password")String password ) throws Exception;
	/**
	 * 登录成功或查询班级信息
	 * @return List<Kaoqinclassshow>
	 * @throws Exception
	 */
	List<Kaoqinclassshow> kaoqinClassshow()throws Exception;
	/**
	 * 考勤类型下拉框
	 * @return KaoqinTypeVo
	 * @throws Exception
	 */
	List<KaoqinTypeVo> kaqinselect()throws Exception;
	/**
	 * 根据考勤名称查找考勤时间
	 * @param text
	 * @return List<KaoqinTypeVo>
	 * @throws Exception
	 */
	KaoqinTypeVo kaoqintime(@Param("text") String text)throws Exception;
	/**
	 * 查询学生信息 
	 * @return List<KaoqinStudentVo>
	 * @throws Exception
	 */
	List<KaoqinStudentVo> KaoqinStuden(@Param("kaoqinclass")String kaoqinclass)throws Exception;
	/**
	 * 录入学生考勤信息
	 * @param attdeta
	 * @return boolean
	 * @throws Exception
	 * @author Tangwj
	 * ,#{class_id},#{teacher_id},#{type_id},sysdate,#{ty_yesno}
	 */
	boolean kaoqinattendance(@Param("class_id")String class_id,@Param("teacher_id")String teacher_id,@Param("type_id")String type_id,@Param("ty_yesno")String ty_yesno)throws Exception;
	/**
	 * 录入学生考勤详情
	 * @return boolean
	 * @throws Exception
	 * @author Tangwj
	 */
	boolean kaoqindetails(@Param("stu_id")String stu_id,@Param("status")String status)throws Exception;
	
}