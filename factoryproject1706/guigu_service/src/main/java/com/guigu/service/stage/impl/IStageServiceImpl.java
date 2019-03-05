package com.guigu.service.stage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.dao.stage.StageMapper;
import com.guigu.domain.curriculum.Stage_course;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.service.stage.IStageService;
@Service
public class IStageServiceImpl implements IStageService {

	@Autowired
	private StageMapper stageMapper;
	@Override
	//查询所有阶段信息
	public LayUiPageInfo queryStage(int page,int limit) throws Exception {
		LayUiPageInfo layUiPageInfo=new LayUiPageInfo();
		Page page1=PageHelper.startPage(page, limit);
		layUiPageInfo.setCode(0);
		layUiPageInfo.setData(this.stageMapper.queryStage());
		layUiPageInfo.setCount(page1.getTotal());
		return layUiPageInfo;
	}

	@Override
	//添加阶段信息
	public void addStage(Stage_course stage_course) throws Exception {
		this.stageMapper.addStage(stage_course);

	}
	//修改阶段信息
	@Override
	public void updateStage(Stage_course stage_course) throws Exception {
		this.stageMapper.updateStage(stage_course);

	}
	//删除阶段信息
	@Override
	public void deleteStage(String id) throws Exception {
		
		this.stageMapper.deleteStage(id);
	}
	/**
	 * 
	 * 查询可用的阶段
	 */

	@Override
	public List<Stage_course> queryUsableStage() throws Exception {
		return this.stageMapper.queryUsableStage();
	}

}
