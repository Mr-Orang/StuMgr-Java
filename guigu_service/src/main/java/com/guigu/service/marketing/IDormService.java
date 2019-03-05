package com.guigu.service.marketing;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.guigu.common.marketing.BoardHelp;
import com.guigu.common.marketing.BoardNotView;
import com.guigu.domain.info.Student;
import com.guigu.domain.marketing.Classes;
import com.guigu.domain.marketing.Dorm;
import com.guigu.domain.marketing.DormType;
import com.guigu.domain.marketing.Migrate;
import com.guigu.util.PageHelpVO;

/**
 * 宿舍业务接口
 * 
 * @author maomao
 *
 */
public interface IDormService {
	/**
	 * 查询已安排的住宿信息
	 * 
	 * @param boardHelp
	 * @param page
	 * @param rows
	 * @return PageHelpVO(已安排的住宿信息集合)
	 * @throws Exception
	 */
	PageHelpVO queryBoard(BoardHelp boardHelp, Integer page, Integer rows) throws Exception;

	/**
	 * 查询班级信息
	 * 
	 * @return 班级信息集合
	 * @throws Exception
	 */
	List<Classes> queryClass() throws Exception;

	/**
	 * 查询更换宿舍类型
	 * 
	 * @return 更换宿舍类型集合
	 * @throws Exception
	 */
	List<Migrate> queryMigrate() throws Exception;

	/**
	 * 查询可添加住宿的宿舍
	 * 
	 * @param classID
	 * @param tdmID
	 * @param sex
	 * @return 可添加住宿的宿舍集合
	 * @throws Exception
	 */
	List<Dorm> queryAbleChangeDorm(String classID, String tdmID, String sex) throws Exception;

	/**
	 * 查询所有宿舍
	 * 
	 * @return 宿舍集合
	 * @throws Exception
	 */
	List<Dorm> queryDorm() throws Exception;

	/**
	 * 查询未完全安排宿舍的班级学生
	 * 
	 * @param classID
	 * @param sex
	 * @return
	 * @throws Exception
	 */
	PageHelpVO queryBoardNoOK(String classID, String sex, Integer page, Integer rows) throws Exception;

	/**
	 * 新增住宿信息
	 * 
	 * @param stu_ids
	 * @param tdm_ids
	 * @throws Exception
	 */
	void addBoard(String[] stu_ids, String tdm_ids) throws Exception;
	/**
	 * 修改学生住宿信息
	 * 
	 * @param stu_ids
	 * @param tdm_ids
	 * @throws Exception
	 */
	// void updateStudentDorm(String[] stu_ids, String[] tdm_ids) throws
	// Exception;

	/**
	 * 查询未完全安排宿舍的班级
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<Classes> queryNotBoardClass(HttpServletRequest request) throws Exception;

	/**
	 * 查询宿舍类型
	 * 
	 * @return
	 * @throws Exception
	 */
	List<DormType> queryDormType() throws Exception;

	/**
	 * 查询宿舍当前可住人数
	 * 
	 * @param tdm_id
	 * @return
	 * @throws Exception
	 */
	int queryDormAbleNumber(String tdm_id) throws Exception;

	/**
	 * 查询当前老师所带的班级
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<Classes> queryClassByEmpID(HttpServletRequest request) throws Exception;

	/**
	 * 查询当前老师所带的班级住的宿舍
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<Dorm> queryDormByEmpID(HttpServletRequest request) throws Exception;

	/**
	 * 根据学生编号查询是否有未审批的申请
	 * 
	 * @param stuID
	 * @return
	 * @throws Exception
	 */
	int queryHaveApplyByStuID(String stuID) throws Exception;

	/**
	 * 根据学生编号查询当前宿舍编号
	 * 
	 * @param stuID
	 * @return
	 * @throws Exception
	 */
	String queryDormIDByStuID(String stuID) throws Exception;
}
