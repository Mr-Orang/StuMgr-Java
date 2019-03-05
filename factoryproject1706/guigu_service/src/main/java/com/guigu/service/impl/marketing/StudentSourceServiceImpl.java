package com.guigu.service.impl.marketing;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.marketing.StudentSourceAdd;
import com.guigu.common.marketing.StudentSourceHelp;
import com.guigu.dao.marketing.MarketMapper;
import com.guigu.dao.marketing.StudentSourceMapper;
import com.guigu.domain.marketing.RecruitStatus;
import com.guigu.domain.marketing.StatisticsSale;
import com.guigu.domain.marketing.StatisticsSchool;
import com.guigu.domain.marketing.StudentSource;
import com.guigu.service.marketing.IStudentSourceService;
import com.guigu.util.PageHelpVO;
/**
 * 生源业务接口实现类
 * @author maomao
 *
 */
@Service
public class StudentSourceServiceImpl implements IStudentSourceService {
	@Autowired
	private StudentSourceMapper studentSourceMapper;
	
	@Autowired
	private MarketMapper marketMapper;
	
	@Override
	public PageHelpVO queryStudentSource(StudentSourceHelp studentSourceHelp,Integer page, Integer rows) throws Exception {
		//System.out.println("Integer ="+page+"------------"+"Integer="+rows);
		PageHelpVO hp = new PageHelpVO();
		Page p = PageHelper.startPage(page, rows, true);
		hp.setRows(this.studentSourceMapper.queryStudentSource(studentSourceHelp));
		hp.setTotal(p.getTotal());
		//System.out.println("p.getTotal()---"+p.getTotal());
		return hp;
	}

	@Override
	public List<RecruitStatus> queryRecruitStatus() throws Exception {
		// TODO Auto-generated method stub
		return this.studentSourceMapper.queryRecruitStatus();
	}

	@Override
	public void addStudentSource(StudentSourceAdd studentSourceAdd) throws Exception {
		this.studentSourceMapper.addStudentSource(studentSourceAdd);
		String sts_id = this.marketMapper.queryStsID(studentSourceAdd.getEmpID());
		System.out.println("1:"+sts_id);
		String tst_id = this.marketMapper.queryTstID(studentSourceAdd.getStuSourceArea());
		System.out.println("2:"+tst_id);
		if(sts_id==null||sts_id==""){
			StatisticsSale ss = new StatisticsSale();
			ss.setSts_empid(studentSourceAdd.getEmpID());
			this.marketMapper.addStatisticsSale(ss);
			System.out.println("3");
		}else{
			this.marketMapper.updateStatisticsSale(sts_id);
			System.out.println("4");
		}
		if(tst_id==null||tst_id==""){
			StatisticsSchool ss = new StatisticsSchool();
			ss.setTst_academy(studentSourceAdd.getStuSourceArea());
			this.marketMapper.addStatisticsSchool(ss);
			System.out.println("5");
		}else{
			System.out.println("5.5");
			this.marketMapper.updateStatisticsSchool(tst_id);
			System.out.println("6");
		}
	}

	@Override
	public StudentSource queryStudentSourceByID(String tss_id) throws Exception {
		// TODO Auto-generated method stub
		return this.studentSourceMapper.queryStudentSourceByID(tss_id);
	}

	@Override
	public void updateStudentSource(StudentSource studentSource) throws Exception {
		// TODO Auto-generated method stub
		this.studentSourceMapper.updateStudentSource(studentSource);
	}

	

}
