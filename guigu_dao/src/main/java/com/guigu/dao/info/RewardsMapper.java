package com.guigu.dao.info;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.common.info.ApplyVo;
import com.guigu.common.info.RewardsInfo;
import com.guigu.common.info.StudentApplyInfo;
import com.guigu.common.info.StudentRewardsPunishInfoVo;
import com.guigu.common.info.StudentRewardsVo;
/**
 * 学校奖罚接口类
 * @author Administrator
 *
 */
import com.guigu.common.info.StudentVo;
public interface RewardsMapper {

	/**
	 * 根据老师查询他所带班级所有学生的奖励与处罚
	 * @param teachid 老师编号
	 * @return
	 * @throws Exception
	 */
    List<StudentRewardsVo> queryStudentApply(String teachid) throws Exception;
    /**
     * 根据老师编号查询他所带班级的所有学生
     * @param teachd 老师编号
     * @return
     * @throws Exception
     */
    List<StudentVo> queryStudentByTeacherid(String teachid) throws Exception;
    /**
     * 添加学生奖罚信息
     * @param review_id 举荐人编号
     * @return
     * @throws Exception
     */
    boolean addRewards(String review_id)throws Exception;
    /**
     * 添加学生奖罚详情
     * @param rewards_type 奖罚类型
     * @param stu_id 学生编号
     * @param rewards_apply_reason 奖罚原因
     * @return
     * @throws Exception
     */
    boolean addrewardsdetails(@Param("rewards_type")String rewards_type,@Param("stu_id")String stu_id,@Param("rewards_apply_reason")String rewards_apply_reason)throws Exception;
    /**
     * 老师上级查看所有奖罚信息
     * @return
     * @throws Exception
     */
    List<ApplyVo> queryAllApply() throws Exception;
    /**
     * 查询所有未审批的学生申请信息
     * @return
     * @throws Exception
     */
    List<RewardsInfo> queryRewardsInfo() throws Exception;
    /**
     * 查询所有未审批的学生申请信息
     * @return
     * @throws Exception
     */
    List<StudentApplyInfo> queryStudentApplyInfo(String rewards_id) throws Exception;
    /**
     * 审批通过的申请
     * @param Review_id 审批人编号
     * @param rewards_id 奖惩信息表编号
     * @return
     * @throws Exception
     */
    boolean updateRewards(@Param("Review_id")String Review_id,@Param("rewards_id")String rewards_id) throws Exception;
   /**
    * 不同意的审批
    * @param Review_id 审批人编号
    * @param rewards_id 奖惩信息表编号
    * @param Rewards_reason 不同意的理由
    * @return
    * @throws Exception
    */
    boolean updateRewardsNoAgree(@Param("Review_id")String Review_id,@Param("rewards_id")String rewards_id,@Param("Rewards_reason")String Rewards_reason) throws Exception;
    /**
     * 学生查看自己的奖罚信息
     * @param stuid 学生编号
     * @return
     * @throws Exception
     */
    List<StudentRewardsPunishInfoVo> queryStudentRewardsInfo(String stuid)throws Exception;
}
