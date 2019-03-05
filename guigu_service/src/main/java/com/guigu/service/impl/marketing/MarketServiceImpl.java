package com.guigu.service.impl.marketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.dao.marketing.MarketMapper;
import com.guigu.domain.marketing.Employee;
import com.guigu.domain.marketing.PageInfo;
import com.guigu.domain.marketing.Statistics;
import com.guigu.domain.marketing.StatisticsSale;
import com.guigu.domain.marketing.StatisticsSchool;
import com.guigu.service.marketing.IMarketService;
import com.guigu.util.PageHelpVO;

@Service
public class MarketServiceImpl implements IMarketService {
	
	@Autowired
	private MarketMapper marketMapper;
	
	/**
	 * 查询所有市场人员统计招生情况
	 */
	@Override
	public PageHelpVO querySale(int page, int rows) throws Exception {
		// TODO Auto-generated method stub
		PageHelpVO pageinfo = new PageHelpVO();
		Page page2 = PageHelper.startPage(page, rows);
		List<Statistics> list = this.marketMapper.querySale();
		System.out.println(list);
		pageinfo.setRows(list);
		pageinfo.setTotal(page2.getTotal());
		return pageinfo;
	}
	
	/**
	 * 查询生源地区/院校统计招生情况
	 */
	@Override
	public PageHelpVO querySchool(int page, int rows) throws Exception {
		// TODO Auto-generated method stub
		PageHelpVO pageinfo = new PageHelpVO();
		Page page3 = PageHelper.startPage(page, rows);
		List<StatisticsSchool> list = this.marketMapper.querySchool();
		pageinfo.setRows(list);
		pageinfo.setTotal(page3.getTotal());
		return pageinfo;
	}

}
