package com.guigu.service.impl.eduoffice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.dao.eduoffice.EmpCourseMapper;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.eduoffice.vo.EmpVo;
import com.guigu.domain.eduoffice.vo.EmpVo2;
import com.guigu.service.eduoffice.EmpCourseService;
/**
 * 课程老师关系业务接口实现类
 * @author zy
 *
 */
@Service
public class EmpCourseServiceImpl implements EmpCourseService{
	
	@Autowired
	private EmpCourseMapper empCourseMapper;
	
	/**
	 * 查询所有老师于课程关系信息
	 * @return
	 */
	@Override
	public LayUiPageInfo queryEmpCourseList(int page,int rows,String ec_id, String tc_cname,String te_name) {
		LayUiPageInfo layUiPageInfo=new LayUiPageInfo();
		layUiPageInfo.setCode(0);
		Page page1=PageHelper.startPage(page, rows);
		layUiPageInfo.setData(this.empCourseMapper.queryEmpCourseList(ec_id,tc_cname,te_name));
		layUiPageInfo.setCount(page1.getTotal());
		return layUiPageInfo;
		
	}
	
	/**
	 *  进行逻辑删除 修改状态为1
	 * @param ec_id
	 */
	@Override
	public boolean updateStatus(String ec_id) {
		try {
			this.empCourseMapper.updateStatus(ec_id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 加载下拉框老师信息
	 */
	@Override
	public List<EmpVo> loadEmpSelect() {
		return this.empCourseMapper.loadEmpSelect();
	}
	
	/**
	 * 添加老师课程关系
	 */
	@Override
	public boolean addEmpCourse(String emp_id, String courseInfo1) {
		try {
			this.empCourseMapper.addEmpCourse(emp_id, courseInfo1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * 查询课程信息
	 */
	@Override
	public List<EmpVo2> queryCourseInfoVo() {
		return this.empCourseMapper.queryCourseInfoVo();
	}

	/**
	 * 启用老师课程关系 修改状态为0
	 */
	@Override
	public boolean updateStatus2(String ec_id) {
		try {
			this.empCourseMapper.updateStatus2(ec_id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
