package com.guigu.service.impl.eduoffice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.eduoffice.EmpCourseMapper;
import com.guigu.dao.eduoffice.FeedbackMapper;
import com.guigu.domain.authority.vo.RoleVO;
import com.guigu.service.eduoffice.FeedBackService;


/**
 * 反馈功能接口实现类
 * @author 雷神
 *
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {

	@Autowired
	private FeedbackMapper feedbackmapper;
	
	/**
	 * 加载下拉框角色信息
	 */
	@Override
	public List<RoleVO> loadFeedSelect(){
		
		return this.feedbackmapper.loadFeedSelect();
		
	}
	
	
}
