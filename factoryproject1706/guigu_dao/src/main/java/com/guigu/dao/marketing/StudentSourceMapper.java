package com.guigu.dao.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.guigu.common.marketing.StudentConsult;
import com.guigu.common.marketing.StudentSourceAdd;
import com.guigu.common.marketing.StudentSourceHelp;
import com.guigu.domain.marketing.RecruitStatus;
import com.guigu.domain.marketing.StudentSource;

/**
 * 生源数据访问接口
 * 
 * @author maomao
 *
 */
@Mapper
public interface StudentSourceMapper {
	/**
	 * 查询生源信息
	 * 
	 * @param studentSourceHelp
	 * @return 生源信息集合
	 * @throws Exception
	 */
	List<StudentSource> queryStudentSource(StudentSourceHelp studentSourceHelp) throws Exception;

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
	/**
	 * 修改生源状态  lijianghua
	 * @param stu
	 * @throws Exception
	 */
	void updateStudentSourceStatus(String stu) throws Exception;

}
