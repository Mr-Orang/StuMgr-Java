package com.guigu.service.impl.eduoffice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.dao.eduoffice.GiveLessonsMapper;
import com.guigu.domain.eduoffice.Classes;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.eduoffice.vo.CourseInfoVo;
import com.guigu.domain.eduoffice.vo.EmpVo;
import com.guigu.service.eduoffice.GiveLessonsService;
/**
 * 授课业务接口实现类
 * @author zy
 *
 */
@Service
public class GiveLessonsServiceImpl implements GiveLessonsService{
	
	@Autowired
	private GiveLessonsMapper giveLessonsMapper;
	
	/**
	 * 查询授课信息
	 */
	@Override
	public LayUiPageInfo queryGiveLessons(int page, int rows, String tc_name, String tc_cname, String te_name) {
		LayUiPageInfo layUiPageInfo=new LayUiPageInfo();
		Page page1=PageHelper.startPage(page, rows);
		layUiPageInfo.setCode(0);
		layUiPageInfo.setData(this.giveLessonsMapper.queryGiveLessons(tc_name,tc_cname,te_name));
		layUiPageInfo.setCount(page1.getTotal());
		return layUiPageInfo;
	}
	
	/**
	 * 根据课程编号查询可授课的老师
	 */
	@Override
	public List<EmpVo> loadSelectDataByScId(String sc_id) {
		return this.giveLessonsMapper.loadSelectDataByScId(sc_id);
	}
	
	/**
	 * 修改授课老师
	 */
	@Override
	public String editGiveLessonsTeacher(String gl_id, String te_name,String status) {
		try {
			this.giveLessonsMapper.editGiveLessonsTeacher(gl_id, te_name,status);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
	}
	
	/**
	 * 加载班级下拉框数据
	 */
	@Override
	public List<Classes> loadClassSelect() {
		return this.giveLessonsMapper.loadClassSelect();
	}
	
	/**
	 * 根据班级id加载课程下拉框
	 */
	@Override
	public List<CourseInfoVo> loadCourseSelectByTcId(String tc_id) {
		return this.giveLessonsMapper.loadCourseSelectByTcId(tc_id);
	}

	/**
	 * 添加授课信息
	 */
	@Override
	public String addGiveLessons(String class_id, String sc_id, String ter_id) {
		try {
			this.giveLessonsMapper.addGiveLessons(class_id, sc_id, ter_id);
			return "ok";
		} catch (Exception e) {
			return "no";
		}
	}
	
	/**
	 * 结课 修改授课状态
	 */
	@Override
	public String editGiveLessonsStatus(String gl_id) {
		try {
			this.giveLessonsMapper.editGiveLessonsStatus(gl_id);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
	}
	
	
	
}
