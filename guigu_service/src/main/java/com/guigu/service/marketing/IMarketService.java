package com.guigu.service.marketing;

import java.util.List;

import com.guigu.domain.marketing.Employee;
import com.guigu.domain.marketing.PageInfo;
import com.guigu.domain.marketing.StatisticsSale;
import com.guigu.domain.marketing.StatisticsSchool;
import com.guigu.util.PageHelpVO;


public interface IMarketService {
	/**
	 * 查询所有市场人员统计招生情况
	 * @return
	 * @throws Exception
	 */
	PageHelpVO querySale(int page,int rows) throws Exception;
	 
	
	/**
	 * 查询生源地区/院校统计招生情况
	 * @return
	 * @throws Exception
	 */
	public  PageHelpVO querySchool(int page, int rows) throws Exception;
	
	
	
}
