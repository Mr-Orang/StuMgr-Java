package com.guigu.controller.materials.loginlogout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.domain.authority.vo.AccountVO;
import com.guigu.domain.marketing.Employee;

import javax.servlet.http.HttpServletRequest;

/**
 * 注销处理器
 */
@Controller
@RequestMapping("/loginAndLogoutController")
public class LogoutController {
	// 注销
	@RequestMapping("/loginOut")
	public void loginOut(HttpServletRequest request) {
		System.out.println("请求成功");
		// 注销账户信息表
		//request.getSession().removeAttribute("account");
		// 注销员工信息表
		//request.getSession().removeAttribute("emplyee");
		// 注销供应商信息表
		//request.getSession().removeAttribute("provider");
		// 返回到登录视图
		// ModelAndView modelAndView = new ModelAndView();
		// modelAndView.setViewName("redirect:/");
		// return modelAndView;
		Employee employee = (Employee) request.getSession().getAttribute("emplyee");
		System.out.println(employee.getTe_id());
		AccountVO account = (AccountVO) request.getSession().getAttribute("account");
		System.out.print(account.getAccount());
	}

	// 标识方法->验证session
	// @RequestMapping("/VerifyTheLogin.action")
	// public void VerifyTheLogin() {
	// }
}
