package com.guigu.service.info.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.info.PageVo;
import com.guigu.dao.info.ChangeClassMapper;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.info.ChangeClassSearch;
import com.guigu.domain.info.ChangeClassView;
import com.guigu.domain.info.Student;
import com.guigu.domain.marketing.Classes;
import com.guigu.service.info.IChangeClassService;
/**
 *	学生转班业务实现类
 * @author cyd
 *
 */
@Service
@Transactional
public class ChangeClassServiceImpl implements IChangeClassService{

	@Autowired
	private ChangeClassMapper changeClassMapper;
	
	@Override
	public PageVo<ChangeClassView> queryChangeClassApply(String teacher_id, Integer rows, Integer page,ChangeClassSearch changeClassSearch) throws Exception {
		// TODO Auto-generated method stub
		PageVo<ChangeClassView> pageVo=new PageVo<ChangeClassView>();
		Page<ChangeClassView> pages=PageHelper.startPage(page, rows);
		List<ChangeClassView> change_class_list=changeClassMapper.queryChangeClassApply(teacher_id,changeClassSearch);
		for(ChangeClassView s:change_class_list){
			System.out.println(s);
		}
		pageVo.setRows(change_class_list);
		pageVo.setTotal(pages.getTotal());
		return pageVo;
	}

	@Override
	public List<ChangeClassView> queryChangeClassByTccId(String tcc_id) throws Exception {
		// TODO Auto-generated method stub
		return changeClassMapper.queryChangeClassByTccId(tcc_id);
	}

	@Override
	public List<Classes> queryClassByTeId(String te_id) throws Exception {
		// TODO Auto-generated method stub
		return changeClassMapper.queryClassByTeId(te_id);
	}

	@Override
	public List<Student> queryStudentByTcId(String tc_id) throws Exception {
		// TODO Auto-generated method stub
		return changeClassMapper.queryStudentByTcId(tc_id);
	}

	@Override
	public List<Classes> queryAllClassByTcId(String tc_id) throws Exception {
		// TODO Auto-generated method stub
		return changeClassMapper.queryAllClassByTcId(tc_id);
	}


	@Override
	public boolean addChangeClassApply(ChangeClassView changeClassView) throws Exception {
		// TODO Auto-generated method stub
		return changeClassMapper.addChangeClassApply(changeClassView)>0?true:false;
	}

	@Override
	public boolean updateChangeClassApply(ChangeClassView changeClassView) throws Exception {
		// TODO Auto-generated method stub
		return changeClassMapper.updateChangeClassApply(changeClassView)>0?true:false;
	}

	@Override
	public LayUiPageInfo queryChangeClassApplyByStuId(Integer page, Integer rows, String stu_id) throws Exception{
		// TODO Auto-generated method stub
		LayUiPageInfo pageVo=new LayUiPageInfo();
		Page<ChangeClassView> pages=PageHelper.startPage(page, rows);
		List<ChangeClassView> changeList=changeClassMapper.queryChangeClassApplyByStuId(stu_id);		
		pageVo.setCode(0);
		pageVo.setData(changeList);
		pageVo.setCount(pages.getTotal());
		return pageVo;
	}

	@Override
	public PageVo<ChangeClassView> queryChangeClassCheck(Integer page, Integer rows, String te_id,ChangeClassView changeClassView)throws Exception {
		// TODO Auto-generated method stub
		PageVo<ChangeClassView> pageVo=new PageVo<ChangeClassView>();
		Page<ChangeClassView> pages=PageHelper.startPage(page, rows);
		List<ChangeClassView> change_check_List=changeClassMapper.queryChangeClassCheck(te_id,changeClassView);
		pageVo.setRows(change_check_List);
		pageVo.setTotal(pages.getTotal());
		return pageVo;
	}

	@Transactional
	@Override
	public boolean updateChangeClassInStatus(ChangeClassView changeClassView) throws Exception {
		// TODO Auto-generated method stub
		int result1 = 0,result2 = 0;
		if(changeClassView.getIn_reason()==null || changeClassView.getIn_reason().equals("")){
			changeClassView.setIn_status(1);
			result1=changeClassMapper.updateChangeClassInStatus(changeClassView);
			result2=changeClassMapper.updateStudentClassInfoByStuId(changeClassView);
			return result1>0&&result2>0?true:false;
			
		}else{
			changeClassView.setIn_status(2);
			result1=changeClassMapper.updateChangeClassInStatus(changeClassView);
			return result1>0?true:false;
		}
		
	}

}
