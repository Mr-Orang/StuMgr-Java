package com.guigu.service.marketing;

import java.util.List;

import com.guigu.common.marketing.StudentConsult;
import com.guigu.common.marketing.StudentConsultLike;
import com.guigu.domain.marketing.Employee;
import com.guigu.domain.marketing.SourceTalk;
import com.guigu.domain.marketing.StudentGrade;
import com.guigu.domain.marketing.StudentSource;
import com.guigu.util.PageHelpVO;

/**
 * 生源咨询的service类
 * @author lijianghua
 *
 */
public interface StudentConsultService {

	/**
	 * 查询生源咨询信息
	 * @return
	 * @throws Exception
	 */
	public PageHelpVO queryConsult(StudentConsult stu,int page,int rows) throws Exception;
	
	/**
	 * 根据id查询修改生源咨询信息
	 * @param tst_id
	 * @return
	 * @throws Exception
	 */
	StudentConsult queryConsultById(String tst_id) throws Exception;
	/**
	 * 根据employee表查询生源咨询的市场人员姓名
	 * @param te_id
	 * @return
	 * @throws Exception
	 */
	List<Employee> queryEmployeeName()throws Exception;
	/**
	 * 根据StudentGrade表查询生源咨询等级
	 * @return
	 * @throws Exception
	 */
	List<StudentGrade> queryStudentGradeName() throws Exception;
	/**
	 * 根据SourceTalk表修改生源咨询信息
	 * @param stu
	 * @throws Exception
	 */
	void updateSourceTalk(StudentConsult stu)throws Exception;
	/**
	 * 修改学生姓名
	 * @param stu
	 * @throws Exception
	 */
	//void updateStudentSourceName(StudentSource name)throws Exception;
	/**
	 * 添加生源咨询信息
	 * @return
	 * @throws Exception
	 */
	void addSourceTalk(SourceTalk sou)throws Exception;
	/**
	 * 查询生源咨询信息
	 * @return
	 * @throws Exception
	 */
	List<StudentConsult> queryStudentConsult()throws Exception;
	/**
	 * 条件加模糊查询
	 * @param consult
	 * @return
	 * @throws Exception
	 */
	PageHelpVO queryLikeStdentConsult(StudentConsultLike consult,Integer page, Integer rows)throws Exception;
	
	
}
