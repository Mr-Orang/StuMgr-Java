package com.guigu.dao.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.guigu.common.marketing.DormMessage;
import com.guigu.domain.marketing.Dorm;
import com.guigu.domain.marketing.DormFloor;

/**
 * 宿舍信息查询mapper类
 * @author lijianghua
 *
 */
@Mapper
public interface DormMessageMapper {
	/**
	 * 查询宿舍信息
	 * @return
	 * @throws Exception
	 */
	List<DormMessage> quereyDormMessages(DormMessage dorm) throws Exception;
	/**
	 * 查询宿舍楼层信息
	 * @return
	 * @throws Exception
	 */
	List<DormFloor> queryDromFloor() throws Exception;
	/**
	 * 添加宿舍信息
	 * @param dorm
	 * @throws Exception
	 */
	void addDormMessages(Dorm dorm) throws Exception;
	/**
	 * 查询宿舍床位
	 * @return
	 * @throws Exception
	 */
	List<DormFloor> queryDromFloorBeD() throws Exception;

	
}
