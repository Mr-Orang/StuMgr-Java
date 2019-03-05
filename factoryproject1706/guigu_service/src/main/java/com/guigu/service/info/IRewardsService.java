package com.guigu.service.info;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.common.info.ApplyVo;
import com.guigu.common.info.StudentRewardsVo;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.util.PageHelpVO;
/**
 * 学生奖罚业务处理接口  taoming
 * @author Administrator
 *
 */
public interface IRewardsService {

	/**
	 * 根据老师查询他所带班级所有学生的奖励与处罚并分页
	 * @param teachid 老师编号
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	PageHelpVO queryStudentApply(String teachid,Integer page,Integer rows) throws Exception;
	/**
	 * 根据老师编号查询他所带班级的所有学生并分页
	 * @param teachid 老师编号
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	PageHelpVO queryStudentByTeacherid(String teachid,Integer page,Integer rows) throws Exception;
	/**
	 * 添加奖罚信息
	 * @param review_id 推荐人编号
	 * @param rewards_type 奖罚类型
	 * @param stu_id 学生学号
	 * @param rewards_apply_reason 奖罚详情
	 * @return
	 * @throws Exception
	 */
	boolean addRewards(String review_id,String rewards_type,String[] stu_id,String rewards_apply_reason) throws Exception;
	/**
	 * 老师上级查看所有奖罚信息
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	PageHelpVO queryAllApply(Integer page,Integer rows) throws Exception;
	/**
	 * 查询所有未审批的学生申请信息
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	PageHelpVO queryRewardsInfo(Integer page,Integer rows) throws Exception;
	/**
	 * 查询所有未审批的学生申请信息
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	PageHelpVO queryStudentApplyInfo(String rewards_id,Integer page,Integer rows)throws Exception;
	/**
	 * 通过的审批申请
	 * @param Review_id  审批人编号
	 * @param rewards_id  奖惩信息表编号
	 * @return
	 * @throws Exception
	 */
	boolean updateRewards(String Review_id,String rewards_id)throws Exception;
	/**
	 * 不同意的审批
	 * @param Review_id 审批人编号
	 * @param rewards_id 奖惩信息表编号
	 * @param Rewards_reason 不同意的理由
	 * @return
	 * @throws Exception
	 */
	boolean updateRewardsNoAgree(String Review_id,String rewards_id,String Rewards_reason)throws Exception;
	/**
	 * 学生查看自己的奖罚信息并分页处理
	 * @param stuid
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	LayUiPageInfo queryStudentRewardsInfo(String stuid,Integer page,Integer rows)throws Exception;
}
