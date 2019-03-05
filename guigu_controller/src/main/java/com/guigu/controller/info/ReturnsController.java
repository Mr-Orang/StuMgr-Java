package com.guigu.controller.info;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guigu.common.info.ReturnVo;
import com.guigu.domain.info.Returns;
import com.guigu.domain.info.Student;
import com.guigu.service.info.IReturnsService;
import com.guigu.util.PageHelpVO;

/**
 * 复学处理器类
 * 
 * @author Administrator
 *
 */
@RestController
public class ReturnsController {
	@Autowired
	private IReturnsService returnsService;
	/**
	 * 复学申请
	 * @param returns
	 */
	@RequestMapping("InsertReturn.action")
	public @ResponseBody void InsertReturn(Returns returns) {
		returnsService.InsertReturn(returns);
	}
	/**
	 * //点击复学申请查看复学记录根据id查看,绑定Session传到前端
	 * @param leave_id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("SReturnvo.action")
	public @ResponseBody ReturnVo SReturnvo(String leave_id,HttpServletRequest request,HttpServletResponse response){
		ReturnVo ReturnVo=null;
		 try {
			 ReturnVo=returnsService.SertReturn("l12");
			 System.out.println(ReturnVo);
			 request.getSession().setAttribute("ReturnVo", ReturnVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ReturnVo;
	}
	/**
	 * 复学申请基本信息(学生可以看见)
	 * @param LEAVE_ID
	 * @return
	 */
	@RequestMapping("SelReturnVo.action")
	public PageHelpVO SelReturnVo(Integer page,Integer rows) {
		PageHelpVO ph=null;
		try {
			//先绑定死值,到时候更改,方便查看
			ph=returnsService.SReturnVo("l12", page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ph;
	}
	/**
	 * 学生基本信息(老师看的)
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("SelReturnVos.action")
	public PageHelpVO SelReturnVos(Integer page,Integer rows) {
		PageHelpVO ph=null;
		try {
			//先绑定死值,到时候更改,方便查看
			ph=returnsService.SReturnVos("l12", page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ph;
	}
	/**
	 * 根据学号和身份证查询
	 * @param stuid	学号
	 * @param stucid 姓名
	 */
	@RequestMapping("SelStucid.action")
	public @ResponseBody String SelStucid(String stuid) {
		List<Student> stu=new ArrayList<Student>();
		String fag="0";
		String stucid="";
		System.out.println("--------用户输入：---------"+stuid+"-------------");
		if(stuid.length()==18){
			stucid=stuid;
			stuid="";
		}
		stu=returnsService.SelStucid(stuid,stucid);
		System.out.println("-----------------"+stu+"---------------");
		if(stu.size()>0){
			fag="1";
		}
		System.out.println("---------------------------"+fag+"---------------");
		return fag;
	}
}
