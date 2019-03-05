package com.guigu.service.info.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.info.ClassVo;
import com.guigu.dao.info.TalkMapper;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.info.Student;
import com.guigu.domain.info.Talk_Details;
import com.guigu.service.info.ITalkService;
import com.guigu.util.PageHelpVO;

/**
 * 谈话管理业务实现类
 * @author ouyang
 *
 */
@Service
public class TalkServiceImpl implements ITalkService {

	@Autowired
	private TalkMapper talkmapper;

	//查询班级阶段和班级信息
	@Override
	public PageHelpVO Querytalkclass(Integer page,Integer rows) throws Exception{
		PageHelpVO ph=new PageHelpVO();
		Page p=PageHelper.startPage(page, rows, true);
		ph.setRows(this.talkmapper.Querytalkclass());
		ph.setTotal(p.getTotal());
		return ph;
	}

	/**
	 * 查询班级信息
	 */
	@Override
	public List<ClassVo> Queryclass() throws Exception {
		return this.talkmapper.Queryclass();
	}

	/**
	 * 根据班级编号查询本班全部学生信息
	 */
	@Override
	public List<Student> QueryStudentInformation(String class_id) throws Exception {
		return this.talkmapper.QueryStudentInformation(class_id);
	}

	/**
	 * 保存学生谈话信息和谈话详情信息
	 */
	@Override
	public void SaveStudentTalkinformation(String talk_person, String stu_id, String talk_content, String talk_type)
			throws Exception {
		//保存谈话信息
		this.talkmapper.SaveStudentTalk(talk_person);
		
		//保存谈话信息详情
		String[] stuid=stu_id.split(",");
		System.out.println(stu_id);
		System.out.println(stuid);
		if(stuid!=null){
			for (int i = 0; i < stuid.length; i++) {
				Talk_Details td=new Talk_Details();
				td.setStu_id(stuid[i]);
				td.setTalk_content(talk_content);
				td.setTalk_conte(0);
				td.setReason("");
				td.setTalk_type(talk_type);
				System.out.println(td);
				this.talkmapper.SaveStudentTalkdetail(td);
			}
		}
	}

	@Override
	public PageHelpVO QueryClassStudentTalkdetail(Integer page,Integer rows,String emp_id, String tc_name) throws Exception {
		PageHelpVO ph=new PageHelpVO();
		Page p=PageHelper.startPage(page, rows, true);
		ph.setRows(this.talkmapper.QueryClassStudentTalkdetail(emp_id, tc_name));
		ph.setTotal(p.getTotal());
		return ph;
	}
	
	@Override
	public PageHelpVO QueryStudentTalkrecord(Integer page, Integer rows, String stu_id, String emp_id)
			throws Exception {
		PageHelpVO ph=new PageHelpVO();
		Page p=PageHelper.startPage(page, rows, true);
		ph.setRows(this.talkmapper.QueryStudentTalkrecord(stu_id, emp_id));
		ph.setTotal(p.getTotal());
		return ph;
	}

	@Override
	public LayUiPageInfo QueryStudentTalk(Integer page,Integer rows,String stu_id) throws Exception {
		LayUiPageInfo layUiPageInfo=new LayUiPageInfo();
		layUiPageInfo.setCode(0);
		Page page1=PageHelper.startPage(page, rows);
		layUiPageInfo.setData(this.talkmapper.QueryStudentTalk(stu_id));
		layUiPageInfo.setCount(page1.getTotal());
		return layUiPageInfo;
	}

	@Override
	public void UpdateStudentAgreeTalk(String talk_details_id) throws Exception {
		this.talkmapper.UpdateStudentAgreeTalk(talk_details_id);
	}
	
}
