package com.guigu.controller.info;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.common.info.PageVo;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.info.ChangeClassSearch;
import com.guigu.domain.info.ChangeClassView;
import com.guigu.domain.info.Student;
import com.guigu.domain.marketing.Classes;
import com.guigu.domain.marketing.Employee;
import com.guigu.service.info.IChangeClassService;
/**
 * 学生转班处理器类
 * @author cyd
 *
 */
@Controller
@RequestMapping("changeclassapply")
public class ChangeClassController {
	
	Employee emp=new Employee("emp4", "liuyang", "17434838549", "430520199903265210", "男", 20, "否", "湖南省醴陵市", "否",null);
	
	@Autowired
	private IChangeClassService changeClassService;
	
	/**
	 * 查询所有转班申请
	 * @param page 当前页面
	 * @param rows 页面大小
	 * @param request 
	 * @return
	 */
	@RequestMapping("/queryChangeClassApply")
	public @ResponseBody PageVo<ChangeClassView> queryChangeClassApply(Integer page,Integer rows,HttpServletRequest request,ChangeClassSearch changeClassSearch){
		
			try {
				return changeClassService.queryChangeClassApply(emp.getTe_id(), rows, page,changeClassSearch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	/**
	 * 根据转班编号查询对应信息
	 * @param tcc_id 转班编号
	 * @return
	 */
	@RequestMapping("/queryChangeClassByTccId")
	public @ResponseBody List<ChangeClassView> queryChangeClassByTccId(String tcc_id){
		
		try {
			return changeClassService.queryChangeClassByTccId(tcc_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询添加操作老师所交的班级
	 * @return
	 */
	@RequestMapping("/queryClassByTeId")
	public @ResponseBody List<Classes> queryClassByTeId(){
		try {
			return changeClassService.queryClassByTeId(emp.getTe_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据班级编号查询所有学生
	 * @return
	 */
	@RequestMapping("queryStudentByTcId")
	public @ResponseBody List<Student> queryStudentByTcId(String tc_id){
		try {
			return changeClassService.queryStudentByTcId(tc_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询所有班级
	 * @return
	 */
	@RequestMapping("/queryAllClassByTcId")
	public @ResponseBody List<Classes> queryAllClassByTcId(String tc_id){
		try {
			return changeClassService.queryAllClassByTcId(tc_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 添加转班申请
	 * @param changeClassView
	 * @return
	 */
	@RequestMapping("/addChangeClassApply")
	public @ResponseBody String addChangeClassApply(ChangeClassView changeClassView){
		changeClassView.setOut_check(emp.getTe_id());
		try {
			return changeClassService.addChangeClassApply(changeClassView)==true?"添加成功":"添加失败";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * 修改转班申请
	  * @param changeClassView
	  * @return
	  */
	 public @ResponseBody String updateChangeClassApply(ChangeClassView changeClassView){
		 changeClassView.setOut_check(emp.getTe_id());
		 try {
			return changeClassService.updateChangeClassApply(changeClassView)==true?"修改成功":"修改失败";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	 }
	 
	 /**
	  * 查询登入学生的所有转班申请
	  * @return
	  */
	 @RequestMapping("/queryChangeClassApplyByStuId")
	 public @ResponseBody LayUiPageInfo queryChangeClassApplyByStuId(Integer page,Integer limit){
		 try {
			return changeClassService.queryChangeClassApplyByStuId(page, limit, "s1001");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	 }
	 
	 /**
	 * 根据登入用户查询转入到本班的审核信息
	 * @param te_id 老师编号
	 * @return
	 */
	 @RequestMapping("/queryChangeClassCheck")
	 public	@ResponseBody PageVo<ChangeClassView> queryChangeClassCheck(Integer page,Integer rows,ChangeClassView changeClassView){
		try {
			return changeClassService.queryChangeClassCheck(page, rows, emp.getTe_id(),changeClassView);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 
	/**
	 * 修改转入班级审核状态信息
	 * @param changeClassView
	 * @return
	 */
	 @RequestMapping("/updateChangeClassInStatus")
	public @ResponseBody String updateChangeClassInStatus(ChangeClassView changeClassView){
		try {
			changeClassView.setIn_check(emp.getTe_id());
			return changeClassService.updateChangeClassInStatus(changeClassView)==true?"审核成功":"审核失败";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}	
