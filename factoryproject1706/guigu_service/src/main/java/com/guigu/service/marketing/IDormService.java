package com.guigu.service.marketing;

import java.util.List;

import com.guigu.common.marketing.BoardHelp;
import com.guigu.domain.marketing.Classes;
import com.guigu.domain.marketing.Dorm;
import com.guigu.domain.marketing.Migrate;
import com.guigu.util.PageHelpVO;

/**
 * 宿舍业务接口
 * @author maomao
 *
 */
public interface IDormService {
	/**
	 * 查询已安排的住宿信息
	 * @param boardHelp
	 * @param page
	 * @param rows
	 * @return PageHelpVO(已安排的住宿信息集合)
	 * @throws Exception
	 */
	PageHelpVO queryBoard(BoardHelp boardHelp,Integer page,Integer rows) throws Exception;
	
	
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
	List<Dorm> queryAbleChangeDorm(String classID, String tdmID) throws Exception;
	
	/**
	 * 查询所有宿舍
	 * 
	 * @return 宿舍集合
	 * @throws Exception
	 */
	List<Dorm> queryDorm() throws Exception;
}
