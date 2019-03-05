package com.guigu.service.info.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.info.ApplyVo;
import com.guigu.common.info.StudentRewardsVo;
import com.guigu.dao.info.RewardsMapper;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.service.info.IRewardsService;
import com.guigu.util.PageHelpVO;
/**
 * 学生奖罚业务处理接口实现类
 * @author Administrator
 *
 */
@Service
public class RewardsServiceImpl implements IRewardsService {

	@Autowired
	private RewardsMapper rewardsmapper;

	@Override
	public PageHelpVO queryStudentApply(String teachid,Integer page,Integer rows) throws Exception {
		// 根据老师查询他所带班级所有学生的奖励与处罚
		PageHelpVO ph=new PageHelpVO();
		Page p=PageHelper.startPage(page,rows,true);
		ph.setRows(rewardsmapper.queryStudentApply(teachid));
		ph.setTotal(p.getTotal());
		return ph;
	}

	@Override
	public PageHelpVO queryStudentByTeacherid(String teachid, Integer page, Integer rows) throws Exception {
		// 根据老师编号查询他所带班级的所有学生并分页
		PageHelpVO ph=new PageHelpVO();
		Page p=PageHelper.startPage(page,rows,true);
		ph.setRows(rewardsmapper.queryStudentByTeacherid(teachid));
		ph.setTotal(p.getTotal());
		return ph;
	}

	@Override
	public boolean addRewards(String review_id, String rewards_type, String[] stu_id, String rewards_apply_reason)
			throws Exception {
		//添加奖罚信息
		boolean flg=false;
		boolean fl1=rewardsmapper.addRewards(review_id);
		boolean fl2 = false;
		for(String stu:stu_id){
			fl2=rewardsmapper.addrewardsdetails(rewards_type, stu, rewards_apply_reason);
			fl2=true;
		}
		if(fl1==true&&fl2==true){
			flg=true;
		}
		return flg;
	}

	@Override
	public PageHelpVO queryAllApply(Integer page,Integer rows) throws Exception {
		// 老师上级查看所有奖罚信息
		PageHelpVO ph=new PageHelpVO();
		Page p=PageHelper.startPage(page,rows,true);
		ph.setRows(rewardsmapper.queryAllApply());
		ph.setTotal(p.getTotal());
		return ph;
	}

	@Override
	public PageHelpVO queryRewardsInfo(Integer page, Integer rows) throws Exception {
		// 查询所有未审批的学生申请信息
		PageHelpVO ph=new PageHelpVO();
		Page p=PageHelper.startPage(page,rows,true);
		ph.setRows(rewardsmapper.queryRewardsInfo());
		ph.setTotal(p.getTotal());
		return ph;
	}
	
	@Override
	public PageHelpVO queryStudentApplyInfo(String rewards_id,Integer page, Integer rows) throws Exception {
		// 查询所有未审批的学生申请信息
		PageHelpVO ph=new PageHelpVO();
		Page p=PageHelper.startPage(page,rows,true);
		ph.setRows(rewardsmapper.queryStudentApplyInfo(rewards_id));
		ph.setTotal(p.getTotal());
		return ph;
	}

	@Override
	public boolean updateRewards(String Review_id, String rewards_id) throws Exception {
		// 审批通过的申请
		return rewardsmapper.updateRewards(Review_id, rewards_id);
	}

	@Override
	public boolean updateRewardsNoAgree(String Review_id, String rewards_id,String Rewards_reason) throws Exception {
		//不同意的审批
		return rewardsmapper.updateRewardsNoAgree(Review_id, rewards_id,Rewards_reason);
	}

	@Override
	public LayUiPageInfo queryStudentRewardsInfo(String stuid, Integer page, Integer rows) throws Exception {
		// 学生查看自己的奖罚信息并分页处理
		LayUiPageInfo layUiPageInfo=new LayUiPageInfo();
		layUiPageInfo.setCode(0);
		Page page1=PageHelper.startPage(page, rows);
		layUiPageInfo.setData(rewardsmapper.queryStudentRewardsInfo(stuid));
		layUiPageInfo.setCount(page1.getTotal());
		return layUiPageInfo;
	}
}
