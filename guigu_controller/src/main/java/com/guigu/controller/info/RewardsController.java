package com.guigu.controller.info;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.guigu.common.info.ApplyVo;
import com.guigu.common.info.StudentRewardsVo;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.service.info.IRewardsService;
import com.guigu.util.PageHelpVO;
/**
 * 学生奖罚处理器类
 * @author Administrator
 *
 */
@RestController
public class RewardsController {

	@Autowired
	private IRewardsService rewardsservice;
	
	//根据老师查询他所带班级所有学生的奖励与处罚 
	@RequestMapping("queryStudent.action")
	public PageHelpVO queryStudentApply(Integer page,Integer rows){
		PageHelpVO ph=null;
		try {
			ph=rewardsservice.queryStudentApply("emp4"/*session参数*/,page,rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ph;
	}
	//根据老师编号查询学生
	@RequestMapping("queryStudentByTeacherid.action")
	public PageHelpVO queryStudentByTeacherid(Integer page,Integer rows){
		PageHelpVO ph=null;
		try {
			ph=rewardsservice.queryStudentByTeacherid("emp4"/*session参数*/,page,rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ph;
	}
	//添加奖罚申请
	@RequestMapping("addRewardsPunish.action")
	public String addrewards(String rewards_type,String stuidArry,String textal){
		String[] stuidary=stuidArry.split(",");
		String msg="系统出错,请联系管理员";
		try {
			if(rewardsservice.addRewards("emp4"/*session参数*/, rewards_type, stuidary, textal)){
				msg="申请成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	//领导对奖罚申请进行审批Leader
	@RequestMapping("examineApprove.action")
	public PageHelpVO examineApprove(Integer page,Integer rows){
		PageHelpVO ph=null;
		try {
			ph=rewardsservice.queryAllApply(page,rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ph;
	}
	//查询所有未审批的申请单信息 
	@RequestMapping("queryRewardsInfo.action")
	public PageHelpVO queryRewardsInfo(Integer page,Integer rows){
		PageHelpVO ph=null;
		try {
			ph=rewardsservice.queryRewardsInfo(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ph;
	}
	//查询所有未审批的学生申请信息
	@RequestMapping("queryStudentApplyInfo.action")
	public PageHelpVO queryStudentApplyInfo(String rewardsid,Integer page,Integer rows){
		PageHelpVO ph=null;
		try {
			ph=rewardsservice.queryStudentApplyInfo(rewardsid,page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ph;
	}
	//审核通过
	@RequestMapping("examineAdopt.action")
	public String examineAdopt(String rewards_id){
		String msg="系统出错,请联系管理员";
		try {
			if(rewardsservice.updateRewards("emp3"/*session参数*/,rewards_id)){
				msg="审核通过";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	//审批不同意
	@RequestMapping("noAgreeExamine.action")
	public String noAgreeExamine(String rewardsid,String Rewards_reason){
		System.out.println(rewardsid+","+Rewards_reason);
		String msg="系统出错,请联系管理员";
		try {
			if(rewardsservice.updateRewardsNoAgree("emp3"/*session参数*/,rewardsid,Rewards_reason)){
				msg="审核通过";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	//学生查看自己的奖罚信息
	@RequestMapping("queryByStudentId.action")
	public LayUiPageInfo queryByStudentId(Integer page,Integer limit){
		LayUiPageInfo ph=null;
		try {
			ph=rewardsservice.queryStudentRewardsInfo("s1001", page, limit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ph;
	}
}
 