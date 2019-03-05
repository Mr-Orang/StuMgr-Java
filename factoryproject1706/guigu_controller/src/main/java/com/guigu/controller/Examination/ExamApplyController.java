package com.guigu.controller.Examination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.service.Examination.IExamApplyService;
@RequestMapping("exam/apply")
@Controller
public class ExamApplyController {
	
	@Autowired
	private IExamApplyService examApplyService;
	
	@RequestMapping("/queryApply.action")
	public @ResponseBody LayUiPageInfo queryFullApply(int page,int limit) {
		//System.out.println(1);
		return examApplyService.queryFullApply(page,limit);
		
	}
}
