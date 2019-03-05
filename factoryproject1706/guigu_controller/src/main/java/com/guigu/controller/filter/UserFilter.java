package com.guigu.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.guigu.domain.authority.vo.AccountVO;
import com.guigu.domain.marketing.Employee;
import com.guigu.domain.materials.Provider;

/**
 * 过滤器 用于临时的session会话请求
 * 
 * @author ExcellentLiuYang
 *
 */
@WebFilter(urlPatterns = "/*")
public class UserFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		// 员工信息
		httpServletRequest.getSession().setAttribute("emplyee", new Employee("emp1", "liuyang", "17434838549",
				"430520199903265210", "男", 20, "否", "湖南省醴陵市", "否", null));
		// 账户信息
		httpServletRequest.getSession().setAttribute("account", new AccountVO("admin", "admin", 0, 1, "emp1"));
		// 供应商信息
		httpServletRequest.getSession().setAttribute("provider", new Provider("providerId_2", "小毛杂货铺", "毛旭文", "maomao",
				"15616213178", "787881867@qq.com", "湖南株洲", null));
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
