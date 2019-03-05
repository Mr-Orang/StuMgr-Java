package com.guigu.service.info.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guigu.common.info.PageVo;
import com.guigu.dao.info.StustuInfoMapper;
import com.guigu.domain.info.LeaveView;
import com.guigu.domain.info.Stuclass;
import com.guigu.domain.info.StudentInfo;
import com.guigu.domain.info.Studorm;
import com.guigu.service.info.StustuInfoService;
import com.guigu.util.PageHelpVO;
@Service
public class StustuInfoServiceImpl implements StustuInfoService{
	@Autowired
public StustuInfoMapper stuInfoMapper;
	@Override
	public StudentInfo querybystuid(String stuid) throws Exception {
	return stuInfoMapper.querybystuid(stuid);
	}

	@Override
	public PageVo<StudentInfo> querybyclassid(StudentInfo studentInfo,Integer page,Integer rows) throws Exception {
		System.out.println("Integer ="+page+"------------"+"Integer="+rows);
	
	
		PageVo<StudentInfo> pagevo = new PageVo<StudentInfo>();
		PageInfo<StudentInfo> pageinfos = PageHelper.startPage(page, rows).doSelectPageInfo(() -> {
			try {
				this.stuInfoMapper.querybyclassid(studentInfo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		pagevo.setRows(pageinfos.getList());
		pagevo.setTotal(pageinfos.getTotal());
		return pagevo;
	}

	@Override
	public List<Stuclass> querybyallclass() throws Exception {
		return this.stuInfoMapper.querybyallclass();
	}

	@Override
	public List<Studorm> querybyalldorm() throws Exception {
		return this.stuInfoMapper.querybyalldorm();
	}

	
	@Override
	public void updatestudentinfo(StudentInfo studentinfo) throws Exception {
		// TODO Auto-generated method stub
		 this.stuInfoMapper.updatestudentinfo(studentinfo);
	}

	@Override
	public StudentInfo querybyupstuid(String stuid) throws Exception {
		// TODO Auto-generated method stub
		return this.stuInfoMapper.querybyupstuid(stuid);
	}

	@Override
	public void deletebystuid(String stuid) throws Exception {
		this.stuInfoMapper.deletebystuid(stuid);
		
	}

}
