package com.guigu.controller.info;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guigu.common.info.PageVo;
import com.guigu.domain.info.LeaveView;
import com.guigu.domain.marketing.Employee;
import com.guigu.service.info.ILeaveService;

@RestController
public class LeaveController {
	@Autowired
	private ILeaveService leaveservice;
	
	/*@RequestMapping("/queryleave.action")
	public @ResponseBody PageVo<LeaveView> queryleave(String stu_id,Integer page, Integer rows) {
		stu_id="s1001";
		page=1;
		rows=5;
		
		PageVo<LeaveView> pages = null;
		try {
			pages = this.leaveservice.queryleave(stu_id,page, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pages;
	}*/
	@RequestMapping("/queryleave.action")
	public @ResponseBody List<LeaveView> queryleave(String stu_id){
		stu_id="s1001";
		List<LeaveView> leavelist=new ArrayList<LeaveView>();
		try {
			
				leavelist=this.leaveservice.queryleave(stu_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leavelist;
	}
	
	@RequestMapping("/approveleave.action")
	public @ResponseBody PageVo<LeaveView> approveleave(HttpServletRequest request,String te_id,Integer page, Integer rows) {
		//Employee emp=(Employee)request.getSession().getAttribute("emplyee");
		te_id="emp4";	
		PageVo<LeaveView> pages = null;
		try {
			pages = this.leaveservice.approveleave(te_id,page, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pages;
	
		}
	
	@RequestMapping("/leavexingxi.action")
	public @ResponseBody LeaveView leavexingxi(String leave_id) {
			LeaveView le=new LeaveView();
		try {
				le= this.leaveservice.leavexingxi(leave_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return le;
		}
	
	@RequestMapping("/shenpibaocun.action")
	public @ResponseBody String shenpibaocun(HttpServletRequest request,String leave_id,int state,String yuanyi){
		String result="审批成功";
		Employee emp=(Employee)request.getSession().getAttribute("emplyee");
		//approver_id="emp3";
		try {
			LeaveView leaveview=new LeaveView();
			leaveview.setLeave_id(leave_id);
			leaveview.setTe_name(emp.getTe_id());
			leaveview.setApprover_reason(yuanyi);
			leaveview.setApprover_status(state);
			this.leaveservice.shenpibaocun(leaveview);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="审批失败";
		}
		return result;
	}
	
	@RequestMapping("/leavexiangxi.action")
	public @ResponseBody PageVo<LeaveView> leavexiangxi(HttpServletRequest request,String te_id,Integer page, Integer rows) {
		//Employee emp=(Employee)request.getSession().getAttribute("emplyee");
		te_id="emp4";
		PageVo<LeaveView> pages = null;
		try {
			pages = this.leaveservice.leavexiangxi(te_id,page, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pages;
		}
	
	@RequestMapping("/directorshenpi.action")
	public @ResponseBody PageVo<LeaveView> directorshenpi(HttpServletRequest request,String te_id,Integer page, Integer rows) {
		//Employee emp=(Employee)request.getSession().getAttribute("emplyee");
		te_id="emp4";
		System.out.println(te_id);
		PageVo<LeaveView> pages = null;
		try {
			pages = this.leaveservice.directorshenpi(te_id,page, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pages;
		}
	
	@RequestMapping("/leavexingxi2.action")
	public @ResponseBody LeaveView leavexingxi2(String leave_id) {
			LeaveView le=new LeaveView();
		try {
				le= this.leaveservice.leavexingxi2(leave_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return le;
		}
	@RequestMapping("/shenpibaocun2.action")
	public @ResponseBody String shenpibaocun2(HttpServletRequest request,String leave_id,int state2,String yuanyi2){
		String result="审批成功";
		Employee emp=(Employee)request.getSession().getAttribute("emplyee");
		//approver_id="emp3";
		try {
			LeaveView leaveview2=new LeaveView();
			leaveview2.setLeave_id(leave_id);
			leaveview2.setTe_namee(emp.getTe_id());
			leaveview2.setReview_status(state2);
			leaveview2.setReview_reason(yuanyi2);
			this.leaveservice.shenpibaocun2(leaveview2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="审批失败";
		}
		return result;
	}
	
	@RequestMapping("/leavexiangxi2.action")
	public @ResponseBody PageVo<LeaveView> leavexiangxi2(HttpServletRequest request,String te_id,Integer page, Integer rows) {
		//Employee emp=(Employee)request.getSession().getAttribute("emplyee");
		te_id="emp4";
		PageVo<LeaveView> pages = null;
		try {
			pages = this.leaveservice.leavexiangxi2(te_id,page, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pages;
		}
	
	
}
