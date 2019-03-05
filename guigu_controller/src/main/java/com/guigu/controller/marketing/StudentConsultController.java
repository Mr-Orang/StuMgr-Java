package com.guigu.controller.marketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guigu.common.marketing.StudentConsult;
import com.guigu.common.marketing.StudentConsultLike;
import com.guigu.domain.marketing.Employee;
import com.guigu.domain.marketing.PageInfo;
import com.guigu.domain.marketing.SourceTalk;
import com.guigu.domain.marketing.StatisticsSchool;
import com.guigu.domain.marketing.StudentGrade;
import com.guigu.domain.marketing.StudentSource;
import com.guigu.service.marketing.StudentConsultService;
import com.guigu.util.PageHelpVO;

@RestController
/**
 * controller类
 * 
 * @author lijianghua
 *
 */
public class StudentConsultController {

	@Autowired
	private StudentConsultService studentConsultService;

	/**
	 * 查询生源咨询信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryConsult")
	public PageHelpVO queryConsult(StudentConsult stu,int page, int rows) {
		PageHelpVO pageinfo = null;
		try {
			pageinfo = this.studentConsultService.queryConsult(stu,page, rows);
			System.out.println(pageinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}

	/**
	 * 根据id查询修改生源咨询信息
	 * 
	 * @param tst_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryConsultById")
	StudentConsult queryConsultById(String tst_id) {
		StudentConsult stu = null;
		try {
			stu = this.studentConsultService.queryConsultById(tst_id);
			System.out.println("stu " + stu);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return stu;
	}

	/**
	 * 根据employee表查询生源咨询的市场人员姓名
	 * 
	 * @param te_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryEmployeeName")
	List<Employee> queryEmployeeName() {
		List<Employee> list = null;
		try {
			list = this.studentConsultService.queryEmployeeName();
			System.out.println("list:" + list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据StudentGrade表查询生源咨询等级
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryStudentGradeName")
	List<StudentGrade> queryStudentGradeName() {
		List<StudentGrade> stu = null;
		try {
			stu = this.studentConsultService.queryStudentGradeName();
			System.out.println("queryStudentGradeName" + stu);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return stu;
	}

	/**
	 * 根据StduentConsult表修改生源咨询信息
	 * 
	 * @param stu
	 * @throws Exception
	 * 
	 */
	@RequestMapping("/updateSourceTalk")
	String updateSourceTalk(StudentConsult stu) {
		String str = "no";
		try {
			this.studentConsultService.updateSourceTalk(stu);
			str = "ok";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			str = "no";
		}
		return str;
	}

	/**
	 * 修改学生姓名
	 * 
	 * @param stu
	 * @throws Exception
	 
	@RequestMapping("/updateStudentSourceName")
	String updateStudentSourceName(StudentSource name) {
		System.out.println("StudentSource:" + name);
		String str = "no";
		try {
			this.studentConsultService.updateStudentSourceName(name);
			str = "ok";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			str = "no";
		}
		return str;
	}*/

	/**
	 * 添加生源咨询信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addSourceTalk")
	public String addSourceTalk(SourceTalk sou,StudentSource stu) {
		try {
			this.studentConsultService.addSourceTalk(sou);
			return "ok";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "no";

	}

	/**
	 * 查询生源咨询信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryStudentConsult")
	List<StudentConsult> queryStudentConsult() {
		List<StudentConsult> list = null;
		try {
			list = this.studentConsultService.queryStudentConsult();
			System.out.println("queryStudentConsult" + list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;

	}
	/**
	 * 条件加模糊查询
	 * @param consult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryLikeStdentConsult")
	PageHelpVO queryLikeStdentConsult(StudentConsultLike consult,Integer page, Integer rows){
		try {
			return this.studentConsultService.queryLikeStdentConsult(consult,page,rows);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
}
