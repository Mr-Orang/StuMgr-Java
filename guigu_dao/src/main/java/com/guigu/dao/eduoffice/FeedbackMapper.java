package com.guigu.dao.eduoffice;

import java.util.List;

import com.guigu.domain.authority.vo.RoleVO;

/**
 * 反馈功能数据访问接口
 * @author 雷神
 *
 */

public interface FeedbackMapper {

	/**
	 * 加载下拉框角色信息
	 * @return
	 */
	List<RoleVO> loadFeedSelect();
}
