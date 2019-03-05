package com.guigu.controller.curriculum;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.guigu.domain.curriculum.Stage_course;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.service.stage.IStageService;

@Controller
public class StageCourseController {


	@Autowired
	private IStageService iStageService;
	/**
	 * 查询阶段信息
	 */
	@RequestMapping("/queryStage.action")
	public @ResponseBody LayUiPageInfo queryStage(int page,int limit){
		try {
			return this.iStageService.queryStage(page, limit);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
	/**
	 * 查询可用的阶段信息
	 */
	@RequestMapping("/queryUsableStage.action")
	public @ResponseBody List<Stage_course>queryUsableStage(){
		List<Stage_course> list = null;
		try {
			list=this.iStageService.queryUsableStage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;								
	}
	/**
	 * 添加课程阶段信息
	 * @param stage_course
	 * @return addStage
	 */
	@RequestMapping("/addStage.action")
	public @ResponseBody String addStage(Stage_course stage_course){
		String msg= "失败";
		try {
			this.iStageService.addStage(stage_course);
			msg = "成功";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	/**
	 * 更新阶段信息
	 * @param Stage_course
	 * @return updateStage
	 */
	@RequestMapping("/updateStage.action")
	
	public @ResponseBody String updateStage(Stage_course stage_course){
		try {
			this.iStageService.updateStage(stage_course);
			return "更新成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "更新失败";
		}
		
	}
	
	/**
	 * 删除阶段信息
	 * @param id
	 * @return 
	 */
	@RequestMapping("/deleteStage.action")
	
	public @ResponseBody String deleteStage (String id){
		try {
			this.iStageService.deleteStage(id);
			return "删除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "删除失败";
		}
	}
}
