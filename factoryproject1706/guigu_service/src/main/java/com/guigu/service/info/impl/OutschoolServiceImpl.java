package com.guigu.service.info.impl;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.info.Outschool_money;
import com.guigu.common.info.StuOutschool;
import com.guigu.dao.info.OutschoolMapper;
import com.guigu.service.info.IOutschoolService;
import com.guigu.util.PageHelpVO;

@Service
public class OutschoolServiceImpl implements IOutschoolService {

	@Autowired
	private OutschoolMapper outschoolMapper;

	@Override
	public PageHelpVO queryoutschool(Integer page,Integer rows) {
		PageHelpVO pageinfo = new PageHelpVO();
		Page p = PageHelper.startPage(page, rows, true);
		pageinfo.setRows(outschoolMapper.queryoutschool());
		pageinfo.setTotal(p.getTotal());
		return pageinfo;
	}

	@Override
	public List<Outschool_money> queryoutschool_money(String stu_id) {
		return outschoolMapper.queryoutschool_money(stu_id);
	}

	@Override
	public List<StuOutschool> querystatus_reson(String stu_id) {
		return outschoolMapper.querystatus_reson(stu_id);
	}

	@Override
	public int updatetoutschool(@Param("review_use")String review_use,@Param("sp_yes")int sp_yes,@Param("text_no")String text_no,@Param("stu_id")String stu_id) {
		return outschoolMapper.updatetoutschool(review_use, sp_yes, text_no, stu_id);
	}

	@Override
	public PageHelpVO queryoutstudentinfo(Integer page, Integer rows) {
		PageHelpVO pageinfo = new PageHelpVO();
		Page p = PageHelper.startPage(page, rows, true);
		pageinfo.setRows(outschoolMapper.queryoutstudentinfo());
		pageinfo.setTotal(p.getTotal());
		return pageinfo;
	}

	@Override
	public List<StuOutschool> queryoutid() {
		return outschoolMapper.queryoutid();
	}

	@Override
	public int saveoutschool(@Param("dropout_id")String dropout_id,@Param("stu_id")String stu_id,@Param("reason")String reason) {
		return outschoolMapper.saveoutschool(dropout_id, stu_id, reason);
	}

	@Override
	public int updatestudentout(String stu_id) {
		return outschoolMapper.updatestudentout(stu_id);
	}
}
