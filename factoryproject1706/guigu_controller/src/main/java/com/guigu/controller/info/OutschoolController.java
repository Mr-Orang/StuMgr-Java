package com.guigu.controller.info;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.guigu.common.info.Outschool_money;
import com.guigu.common.info.StuOutschool;
import com.guigu.domain.authority.vo.AccountVO;
import com.guigu.service.info.IOutschoolService;
import com.guigu.util.PageHelpVO;

@Controller
@RequestMapping("dyc")
public class OutschoolController {

	@Autowired
	private IOutschoolService outschoolService;
	
	//查询学生退学信息 
	@RequestMapping("/queryoutschool")
	public @ResponseBody PageHelpVO queryoutschool(Integer page,Integer rows){
		try {
			return outschoolService.queryoutschool(page,rows);
		} catch (Exception e) {
			return null;
		}
	}
	
	//学生退学缴费详情
	@RequestMapping("/queryoutschool_money")
	public @ResponseBody List<Outschool_money> queryoutschool_money(String stu_id){
		return outschoolService.queryoutschool_money(stu_id);
	}
	
	//审批获取学生退学信息审批状态和不同意原因
	@RequestMapping("/querystatus_reson")
	public @ResponseBody List<StuOutschool> querystatus_reson(String stu_id){
		return outschoolService.querystatus_reson(stu_id);
	}
	
	//对学生退学进行审批
	@RequestMapping("/updatetoutschool")
	public @ResponseBody String updatetoutschool(HttpServletRequest request){
		int sp_yes = 0;
		AccountVO account = (AccountVO) request.getSession().getAttribute("account");
		String review_use = account.getAccount();
		String sp_text = request.getParameter("sp_yes");
		if(sp_text.equals("未审核")){
			sp_yes = 0;
		}
		if(sp_text.equals("同意")){
			sp_yes = 1;
		}
		if(sp_text.equals("不同意")){
			sp_yes = 2;
		}
		String text_no = request.getParameter("text_no");
		String stu_id = request.getParameter("stu_id");
		int flag =  outschoolService.updatetoutschool(review_use, sp_yes, text_no, stu_id);
		if(flag > 0 && sp_yes==1){
			outschoolService.updatestudentout(stu_id);
			return "审核成功，已通知该学生";
		}else if(flag > 0){
			return "审核成功，已通知该学生";
		}else{
			return "网络失败，稍后再试";
		}
	}
	
	//查询所有在班学生信息
	@RequestMapping("/queryoutstudentinfo")
	public @ResponseBody PageHelpVO queryoutstudentinfo(Integer page,Integer rows){
		try {
			return outschoolService.queryoutstudentinfo(page, rows);
		} catch (Exception e) {
			return null;
		}
	}
	
	//查询学生退学单id
	@RequestMapping("/queryoutid")
	public @ResponseBody List<StuOutschool> queryoutid(){
		return outschoolService.queryoutid();
	}
	
	//保存学生退学单
	@RequestMapping("/saveoutschool")
	public @ResponseBody String saveoutschool(String dropout_id,String stu_id,String reason){
		int flag =  outschoolService.saveoutschool(dropout_id, stu_id, reason);
		if(flag > 0){
			return "填写申请单成功，等待审批";
		}else{
			return "网络延迟，稍后再试";
		}
	}
	
	
}
