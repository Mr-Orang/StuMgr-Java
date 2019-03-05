 package com.guigu.controller.info;



import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guigu.common.info.PageVo;
import com.guigu.domain.info.Stuclass;
import com.guigu.domain.info.StudentInfo;
import com.guigu.domain.info.Studorm;
import com.guigu.service.info.StustuInfoService;


@RestController
public class StustuInfoController {
	@Autowired
	private StustuInfoService stuinfoservice;
	
	//根据学生学号查询学生基本信息 
	@RequestMapping("/querybystuid.action")
	public @ResponseBody StudentInfo querybystuid(String stuid,HttpServletRequest request,HttpServletResponse response){
		stuid="s1001";
		StudentInfo studentInfo=null;
		try {
			 studentInfo= stuinfoservice.querybystuid(stuid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentInfo;
	}
	//根据班级编号查询该班学生基本信息 
		@RequestMapping("/querybyclassid.action")
		public @ResponseBody PageVo<StudentInfo> querybyclassid(StudentInfo studentInfo,Integer page,Integer rows) {
			System.out.println("1");
			String teid="emp4";
			studentInfo.setTeid(teid);
			PageVo<StudentInfo> pageHelpVO=null;
			 try {
				 pageHelpVO=stuinfoservice.querybyclassid(studentInfo, page, rows);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return pageHelpVO;
		}
		//查询班级
				@RequestMapping("/querybyallclass.action")
				public @ResponseBody List<Stuclass> querybyallclass() {
					List<Stuclass> stuclasslist=null;
					try {
						stuclasslist=stuinfoservice.querybyallclass();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(stuclasslist);
					return stuclasslist;
					
				}
				//查询宿舍
				@RequestMapping("/querybyalldorm.action")
				public @ResponseBody List<Studorm> querybyalldorm() {
					List<Studorm> studormlist=null;
					try {
						studormlist=stuinfoservice.querybyalldorm();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(studormlist);
					return 	studormlist;
					
				}
				//修改学生
				@RequestMapping("/updatestudentinfo.action")
				public @ResponseBody String updatestudentinfo(StudentInfo studentinfo) {
					System.out.println("修改"+studentinfo);
					try {
						this.stuinfoservice.updatestudentinfo(studentinfo);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return "修改失败！";
					}
					return "修改成功！";
			}
				//进入修改学生
				@RequestMapping("/querybyupstuid.action")
				public @ResponseBody StudentInfo querybyupstuid(String stuid) {
					StudentInfo s=null;
					try {
						 s=this.stuinfoservice.querybyupstuid(stuid);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return s;
				}
				//删除学生
				@RequestMapping("/deletebystuid.action")
				public @ResponseBody String deletebystuid(String stuid) {
					try {
						this.stuinfoservice.deletebystuid(stuid);;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return "删除失败！";
					}
					return "删除成功！";
			}
}
