package com.guigu.service.info.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guigu.common.info.PageVo;
import com.guigu.dao.info.LeaveMapper;
import com.guigu.domain.info.LeaveView;
import com.guigu.service.info.ILeaveService;
@Service
public class LeaveServiceimpl implements ILeaveService{
	@Autowired
	private LeaveMapper leavemapper;

	@Override
	public List<LeaveView> queryleave(String stu_id) throws Exception {
		return this.leavemapper.queryleave(stu_id);
	}

	@Override
	public PageVo<LeaveView> approveleave(String te_id, Integer currentPage, Integer pageSize) throws Exception {
		PageVo<LeaveView> pagevo = new PageVo<LeaveView>();
		PageInfo<LeaveView> pageinfos = PageHelper.startPage(currentPage, pageSize).doSelectPageInfo(() -> {
			try {
				this.leavemapper.approveleave(te_id);
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
	public LeaveView leavexingxi(String leave_id) throws Exception {
		return this.leavemapper.leavexingxi(leave_id);
	}

	@Override
	public void shenpibaocun(LeaveView leaveview) throws Exception {
		this.leavemapper.shenpibaocun(leaveview);
		
	}

	@Override
	public PageVo<LeaveView> leavexiangxi(String te_id, Integer currentPage, Integer pageSize) throws Exception {
		PageVo<LeaveView> pagevos = new PageVo<LeaveView>();
		PageInfo<LeaveView> pageinfos = PageHelper.startPage(currentPage, pageSize).doSelectPageInfo(() -> {
			try {
				this.leavemapper.leavexiangxi(te_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		pagevos.setRows(pageinfos.getList());
		pagevos.setTotal(pageinfos.getTotal());
		return pagevos;
	}

	@Override
	public PageVo<LeaveView> directorshenpi(String te_id, Integer currentPage, Integer pageSize) throws Exception {
		PageVo<LeaveView> pagevos = new PageVo<LeaveView>();
		PageInfo<LeaveView> pageinfos = PageHelper.startPage(currentPage, pageSize).doSelectPageInfo(() -> {
			try {
				this.leavemapper.directorshenpi(te_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		pagevos.setRows(pageinfos.getList());
		pagevos.setTotal(pageinfos.getTotal());
		return pagevos;
	}

	@Override
	public LeaveView leavexingxi2(String leave_id) throws Exception {
		return this.leavemapper.leavexingxi2(leave_id);
	}

	@Override
	public void shenpibaocun2(LeaveView leaveview) throws Exception {
		this.leavemapper.shenpibaocun2(leaveview);
		
	}

	@Override
	public PageVo<LeaveView> leavexiangxi2(String te_id, Integer currentPage, Integer pageSize) throws Exception {
		PageVo<LeaveView> pagevos = new PageVo<LeaveView>();
		PageInfo<LeaveView> pageinfos = PageHelper.startPage(currentPage, pageSize).doSelectPageInfo(() -> {
			try {
				this.leavemapper.leavexiangxi2(te_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		pagevos.setRows(pageinfos.getList());
		pagevos.setTotal(pageinfos.getTotal());
		return pagevos;
	}
	
	/*
	 * @Override 学生端查询
	public PageVo<LeaveView> queryleave(String leave_id,Integer currentPage, Integer pageSize) throws Exception {
		PageVo<LeaveView> pagevo = new PageVo<LeaveView>();
		PageInfo<LeaveView> pageinfos = PageHelper.startPage(currentPage, pageSize).doSelectPageInfo(() -> {
			try {
				this.leavemapper.queryleave(leave_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		pagevo.setRows(pageinfos.getList());
		pagevo.setTotal(pageinfos.getTotal());
		return pagevo;
	}*/
	
}
