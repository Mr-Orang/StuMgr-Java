package com.guigu.controller.info;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.common.info.KaoqinTypeVo;
import com.guigu.domain.info.Attendance;
import com.guigu.service.info.IKaoqinService;
import com.guigu.util.PageHelpVO;

@Controller
@RequestMapping("kaoqin")
public class KaoqinController {
	@Autowired
	private IKaoqinService ikaoqinservice;
	/**
	 * 查询班级 的名称，人数，班级类别并分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/kaoqincalssshow.action")
	public  @ResponseBody PageHelpVO queryemp(int page,int rows) {
		PageHelpVO pageInfo = new PageHelpVO();
		try{
			pageInfo = ikaoqinservice.kaoqinClassshow(page , rows);
		}catch(Exception e){
			e.printStackTrace();
		}
		return pageInfo;
	}
	@RequestMapping("/kaoqintypeselect.action")
	public @ResponseBody List<KaoqinTypeVo> kaoqintypeselect(){
		List<KaoqinTypeVo> ktv= new ArrayList(); 
		try{
			 ktv = ikaoqinservice.kaqinselect();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ktv;
	}
	@RequestMapping("/kaoqinTime.action")
	public @ResponseBody KaoqinTypeVo kaoqintime(HttpServletRequest request,String text){
		KaoqinTypeVo ktv= new KaoqinTypeVo(); 
		try{
			 ktv = ikaoqinservice.kaoqintime(request, text);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ktv;
	}
	@RequestMapping("/kaoqinStudent.action")
	public @ResponseBody PageHelpVO queryStudengtwj(String kaoqinleixing,int page,int rows) {
		System.out.println(kaoqinleixing);
		PageHelpVO pageInfo = new PageHelpVO();
		try{
			pageInfo = ikaoqinservice.KaoqinStuden(page, rows, kaoqinleixing);
		}catch(Exception e){
			e.printStackTrace();
		}
		return pageInfo;
	}
	@RequestMapping("/kaoqininsert.action")
	public String inserkaoqindetails(HttpServletRequest request,HttpServletResponse response,String stu_id,String status,String class_id,String type_id,String ty_yesno){
		PrintWriter pw=null;
		System.out.println(stu_id+status+ class_id+type_id+ ty_yesno);
		String msg = "考勤失败,请联系管理员";
		response.setContentType("text/html;charset=utf-8");
		try{
			pw = response.getWriter();
			if(ikaoqinservice.kaoqinattendance(request,class_id, "admin", type_id, ty_yesno ) && ikaoqinservice.kaoqindetails(stu_id, status)!=false){
				msg="考勤成功";
			}
		}catch(Exception e){
			e.printStackTrace();
			}
			pw.println(msg);
		return null;
	}
}








