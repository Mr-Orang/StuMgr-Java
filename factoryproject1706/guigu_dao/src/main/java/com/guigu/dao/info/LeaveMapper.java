package com.guigu.dao.info;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.guigu.domain.info.LeaveView;
@Mapper
public interface LeaveMapper {
	/**
	 * 根据id查询所有请假信息
	 * @param stu_id
	 * @return
	 * @throws Exception
	 */
	List<LeaveView> queryleave(String stu_id) throws Exception;
	/**
	 * 根据员工编号查询出该员工所带班级的学生请假信息
	 * @param te_id
	 * @return
	 * @throws Exception
	 */
	List<LeaveView> approveleave(String te_id) throws Exception;
	/**
	 * 老师查询请假id查询请假信息
	 * @param leave_id
	 * @return
	 * @throws Exception
	 */
	LeaveView leavexingxi(String leave_id) throws Exception;
	/**
	 * 审批数据
	 * @param leaveview
	 * @throws Exception
	 */
	void shenpibaocun(LeaveView leaveview) throws Exception;
	/**
	 * 根据id查询出所有请假人的详细数据
	 * @param leave_id
	 * @return
	 * @throws Exception
	 */
	List<LeaveView> leavexiangxi(String te_id) throws Exception;
	/**
	 * 查询请假超过5天并且老师意见审批通过的请假数据
	 * @param te_id
	 * @return
	 * @throws Exception
	 */
	List<LeaveView> directorshenpi(String te_id) throws Exception;
	
	/**
	 * 主任查询请假id查询请假信息
	 * @param leave_id
	 * @return
	 * @throws Exception
	 */
	LeaveView leavexingxi2(String leave_id) throws Exception;
	/**
	 * 主任审批数据
	 * @param leaveview
	 * @throws Exception
	 */
	void shenpibaocun2(LeaveView leaveview) throws Exception;
	/**
	 * 主任审批超过5天详细数据
	 * @param te_id
	 * @return
	 * @throws Exception
	 */
	List<LeaveView> leavexiangxi2(String te_id) throws Exception;
	
	
}
