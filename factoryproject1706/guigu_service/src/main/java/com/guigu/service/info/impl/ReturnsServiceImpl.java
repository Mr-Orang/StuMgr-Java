package com.guigu.service.info.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.info.ReturnVo;
import com.guigu.dao.info.ReturnMapper;
import com.guigu.domain.info.Returns;
import com.guigu.domain.info.Student;
import com.guigu.service.info.IReturnsService;
import com.guigu.util.PageHelpVO;

/**
 * 复学业务处理接口实现类
 * 
 * @author Administrator
 *
 */
@Service
public class ReturnsServiceImpl implements IReturnsService {
	@Autowired
	private ReturnMapper returnMapper;

	/**
	 * 学生申请
	 */
	@Override
	public void InsertReturn(Returns returns) {
		this.returnMapper.InsertReturn(returns);
	}

	/**
	 * 显示学生申请基本信息 完成
	 */
	@Override
	public PageHelpVO SReturnVo(String LEAVE_ID, Integer page, Integer rows) {
		// 分页对象
		PageHelpVO ph = new PageHelpVO();
		Page p = PageHelper.startPage(page, rows, true);
		ph.setRows(returnMapper.SReturnVo(LEAVE_ID));
		ph.setTotal(p.getTotal());
		return ph;
	}

	/**
	 * 点击复学申请查看复学记录根据id查看 审批 未完成
	 */
	@Override
	public ReturnVo SertReturn(String return_id) {
		return returnMapper.SertReturn(return_id);
	}

	/**
	 * 
	 */
	@Override
	public List<Student> SelStucid(String stuid, String stucid) {
		return returnMapper.SelStucid(stuid, stucid);
	}

	@Override
	public PageHelpVO SReturnVos(String LEAVE_ID, Integer page, Integer rows) {
		// 分页对象
		PageHelpVO ph = new PageHelpVO();
		Page p = PageHelper.startPage(page, rows, true);
		ph.setRows(returnMapper.SReturnVos(LEAVE_ID));
		ph.setTotal(p.getTotal());
		return ph;
	}

}
