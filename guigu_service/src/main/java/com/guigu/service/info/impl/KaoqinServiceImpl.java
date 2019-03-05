package com.guigu.service.info.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.info.KaoqinStudentVo;
import com.guigu.common.info.KaoqinTypeVo;
import com.guigu.dao.info.KaoqinMapper;
import com.guigu.domain.info.Attendance;
import com.guigu.domain.info.Attendance_details;
import com.guigu.domain.info.Kaoqinclassshow;
import com.guigu.service.info.IKaoqinService;
import com.guigu.util.PageHelpVO;
@Service
public class KaoqinServiceImpl implements IKaoqinService {
	@Autowired
	private KaoqinMapper kaoqinMapper;
	public PageHelpVO kaoqinClassshow(Integer page,Integer rows) throws Exception {
		PageHelpVO pageInfo = new PageHelpVO();
		List<Kaoqinclassshow> list = null;
		Page pages=null;
		pages = PageHelper.startPage(page, rows);
		list = kaoqinMapper.kaoqinClassshow();
		pageInfo.setRows(list);
		pageInfo.setTotal((long)pages.getTotal());
		return pageInfo;
	}
	@Override
	public List<KaoqinTypeVo> kaqinselect() throws Exception {
		List<KaoqinTypeVo> kqt =kaoqinMapper.kaqinselect();
		return kqt;
	}
	@Override
	public KaoqinTypeVo kaoqintime(HttpServletRequest request,String text) throws Exception {
		KaoqinTypeVo kqt =kaoqinMapper.kaoqintime(text);
		return kqt;
	}
	@Override
	public PageHelpVO KaoqinStuden(Integer page, Integer rows, String kaoqinclass) throws Exception {
		PageHelpVO pageInfo = new PageHelpVO();
		List<KaoqinStudentVo> list = null;
		Page pages=null;
		pages = PageHelper.startPage(page, rows);
		list=kaoqinMapper.KaoqinStuden(kaoqinclass);
		pageInfo.setRows(list);
		pageInfo.setTotal((long)pages.getTotal());
		return pageInfo;
	}
	@Override
	public boolean kaoqinattendance(HttpServletRequest request,String class_id,String teacher_id,String type_id,String ty_yesno)throws Exception {
		boolean f=false;
		 Attendance adc = new  Attendance();
		 adc.setTeacher_id("roleId_1");
		if(kaoqinMapper.kaoqinattendance( class_id, teacher_id, type_id, ty_yesno)!=false){
			f=true;
		}
		return f;
	}
	@Override
	public boolean kaoqindetails(String stu_id,String status) throws Exception {
		boolean f=false;
		String[] stubianhao = stu_id.split(",");
		for(int i=0;i<stubianhao.length;i++){
			Attendance_details attd = new Attendance_details();
			String studntkaoqinid = stubianhao[i];
			attd.setStu_id(studntkaoqinid);
			attd.setStatus(status);
			if(kaoqinMapper.kaoqindetails(studntkaoqinid, status)!=false){
				f=true;
			}
		}
		return f;
	}
}
