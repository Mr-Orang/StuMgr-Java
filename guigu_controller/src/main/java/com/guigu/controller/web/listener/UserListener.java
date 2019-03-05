package com.guigu.controller.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器
 * 
 * @author ExcellentLiuYang
 *
 */
@WebListener
public class UserListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// System.out.println("初始项目");
		// sce.getServletContext().setAttribute("emplyee",
		// new Employee("emp1", "liuyang", "17434838549", "430520199903265210", "男", 20,
		// "否", "湖南省醴陵市", "否"));
		// sce.getServletContext().setAttribute("account", new AccountVO("admin",
		// "admin", 0, 1, "emp1"));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// System.out.println("销毁项目");
	}
}
