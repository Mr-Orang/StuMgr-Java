package com.guigu.service.examination.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.dao.examination.Admission_ticket_mapper;
import com.guigu.domain.examination.Admission_ticket_dom;
import com.guigu.service.examination.Admission_ticket_service;

/**
 * 准考证号查询实现类
 * @author Samsung
 *
 */
@Service
@Transactional
public class Admission_ticket_impl implements Admission_ticket_service {
	
	@Autowired
	private Admission_ticket_mapper admission_ticket_mapper;
 
	@Override
	public Object Enquiry_admission(String adm_id,String stu_cid){
		return admission_ticket_mapper.queryAdmission(adm_id,stu_cid);
		
	}
}
