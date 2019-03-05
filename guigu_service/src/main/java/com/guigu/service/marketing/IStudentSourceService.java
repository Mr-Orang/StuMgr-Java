package com.guigu.service.marketing;

import java.util.List;

import com.guigu.common.marketing.StudentSourceAdd;
import com.guigu.common.marketing.StudentSourceHelp;
import com.guigu.domain.marketing.RecruitStatus;
import com.guigu.domain.marketing.StudentSource;
import com.guigu.util.PageHelpVO;

/**
 * 生源业务接口
 * 
 * @author maomao
 *
 */
public interface IStudentSourceService {
	/**
	 * 查询生源信息
	 * 
	 * @param studentSourceHelp
	 * @param page
	 * @param rows
	 * @return PageHelpVO [StudentSource]
	 * @throws Exception
	 */
	PageHelpVO queryStudentSource(StudentSourceHelp studentSourceHelp, Integer page, Integer rows) throws Exception;

	/**
	 * 查询招生状态信息
	 * 
	 * @return 招生状态信息集合
	 * @throws Exception
	 */
	List<RecruitStatus> queryRecruitStatus() throws Exception;

	/**
	 * 新增生源
	 * 
	 * @param studentSourceAdd
	 * @throws Exception
	 */
	void addStudentSource(StudentSourceAdd studentSourceAdd) throws Exception;

	/**
	 * 根据生源编号查询生源基本信息
	 * 
	 * @param tss_id
	 * @return
	 * @throws Exception
	 */
	StudentSource queryStudentSourceByID(String tss_id) throws Exception;

	/**
	 * 修改生源信息
	 * 
	 * @param studentSource
	 * @throws Exception
	 */
	void updateStudentSource(StudentSource studentSource) throws Exception;
}
