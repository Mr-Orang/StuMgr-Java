package com.guigu.service.eduoffice;

import java.util.List;

import com.guigu.domain.authority.vo.RoleVO;

/**
 * 反馈功能接口
 * @author 雷神
 *
 */
public interface FeedBackService {

	/**
	 * 加载下拉框角色信息
	 * @return
	 */
	List<RoleVO> loadFeedSelect();

	
	
	
}
