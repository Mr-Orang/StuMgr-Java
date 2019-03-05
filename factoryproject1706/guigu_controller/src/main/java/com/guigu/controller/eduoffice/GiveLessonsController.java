package com.guigu.controller.eduoffice;

import java.util.List;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.domain.eduoffice.Classes;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.eduoffice.vo.CourseInfoVo;
import com.guigu.domain.eduoffice.vo.EmpVo;
import com.guigu.service.eduoffice.GiveLessonsService;
/**
 * 授课业务处理器类
 * @author zy
 *
 */
@Controller
@RequestMapping("/giveLessons")
public class GiveLessonsController {
	
	@Autowired
	private GiveLessonsService giveLessonsService;
	
	/**
	 * 查询授课信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/queryGiveLessons")
	public @ResponseBody LayUiPageInfo queryGiveLessons(int page,int limit,String tc_name,String tc_cname,String te_name) {
		return this.giveLessonsService.queryGiveLessons(page, limit,tc_name,tc_cname,te_name);
	}
	
	/**
	 * 根据课程编号查询可授课的老师
	 * @param sc_id
	 * @return
	 */
	@RequestMapping("/loadSelectDataByScId")
	public @ResponseBody List<EmpVo> loadSelectDataByScId(String sc_id){
		return this.giveLessonsService.loadSelectDataByScId(sc_id);
	}
	
	/**
	 * 修改授课老师
	 * @param gl_id
	 * @param te_name
	 * @return
	 */
	@RequestMapping("/editGiveLessonsTeacher")
	public @ResponseBody String editGiveLessonsTeacher(String gl_id,String empInfo1,String status) {
		return this.giveLessonsService.editGiveLessonsTeacher(gl_id, empInfo1,status);
	}
	
	/**
	 * 加载班级下拉框数据
	 * @return
	 */
	@RequestMapping("/loadClassSelect")
	public @ResponseBody List<Classes> loadClassSelect(){
		return this.giveLessonsService.loadClassSelect();
	}
	
	/**
	 * 根据班级id加载课程下拉框
	 * @param tc_id
	 * @return
	 */
	@RequestMapping("/loadCourseSelectByTcId")
	public @ResponseBody List<CourseInfoVo> loadCourseSelectByTcId(String tc_id){
		return this.giveLessonsService.loadCourseSelectByTcId(tc_id);
	}
	
	/**
	 * 添加授课信息
	 * @param class1
	 * @param course
	 * @param empInfo1
	 * @return
	 */
	@RequestMapping("/addGiveLessons")
	public @ResponseBody String addGiveLessons(String class1,String course,String empInfo1) {
		return this.giveLessonsService.addGiveLessons(class1, course, empInfo1);
	}
	
	/**
	 * 结课 修改授课状态
	 * @param gl_id
	 * @return
	 */
	@RequestMapping("/editGiveLessonsStatus")
	public @ResponseBody String editGiveLessonsStatus(String gl_id) {
		return this.giveLessonsService.editGiveLessonsStatus(gl_id);
	}
} 