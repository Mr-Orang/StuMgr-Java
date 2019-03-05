package com.guigu.service.impl.marketing;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.marketing.BoardHelp;
import com.guigu.common.marketing.BoardNotView;
import com.guigu.dao.marketing.DormMapper;
import com.guigu.domain.info.Student;
import com.guigu.domain.marketing.Classes;
import com.guigu.domain.marketing.Dorm;
import com.guigu.domain.marketing.DormType;
import com.guigu.domain.marketing.Employee;
import com.guigu.domain.marketing.Migrate;
import com.guigu.service.marketing.IDormService;
import com.guigu.util.PageHelpVO;
/**
 * 宿舍业务接口实现类
 * @author maomao
 *
 */
@Service
public class DormServiceImpl implements IDormService {
	@Autowired
	private DormMapper dormMapper;
	
	@Override
	public PageHelpVO queryBoard(BoardHelp boardHelp, Integer page, Integer rows) throws Exception {
		PageHelpVO hp = new PageHelpVO();
		Page p = PageHelper.startPage(page, rows, true);
		hp.setRows(this.dormMapper.queryBoard(boardHelp));
		hp.setTotal(p.getTotal());
		return hp;
	}

	@Override
	public List<Classes> queryClass() throws Exception {
		// TODO Auto-generated method stub
		return this.dormMapper.queryClass();
	}

	@Override
	public List<Migrate> queryMigrate() throws Exception {
		// TODO Auto-generated method stub
		return this.dormMapper.queryMigrate();
	}

	@Override
	public List<Dorm> queryAbleChangeDorm(String classID, String tdmID,String sex) throws Exception {
		// TODO Auto-generated method stub
		return this.dormMapper.queryAbleChangeDorm(classID, tdmID,sex);
	}

	@Override
	public List<Dorm> queryDorm() throws Exception {
		// TODO Auto-generated method stub
		return this.dormMapper.queryDorm();
	}

	@Override
	public PageHelpVO queryBoardNoOK(String classID, String sex, Integer page, Integer rows) throws Exception {
		// TODO Auto-generated method stub
		PageHelpVO hp = new PageHelpVO();
		Page p = PageHelper.startPage(page, rows, true);
		hp.setRows(this.dormMapper.queryBoardNoOK(classID, sex));
		hp.setTotal(p.getTotal());
		return hp;
	}


	@Override
	public void addBoard(String[] stu_ids, String tdm_ids) throws Exception {
		// TODO Auto-generated method stub
		List<Student> stuList = new ArrayList<Student>();
		int number = stu_ids.length;
		for(int i=0;i<stu_ids.length;i++){
			Student s = new Student();
			s.setStuid(stu_ids[i]);
			s.setApartmentid(tdm_ids);
			stuList.add(s);
		}
		this.dormMapper.addBoard(stuList);
		this.dormMapper.updateDormNumber(number, tdm_ids);
		this.dormMapper.updateStudentDorm(stuList);
	}

	@Override
	public List<Classes> queryNotBoardClass(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String empID = ((Employee)request.getSession().getAttribute("emplyee")).getTe_id();
		return this.dormMapper.queryNotBoardClass(empID);
	}


	@Override
	public List<DormType> queryDormType() throws Exception {
		// TODO Auto-generated method stub
		return this.dormMapper.queryDormType();
	}

	@Override
	public int queryDormAbleNumber(String tdm_id) throws Exception {
		// TODO Auto-generated method stub
		return this.dormMapper.queryDormAbleNumber(tdm_id);
	}

	@Override
	public List<Classes> queryClassByEmpID(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String empID = ((Employee)request.getSession().getAttribute("emplyee")).getTe_id();
		return this.dormMapper.queryClassByEmpID(empID);
	}

	@Override
	public List<Dorm> queryDormByEmpID(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String empID = ((Employee)request.getSession().getAttribute("emplyee")).getTe_id();
		return this.dormMapper.queryDormByEmpID(empID);
	}

	@Override
	public int queryHaveApplyByStuID(String stuID) throws Exception {
		// TODO Auto-generated method stub
		return this.dormMapper.queryHaveApplyByStuID(stuID);
	}

	@Override
	public String queryDormIDByStuID(String stuID) throws Exception {
		// TODO Auto-generated method stub
		return this.dormMapper.queryDormIDByStuID(stuID);
	}

	
	
	

}
