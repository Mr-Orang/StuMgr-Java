package com.guigu.dao.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.guigu.common.marketing.BoardHelp;
import com.guigu.common.marketing.BoardView;
import com.guigu.domain.marketing.Classes;
import com.guigu.domain.marketing.Dorm;
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
	 * @return 查询可添加住宿的宿舍集合
	 * @throws Exception
	 */
	List<Dorm> queryAbleChangeDorm(@Param("classID") String classID, @Param("tdmID") String tdmID) throws Exception;

	/**
	 * 查询所有宿舍
	 * 
	 * @return 宿舍集合
	 * @throws Exception
	 */
	List<Dorm> queryDorm() throws Exception;
}
