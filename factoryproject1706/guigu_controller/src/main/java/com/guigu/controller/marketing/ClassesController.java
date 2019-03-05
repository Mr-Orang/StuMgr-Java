package com.guigu.controller.marketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.marketing.StudentSourceView;
import com.guigu.domain.info.StudentInfo;
import com.guigu.domain.marketing.Classes;
import com.guigu.domain.marketing.Menu;
import com.guigu.service.marketing.IClassesService;
import com.guigu.service.marketing.IMarketService;
import com.guigu.util.PageHelpVO;

@RestController
@RequestMapping("/Class")
public class ClassesController {
  @Autowired
  private IClassesService classeservice;
  @RequestMapping("/queryJoinClass")
  //查询s1未满班的班级
  public List<Menu> queryJoinClass(){
	  List<Menu> listmenu=null;
	try {
		listmenu = this.classeservice.queryJoinClass();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	  return listmenu;
  }
  @RequestMapping("/queryStudentSource")
  //查询以为报名或预座的生源信息
  public  PageHelpVO queryStudentSource(Integer page,Integer rows){
	 List<StudentSourceView> studensoutceview=null;
	 PageHelpVO pagevo=new PageHelpVO();
	try {
		  Page pages=PageHelper.startPage(page, rows, true);
		  studensoutceview = this.classeservice.queryStudentSource();
		  pagevo.setRows(studensoutceview);
		  pagevo.setTotal(pages.getTotal());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return pagevo;
  }
  @RequestMapping("queryClass")
  public Classes queryClass(String tc_id){
	  	Classes classes=null;
	  try {
		 classes=this.classeservice.queryClass(tc_id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return classes;
  }
  @RequestMapping("queryStudentById")
  public StudentSourceView queryStudentById(String tss_id){
	  StudentSourceView studentsourcesiew=null;
	try {
		studentsourcesiew = this.classeservice.queryStudentById(tss_id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return studentsourcesiew;
  }
  //学生入班报名
  @RequestMapping("saveJoinClass")
  public String  saveJoinClass(String rouid,String classid,String sts_id,String apply,String stuname,String stuphone,String address,String parphone,String stusex,String stubirthday,String stucid,String school){
	  StudentInfo studentInfo=new StudentInfo("", stuname, stusex, stubirthday, stucid, stuphone, parphone, address, classid, "", 0, school, rouid,"");
	  try {
		  String applyid="";
		  if(apply.equals("报名")){
			  applyid="trs4";
		  }else{
			  applyid="trs5";
		  }
		  
		  String addrss=this.classeservice.queryTstID(address);
		  String emp=this.classeservice.queryStsID(sts_id);
		  this.classeservice.updateSaleEnrollment(emp);
		  this.classeservice.updateSchoolEnrollment(addrss);
		  this.classeservice.updateApply(applyid, rouid);
		  this.classeservice.saveStudent(studentInfo);
		  this.classeservice.updetaStudent(classid);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	  
	  return "入班操作成功！！";
	  
  }
}
