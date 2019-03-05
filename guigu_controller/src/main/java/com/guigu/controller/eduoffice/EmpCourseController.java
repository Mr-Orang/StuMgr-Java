package com.guigu.controller.eduoffice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.eduoffice.vo.EmpVo;
import com.guigu.domain.eduoffice.vo.EmpVo2;
import com.guigu.service.eduoffice.EmpCourseService;

/**
 * 课程老师关系业务处理器类
 * @author zy
 *
 */
@Controller
@RequestMapping("/empCourse")
public class EmpCourseController {
	
	@Autowired
	private EmpCourseService empCourseService;
	
	
	
	/**
	 * 查询所有老师于课程关系信息
	 * @return
	 */
	@RequestMapping("/queryEmpCourseList")
	public @ResponseBody LayUiPageInfo queryEmpCourseList(int page,int limit,String ec_id,String tc_cname,String te_name) {
		return this.empCourseService.queryEmpCourseList(page, limit,ec_id,tc_cname,te_name);
	}
	
	/**
	 *  进行逻辑删除 修改状态为1
	 * @param ec_id
	 * @return
	 */
	@RequestMapping("/updateStatus")
	public @ResponseBody String updateStatus(String ec_id) {
		boolean f=this.empCourseService.updateStatus(ec_id);
		if(f) {
			return "ok";
		}else {
			return "no";
		}
	}
	
	/**
	 * 加载下拉框老师信息
	 * @return
	 */
	@RequestMapping("/loadEmpSelect")
	public @ResponseBody List<EmpVo> loadEmpSelect(){
		return this.empCourseService.loadEmpSelect();
	}
	
	/**
	 * 添加老师课程关系
	 * @param empInfo1
	 * @param courseInfo1
	 * @return
	 */
	@RequestMapping("/addEmpCourse")
	public @ResponseBody String addEmpCourse(String empInfo1,String courseInfo1) {
		boolean f=this.empCourseService.addEmpCourse(empInfo1, courseInfo1);
		if(f) {
			return "ok";
		}else {
			return "no";
		}
		
	}
	
	/**
	 * 查询课程信息
	 * @return
	 */
	@RequestMapping("/queryCourseInfoVo")
	public @ResponseBody List<EmpVo2> queryCourseInfoVo(){
		return this.empCourseService.queryCourseInfoVo();
	}
	
	/**
	 * 启用老师课程关系 修改状态为0
	 * @return
	 */
	@RequestMapping("/updateStatus2")
	public @ResponseBody String updateStatus2(String ec_id) {
		boolean f=this.empCourseService.updateStatus2(ec_id);
		if(f) {
			return "ok";
		}else {
			return "no";
		}
	}
	
}
