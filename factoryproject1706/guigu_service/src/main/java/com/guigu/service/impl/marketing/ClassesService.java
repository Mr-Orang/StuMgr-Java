package com.guigu.service.impl.marketing;
/**
 * 许永康
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.common.marketing.StudentSourceView;
import com.guigu.dao.marketing.ClassesMapper;
import com.guigu.domain.info.StudentInfo;
import com.guigu.domain.marketing.Classes;
import com.guigu.domain.marketing.Menu;
import com.guigu.service.marketing.IClassesService;
@Service
public class ClassesService implements IClassesService {
	@Autowired
	private ClassesMapper classesMapper;
	@Override
	public List<Menu> queryJoinClass() throws Exception {
		// TODO Auto-generated method stub
		return this.classesMapper.queryJoinClass();
	}
	@Override
	public List<StudentSourceView> queryStudentSource() throws Exception {
		// TODO Auto-generated method stub
		//for (StudentSourceView s : this.classesMapper.queryStudentSource()) {
			//System.out.println(s);

		//}
		return this.classesMapper.queryStudentSource();
	}
	@Override
	public Classes queryClass(String td_id) throws Exception {
		// TODO Auto-generated method stub
		return this.classesMapper.queryClass(td_id);
	}
	@Override
	public StudentSourceView queryStudentById(String tss_id) throws Exception {
		// TODO Auto-generated method stub
		return this.classesMapper.queryStudentById(tss_id);
	}
	@Override
	public void saveStudent(StudentInfo studentinfo) throws Exception {
		// TODO Auto-generated method stub
		this.classesMapper.saveStudent(studentinfo);
	}
	@Override
	public void updetaStudent(String classid) throws Exception {
		// TODO Auto-generated method stub
		this.classesMapper.updetaStudent(classid);
	}
	@Override
	public void updateApply(String apply, String rouid) throws Exception {
		// TODO Auto-generated method stub
		this.classesMapper.updateApply(apply, rouid);
	}
	@Override
	public String queryStsID(String empID) {
		// TODO Auto-generated method stub
		return this.classesMapper.queryStsID(empID);
	}
	@Override
	public String queryTstID(String stuSourceArea) {
		// TODO Auto-generated method stub
		return this.classesMapper.queryTstID(stuSourceArea);
	}
	@Override
	public void updateSaleEnrollment(String sts_id) throws Exception {
		// TODO Auto-generated method stub
		this.classesMapper.updateSaleEnrollment(sts_id);
	}
	@Override
	public void updateSchoolEnrollment(String tst_id) throws Exception {
		// TODO Auto-generated method stub
		this.classesMapper.updateSchoolEnrollment(tst_id);
	}

}
