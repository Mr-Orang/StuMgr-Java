package com.guigu.dao.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.guigu.common.marketing.BoardHelp;
import com.guigu.common.marketing.BoardNotView;
import com.guigu.common.marketing.BoardView;
import com.guigu.domain.info.Student;
import com.guigu.domain.marketing.Classes;
import com.guigu.domain.marketing.Dorm;
import com.guigu.domain.marketing.DormType;
import com.guigu.domain.marketing.Migrate;

/**
 * 宿舍数据访问接口
 * 
 * @author maomao
 *
 */
@Mapper
public interface DormMapper {
	/**
	 * 查询已安排的住宿信息
	 * 
	 * @param boardHelp
	 * @return 已安排的住宿信息集合
	 * @throws Exception
	 */
	List<BoardView> queryBoard(BoardHelp boardHelp) throws Exception;

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
	List<Dorm> queryAbleChangeDorm(@Param("classID") String classID, @Param("tdmID") String tdmID,
			@Param("sex") String sex) throws Exception;

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
	 * @return List<BoardNotView>
	 * @throws Exception
	 */
	List<BoardNotView> queryBoardNoOK(@Param("classID") String classID, @Param("sex") String sex) throws Exception;

	/**
	 * 新增住宿信息
	 * 
	 * @param stuList
	 * @throws Exception
	 */
	void addBoard(List<Student> stuList) throws Exception;

	/**
	 * 修改学生住宿信息
	 * 
	 * @param stuList
	 * @throws Exception
	 */
	void updateStudentDorm(List<Student> stuList) throws Exception;

	/**
	 * 查询未完全安排宿舍的班级
	 * 
	 * @param empID
	 * @return
	 * @throws Exception
	 */
	List<Classes> queryNotBoardClass(String empID) throws Exception;

	/**
	 * 查询宿舍类型
	 * 
	 * @return
	 * @throws Exception
	 */
	List<DormType> queryDormType() throws Exception;

	/**
	 * 当新增或更换宿舍时修改宿舍实住人数
	 * 
	 * @param tdm_nowBed
	 * @param tdm_id
	 * @throws Exception
	 */
	void updateDormNumber(@Param("tdm_nowBed") int tdm_nowBed, @Param("tdm_id") String tdm_id) throws Exception;

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
	 * @param empID
	 * @return
	 * @throws Exception
	 */
	List<Classes> queryClassByEmpID(String empID) throws Exception;

	/**
	 * 查询当前老师所带的班级住的宿舍
	 * 
	 * @param empID
	 * @return
	 * @throws Exception
	 */
	List<Dorm> queryDormByEmpID(String empID) throws Exception;

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
