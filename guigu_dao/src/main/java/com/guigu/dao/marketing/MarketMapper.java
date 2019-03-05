package com.guigu.dao.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.guigu.domain.marketing.Statistics;
import com.guigu.domain.marketing.StatisticsSale;
import com.guigu.domain.marketing.StatisticsSchool;

/**
 * 市场数据访问接口
 * 
 * @author maomao
 *
 */
@Mapper
public interface MarketMapper {
	/**
	 * 根据员工编号查询（T_STATISTICS_SALE）报表编号
	 * 
	 * @param empID
	 * @return
	 */
	String queryStsID(String empID)throws Exception;

	/**
	 * 根据地区或院校名称（T_STATISTICS_SCHOOL）查询报表编号
	 * 
	 * @param stuSourceArea
	 * @return
	 */
	String queryTstID(String stuSourceArea)throws Exception;

	/**
	 * 当表中没有记录时新增（t_statistics_sale）
	 * 
	 * @param ss
	 */
	void addStatisticsSale(StatisticsSale ss)throws Exception;

	/**
	 * 当表中有记录时修改生源人数 及报名率（t_statistics_sale）
	 * 
	 * @param sts_id
	 */
	void updateStatisticsSale(String sts_id)throws Exception;

	/**
	 * 当表中没有记录时新增（t_statistics_school）
	 * 
	 * @param ss
	 */
	void addStatisticsSchool(StatisticsSchool ss)throws Exception;

	/**
	 * 当表中有记录时修改生源人数 及报名率（t_statistics_school）
	 * 
	 * @param tst_id
	 */
	void updateStatisticsSchool(String tst_id)throws Exception;

	/**
	 * 当生源为报名时修改报名人数及报名率（t_statistics_sale）
	 * 
	 * @param sts_id
	 * @throws Exception
	 */
	void updateSaleEnrollment(String sts_id) throws Exception;

	/**
	 * 当生源为报名时修改报名人数及报名率（t_statistics_school）
	 * 
	 * @param tst_id
	 * @throws Exception
	 */
	void updateSchoolEnrollment(String tst_id) throws Exception;
	/**
	 * 
	 * @return
	 */

	List<StatisticsSchool> querySchool();

	List<Statistics> querySale();

}
