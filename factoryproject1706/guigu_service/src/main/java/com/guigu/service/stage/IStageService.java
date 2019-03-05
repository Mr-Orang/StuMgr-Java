package com.guigu.service.stage;

import java.util.List;


import com.guigu.domain.curriculum.Stage_course;
import com.guigu.domain.eduoffice.LayUiPageInfo;
public interface IStageService {

	/**
	 * 查询所有阶段信息
	 * @return
	 * @throws Exception
	 */
	LayUiPageInfo queryStage(int page,int limit)throws Exception;
	
	/**
	 * 查询可用的阶段信息
	 * @return
	 * @throws Exception
	 */
	List<Stage_course>queryUsableStage()throws Exception;
	/**
	 * 添加阶段信息
	 * @param courseStageHelp
	 * @throws Exception
	 */
	void addStage(Stage_course stage_course)throws Exception;
	
	/**
	 * 修改阶段信息
	 * @param courseStageHelp
	 * @throws Exception
	 */
	void updateStage(Stage_course stage_course)throws Exception;
	/**
	 * 删除阶段信息
	 * @param id
	 * @throws Exception
	 */
	void deleteStage(String id)throws Exception;
}
