package com.guigu.dao.info;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.guigu.common.info.ClassStudentTalkVo;
import com.guigu.common.info.ClassVo;
import com.guigu.common.info.TalkClassStudentVo;
import com.guigu.common.info.TalkclassVo;
import com.guigu.domain.info.Student;
import com.guigu.domain.info.Talk_Details;


/**
 * 连接数据库实现接口，完成数据增删改查连接操作
 * @author ouyang
 *
 */
@Mapper
public interface TalkMapper {

	//老师端开始
	/**
	 * 查询班级阶段和班级信息
	 * @return
	 * @throws Exception
	 */
	List<TalkclassVo> Querytalkclass() throws Exception;
	
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
	List<Student> QueryStudentInformation(@Param("class_id")String class_id) throws Exception;
	
	/**
	 * 保存谈话信息表
	 * @param talk_person
	 * @throws Exception
	 */
	void SaveStudentTalk(@Param("talk_person")String talk_person) throws Exception;
	
	/**
	 * 保存谈话详情信息
	 * @param stu_id
	 * @param talk_content
	 * @param talk_type
	 * @throws Exception
	 */
	void SaveStudentTalkdetail(Talk_Details tds) throws Exception;
	
	/**
	 * 根据老师编号和班级查询全班学生谈话信息
	 * @param emp_id
	 * @param tc_name
	 * @return
	 * @throws Exception
	 */
	List<ClassStudentTalkVo> QueryClassStudentTalkdetail(@Param("emp_id")String emp_id,@Param("tc_name")String tc_name) throws Exception;
	
	/**
	 * 查询学生个人谈话详情记录
	 * @param stu_id
	 * @param emp_id
	 * @return
	 * @throws Exception
	 */
	List<TalkClassStudentVo> QueryStudentTalkrecord(@Param("stu_id")String stu_id,@Param("emp_id")String emp_id) throws Exception;
	//老师端结束
	
	//学生端开始
	/**
	 * 根据学生id查询谈话信息
	 * @param stu_id
	 * @return
	 * @throws Exception
	 */
	List<TalkClassStudentVo> QueryStudentTalk(@Param("stu_id")String stu_id) throws Exception;
	
	/**
	 * 根据谈话详情id修改学生同意谈话状态
	 * @param talk_details_id
	 * @throws Exception
	 */
	void UpdateStudentAgreeTalk(@Param("talk_details_id")String talk_details_id) throws Exception;
	
}

