package com.guigu.controller.curriculum;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import java.io.File;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.guigu.dao.curriculum.CourseInfoMapper;
import com.guigu.domain.curriculum.Stage_course;
import com.guigu.domain.curriculum.vo.Course_addInfo;
import com.guigu.domain.curriculum.vo.Course_detailInfo;
import com.guigu.domain.curriculum.vo.Course_search;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.service.curriculum.CourseInfoService;

/**
 * 课程信息处理器类
 * @author zy
 *
 */
@Controller
@RequestMapping("/courseInfo")
public class CourseInfoController {
	
	@Autowired
	private CourseInfoService courseInfoService;
	
	/**
	 * 加载下拉框课程数据
	 * @return
	 */
	@RequestMapping("/loadSelectCourseInfo")
	public @ResponseBody List<CourseInfoMapper> loadSelectCourseInfo(String emp_id){
		return this.courseInfoService.loadSelectCourseInfo(emp_id);
	}
	
	/**
	 * 查询所有显示的课程信息
	 */
	@RequestMapping("/queryAllCourseInfo")
	public @ResponseBody LayUiPageInfo queryAllCourseInfo(int page,int limit,Course_search c_search){
		System.out.println("---------------------------");
		return this.courseInfoService.queryAllCourseInfo(page, limit,c_search);
	}
	/**
	 * 根据课程编号查询出该课程的所有信息
	 * 
	 */
	@RequestMapping("/queryCourseInfoById")
	public ModelAndView queryCourseInfoById(String tc_cid){
		ModelAndView mav=new ModelAndView();
		Course_detailInfo c_d=this.courseInfoService.queryCourseInfoById(tc_cid);
		mav.setViewName("forward:/curriculumAndEduoffice/curriculum/Course_detailInfo.jsp");
		mav.addObject("course",c_d);
		return mav;
	}
	
	/**
	 * 根据课程编号查询出该课程所有的章节信息
	 */
	@RequestMapping("/querySectionsByCourseId")
	public @ResponseBody LayUiPageInfo querySectionsByCourseId(int page,int limit,String tc_cid){
		return this.courseInfoService.querySectionsByCourseId(page,limit,tc_cid);
	}

	
	/**
	 * 添加课程阶段信息
	 * @param stage_course
	 * @return addStage
	 */
	@RequestMapping("/addCourseinfo.action")
	public @ResponseBody String addCourseinfo(Stage_course stage_course) {
		return "添加失败";
		
	}
	/*
	 * 课程大纲上传Controller
	 * */
	@RequestMapping(value = "/FileCourse" , method = RequestMethod.POST)
    @ResponseBody
	public JSONObject FileCoures(HttpServletRequest servletRequest,@RequestParam("file") MultipartFile file) throws IOException{
		//如果文件内容不为空，就写入上传路径
		JSONObject res = new JSONObject();
		JSONObject resUrl = new JSONObject();
		if(!file.isEmpty()) {
			//获取原文件名称
			String originalFilename =file.getOriginalFilename();
			//获取原文件扩展名
			String suffName=originalFilename.substring(originalFilename.lastIndexOf("."));
			//产生新的文件名称
			String newFilename=UUID.randomUUID()+suffName;
			//上传文件路径
			String path = servletRequest.getSession().getServletContext().getRealPath("/curriculumAndEduoffice/curriculum/stage");
			//打印出文件名称
			System.out.println("文件名称"+newFilename);
			//上传文件名
			File filepath=new File(path,newFilename);
			//判断路径是否存在，没有的话就创建一个
			if(!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			//将上传文件保存到一个目标文档中
			File file1= new File(path+File.separator+newFilename);
			file.transferTo(file1);
			//返回的是一个URL对象
			resUrl.put("url",file1.getPath());
			res.put("code", 0);
		    res.put("msg", "");
		    res.put("data", resUrl);

			System.out.println(res);
			return res;
		}else {
			return res;
		}

	}
	/**
	 * 
	 *删除课程（逻辑删除，修改课程状态） 
	 */
	@RequestMapping("/deleteCourseById")
	@ResponseBody
	public String deleteCourseById(String tc_cid){
		// ModelAndView mav=new ModelAndView();
		 try {
			this.courseInfoService.deleteCourseById(tc_cid);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		 // mav.setViewName("forward:/curriculumAndEduoffice/curriculum/CourseInfo.jsp");
//		 return mav; 
	}
	
	
	/**
	 * 根据表单提交的课程信息进行修改
	 */
	@RequestMapping("/updateCourseInfoById")
	//参数列表: 	课程基本信息对象	上传文件对象	选择的阶段编号(实现文件上传和创建文件时再启用)
	public ModelAndView updateCourseInfoById(Course_detailInfo c_d,File f,String tc_sid){
		ModelAndView mav=new ModelAndView();
		 try {
			 //修改课程基本信息
			this.courseInfoService.updateCourseInfoById(c_d);
			
			if(f!=null|| !f.exists() || f.length()!=0){
				//修改课程的教学大纲
				this.courseInfoService.updateCoutlineById(c_d.getTc_coutline(),c_d.getTc_cid());
			}
			//修改课程所属阶段
			this.courseInfoService.updateCourseStageById(tc_sid,c_d.getTc_cid());
			mav.addObject("message","修改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("message","修改失败!");
		}
		 mav.setViewName("forward:/curriculumAndEduoffice/curriculum/CourseInfo.jsp");
		 return mav;
	}
	
	/**
	 * 删除某个课程的章节(逻辑删除:修改状态)
	 */
	@RequestMapping("/deleteCourseSectionById")
	public @ResponseBody String deleteCourseSectionById(String s_id){
		String message="ok";
		try {
			this.courseInfoService.deleteCourseSectionById(s_id);
		} catch (Exception e) {
			message="fail";
			e.printStackTrace();
		}
		return message;
	}
	
	/**
	 * 添加课程信息
	 */
	@RequestMapping("/addCouseInfo")
	public @ResponseBody String addCouseInfo(Course_addInfo c_a){
		String message="ok";
		try {
			//添加课程信息
			this.courseInfoService.addCouseInfo(c_a);
			//添加课程的阶段信息
			this.courseInfoService.addCourseStage(c_a.getTc_sid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				message="fail";
		}
		return message;
	}
}
