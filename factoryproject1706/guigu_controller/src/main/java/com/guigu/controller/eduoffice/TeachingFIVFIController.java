package com.guigu.controller.eduoffice;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.domain.marketing.PageInfo;
import com.guigu.service.eduoffice.CuedMenuService;
import com.guigu.service.eduoffice.EmpCourseService;
import com.guigu.service.eduoffice.TeacheringClassesService;
import com.guigu.domain.authority.vo.MenuVO;
import com.guigu.domain.curriculum.Course_section;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.eduoffice.vo.CuedClassesVO;
import com.guigu.domain.eduoffice.vo.StudentVO;
/**
 * 授课业务处理器类
 * @author FIVFI
 *
 */
@Controller
@RequestMapping("/curriculumAndEduoffice")
public class TeachingFIVFIController {
	
	@Autowired
	private CuedMenuService cuedService;
	@Autowired
	private TeacheringClassesService teachingService;
	/**
	 * 通过账号所提供的角色给出相应的菜单
	 * @return
	 */
	@RequestMapping("/queryCuedMenuList")
	public @ResponseBody String queryCuedMenu (HttpServletRequest request, String roleId,String modelId) {
		String msg="yes";
		List<MenuVO> muenlist=this.cuedService.queryMenu_cued(roleId, modelId);
		request.getSession().setAttribute("muenlist", muenlist);
		return msg;
	}
	
	/**
	 * 老师根据自己的账号查询自己所带的班级以及课程
	 * 
	 * @return
	 */
	@RequestMapping("/queryCuedClassListByAccid")
	public @ResponseBody void queryCuedClassListByAccid (HttpServletRequest request,HttpServletResponse response,String accid) {
		List<CuedClassesVO> clist=teachingService.queryCuedClassListByAccid("FIVFI");		
		request.setAttribute("clist", clist);//将lists放到作用域
		try {
			request.getRequestDispatcher("/curriculumAndEduoffice/eduoffice/checkwork.jsp").forward(request, response);
//			response.sendRedirect("/curriculumAndEduoffice/eduoffice/checkwork.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("报错");
		}
		
	}
	
	/**
	 *   通过课程id获取章节
	 * 
	 * @return
	 */
	@RequestMapping("/queryCuedSectionsByid")
	public @ResponseBody LayUiPageInfo queryCuedSectionsByid (int page,int limit,String cinfo_id) {
		return teachingService.queryCuedListByAccid(page,limit,cinfo_id);
		
	}
	
	/**
	 *    通过班级id获取学生
	 * 
	 * @return
	 */
	@RequestMapping("/queryStudentsByCid")
	public @ResponseBody LayUiPageInfo queryStudentsByCid (int page,int limit,String class_id) {
		return teachingService.queryStudentsByCid(page,limit,class_id);
		
	}
}
