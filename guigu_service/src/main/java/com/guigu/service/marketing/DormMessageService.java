package com.guigu.service.marketing;

import java.util.List;

import com.guigu.common.marketing.DormMessage;
import com.guigu.common.marketing.StudentConsult;
import com.guigu.domain.marketing.Dorm;
import com.guigu.domain.marketing.DormFloor;
import com.guigu.util.PageHelpVO;
/**
 * 宿舍信息查询service类
 * @author lijianghua
 *
 */
public interface DormMessageService {

	/**
	 * 查询宿舍信息
	 * @return
	 * @throws Exception
	 */
	PageHelpVO quereyDormMessages(DormMessage dorm,int page,int rows) throws Exception;
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
