package com.guigu.service.impl.curriculum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.dao.curriculum.CourseInfoMapper;
import com.guigu.domain.curriculum.vo.Course_addInfo;
import com.guigu.domain.curriculum.vo.Course_detailInfo;
import com.guigu.domain.curriculum.vo.Course_search;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.service.curriculum.CourseInfoService;
/**
 * 课程信息业务接口实现类
 * @author zy
 *
 */
@Service
public class CourseInfoServiceImpl implements CourseInfoService{
	
	@Autowired
	private CourseInfoMapper courseInfoMapper;

	/**
	 * 加载下拉框课程数据
	 */
	@Override
	public List<CourseInfoMapper> loadSelectCourseInfo(String emp_id) {
		return this.courseInfoMapper.loadSelectCourseInfoByEmpId(emp_id);
	}

	/**
	 * 查询所有课程显示信息
	 */
	@Override
	public LayUiPageInfo queryAllCourseInfo(int page,int rows,Course_search c_search) {
		LayUiPageInfo layUiPageInfo=new LayUiPageInfo();
		layUiPageInfo.setCode(0);
		Page page1=PageHelper.startPage(page, rows);
		layUiPageInfo.setData(this.courseInfoMapper.queryAllCourseInfo(c_search));
		layUiPageInfo.setCount(page1.getTotal());
		return layUiPageInfo;
	}
	
	/**
	 * 根据课程编号查询出该课程所有信息
	 */
	@Override
	public Course_detailInfo queryCourseInfoById(String te_cid) {
		return this.courseInfoMapper.queryCourseInfoById(te_cid);
	}
	
	/**
	 * 根据课程编号查询该课程所有章节信息
	 */
	@Override
	public LayUiPageInfo querySectionsByCourseId(int page,int rows,String te_cid) {
		LayUiPageInfo layUiPageInfo=new LayUiPageInfo();
		layUiPageInfo.setCode(0);
		Page page1=PageHelper.startPage(page, rows);
		layUiPageInfo.setData(this.courseInfoMapper.querySectionsByCourseId(te_cid));
		layUiPageInfo.setCount(page1.getTotal());
		return layUiPageInfo;
	}

	
	/**
	 * 
	 *删除课程（逻辑删除，修改课程状态） 
	 */
	public void deleteCourseById(String tc_cid) throws Exception {
		this.courseInfoMapper.deleteCourseById(tc_cid);
	}

	/**
	 * 根据客户端提交的课程信息进行修改
	 */
	@Override
	public void updateCourseInfoById(Course_detailInfo c_d) throws Exception {
		this.courseInfoMapper.updateCourseInfoById(c_d);
	}

	/**
	 * 修改课程的教学大纲
	 */
	@Override
	public void updateCoutlineById(String url,String tc_cid) throws Exception {
	
		this.courseInfoMapper.updateCoutlineById(url,tc_cid);
	}

	/**
	 * 修改课程的所属阶段
	 */
	@Override
	public void updateCourseStageById(String sid, String tc_cid)throws Exception {
		this.courseInfoMapper.updateCourseStageById(sid,tc_cid);
		
	}

	/**
	 * 删除某个课程的章节
	 */
	@Override
	public void deleteCourseSectionById(String sid) throws Exception {
		this.courseInfoMapper.deleteCourseSectionById(sid);
	}

	/**
	 * 添加课程信息
	 */
	@Override
	public void addCouseInfo(Course_addInfo c_a) throws Exception {
		this.courseInfoMapper.addCouseInfo(c_a);
	}
	
	/**
	 * 添加课程的阶段信息
	 */
	@Override
	public void addCourseStage(String sid) throws Exception {
		this.courseInfoMapper.addCourseStage(sid);
	}

}
