package com.guigu.service.examination.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.examination.ExamApplyView;
import com.guigu.dao.examination.ApplyExamMapper;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.service.examination.IExamApplyService;
@Service
public class ExamApplyServiceImpl implements IExamApplyService {
	
	@Autowired
	private ApplyExamMapper applyExamMapper;
	
	@Override
	public LayUiPageInfo queryFullApply(int page,int limit) {
		// TODO Auto-generated method stub
		LayUiPageInfo pagevo=new LayUiPageInfo();
		Page pages=PageHelper.startPage(page, limit);
		List<ExamApplyView> list=applyExamMapper.queryFullApply();
		pagevo.setData(list);
		pagevo.setCount(pages.getTotal());
		return pagevo;
	}

}
