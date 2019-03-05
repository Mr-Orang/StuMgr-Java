package com.guigu.service.info;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.common.info.Outschool_money;
import com.guigu.common.info.Outschool_studentinfo;
import com.guigu.common.info.StuOutschool;
import com.guigu.domain.authority.vo.AccountVO;
import com.guigu.util.PageHelpVO;

public interface IOutschoolService {

	/**
	 * 查询学生退学信息 
	 * @return
	 */
	PageHelpVO queryoutschool(Integer page, Integer rows);
	/**
	 * 学生退学缴费详情
	 * @return
	 */
	List<Outschool_money> queryoutschool_money(String stu_id);
	/**
	 * 审批获取学生退学信息审批状态和不同意原因
	 * @param stu_id
	 * @return
	 */
	List<StuOutschool> querystatus_reson(String stu_id);
	/**
	 * 对学生退学进行审批
	 * @param sp_user
	 * @param sp_yes
	 * @param text_no
	 * @param stu_id
	 * @return
	 */
	int updatetoutschool(@Param("review_use")String review_use,@Param("sp_yes")int sp_yes,@Param("text_no")String text_no,@Param("stu_id")String stu_id);
	/**
	 * 查询所有在班学生信息
	 * @return
	 */
	PageHelpVO queryoutstudentinfo(Integer page, Integer rows);
	/**
	 * 查询最后一个退学单编号
	 * @return
	 */
	List<StuOutschool> queryoutid();
	/**
	 * 报存申请退学单
	 * @param dropout_id
	 * @param stu_id
	 * @param reason
	 * @return
	 */
	int saveoutschool(@Param("dropout_id")String dropout_id,@Param("stu_id")String stu_id,@Param("reason")String reason);
	/**
	 * 修改学生信息在读状态
	 * @param stu_id
	 * @return
	 */
	int updatestudentout(@Param("stu_id")String stu_id);
}
