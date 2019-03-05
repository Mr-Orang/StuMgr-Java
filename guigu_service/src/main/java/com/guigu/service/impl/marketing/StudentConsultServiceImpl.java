package com.guigu.service.impl.marketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.marketing.StudentConsult;
import com.guigu.common.marketing.StudentConsultLike;
import com.guigu.dao.marketing.StudentConsultMapper;
import com.guigu.dao.marketing.StudentSourceMapper;
import com.guigu.domain.marketing.Employee;
import com.guigu.domain.marketing.PageInfo;
import com.guigu.domain.marketing.SourceTalk;
import com.guigu.domain.marketing.StatisticsSale;
import com.guigu.domain.marketing.StudentGrade;
import com.guigu.domain.marketing.StudentSource;
import com.guigu.service.marketing.StudentConsultService;
import com.guigu.util.PageHelpVO;
/**
 * service的实现类
 * @author lijianghua
 *
 */
@Service
public class StudentConsultServiceImpl implements StudentConsultService{
	@Autowired
	private StudentConsultMapper studentConsultMapper;

	@Autowired
	private StudentSourceMapper studentSourceMapper;
	@Override
	public PageHelpVO queryConsult(StudentConsult stu,int page, int rows) throws Exception {

		//return this.studentConsultMapper.queryConsult();
		PageHelpVO pageinfo = new PageHelpVO();
		Page page2 = PageHelper.startPage(page, rows);
		List<StudentConsult> list = this.studentConsultMapper.queryConsult(stu);
		System.out.println(list);
		pageinfo.setRows(list);
		pageinfo.setTotal(page2.getTotal());
		return pageinfo;
	}

	@Override
	public StudentConsult queryConsultById(String tst_id) throws Exception {
		// TODO Auto-generated method stub
		return this.studentConsultMapper.queryConsultById(tst_id);
	}

	@Override
	public List<Employee> queryEmployeeName() throws Exception {
		// TODO Auto-generated method stub
		return this.studentConsultMapper.queryEmployeeName();
	}

	@Override
	public List<StudentGrade> queryStudentGradeName() throws Exception {
		// TODO Auto-generated method stub
		return this.studentConsultMapper.queryStudentGradeName();
	}

	@Override
	public void updateSourceTalk(StudentConsult stu) throws Exception {
		// TODO Auto-generated method stub
		this.studentConsultMapper.updateStudentConsult(stu);
		//this.studentConsultMapper.updateStudentSourceName(stu.getTss_name());
		//this.studentConsultMapper.updateStudentSourceName(name);
	}

	/*@Override
	public void updateStudentSourceName(StudentSource name) throws Exception {
		// TODO Auto-generated method stub
		this.studentConsultMapper.updateStudentSourceName(name);
	}
	 */
	@Override
	public void addSourceTalk(SourceTalk sou) throws Exception {
		// TODO Auto-generated method stub
		this.studentConsultMapper.addSourceTalk(sou);
		this.studentSourceMapper.updateStudentSourceStatus(sou.getTss_id());
	}

	@Override
	public List<StudentConsult> queryStudentConsult() throws Exception {
		// TODO Auto-generated method stub
		return this.studentConsultMapper.queryStudentConsult();
	}

	@Override
	public PageHelpVO queryLikeStdentConsult(StudentConsultLike consult,Integer page, Integer rows) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Integer ="+page+"------------"+"Integer="+rows);
		PageHelpVO hp = new PageHelpVO();
		Page p = PageHelper.startPage(page, rows, true);
		hp.setRows(this.studentConsultMapper.queryLikeStdentConsult(consult));
		hp.setTotal(p.getTotal());
		System.out.println("p.getTotal()---"+p.getTotal());
		return hp;
	}



}
