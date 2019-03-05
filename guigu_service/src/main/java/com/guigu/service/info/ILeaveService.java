package com.guigu.service.info;


import java.util.List;

import com.guigu.common.info.PageVo;
import com.guigu.domain.info.LeaveView;

public interface ILeaveService {
	 /**
	  * service层根据id查询所有请假信息并且分页
	  * @param leave_id
	  * @param currentPage
	  * @param pageSize
	  * @return
	  * @throws Exception
	  */
	/* PageVo<LeaveView> queryleave(String stu_id,Integer currentPage,Integer pageSize) throws Exception;*/
	List<LeaveView> queryleave(String stu_id) throws Exception;
	/**
	 * service层根据员工编号查询出该员工所带班级的学生请假信息
	 * @param stu_id
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageVo<LeaveView> approveleave(String te_id,Integer currentPage,Integer pageSize) throws Exception;
	/**
	 * service查询请假id查询请假信息
	 * @param leave_id
	 * @return
	 * @throws Exception
	 */
	LeaveView leavexingxi(String leave_id) throws Exception;
	/**
	 * service层审批数据
	 * @param leaveview
	 * @throws Exception
	 */
	void shenpibaocun(LeaveView leaveview) throws Exception;
	/**
	 * service层根据id查询出所有请假人的详细
	 * @param te_id
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageVo<LeaveView> leavexiangxi(String te_id,Integer currentPage,Integer pageSize) throws Exception;
	/**
	 * service层查询请假超过5天并且老师意见审批通过的请假数据
	 * @param te_id
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageVo<LeaveView> directorshenpi(String te_id,Integer currentPage,Integer pageSize) throws Exception;
	/**
	 * service层主任查询请假id查询请假信息
	 * @param leave_id
	 * @return
	 * @throws Exception
	 */
	LeaveView leavexingxi2(String leave_id) throws Exception;
	
	/**
	 * service层主任审批数据
	 * @param leaveview
	 * @throws Exception
	 */
	void shenpibaocun2(LeaveView leaveview) throws Exception;
	/**
	 * service层 主任审批超过5天详细数据
	 * @param te_id
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageVo<LeaveView> leavexiangxi2(String te_id,Integer currentPage,Integer pageSize) throws Exception;
	
}
