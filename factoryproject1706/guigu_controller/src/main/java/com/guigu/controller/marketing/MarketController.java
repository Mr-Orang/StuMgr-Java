package com.guigu.controller.marketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guigu.domain.marketing.Employee;
import com.guigu.domain.marketing.PageInfo;
import com.guigu.domain.marketing.StatisticsSale;
import com.guigu.domain.marketing.StatisticsSchool;
import com.guigu.service.marketing.IMarketService;
import com.guigu.util.PageHelpVO;

@RestController
public class MarketController {
	
	@Autowired
	private IMarketService marketService;
	
	/**
	 * 查询所有市场人员统计招生情况
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/querySale")
	public PageHelpVO querySale(int page, int rows) {
		PageHelpVO pageinfo = null;
		try {
			pageinfo = this.marketService.querySale(page, rows);
			System.out.println(pageinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}
	
	/**
	 * 查询生源地区/院校统计招生情况
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/querySchool")
	public PageHelpVO querySchool(int page, int rows) {
		PageHelpVO pageinfo = null;
		try {
			pageinfo = this.marketService.querySchool(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}
}
