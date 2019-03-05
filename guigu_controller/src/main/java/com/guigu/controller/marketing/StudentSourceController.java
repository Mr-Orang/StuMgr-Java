package com.guigu.controller.marketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guigu.common.marketing.StudentSourceAdd;
import com.guigu.common.marketing.StudentSourceHelp;
import com.guigu.domain.marketing.RecruitStatus;
import com.guigu.domain.marketing.StudentSource;
import com.guigu.service.marketing.IStudentSourceService;
import com.guigu.util.PageHelpVO;

@RestController
@RequestMapping("/marketing/studentSource")
public class StudentSourceController {
	@Autowired
	private IStudentSourceService studentSourceServiceImpl;

	@RequestMapping("/queryStudentSource")
	public PageHelpVO queryStudentSource(StudentSourceHelp studentSourceHelp, Integer page, Integer rows) {
		try {
			return studentSourceServiceImpl.queryStudentSource(studentSourceHelp, page, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/queryRecruitStatus")
	public List<RecruitStatus> queryRecruitStatus() {
		try {
			return studentSourceServiceImpl.queryRecruitStatus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/addStudentSource")
	public String addStudentSource(StudentSourceAdd studentSourceAdd) {
		try {
			this.studentSourceServiceImpl.addStudentSource(studentSourceAdd);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@RequestMapping("/queryStudentSourceByID")
	public StudentSource queryStudentSourceByID(String tss_id) {
		try {
			return this.studentSourceServiceImpl.queryStudentSourceByID(tss_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/updateStudentSource")
	public String updateStudentSource(StudentSource studentSource) {
		try {
			this.studentSourceServiceImpl.updateStudentSource(studentSource);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
}
