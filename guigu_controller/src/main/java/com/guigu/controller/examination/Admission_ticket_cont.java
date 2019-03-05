package com.guigu.controller.examination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.service.examination.Admission_ticket_service;

/**
 * 准考证号查询业务
 * @author Samsung
 *
 */
@Controller
@RequestMapping("admission")
public class Admission_ticket_cont {

	@Autowired
	private Admission_ticket_service admission_ticket_service;
	
	/**
	 * 查询准考证号登录学生端
	 * @return 
	 */
	@RequestMapping("/admission_login")
	public @ResponseBody Object Enquiry_admission(String adm_id,String stu_cid){
		return admission_ticket_service.Enquiry_admission(adm_id,stu_cid);
	}
	
	/**
	 * 查询老师账号登录老师端
	 * @return
	 */
//	@RequestMapping("/teacher_login")
//	public @ResponseBody Object Enquiry_teacher()
}
