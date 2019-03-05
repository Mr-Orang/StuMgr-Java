package com.guigu.service.info;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.guigu.common.info.KaoqinTypeVo;
import com.guigu.domain.info.Attendance;
import com.guigu.util.PageHelpVO;

public interface IKaoqinService {
/**
	 * 登录成功或查询班级信息
	 * @return List<Kaoqinclassshow>
	 * @throws Exception
	 */
	PageHelpVO kaoqinClassshow(Integer page,Integer rows)throws Exception;
	
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
	KaoqinTypeVo kaoqintime(HttpServletRequest request,String text)throws Exception;
	
	/**
	 * 查询学生信息 
	 * @return List<KaoqinStudentVo>
	 * @throws Exception
	 */
	PageHelpVO KaoqinStuden(Integer page,Integer rows,String kaoqinclass)throws Exception;
	
	
	/**
	 * 录入学生考勤信息
	 * @param attdeta
	 * @return boolean
	 * @throws Exception
	 * @author Tangwj
	 */
	boolean kaoqinattendance(HttpServletRequest request,String class_id,String teacher_id,String type_id,String ty_yesno)throws Exception;
	/**
	 * 录入学生考勤详情
	 * @return boolean
	 * @throws Exception
	 * @author Tangwj
	 */
	boolean kaoqindetails(String stu_id,String status)throws Exception;
	
}
