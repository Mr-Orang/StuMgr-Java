package com.guigu.service.info;

import java.util.List;

import com.guigu.common.info.ClassVo;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.info.Student;
import com.guigu.util.PageHelpVO;

/**
 * 谈话管理业务实现接口
 * @author hkd
 *
 */
public interface ITalkService {

	/**
	 * 查询班级阶段和班级信息
	 * @return
	 */
	PageHelpVO Querytalkclass(Integer page,Integer rows) throws Exception;
	
	/**
	 * 查询班级信息
	 * @return
	 * @throws Exception
	 */
	List<ClassVo> Queryclass() throws Exception;
	
	/**
	 * 根据班级编号查询本班全部学生信息
	 * @param class_id
	 * @return
	 * @throws Exception
	 */
	List<Student> QueryStudentInformation(String class_id) throws Exception;
	
	/**
	 * 保存学生谈话信息和谈话详情信息
	 * @param talk_person
	 * @param stu_id
	 * @param talk_content
	 * @param talk_type
	 * @throws Exception
	 */
	void SaveStudentTalkinformation(String talk_person,String stu_id,String talk_content,String talk_type) throws Exception;
	
	/**
	 * 根据老师编号和班级查询全班学生谈话信息
	 * @param emp_id
	 * @param tc_name
	 * @return
	 * @throws Exception
	 */
	PageHelpVO QueryClassStudentTalkdetail(Integer page,Integer rows,String emp_id,String tc_name) throws Exception;
	
	/**
	 * 查询学生个人谈话详情记录
	 * @param stu_id
	 * @param emp_id
	 * @return
	 * @throws Exception
	 */
	PageHelpVO QueryStudentTalkrecord(Integer page,Integer rows,String stu_id,String emp_id) throws Exception;


	/**
	 * 根据学生id查询谈话信息
	 * @param stu_id
	 * @return
	 * @throws Exception
	 */
	LayUiPageInfo QueryStudentTalk(Integer page,Integer rows,String stu_id,String viewpoint) throws Exception;
	
	/**
	 * 根据谈话详情id修改学生同意谈话状态
	 * @param talk_details_id
	 * @throws Exception
	 */
	void UpdateStudentAgreeTalk(String talk_details_id) throws Exception;
	
	/**
	 * 根据谈话详情id修改学生不同意谈话状态
	 * @param talk_details_id
	 * @throws Exception
	 */
	void UpdateStudentNoAgreeTalk(String talk_details_id,String reason) throws Exception;
	
}
