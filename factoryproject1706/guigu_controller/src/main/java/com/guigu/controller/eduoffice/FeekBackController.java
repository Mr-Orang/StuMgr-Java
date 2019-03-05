package com.guigu.controller.eduoffice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.domain.authority.vo.RoleVO;
import com.guigu.service.eduoffice.FeedBackService;
import com.guigu.service.eduoffice.GiveLessonsService;

/**
 * 反馈业务处理器类
 * @author 雷神
 *
 */
@Controller
@RequestMapping("/feedback")
public class FeekBackController {
	
	@Autowired
	private FeedBackService feekbackservice;
	
	/**
	 * 加载下拉框角色信息
	 * @return
	 */
	@RequestMapping("/loadFeedSelect")
	public @ResponseBody List<RoleVO> loadFeedSelect(){
		
		return this.feekbackservice.loadFeedSelect();
	}
	
	
	

}
